package com.coder.main.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import com.coder.main.CoderStudents;

@Controller
@RequestMapping("/studentStudentsDelete")
public class StudentStudentsDeleteController {

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
   @PostMapping
   public ModelAndView showPage(@RequestParam("id") String recordId, Model model) {

	  List<CoderStudents> results = getRecord(recordId);

	  ModelAndView mv = new ModelAndView("redirect:/studentStudents");

      if(!results.isEmpty())
      {
         int n = jdbc.update("DELETE FROM c0d3r_students WHERE id=?", recordId);
         if(n > 0)
         {
        	 mv.addObject("operationSuccess", "Операция произведена успешно!");
         }
         else
         {
            mv.addObject("operationError", "Ошибка удаления записи.");
         }
      }
      else
      {
    	  mv.addObject("operationError", "Запись не найдена.");
      }

      return mv;
   }
}

