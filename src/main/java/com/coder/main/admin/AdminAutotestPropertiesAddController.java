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
import com.coder.main.CoderAutotestProperties;

@Controller
@RequestMapping("/adminAutotestPropertiesAdd")
public class AdminAutotestPropertiesAddController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      model.addAttribute("coderAutotestProperties", new CoderAutotestProperties());

      return "admin/adminAutotestPropertiesAdd";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderAutotestProperties") @Valid CoderAutotestProperties coderAutotestProperties, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "admin/adminAutotestPropertiesAdd";
      }

	  int n = jdbc.update("INSERT INTO c0d3r_task_autotest_properties (id,"
            + "taskId,"
            + "languageId,"
            + "runTimeMillisecondsFrom,"
            + "runTimeMillisecondsTo,"
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
            + "CURRENT_TIMESTAMP)",
	  		coderAutotestProperties.getId(),
	  		coderAutotestProperties.getTaskId(),
	  		coderAutotestProperties.getLanguageId(),
	  		coderAutotestProperties.getRunTimeMillisecondsFrom(),
	  		coderAutotestProperties.getRunTimeMillisecondsTo(),
	  		coderAutotestProperties.getRewardValue(),
	  		coderAutotestProperties.getInputData(),
	  		coderAutotestProperties.getOutputData(),
	  		coderAutotestProperties.getInputURL(),
	  		coderAutotestProperties.getOutputURL(),
	  		coderAutotestProperties.getInputFileName(),
	  		coderAutotestProperties.getOutputFileName(),
	  		coderAutotestProperties.getInputMethod(),
	  		coderAutotestProperties.getOutputMethod(),
	  		coderAutotestProperties.getStatus(),
	  		coderAutotestProperties.getAddedTime());
	  if(n > 0)
	  {
	     model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "admin/adminAutotestPropertiesAdd";
   }
}

