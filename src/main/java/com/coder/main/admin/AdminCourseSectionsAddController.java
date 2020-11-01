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
import com.coder.main.CoderCourseSections;

@Controller
@RequestMapping("/adminCourseSectionsAdd")
public class AdminCourseSectionsAddController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      model.addAttribute("coderCourseSections", new CoderCourseSections());

      return "admin/adminCourseSectionsAdd";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderCourseSections") @Valid CoderCourseSections coderCourseSections, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "admin/adminCourseSectionsAdd";
      }

	  int n = jdbc.update("INSERT INTO c0d3r_course_sections (id,"
            + "courseId,"
            + "sectionName,"
            + "localeName,"
            + "sectionType,"
            + "sectionDescription,"
            + "status,"
            + "addedTime) values(?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "CURRENT_TIMESTAMP)",
	  		coderCourseSections.getId(),
	  		coderCourseSections.getCourseId(),
	  		coderCourseSections.getSectionName(),
	  		coderCourseSections.getLocaleName(),
	  		coderCourseSections.getSectionType(),
	  		coderCourseSections.getSectionDescription(),
	  		coderCourseSections.getStatus(),
	  		coderCourseSections.getAddedTime());
	  if(n > 0)
	  {
	     model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "admin/adminCourseSectionsAdd";
   }
}

