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
import com.coder.main.CoderTasks;

@Controller
@RequestMapping("/teacherTasksDelete")
public class TeacherTasksDeleteController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderTasks> getRecord(String id)
   {
      List<CoderTasks> r = jdbc.query("SELECT * FROM c0d3r_tasks WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderTasks>() {
		     @Override
		     public CoderTasks mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderTasks(rs.getLong("id"),
                   rs.getLong("courseId"),
                   rs.getLong("sectionId"),
                   rs.getInt("languageId"),
                   rs.getLong("teacherId"),
                   rs.getString("taskName"),
                   rs.getString("localeName"),
                   rs.getInt("taskType"),
                   rs.getFloat("taskValue"),
                   rs.getString("taskDescription"),
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

	  List<CoderTasks> results = getRecord(recordId);

	  ModelAndView mv = new ModelAndView("redirect:/teacherTasks");

      if(!results.isEmpty())
      {
         int n = jdbc.update("DELETE FROM c0d3r_tasks WHERE id=?", recordId);
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

