package com.coder.main.teacher;

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
import com.coder.main.CoderTeachers;

@Controller
@RequestMapping("/teacherTeachersDelete")
public class TeacherTeachersDeleteController {

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
   @PostMapping
   public ModelAndView showPage(@RequestParam("id") String recordId, Model model) {

	  List<CoderTeachers> results = getRecord(recordId);

	  ModelAndView mv = new ModelAndView("redirect:/teacherTeachers");

      if(!results.isEmpty())
      {
         int n = jdbc.update("DELETE FROM c0d3r_teachers WHERE id=?", recordId);
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

