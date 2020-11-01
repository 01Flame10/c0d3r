package com.coder.main.admin;

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
import com.coder.main.CoderCourses;

@Controller
@RequestMapping("/adminCoursesDelete")
public class AdminCoursesDeleteController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderCourses> getRecord(String id)
   {
      List<CoderCourses> r = jdbc.query("SELECT * FROM c0d3r_courses WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderCourses>() {
		     @Override
		     public CoderCourses mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderCourses(rs.getLong("id"),
                   rs.getString("courseName"),
                   rs.getString("localeName"),
                   rs.getInt("courseType"),
                   rs.getString("courseDescription"),
                   rs.getInt("status"),
                   rs.getString("addedTime"));
			 }
		  }
	   );

      return r;
   }

   @GetMapping
   @PostMapping
   public ModelAndView showPage(@RequestParam("id") String recordId, Model model) {

	  List<CoderCourses> results = getRecord(recordId);

	  ModelAndView mv = new ModelAndView("redirect:/adminCourses");

      if(!results.isEmpty())
      {
         int n = jdbc.update("DELETE FROM c0d3r_courses WHERE id=?", recordId);
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

