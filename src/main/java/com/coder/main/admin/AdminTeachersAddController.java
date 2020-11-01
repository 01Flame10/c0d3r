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
import com.coder.main.CoderTeachers;

@Controller
@RequestMapping("/adminTeachersAdd")
public class AdminTeachersAddController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      model.addAttribute("coderTeachers", new CoderTeachers());

      return "admin/adminTeachersAdd";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderTeachers") @Valid CoderTeachers coderTeachers, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "admin/adminTeachersAdd";
      }

	  int n = jdbc.update("INSERT INTO c0d3r_teachers (id,"
            + "teacherFirstName,"
            + "teacherMiddleName,"
            + "teacherLastName,"
            + "teacherEmail,"
            + "teacherLogin,"
            + "teacherPassword,"
            + "teacherPasswordMatch,"
            + "teacherCompanyName,"
            + "teacherAddress,"
            + "teacherPhone,"
            + "teacherCity,"
            + "teacherZip,"
            + "teacherState,"
            + "teacherCountry,"
            + "teacherAboutMe,"
            + "profilePhotoUrl,"
            + "teacherType,"
            + "teacherAuthority,"
            + "teacherMembership,"
            + "teacherActivated,"
            + "activationCode,"
            + "teacherCoursesEnrolled,"
            + "teacherTasksCreated,"
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
	  		coderTeachers.getId(),
	  		coderTeachers.getTeacherFirstName(),
	  		coderTeachers.getTeacherMiddleName(),
	  		coderTeachers.getTeacherLastName(),
	  		coderTeachers.getTeacherEmail(),
	  		coderTeachers.getTeacherLogin(),
	  		coderTeachers.getTeacherPassword(),
	  		coderTeachers.getTeacherPasswordMatch(),
	  		coderTeachers.getTeacherCompanyName(),
	  		coderTeachers.getTeacherAddress(),
	  		coderTeachers.getTeacherPhone(),
	  		coderTeachers.getTeacherCity(),
	  		coderTeachers.getTeacherZip(),
	  		coderTeachers.getTeacherState(),
	  		coderTeachers.getTeacherCountry(),
	  		coderTeachers.getTeacherAboutMe(),
	  		coderTeachers.getProfilePhotoUrl(),
	  		coderTeachers.getTeacherType(),
	  		coderTeachers.getTeacherAuthority(),
	  		coderTeachers.getTeacherMembership(),
	  		coderTeachers.getTeacherActivated(),
	  		coderTeachers.getActivationCode(),
	  		coderTeachers.getTeacherCoursesEnrolled(),
	  		coderTeachers.getTeacherTasksCreated(),
	  		coderTeachers.getLastLoginTime(),
	  		coderTeachers.getPrevLoginTime(),
	  		coderTeachers.getInstagramId(),
	  		coderTeachers.getFacebookId(),
	  		coderTeachers.getVkId(),
	  		coderTeachers.getYoutubeId(),
	  		coderTeachers.getTwitterId(),
	  		coderTeachers.getStatus(),
	  		coderTeachers.getAgree(),
	  		coderTeachers.getAddedTime());
	  if(n > 0)
	  {
	     model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "admin/adminTeachersAdd";
   }
}

