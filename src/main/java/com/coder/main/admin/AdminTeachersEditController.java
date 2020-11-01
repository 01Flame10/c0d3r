package com.coder.main.admin;

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
import com.coder.main.CoderTeachers;

@Controller
@RequestMapping("/adminTeachersEdit")
public class AdminTeachersEditController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderTeachers> getRecord(String id)
   {
      List<CoderTeachers> r = jdbc.query("SELECT * FROM c0d3r_teachers WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderTeachers>() {
		     @Override
		     public CoderTeachers mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderTeachers(rs.getLong("id"),
                   rs.getString("teacherFirstName"),
                   rs.getString("teacherMiddleName"),
                   rs.getString("teacherLastName"),
                   rs.getString("teacherEmail"),
                   rs.getString("teacherLogin"),
                   rs.getString("teacherPassword"),
                   rs.getString("teacherPasswordMatch"),
                   rs.getString("teacherCompanyName"),
                   rs.getString("teacherAddress"),
                   rs.getString("teacherPhone"),
                   rs.getString("teacherCity"),
                   rs.getString("teacherZip"),
                   rs.getString("teacherState"),
                   rs.getString("teacherCountry"),
                   rs.getString("teacherAboutMe"),
                   rs.getString("profilePhotoUrl"),
                   rs.getInt("teacherType"),
                   rs.getString("teacherAuthority"),
                   rs.getInt("teacherMembership"),
                   rs.getInt("teacherActivated"),
                   rs.getString("activationCode"),
                   rs.getInt("teacherCoursesEnrolled"),
                   rs.getInt("teacherTasksCreated"),
                   rs.getString("lastLoginTime"),
                   rs.getString("prevLoginTime"),
                   rs.getString("instagramId"),
                   rs.getString("facebookId"),
                   rs.getString("vkId"),
                   rs.getString("youtubeId"),
                   rs.getString("twitterId"),
                   rs.getInt("status"),
                   rs.getInt("agree"),
                   rs.getString("addedTime"));
			 }
		  }
	   );

      return r;
   }

   @GetMapping
   public String showPage(@RequestParam("id") String recordId, Model model) {

      List<CoderTeachers> results = getRecord(recordId);

      if(!results.isEmpty())
      {
         model.addAttribute("coderTeachersRecord", results.get(0));
      }
      else
      {
         model.addAttribute("errorOutput", "Запись не найдена.");
         return "admin/adminErrorGeneral";
      }

	  model.addAttribute("coderTeachers", new CoderTeachers());

      return "admin/adminTeachersEdit";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderTeachers") @Valid CoderTeachers coderTeachers, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "admin/adminadminTeachersEdit";
      }

      int n = jdbc.update("UPDATE c0d3r_teachers SET id=?,"
            + "teacherFirstName=?,"
            + "teacherMiddleName=?,"
            + "teacherLastName=?,"
            + "teacherEmail=?,"
            + "teacherLogin=?,"
            + "teacherPassword=?,"
            + "teacherPasswordMatch=?,"
            + "teacherCompanyName=?,"
            + "teacherAddress=?,"
            + "teacherPhone=?,"
            + "teacherCity=?,"
            + "teacherZip=?,"
            + "teacherState=?,"
            + "teacherCountry=?,"
            + "teacherAboutMe=?,"
            + "profilePhotoUrl=?,"
            + "teacherType=?,"
            + "teacherAuthority=?,"
            + "teacherMembership=?,"
            + "teacherActivated=?,"
            + "activationCode=?,"
            + "teacherCoursesEnrolled=?,"
            + "teacherTasksCreated=?,"
            + "lastLoginTime=CURRENT_TIMESTAMP,"
            + "prevLoginTime=CURRENT_TIMESTAMP,"
            + "instagramId=?,"
            + "facebookId=?,"
            + "vkId=?,"
            + "youtubeId=?,"
            + "twitterId=?,"
            + "status=?,"
            + "agree=?,"
            + "addedTime=CURRENT_TIMESTAMP WHERE id=?",
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
            coderTeachers.getAddedTime(),
            coderTeachers.getId());

	  if(n > 0)
	  {
		 List<CoderTeachers> results = getRecord(String.valueOf(coderTeachers.getId()));

	     if(!results.isEmpty())
	     {
	    	 model.addAttribute("coderTeachersRecord", results.get(0));
	     }
	     else
	     {
	    	 model.addAttribute("operationError", "Запись не найдена.");
	    	 return "admin/adminErrorGeneral";
	     }

		 model.addAttribute("coderTeachers", new CoderTeachers());

		 model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "admin/adminTeachersEdit";
   }
}

