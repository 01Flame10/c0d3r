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
import com.coder.main.CoderClasses;

@Controller
@RequestMapping("/adminClassesDelete")
public class AdminClassesDeleteController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderClasses> getRecord(String id)
   {
      List<CoderClasses> r = jdbc.query("SELECT * FROM c0d3r_classes WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderClasses>() {
		     @Override
		     public CoderClasses mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderClasses(rs.getLong("id"),
                   rs.getString("className"),
                   rs.getString("localeName"),
                   rs.getInt("classType"),
                   rs.getString("classDescription"),
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

	  List<CoderClasses> results = getRecord(recordId);

	  ModelAndView mv = new ModelAndView("redirect:/adminClasses");

      if(!results.isEmpty())
      {
         int n = jdbc.update("DELETE FROM c0d3r_classes WHERE id=?", recordId);
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

