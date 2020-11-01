package com.coder.main.teacher;

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
import com.coder.main.CoderGroups;

@Controller
@RequestMapping("/teacherGroupsEdit")
public class TeacherGroupsEditController {

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
   public String showPage(@RequestParam("id") String recordId, Model model) {

      List<CoderGroups> results = getRecord(recordId);

      if(!results.isEmpty())
      {
         model.addAttribute("coderGroupsRecord", results.get(0));
      }
      else
      {
         model.addAttribute("errorOutput", "Запись не найдена.");
         return "teacher/teacherErrorGeneral";
      }

	  model.addAttribute("coderGroups", new CoderGroups());

      return "teacher/teacherGroupsEdit";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderGroups") @Valid CoderGroups coderGroups, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "teacher/teacherGroupsEdit";
      }

      int n = jdbc.update("UPDATE c0d3r_groups SET id=?,"
            + "classId=?,"
            + "groupName=?,"
            + "localeName=?,"
            + "groupType=?,"
            + "groupDescription=?,"
            + "status=?,"
            + "addedTime=CURRENT_TIMESTAMP WHERE id=?",
            coderGroups.getId(),
            coderGroups.getClassId(),
            coderGroups.getGroupName(),
            coderGroups.getLocaleName(),
            coderGroups.getGroupType(),
            coderGroups.getGroupDescription(),
            coderGroups.getStatus(),
            coderGroups.getAddedTime(),
            coderGroups.getId());

	  if(n > 0)
	  {
		 List<CoderGroups> results = getRecord(String.valueOf(coderGroups.getId()));

	     if(!results.isEmpty())
	     {
	    	 model.addAttribute("coderGroupsRecord", results.get(0));
	     }
	     else
	     {
	    	 model.addAttribute("operationError", "Запись не найдена.");
	    	 return "teacher/teacherErrorGeneral";
	     }

		 model.addAttribute("coderGroups", new CoderGroups());

		 model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "teacher/teacherGroupsEdit";
   }
}

