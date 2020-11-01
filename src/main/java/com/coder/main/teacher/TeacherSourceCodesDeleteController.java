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
import com.coder.main.CoderSourceCodes;

@Controller
@RequestMapping("/teacherSourceCodesDelete")
public class TeacherSourceCodesDeleteController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderSourceCodes> getRecord(String id)
   {
      List<CoderSourceCodes> r = jdbc.query("SELECT * FROM c0d3r_task_result_source_codes WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderSourceCodes>() {
		     @Override
		     public CoderSourceCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderSourceCodes(rs.getLong("id"),
                   rs.getLong("resultId"),
                   rs.getLong("studentId"),
                   rs.getString("fileURL"),
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

	  List<CoderSourceCodes> results = getRecord(recordId);

	  ModelAndView mv = new ModelAndView("redirect:/teacherSourceCodes");

      if(!results.isEmpty())
      {
         int n = jdbc.update("DELETE FROM c0d3r_task_result_source_codes WHERE id=?", recordId);
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

