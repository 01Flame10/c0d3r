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
import com.coder.main.CoderAutotestResults;

@Controller
@RequestMapping("/teacherAutotestResultsDelete")
public class TeacherAutotestResultsDeleteController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderAutotestResults> getRecord(String id)
   {
      List<CoderAutotestResults> r = jdbc.query("SELECT * FROM c0d3r_task_autotest_results WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderAutotestResults>() {
		     @Override
		     public CoderAutotestResults mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderAutotestResults(rs.getLong("id"),
                   rs.getLong("taskId"),
                   rs.getLong("resultId"),
                   rs.getLong("autotestId"),
                   rs.getInt("languageId"),
                   rs.getString("runTimeMilliseconds"),
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

	  List<CoderAutotestResults> results = getRecord(recordId);

	  ModelAndView mv = new ModelAndView("redirect:/teacherAutotestResults");

      if(!results.isEmpty())
      {
         int n = jdbc.update("DELETE FROM c0d3r_task_autotest_results WHERE id=?", recordId);
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

