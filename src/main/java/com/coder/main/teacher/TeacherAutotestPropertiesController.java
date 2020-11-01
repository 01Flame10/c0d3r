package com.coder.main.teacher;

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
import com.coder.main.CoderAutotestProperties;

@Controller
@RequestMapping("/teacherAutotestProperties")
public class TeacherAutotestPropertiesController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      String strOutput = "";

      List<CoderAutotestProperties> results = jdbc.query("SELECT * FROM c0d3r_task_autotest_properties ORDER BY id DESC",
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
      for(CoderAutotestProperties r : results) {
         strOutput += "<tr>";
		 strOutput += "<th scope='row'>"+r.getId()+"</th>";
		 strOutput += "<td>"+r.getTaskId()+"</td>";
		 strOutput += "<td>"+r.getLanguageId()+"</td>";
		 strOutput += "<td>"+r.getRewardValue()+"</td>";
		 strOutput += "<td>"+r.getStatus()+"</td>";
		 strOutput += "<td>"+r.getAddedTime()+"</td>";
         strOutput += "<td style='text-align:right;'><nobr><a href='#' onClick='showDetails("+r.getId()+");return false;' role='button' class='btn btn-primary btn-sm'><i class='fas fa-eye'></i></a><a href='/adminAutotestpropertiesEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminAutotestpropertiesDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td>";
         strOutput += "</tr>";
      }

      if(strOutput.length() == 0) {

         strOutput += "<tr>";
         strOutput += "<td colspan='7' style='text-align:center;'><b>Записи не найдены.</b></td>";
         strOutput += "</tr>";
      }

      model.addAttribute("output", strOutput);

      return "teacher/teacherAutotestProperties";
   }
}

