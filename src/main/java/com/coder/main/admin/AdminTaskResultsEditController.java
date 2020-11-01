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
import com.coder.main.CoderTaskResults;

@Controller
@RequestMapping("/adminTaskResultsEdit")
public class AdminTaskResultsEditController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderTaskResults> getRecord(String id)
   {
      List<CoderTaskResults> r = jdbc.query("SELECT * FROM c0d3r_task_results WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderTaskResults>() {
		     @Override
		     public CoderTaskResults mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderTaskResults(rs.getLong("id"),
                   rs.getLong("taskId"),
                   rs.getLong("studentId"),
                   rs.getInt("languageId"),
                   rs.getString("localeName"),
                   rs.getFloat("resultValue"),
                   rs.getString("resultDescription"),
                   rs.getInt("status"),
                   rs.getString("addedTime"));
			 }
		  }
	   );

      return r;
   }

   @GetMapping
   public String showPage(@RequestParam("id") String recordId, Model model) {

      List<CoderTaskResults> results = getRecord(recordId);

      if(!results.isEmpty())
      {
         model.addAttribute("coderTaskResultsRecord", results.get(0));
      }
      else
      {
         model.addAttribute("errorOutput", "Запись не найдена.");
         return "admin/adminErrorGeneral";
      }

	  model.addAttribute("coderTaskResults", new CoderTaskResults());

      return "admin/adminTaskResultsEdit";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderTaskResults") @Valid CoderTaskResults coderTaskResults, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "admin/adminadminTaskResultsEdit";
      }

      int n = jdbc.update("UPDATE c0d3r_task_results SET id=?,"
            + "taskId=?,"
            + "studentId=?,"
            + "languageId=?,"
            + "localeName=?,"
            + "resultValue=?,"
            + "resultDescription=?,"
            + "status=?,"
            + "addedTime=CURRENT_TIMESTAMP WHERE id=?",
            coderTaskResults.getId(),
            coderTaskResults.getTaskId(),
            coderTaskResults.getStudentId(),
            coderTaskResults.getLanguageId(),
            coderTaskResults.getLocaleName(),
            coderTaskResults.getResultValue(),
            coderTaskResults.getResultDescription(),
            coderTaskResults.getStatus(),
            coderTaskResults.getAddedTime(),
            coderTaskResults.getId());

	  if(n > 0)
	  {
		 List<CoderTaskResults> results = getRecord(String.valueOf(coderTaskResults.getId()));

	     if(!results.isEmpty())
	     {
	    	 model.addAttribute("coderTaskResultsRecord", results.get(0));
	     }
	     else
	     {
	    	 model.addAttribute("operationError", "Запись не найдена.");
	    	 return "admin/adminErrorGeneral";
	     }

		 model.addAttribute("coderTaskResults", new CoderTaskResults());

		 model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "admin/adminTaskResultsEdit";
   }
}

