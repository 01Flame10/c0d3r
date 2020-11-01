package com.coder.main.admin;

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
import com.coder.main.CoderTaskResults;

@Controller
@RequestMapping("/adminTaskResultsAdd")
public class AdminTaskResultsAddController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      model.addAttribute("coderTaskResults", new CoderTaskResults());

      return "admin/adminTaskResultsAdd";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderTaskResults") @Valid CoderTaskResults coderTaskResults, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "admin/adminTaskResultsAdd";
      }

	  int n = jdbc.update("INSERT INTO c0d3r_task_results (id,"
            + "taskId,"
            + "studentId,"
            + "languageId,"
            + "localeName,"
            + "resultValue,"
            + "resultDescription,"
            + "status,"
            + "addedTime) values(?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "CURRENT_TIMESTAMP)",
	  		coderTaskResults.getId(),
	  		coderTaskResults.getTaskId(),
	  		coderTaskResults.getStudentId(),
	  		coderTaskResults.getLanguageId(),
	  		coderTaskResults.getLocaleName(),
	  		coderTaskResults.getResultValue(),
	  		coderTaskResults.getResultDescription(),
	  		coderTaskResults.getStatus(),
	  		coderTaskResults.getAddedTime());
	  if(n > 0)
	  {
	     model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "admin/adminTaskResultsAdd";
   }
}

