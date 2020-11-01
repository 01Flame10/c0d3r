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
import com.coder.main.CoderAutotestResults;

@Controller
@RequestMapping("/teacherAutotestResultsEdit")
public class TeacherAutotestResultsEditController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderAutotestResults> getRecord(String id)
   {
      List<CoderAutotestResults> r = jdbc.query("SELECT * FROM c0d3r_task_autotest_results WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderAutotestResults>() {
		     @Override
		     public CoderAutotestResults mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderAutotestResults(rs.getLong("id"),
                   rs.getLong("taskId"),
                   rs.getLong("resultId"),
                   rs.getLong("autotestId"),
                   rs.getInt("languageId"),
                   rs.getString("runTimeMilliseconds"),
                   rs.getFloat("rewardValue"),
                   rs.getString("inputData"),
                   rs.getString("outputData"),
                   rs.getString("inputURL"),
                   rs.getString("outputURL"),
                   rs.getString("inputFileName"),
                   rs.getString("outputFileName"),
                   rs.getString("inputMethod"),
                   rs.getString("outputMethod"),
                   rs.getInt("status"),
                   rs.getString("addedTime"));
			 }
		  }
	   );

      return r;
   }

   @GetMapping
   public String showPage(@RequestParam("id") String recordId, Model model) {

      List<CoderAutotestResults> results = getRecord(recordId);

      if(!results.isEmpty())
      {
         model.addAttribute("coderAutotestResultsRecord", results.get(0));
      }
      else
      {
         model.addAttribute("errorOutput", "Запись не найдена.");
         return "teacher/teacherErrorGeneral";
      }

	  model.addAttribute("coderAutotestResults", new CoderAutotestResults());

      return "teacher/teacherAutotestResultsEdit";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderAutotestResults") @Valid CoderAutotestResults coderAutotestResults, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "teacher/teacherAutotestResultsEdit";
      }

      int n = jdbc.update("UPDATE c0d3r_task_autotest_results SET id=?,"
            + "taskId=?,"
            + "resultId=?,"
            + "autotestId=?,"
            + "languageId=?,"
            + "runTimeMilliseconds=?,"
            + "rewardValue=?,"
            + "inputData=?,"
            + "outputData=?,"
            + "inputURL=?,"
            + "outputURL=?,"
            + "inputFileName=?,"
            + "outputFileName=?,"
            + "inputMethod=?,"
            + "outputMethod=?,"
            + "status=?,"
            + "addedTime=CURRENT_TIMESTAMP WHERE id=?",
            coderAutotestResults.getId(),
            coderAutotestResults.getTaskId(),
            coderAutotestResults.getResultId(),
            coderAutotestResults.getAutotestId(),
            coderAutotestResults.getLanguageId(),
            coderAutotestResults.getRunTimeMilliseconds(),
            coderAutotestResults.getRewardValue(),
            coderAutotestResults.getInputData(),
            coderAutotestResults.getOutputData(),
            coderAutotestResults.getInputURL(),
            coderAutotestResults.getOutputURL(),
            coderAutotestResults.getInputFileName(),
            coderAutotestResults.getOutputFileName(),
            coderAutotestResults.getInputMethod(),
            coderAutotestResults.getOutputMethod(),
            coderAutotestResults.getStatus(),
            coderAutotestResults.getAddedTime(),
            coderAutotestResults.getId());

	  if(n > 0)
	  {
		 List<CoderAutotestResults> results = getRecord(String.valueOf(coderAutotestResults.getId()));

	     if(!results.isEmpty())
	     {
	    	 model.addAttribute("coderAutotestResultsRecord", results.get(0));
	     }
	     else
	     {
	    	 model.addAttribute("operationError", "Запись не найдена.");
	    	 return "teacher/teacherErrorGeneral";
	     }

		 model.addAttribute("coderAutotestResults", new CoderAutotestResults());

		 model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "teacher/teacherAutotestResultsEdit";
   }
}

