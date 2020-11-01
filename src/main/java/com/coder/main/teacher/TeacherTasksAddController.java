package com.coder.main.teacher;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.coder.main.CoderTasks;

@Controller
@RequestMapping("/teacherTasksAdd")
public class TeacherTasksAddController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      model.addAttribute("coderTasks", new CoderTasks());

      return "teacher/teacherTasksAdd";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderTasks") @Valid CoderTasks coderTasks, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "teacher/teacherTasksAdd";
      }

	  int n = jdbc.update("INSERT INTO c0d3r_tasks (id,"
            + "courseId,"
            + "sectionId,"
            + "languageId,"
            + "teacherId,"
            + "taskName,"
            + "localeName,"
            + "taskType,"
            + "taskValue,"
            + "taskDescription,"
            + "status,"
            + "addedTime) values(?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "CURRENT_TIMESTAMP)",
	  		coderTasks.getId(),
	  		coderTasks.getCourseId(),
	  		coderTasks.getSectionId(),
	  		coderTasks.getLanguageId(),
	  		coderTasks.getTeacherId(),
	  		coderTasks.getTaskName(),
	  		coderTasks.getLocaleName(),
	  		coderTasks.getTaskType(),
	  		coderTasks.getTaskValue(),
	  		coderTasks.getTaskDescription(),
	  		coderTasks.getStatus(),
	  		coderTasks.getAddedTime());
	  if(n > 0)
	  {
	     model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "teacher/teacherTasksAdd";
   }
}

