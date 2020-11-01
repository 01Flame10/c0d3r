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
import com.coder.main.CoderCourseSections;

@Controller
@RequestMapping("/teacherCourseSectionsEdit")
public class TeacherCourseSectionsEditController {

   @Autowired
   private JdbcTemplate jdbc;

   private List<CoderCourseSections> getRecord(String id)
   {
      List<CoderCourseSections> r = jdbc.query("SELECT * FROM c0d3r_course_sections WHERE id = ?",
		  new Object[] { id },
		  new RowMapper<CoderCourseSections>() {
		     @Override
		     public CoderCourseSections mapRow(ResultSet rs, int rowNum) throws SQLException {
		        return new CoderCourseSections(rs.getLong("id"),
                   rs.getLong("courseId"),
                   rs.getString("sectionName"),
                   rs.getString("localeName"),
                   rs.getInt("sectionType"),
                   rs.getString("sectionDescription"),
                   rs.getInt("status"),
                   rs.getString("addedTime"));
			 }
		  }
	   );

      return r;
   }

   @GetMapping
   public String showPage(@RequestParam("id") String recordId, Model model) {

      List<CoderCourseSections> results = getRecord(recordId);

      if(!results.isEmpty())
      {
         model.addAttribute("coderCourseSectionsRecord", results.get(0));
      }
      else
      {
         model.addAttribute("errorOutput", "Запись не найдена.");
         return "teacher/teacherErrorGeneral";
      }

	  model.addAttribute("coderCourseSections", new CoderCourseSections());

      return "teacher/teacherCourseSectionsEdit";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderCourseSections") @Valid CoderCourseSections coderCourseSections, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "teacher/teacherCourseSectionsEdit";
      }

      int n = jdbc.update("UPDATE c0d3r_course_sections SET id=?,"
            + "courseId=?,"
            + "sectionName=?,"
            + "localeName=?,"
            + "sectionType=?,"
            + "sectionDescription=?,"
            + "status=?,"
            + "addedTime=CURRENT_TIMESTAMP WHERE id=?",
            coderCourseSections.getId(),
            coderCourseSections.getCourseId(),
            coderCourseSections.getSectionName(),
            coderCourseSections.getLocaleName(),
            coderCourseSections.getSectionType(),
            coderCourseSections.getSectionDescription(),
            coderCourseSections.getStatus(),
            coderCourseSections.getAddedTime(),
            coderCourseSections.getId());

	  if(n > 0)
	  {
		 List<CoderCourseSections> results = getRecord(String.valueOf(coderCourseSections.getId()));

	     if(!results.isEmpty())
	     {
	    	 model.addAttribute("coderCourseSectionsRecord", results.get(0));
	     }
	     else
	     {
	    	 model.addAttribute("operationError", "Запись не найдена.");
	    	 return "teacher/teacherErrorGeneral";
	     }

		 model.addAttribute("coderCourseSections", new CoderCourseSections());

		 model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "teacher/teacherCourseSectionsEdit";
   }
}

