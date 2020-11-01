package com.coder.main.teacher;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.coder.main.CoderAutotestResults;

@Controller
@RequestMapping("/teacherAutotestResultsAdd")
public class TeacherAutotestResultsAddController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      model.addAttribute("coderAutotestResults", new CoderAutotestResults());

      return "teacher/teacherAutotestResultsAdd";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderAutotestResults") @Valid CoderAutotestResults coderAutotestResults, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "teacher/teacherAutotestResultsAdd";
      }

	  int n = jdbc.update("INSERT INTO c0d3r_task_autotest_results (id,"
            + "taskId,"
            + "resultId,"
            + "autotestId,"
            + "languageId,"
            + "runTimeMilliseconds,"
            + "rewardValue,"
            + "inputData,"
            + "outputData,"
            + "inputURL,"
            + "outputURL,"
            + "inputFileName,"
            + "outputFileName,"
            + "inputMethod,"
            + "outputMethod,"
            + "status,"
            + "addedTime) values(?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "CURRENT_TIMESTAMP)",
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
	  		coderAutotestResults.getAddedTime());
	  if(n > 0)
	  {
	     model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "teacher/teacherAutotestResultsAdd";
   }
}

