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
import com.coder.main.CoderCourses;

@Controller
@RequestMapping("/teacherCoursesAdd")
public class TeacherCoursesAddController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      model.addAttribute("coderCourses", new CoderCourses());

      return "teacher/teacherCoursesAdd";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderCourses") @Valid CoderCourses coderCourses, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "teacher/teacherCoursesAdd";
      }

	  int n = jdbc.update("INSERT INTO c0d3r_courses (id,"
            + "courseName,"
            + "localeName,"
            + "courseType,"
            + "courseDescription,"
            + "status,"
            + "addedTime) values(?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "CURRENT_TIMESTAMP)",
	  		coderCourses.getId(),
	  		coderCourses.getCourseName(),
	  		coderCourses.getLocaleName(),
	  		coderCourses.getCourseType(),
	  		coderCourses.getCourseDescription(),
	  		coderCourses.getStatus(),
	  		coderCourses.getAddedTime());
	  if(n > 0)
	  {
	     model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "teacher/teacherCoursesAdd";
   }
}

