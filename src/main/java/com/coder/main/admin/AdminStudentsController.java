package com.coder.main.admin;

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
import com.coder.main.CoderStudents;

@Controller
@RequestMapping("/adminStudents")
public class AdminStudentsController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      String strOutput = "";

      List<CoderStudents> results = jdbc.query("SELECT * FROM c0d3r_students ORDER BY id DESC",
         new RowMapper<CoderStudents>() {
            @Override
            public CoderStudents mapRow(ResultSet rs, int rowNum) throws SQLException {
               return new CoderStudents(rs.getLong("id"),
                  rs.getString("studentFirstName"),
                  rs.getString("studentMiddleName"),
                  rs.getString("studentLastName"),
                  rs.getString("studentEmail"),
                  rs.getString("studentLogin"),
                  rs.getString("studentPassword"),
                  rs.getString("studentPasswordMatch"),
                  rs.getString("studentCompanyName"),
                  rs.getString("studentAddress"),
                  rs.getString("studentPhone"),
                  rs.getString("studentCity"),
                  rs.getString("studentZip"),
                  rs.getString("studentState"),
                  rs.getString("studentCountry"),
                  rs.getString("studentAboutMe"),
                  rs.getString("profilePhotoUrl"),
                  rs.getInt("studentType"),
                  rs.getString("studentAuthority"),
                  rs.getInt("studentMembership"),
                  rs.getInt("studentActivated"),
                  rs.getString("activationCode"),
                  rs.getInt("studentRating"),
                  rs.getInt("studentCoursesEnrolled"),
                  rs.getInt("studentTasksComplete"),
                  rs.getString("lastLoginTime"),
                  rs.getString("prevLoginTime"),
                  rs.getString("instagramId"),
                  rs.getString("facebookId"),
                  rs.getString("vkId"),
                  rs.getString("youtubeId"),
                  rs.getString("twitterId"),
                  rs.getInt("status"),
                  rs.getInt("agree"),
                  rs.getString("addedTime"));
            }
         }
      );
      for(CoderStudents r : results) {
         strOutput += "<tr>";
		 strOutput += "<th scope='row'>"+r.getId()+"</th>";
		 strOutput += "<td>"+r.getStudentEmail()+"</td>";
		 strOutput += "<td>"+r.getStudentLogin()+"</td>";
		 strOutput += "<td>"+r.getStudentPhone()+"</td>";
		 strOutput += "<td>"+r.getStatus()+"</td>";
		 strOutput += "<td>"+r.getAddedTime()+"</td>";
         strOutput += "<td style='text-align:right;'><nobr><a href='#' onClick='showDetails("+r.getId()+");return false;' role='button' class='btn btn-primary btn-sm'><i class='fas fa-eye'></i></a><a href='/adminStudentsEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminStudentsDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td>";
         strOutput += "</tr>";
      }

      if(strOutput.length() == 0) {

         strOutput += "<tr>";
         strOutput += "<td colspan='7' style='text-align:center;'><b>Записи не найдены.</b></td>";
         strOutput += "</tr>";
      }

      model.addAttribute("output", strOutput);

      return "admin/adminStudents";
   }
}

