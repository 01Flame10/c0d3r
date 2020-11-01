package com.coder.main.teacher;

import org.springframework.http.MediaType;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.json.JSONObject;
import com.coder.main.CoderCourses;

@Controller
@RequestMapping(value = "/teacherCoursesDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public class TeacherCoursesDetailsController {

   @Autowired
   private JdbcTemplate jdbc;

   @PostMapping
   public ResponseEntity<String> showJSON(@RequestParam("id") String recordId) {

      String strOutput = "<table class='table table-striped'>";

      List<CoderCourses> results = jdbc.query("SELECT * FROM c0d3r_courses WHERE id=?",
         new Object[] { recordId },
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
      for(CoderCourses r : results) {
         strOutput += "<tr><td>ID:</td><td>"+r.getId()+"</td></tr>";
         strOutput += "<tr><td>Курс:</td><td>"+r.getCourseName()+"</td></tr>";
         strOutput += "<tr><td>Локализация:</td><td>"+r.getLocaleName()+"</td></tr>";
         strOutput += "<tr><td>Тип:</td><td>"+r.getCourseType()+"</td></tr>";
         strOutput += "<tr><td>Описание:</td><td>"+r.getCourseDescription()+"</td></tr>";
         strOutput += "<tr><td>Статус:</td><td>"+r.getStatus()+"</td></tr>";
         strOutput += "<tr><td>Дата создания:</td><td>"+r.getAddedTime()+"</td></tr>";
         strOutput += "<tr><td></td><td><a href='/adminCoursesEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminCoursesDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td><tr>";
      }

	  strOutput += "</table>";

	  return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body("{\"status\" : \"OK\", \"output\" : "+JSONObject.quote(strOutput)+"}");
   }
}

