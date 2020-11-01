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
import com.coder.main.CoderGroups;

@Controller
@RequestMapping("/adminGroupsAdd")
public class AdminGroupsAddController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      model.addAttribute("coderGroups", new CoderGroups());

      return "admin/adminGroupsAdd";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderGroups") @Valid CoderGroups coderGroups, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "admin/adminGroupsAdd";
      }

	  int n = jdbc.update("INSERT INTO c0d3r_groups (id,"
            + "classId,"
            + "groupName,"
            + "localeName,"
            + "groupType,"
            + "groupDescription,"
            + "status,"
            + "addedTime) values(?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "CURRENT_TIMESTAMP)",
	  		coderGroups.getId(),
	  		coderGroups.getClassId(),
	  		coderGroups.getGroupName(),
	  		coderGroups.getLocaleName(),
	  		coderGroups.getGroupType(),
	  		coderGroups.getGroupDescription(),
	  		coderGroups.getStatus(),
	  		coderGroups.getAddedTime());
	  if(n > 0)
	  {
	     model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "admin/adminGroupsAdd";
   }
}

