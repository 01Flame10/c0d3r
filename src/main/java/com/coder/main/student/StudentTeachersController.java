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
import com.coder.main.CoderTeachers;

@Controller
@RequestMapping("/studentTeachers")
public class StudentTeachersController {

   @Autowired
   private JdbcTemplate jdbc;

   @GetMapping
   public String showPage(Model model) {

      String strOutput = "";

      List<CoderTeachers> results = jdbc.query("SELECT * FROM c0d3r_teachers ORDER BY id DESC",
         new RowMapper<CoderTeachers>() {
            @Override
            public CoderTeachers mapRow(ResultSet rs, int rowNum) throws SQLException {
               return new CoderTeachers(rs.getLong("id"),
                  rs.getString("teacherFirstName"),
                  rs.getString("teacherMiddleName"),
                  rs.getString("teacherLastName"),
                  rs.getString("teacherEmail"),
                  rs.getString("teacherLogin"),
                  rs.getString("teacherPassword"),
                  rs.getString("teacherPasswordMatch"),
                  rs.getString("teacherCompanyName"),
                  rs.getString("teacherAddress"),
                  rs.getString("teacherPhone"),
                  rs.getString("teacherCity"),
                  rs.getString("teacherZip"),
                  rs.getString("teacherState"),
                  rs.getString("teacherCountry"),
                  rs.getString("teacherAboutMe"),
                  rs.getString("profilePhotoUrl"),
                  rs.getInt("teacherType"),
                  rs.getString("teacherAuthority"),
                  rs.getInt("teacherMembership"),
                  rs.getInt("teacherActivated"),
                  rs.getString("activationCode"),
                  rs.getInt("teacherCoursesEnrolled"),
                  rs.getInt("teacherTasksCreated"),
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
      for(CoderTeachers r : results) {
         strOutput += "<tr>";
		 strOutput += "<th scope='row'>"+r.getId()+"</th>";
		 strOutput += "<td>"+r.getTeacherFirstName()+"</td>";
		 strOutput += "<td>"+r.getTeacherEmail()+"</td>";
		 strOutput += "<td>"+r.getTeacherLogin()+"</td>";
		 strOutput += "<td>"+r.getTeacherPhone()+"</td>";
		 strOutput += "<td>"+r.getStatus()+"</td>";
		 strOutput += "<td>"+r.getAddedTime()+"</td>";
         strOutput += "<td style='text-align:right;'><nobr><a href='#' onClick='showDetails("+r.getId()+");return false;' role='button' class='btn btn-primary btn-sm'><i class='fas fa-eye'></i></a><a href='/adminTeachersEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminTeachersDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td>";
         strOutput += "</tr>";
      }

      if(strOutput.length() == 0) {

         strOutput += "<tr>";
         strOutput += "<td colspan='8' style='text-align:center;'><b>Записи не найдены.</b></td>";
         strOutput += "</tr>";
      }

      model.addAttribute("output", strOutput);

      return "student/studentTeachers";
   }
}

