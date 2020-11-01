package com.coder.main.student;

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
import com.coder.main.CoderStudents;

@Controller
@RequestMapping("/studentStudentsEdit")
public class StudentStudentsEditController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderStudents> getRecord(String id)
   {
      List<CoderStudents> r = jdbc.query("SELECT * FROM c0d3r_students WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderStudents>() {
		     @Override
		     public CoderStudents mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderStudents(rs.getLong("id"),
                   rs.getString("studentFirstName"),
                   rs.getString("studentMiddleName"),
                   rs.getString("studentLastName"),
                   rs.getString("studentEmail"),
                   rs.getString("studentLogin"),
                   rs.getString("studentPassword"),
                   rs.getString("studentPasswordMatch"),
                   rs.getString("studentCompanyName"),
                   rs.getString("studentAddress"),
                   rs.getString("studentPhone"),
                   rs.getString("studentCity"),
                   rs.getString("studentZip"),
                   rs.getString("studentState"),
                   rs.getString("studentCountry"),
                   rs.getString("studentAboutMe"),
                   rs.getString("profilePhotoUrl"),
                   rs.getInt("studentType"),
                   rs.getString("studentAuthority"),
                   rs.getInt("studentMembership"),
                   rs.getInt("studentActivated"),
                   rs.getString("activationCode"),
                   rs.getInt("studentRating"),
                   rs.getInt("studentCoursesEnrolled"),
                   rs.getInt("studentTasksComplete"),
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

      List<CoderStudents> results = getRecord(recordId);

      if(!results.isEmpty())
      {
         model.addAttribute("coderStudentsRecord", results.get(0));
      }
      else
      {
         model.addAttribute("errorOutput", "Запись не найдена.");
         return "student/studentErrorGeneral";
      }

	  model.addAttribute("coderStudents", new CoderStudents());

      return "student/studentStudentsEdit";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderStudents") @Valid CoderStudents coderStudents, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "student/studentStudentsEdit";
      }

      int n = jdbc.update("UPDATE c0d3r_students SET id=?,"
            + "studentFirstName=?,"
            + "studentMiddleName=?,"
            + "studentLastName=?,"
            + "studentEmail=?,"
            + "studentLogin=?,"
            + "studentPassword=?,"
            + "studentPasswordMatch=?,"
            + "studentCompanyName=?,"
            + "studentAddress=?,"
            + "studentPhone=?,"
            + "studentCity=?,"
            + "studentZip=?,"
            + "studentState=?,"
            + "studentCountry=?,"
            + "studentAboutMe=?,"
            + "profilePhotoUrl=?,"
            + "studentType=?,"
            + "studentAuthority=?,"
            + "studentMembership=?,"
            + "studentActivated=?,"
            + "activationCode=?,"
            + "studentRating=?,"
            + "studentCoursesEnrolled=?,"
            + "studentTasksComplete=?,"
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
            coderStudents.getId(),
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
            coderStudents.getStudentAuthority(),
            coderStudents.getStudentMembership(),
            coderStudents.getStudentActivated(),
            coderStudents.getActivationCode(),
            coderStudents.getStudentRating(),
            coderStudents.getStudentCoursesEnrolled(),
            coderStudents.getStudentTasksComplete(),
            coderStudents.getLastLoginTime(),
            coderStudents.getPrevLoginTime(),
            coderStudents.getInstagramId(),
            coderStudents.getFacebookId(),
            coderStudents.getVkId(),
            coderStudents.getYoutubeId(),
            coderStudents.getTwitterId(),
            coderStudents.getStatus(),
            coderStudents.getAgree(),
            coderStudents.getAddedTime(),
            coderStudents.getId());

	  if(n > 0)
	  {
		 List<CoderStudents> results = getRecord(String.valueOf(coderStudents.getId()));

	     if(!results.isEmpty())
	     {
	    	 model.addAttribute("coderStudentsRecord", results.get(0));
	     }
	     else
	     {
	    	 model.addAttribute("operationError", "Запись не найдена.");
	    	 return "student/studentErrorGeneral";
	     }

		 model.addAttribute("coderStudents", new CoderStudents());

		 model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "student/studentStudentsEdit";
   }
}

