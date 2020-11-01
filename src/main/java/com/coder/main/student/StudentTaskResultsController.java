package com.coder.main.student;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.coder.main.CoderTaskResults;

@Controller
@RequestMapping("/studentTaskResults")
public class StudentTaskResultsController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      String strOutput = "";

      List<CoderTaskResults> results = jdbc.query("SELECT * FROM c0d3r_task_results ORDER BY id DESC",
         new RowMapper<CoderTaskResults>() {
            @Override
            public CoderTaskResults mapRow(ResultSet rs, int rowNum) throws SQLException {
               return new CoderTaskResults(rs.getLong("id"),
                  rs.getLong("taskId"),
                  rs.getLong("studentId"),
                  rs.getInt("languageId"),
                  rs.getString("localeName"),
                  rs.getFloat("resultValue"),
                  rs.getString("resultDescription"),
                  rs.getInt("status"),
                  rs.getString("addedTime"));
            }
         }
      );
      for(CoderTaskResults r : results) {
         strOutput += "<tr>";
		 strOutput += "<th scope='row'>"+r.getId()+"</th>";
		 strOutput += "<td>"+r.getTaskId()+"</td>";
		 strOutput += "<td>"+r.getStudentId()+"</td>";
		 strOutput += "<td>"+r.getLanguageId()+"</td>";
		 strOutput += "<td>"+r.getLocaleName()+"</td>";
		 strOutput += "<td>"+r.getResultValue()+"</td>";
		 strOutput += "<td>"+r.getStatus()+"</td>";
		 strOutput += "<td>"+r.getAddedTime()+"</td>";
         strOutput += "<td style='text-align:right;'><nobr><a href='#' onClick='showDetails("+r.getId()+");return false;' role='button' class='btn btn-primary btn-sm'><i class='fas fa-eye'></i></a><a href='/adminTaskresultsEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminTaskresultsDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td>";
         strOutput += "</tr>";
      }

      if(strOutput.length() == 0) {

         strOutput += "<tr>";
         strOutput += "<td colspan='9' style='text-align:center;'><b>Записи не найдены.</b></td>";
         strOutput += "</tr>";
      }

      model.addAttribute("output", strOutput);

      return "student/studentTaskResults";
   }
}

