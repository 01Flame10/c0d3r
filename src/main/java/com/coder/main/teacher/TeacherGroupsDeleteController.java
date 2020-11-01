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
import com.coder.main.CoderGroups;

@Controller
@RequestMapping("/teacherGroupsDelete")
public class TeacherGroupsDeleteController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderGroups> getRecord(String id)
   {
      List<CoderGroups> r = jdbc.query("SELECT * FROM c0d3r_groups WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderGroups>() {
		     @Override
		     public CoderGroups mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderGroups(rs.getLong("id"),
                   rs.getLong("classId"),
                   rs.getString("groupName"),
                   rs.getString("localeName"),
                   rs.getInt("groupType"),
                   rs.getString("groupDescription"),
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

	  List<CoderGroups> results = getRecord(recordId);

	  ModelAndView mv = new ModelAndView("redirect:/teacherGroups");

      if(!results.isEmpty())
      {
         int n = jdbc.update("DELETE FROM c0d3r_groups WHERE id=?", recordId);
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

