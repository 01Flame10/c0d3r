package com.coder.main.admin;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.coder.main.CoderTasks;

@Controller
@RequestMapping("/adminTasksEdit")
public class AdminTasksEditController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderTasks> getRecord(String id)
   {
      List<CoderTasks> r = jdbc.query("SELECT * FROM c0d3r_tasks WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderTasks>() {
		     @Override
		     public CoderTasks mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderTasks(rs.getLong("id"),
                   rs.getLong("courseId"),
                   rs.getLong("sectionId"),
                   rs.getInt("languageId"),
                   rs.getLong("teacherId"),
                   rs.getString("taskName"),
                   rs.getString("localeName"),
                   rs.getInt("taskType"),
                   rs.getFloat("taskValue"),
                   rs.getString("taskDescription"),
                   rs.getInt("status"),
                   rs.getString("addedTime"));
			 }
		  }
	   );

      return r;
   }

   @GetMapping
   public String showPage(@RequestParam("id") String recordId, Model model) {

      List<CoderTasks> results = getRecord(recordId);

      if(!results.isEmpty())
      {
         model.addAttribute("coderTasksRecord", results.get(0));
      }
      else
      {
         model.addAttribute("errorOutput", "Запись не найдена.");
         return "admin/adminErrorGeneral";
      }

	  model.addAttribute("coderTasks", new CoderTasks());

      return "admin/adminTasksEdit";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderTasks") @Valid CoderTasks coderTasks, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "admin/adminadminTasksEdit";
      }

      int n = jdbc.update("UPDATE c0d3r_tasks SET id=?,"
            + "courseId=?,"
            + "sectionId=?,"
            + "languageId=?,"
            + "teacherId=?,"
            + "taskName=?,"
            + "localeName=?,"
            + "taskType=?,"
            + "taskValue=?,"
            + "taskDescription=?,"
            + "status=?,"
            + "addedTime=CURRENT_TIMESTAMP WHERE id=?",
            coderTasks.getId(),
            coderTasks.getCourseId(),
            coderTasks.getSectionId(),
            coderTasks.getLanguageId(),
            coderTasks.getTeacherId(),
            coderTasks.getTaskName(),
            coderTasks.getLocaleName(),
            coderTasks.getTaskType(),
            coderTasks.getTaskValue(),
            coderTasks.getTaskDescription(),
            coderTasks.getStatus(),
            coderTasks.getAddedTime(),
            coderTasks.getId());

	  if(n > 0)
	  {
		 List<CoderTasks> results = getRecord(String.valueOf(coderTasks.getId()));

	     if(!results.isEmpty())
	     {
	    	 model.addAttribute("coderTasksRecord", results.get(0));
	     }
	     else
	     {
	    	 model.addAttribute("operationError", "Запись не найдена.");
	    	 return "admin/adminErrorGeneral";
	     }

		 model.addAttribute("coderTasks", new CoderTasks());

		 model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "admin/adminTasksEdit";
   }
}

