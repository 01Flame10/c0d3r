package com.coder.main.admin;

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
import com.coder.main.CoderClasses;

@Controller
@RequestMapping("/adminClassesEdit")
public class AdminClassesEditController {

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
   public String showPage(@RequestParam("id") String recordId, Model model) {

      List<CoderClasses> results = getRecord(recordId);

      if(!results.isEmpty())
      {
         model.addAttribute("coderClassesRecord", results.get(0));
      }
      else
      {
         model.addAttribute("errorOutput", "Запись не найдена.");
         return "admin/adminErrorGeneral";
      }

	  model.addAttribute("coderClasses", new CoderClasses());

      return "admin/adminClassesEdit";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderClasses") @Valid CoderClasses coderClasses, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "admin/adminadminClassesEdit";
      }

      int n = jdbc.update("UPDATE c0d3r_classes SET id=?,"
            + "className=?,"
            + "localeName=?,"
            + "classType=?,"
            + "classDescription=?,"
            + "status=?,"
            + "addedTime=CURRENT_TIMESTAMP WHERE id=?",
            coderClasses.getId(),
            coderClasses.getClassName(),
            coderClasses.getLocaleName(),
            coderClasses.getClassType(),
            coderClasses.getClassDescription(),
            coderClasses.getStatus(),
            coderClasses.getAddedTime(),
            coderClasses.getId());

	  if(n > 0)
	  {
		 List<CoderClasses> results = getRecord(String.valueOf(coderClasses.getId()));

	     if(!results.isEmpty())
	     {
	    	 model.addAttribute("coderClassesRecord", results.get(0));
	     }
	     else
	     {
	    	 model.addAttribute("operationError", "Запись не найдена.");
	    	 return "admin/adminErrorGeneral";
	     }

		 model.addAttribute("coderClasses", new CoderClasses());

		 model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "admin/adminClassesEdit";
   }
}

