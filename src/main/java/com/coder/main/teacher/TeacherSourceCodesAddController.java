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
import com.coder.main.CoderSourceCodes;

@Controller
@RequestMapping("/teacherSourceCodesAdd")
public class TeacherSourceCodesAddController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      model.addAttribute("coderSourceCodes", new CoderSourceCodes());

      return "teacher/teacherSourceCodesAdd";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderSourceCodes") @Valid CoderSourceCodes coderSourceCodes, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "teacher/teacherSourceCodesAdd";
      }

	  int n = jdbc.update("INSERT INTO c0d3r_task_result_source_codes (id,"
            + "resultId,"
            + "studentId,"
            + "fileURL,"
            + "status,"
            + "addedTime) values(?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "CURRENT_TIMESTAMP)",
	  		coderSourceCodes.getId(),
	  		coderSourceCodes.getResultId(),
	  		coderSourceCodes.getStudentId(),
	  		coderSourceCodes.getFileURL(),
	  		coderSourceCodes.getStatus(),
	  		coderSourceCodes.getAddedTime());
	  if(n > 0)
	  {
	     model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "teacher/teacherSourceCodesAdd";
   }
}

