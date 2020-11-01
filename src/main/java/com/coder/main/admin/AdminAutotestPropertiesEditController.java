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
import com.coder.main.CoderAutotestProperties;

@Controller
@RequestMapping("/adminAutotestPropertiesEdit")
public class AdminAutotestPropertiesEditController {

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
   public String showPage(@RequestParam("id") String recordId, Model model) {

      List<CoderAutotestProperties> results = getRecord(recordId);

      if(!results.isEmpty())
      {
         model.addAttribute("coderAutotestPropertiesRecord", results.get(0));
      }
      else
      {
         model.addAttribute("errorOutput", "Запись не найдена.");
         return "admin/adminErrorGeneral";
      }

	  model.addAttribute("coderAutotestProperties", new CoderAutotestProperties());

      return "admin/adminAutotestPropertiesEdit";
   }

   @PostMapping
   public String processRequest(@ModelAttribute("coderAutotestProperties") @Valid CoderAutotestProperties coderAutotestProperties, BindingResult bindingResult, Model model, Errors errors) {

	  if(errors.hasErrors()) {

	     return "admin/adminadminAutotestPropertiesEdit";
      }

      int n = jdbc.update("UPDATE c0d3r_task_autotest_properties SET id=?,"
            + "taskId=?,"
            + "languageId=?,"
            + "runTimeMillisecondsFrom=?,"
            + "runTimeMillisecondsTo=?,"
            + "rewardValue=?,"
            + "inputData=?,"
            + "outputData=?,"
            + "inputURL=?,"
            + "outputURL=?,"
            + "inputFileName=?,"
            + "outputFileName=?,"
            + "inputMethod=?,"
            + "outputMethod=?,"
            + "status=?,"
            + "addedTime=CURRENT_TIMESTAMP WHERE id=?",
            coderAutotestProperties.getId(),
            coderAutotestProperties.getTaskId(),
            coderAutotestProperties.getLanguageId(),
            coderAutotestProperties.getRunTimeMillisecondsFrom(),
            coderAutotestProperties.getRunTimeMillisecondsTo(),
            coderAutotestProperties.getRewardValue(),
            coderAutotestProperties.getInputData(),
            coderAutotestProperties.getOutputData(),
            coderAutotestProperties.getInputURL(),
            coderAutotestProperties.getOutputURL(),
            coderAutotestProperties.getInputFileName(),
            coderAutotestProperties.getOutputFileName(),
            coderAutotestProperties.getInputMethod(),
            coderAutotestProperties.getOutputMethod(),
            coderAutotestProperties.getStatus(),
            coderAutotestProperties.getAddedTime(),
            coderAutotestProperties.getId());

	  if(n > 0)
	  {
		 List<CoderAutotestProperties> results = getRecord(String.valueOf(coderAutotestProperties.getId()));

	     if(!results.isEmpty())
	     {
	    	 model.addAttribute("coderAutotestPropertiesRecord", results.get(0));
	     }
	     else
	     {
	    	 model.addAttribute("operationError", "Запись не найдена.");
	    	 return "admin/adminErrorGeneral";
	     }

		 model.addAttribute("coderAutotestProperties", new CoderAutotestProperties());

		 model.addAttribute("operationSuccess", "Операция успешно выполнена!");
	  }
	  else
	  {
		 model.addAttribute("operationError", "Ошибка операции с БД.");
	  }

      return "admin/adminAutotestPropertiesEdit";
   }
}

