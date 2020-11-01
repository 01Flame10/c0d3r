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
import com.coder.main.CoderClasses;

@Controller
@RequestMapping("/adminClassesAdd")
public class AdminClassesAddController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      model.addAttribute("coderClasses", new CoderClasses());

      return "admin/adminClassesAdd";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderClasses") @Valid CoderClasses coderClasses, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "admin/adminClassesAdd";
      }

	  int n = jdbc.update("INSERT INTO c0d3r_classes (id,"
            + "className,"
            + "localeName,"
            + "classType,"
            + "classDescription,"
            + "status,"
            + "addedTime) values(?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "CURRENT_TIMESTAMP)",
	  		coderClasses.getId(),
	  		coderClasses.getClassName(),
	  		coderClasses.getLocaleName(),
	  		coderClasses.getClassType(),
	  		coderClasses.getClassDescription(),
	  		coderClasses.getStatus(),
	  		coderClasses.getAddedTime());
	  if(n > 0)
	  {
	     model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "admin/adminClassesAdd";
   }
}

