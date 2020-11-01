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
import com.coder.main.CoderAutotestProperties;

@Controller
@RequestMapping("/teacherAutotestPropertiesDelete")
public class TeacherAutotestPropertiesDeleteController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderAutotestProperties> getRecord(String id)
   {
      List<CoderAutotestProperties> r = jdbc.query("SELECT * FROM c0d3r_task_autotest_properties WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderAutotestProperties>() {
		     @Override
		     public CoderAutotestProperties mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderAutotestProperties(rs.getLong("id"),
                   rs.getLong("taskId"),
                   rs.getInt("languageId"),
                   rs.getString("runTimeMillisecondsFrom"),
                   rs.getString("runTimeMillisecondsTo"),
                   rs.getFloat("rewardValue"),
                   rs.getString("inputData"),
                   rs.getString("outputData"),
                   rs.getString("inputURL"),
                   rs.getString("outputURL"),
                   rs.getString("inputFileName"),
                   rs.getString("outputFileName"),
                   rs.getString("inputMethod"),
                   rs.getString("outputMethod"),
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

	  List<CoderAutotestProperties> results = getRecord(recordId);

	  ModelAndView mv = new ModelAndView("redirect:/teacherAutotestProperties");

      if(!results.isEmpty())
      {
         int n = jdbc.update("DELETE FROM c0d3r_task_autotest_properties WHERE id=?", recordId);
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

