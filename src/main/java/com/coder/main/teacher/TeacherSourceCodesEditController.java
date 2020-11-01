package com.coder.main.teacher;

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
import com.coder.main.CoderSourceCodes;

@Controller
@RequestMapping("/teacherSourceCodesEdit")
public class TeacherSourceCodesEditController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderSourceCodes> getRecord(String id)
   {
      List<CoderSourceCodes> r = jdbc.query("SELECT * FROM c0d3r_task_result_source_codes WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderSourceCodes>() {
		     @Override
		     public CoderSourceCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderSourceCodes(rs.getLong("id"),
                   rs.getLong("resultId"),
                   rs.getLong("studentId"),
                   rs.getString("fileURL"),
                   rs.getInt("status"),
                   rs.getString("addedTime"));
			 }
		  }
	   );

      return r;
   }

   @GetMapping
   public String showPage(@RequestParam("id") String recordId, Model model) {

      List<CoderSourceCodes> results = getRecord(recordId);

      if(!results.isEmpty())
      {
         model.addAttribute("coderSourceCodesRecord", results.get(0));
      }
      else
      {
         model.addAttribute("errorOutput", "Запись не найдена.");
         return "teacher/teacherErrorGeneral";
      }

	  model.addAttribute("coderSourceCodes", new CoderSourceCodes());

      return "teacher/teacherSourceCodesEdit";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderSourceCodes") @Valid CoderSourceCodes coderSourceCodes, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "teacher/teacherSourceCodesEdit";
      }

      int n = jdbc.update("UPDATE c0d3r_task_result_source_codes SET id=?,"
            + "resultId=?,"
            + "studentId=?,"
            + "fileURL=?,"
            + "status=?,"
            + "addedTime=CURRENT_TIMESTAMP WHERE id=?",
            coderSourceCodes.getId(),
            coderSourceCodes.getResultId(),
            coderSourceCodes.getStudentId(),
            coderSourceCodes.getFileURL(),
            coderSourceCodes.getStatus(),
            coderSourceCodes.getAddedTime(),
            coderSourceCodes.getId());

	  if(n > 0)
	  {
		 List<CoderSourceCodes> results = getRecord(String.valueOf(coderSourceCodes.getId()));

	     if(!results.isEmpty())
	     {
	    	 model.addAttribute("coderSourceCodesRecord", results.get(0));
	     }
	     else
	     {
	    	 model.addAttribute("operationError", "Запись не найдена.");
	    	 return "teacher/teacherErrorGeneral";
	     }

		 model.addAttribute("coderSourceCodes", new CoderSourceCodes());

		 model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "teacher/teacherSourceCodesEdit";
   }
}

