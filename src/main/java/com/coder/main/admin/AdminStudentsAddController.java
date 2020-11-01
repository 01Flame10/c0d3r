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
import com.coder.main.CoderStudents;

@Controller
@RequestMapping("/adminStudentsAdd")
public class AdminStudentsAddController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      model.addAttribute("coderStudents", new CoderStudents());

      return "admin/adminStudentsAdd";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderStudents") @Valid CoderStudents coderStudents, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "admin/adminStudentsAdd";
      }

	  int n = jdbc.update("INSERT INTO c0d3r_students (studentFirstName,"
            + "studentMiddleName,"
            + "studentLastName,"
            + "studentEmail,"
            + "studentLogin,"
            + "studentPassword,"
            + "studentPasswordMatch,"
            + "studentCompanyName,"
            + "studentAddress,"
            + "studentPhone,"
            + "studentCity,"
            + "studentZip,"
            + "studentState,"
            + "studentCountry,"
            + "studentAboutMe,"
            + "profilePhotoUrl,"
            + "studentType,"
            + "studentMembership,"
            + "studentRating,"
            + "studentCoursesEnrolled,"
            + "studentTasksComplete,"
            + "lastLoginTime,"
            + "prevLoginTime,"
            + "instagramId,"
            + "facebookId,"
            + "vkId,"
            + "youtubeId,"
            + "twitterId,"
            + "status,"
            + "agree,"
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
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "CURRENT_TIMESTAMP,"
            + "CURRENT_TIMESTAMP,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "CURRENT_TIMESTAMP)",
	  		coderStudents.getStudentFirstName(),
	  		coderStudents.getStudentMiddleName(),
	  		coderStudents.getStudentLastName(),
	  		coderStudents.getStudentEmail(),
	  		coderStudents.getStudentLogin(),
	  		coderStudents.getStudentPassword(),
	  		coderStudents.getStudentPasswordMatch(),
	  		coderStudents.getStudentCompanyName(),
	  		coderStudents.getStudentAddress(),
	  		coderStudents.getStudentPhone(),
	  		coderStudents.getStudentCity(),
	  		coderStudents.getStudentZip(),
	  		coderStudents.getStudentState(),
	  		coderStudents.getStudentCountry(),
	  		coderStudents.getStudentAboutMe(),
	  		coderStudents.getProfilePhotoUrl(),
	  		coderStudents.getStudentType(),
	  		coderStudents.getStudentMembership(),
	  		coderStudents.getStudentRating(),
	  		coderStudents.getStudentCoursesEnrolled(),
	  		coderStudents.getStudentTasksComplete(),
	  		coderStudents.getInstagramId(),
	  		coderStudents.getFacebookId(),
	  		coderStudents.getVkId(),
	  		coderStudents.getYoutubeId(),
	  		coderStudents.getTwitterId(),
	  		coderStudents.getStatus(),
	  		1);
	  if(n > 0)
	  {
	     model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "admin/adminStudentsAdd";
   }
}

