package com.coder.main.student;

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
import com.coder.main.CoderCourseSections;

@Controller
@RequestMapping(value = "/studentCourseSectionsDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentCourseSectionsDetailsController {

   @Autowired
   private JdbcTemplate jdbc;

   @PostMapping
   public ResponseEntity<String> showJSON(@RequestParam("id") String recordId) {

      String strOutput = "<table class='table table-striped'>";

      List<CoderCourseSections> results = jdbc.query("SELECT * FROM c0d3r_course_sections WHERE id=?",
         new Object[] { recordId },
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
      for(CoderCourseSections r : results) {
         strOutput += "<tr><td>ID:</td><td>"+r.getId()+"</td></tr>";
         strOutput += "<tr><td>ID Курса:</td><td>"+r.getCourseId()+"</td></tr>";
         strOutput += "<tr><td>Раздел:</td><td>"+r.getSectionName()+"</td></tr>";
         strOutput += "<tr><td>Локализация:</td><td>"+r.getLocaleName()+"</td></tr>";
         strOutput += "<tr><td>Тип:</td><td>"+r.getSectionType()+"</td></tr>";
         strOutput += "<tr><td>Описание:</td><td>"+r.getSectionDescription()+"</td></tr>";
         strOutput += "<tr><td>Статус:</td><td>"+r.getStatus()+"</td></tr>";
         strOutput += "<tr><td>Дата создания:</td><td>"+r.getAddedTime()+"</td></tr>";
         strOutput += "<tr><td></td><td><a href='/adminCoursesectionsEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminCoursesectionsDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td><tr>";
      }

	  strOutput += "</table>";

	  return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body("{\"status\" : \"OK\", \"output\" : "+JSONObject.quote(strOutput)+"}");
   }
}

