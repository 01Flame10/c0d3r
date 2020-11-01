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
import com.coder.main.CoderCourses;

@Controller
@RequestMapping("/teacherCoursesEdit")
public class TeacherCoursesEditController {

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
   public String showPage(@RequestParam("id") String recordId, Model model) {

      List<CoderCourses> results = getRecord(recordId);

      if(!results.isEmpty())
      {
         model.addAttribute("coderCoursesRecord", results.get(0));
      }
      else
      {
         model.addAttribute("errorOutput", "Запись не найдена.");
         return "teacher/teacherErrorGeneral";
      }

	  model.addAttribute("coderCourses", new CoderCourses());

      return "teacher/teacherCoursesEdit";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderCourses") @Valid CoderCourses coderCourses, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "teacher/teacherCoursesEdit";
      }

      int n = jdbc.update("UPDATE c0d3r_courses SET id=?,"
            + "courseName=?,"
            + "localeName=?,"
            + "courseType=?,"
            + "courseDescription=?,"
            + "status=?,"
            + "addedTime=CURRENT_TIMESTAMP WHERE id=?",
            coderCourses.getId(),
            coderCourses.getCourseName(),
            coderCourses.getLocaleName(),
            coderCourses.getCourseType(),
            coderCourses.getCourseDescription(),
            coderCourses.getStatus(),
            coderCourses.getAddedTime(),
            coderCourses.getId());

	  if(n > 0)
	  {
		 List<CoderCourses> results = getRecord(String.valueOf(coderCourses.getId()));

	     if(!results.isEmpty())
	     {
	    	 model.addAttribute("coderCoursesRecord", results.get(0));
	     }
	     else
	     {
	    	 model.addAttribute("operationError", "Запись не найдена.");
	    	 return "teacher/teacherErrorGeneral";
	     }

		 model.addAttribute("coderCourses", new CoderCourses());

		 model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "teacher/teacherCoursesEdit";
   }
}

