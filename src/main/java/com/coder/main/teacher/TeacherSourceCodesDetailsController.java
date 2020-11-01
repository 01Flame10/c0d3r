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
import com.coder.main.CoderSourceCodes;

@Controller
@RequestMapping(value = "/teacherSourceCodesDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public class TeacherSourceCodesDetailsController {

   @Autowired
   private JdbcTemplate jdbc;

   @PostMapping
   public ResponseEntity<String> showJSON(@RequestParam("id") String recordId) {

      String strOutput = "<table class='table table-striped'>";

      List<CoderSourceCodes> results = jdbc.query("SELECT * FROM c0d3r_task_result_source_codes WHERE id=?",
         new Object[] { recordId },
         new RowMapper<CoderSourceCodes>() {
            @Override
            public CoderSourceCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
               return new CoderSourceCodes(rs.getLong("id"),
                  rs.getLong("resultId"),
                  rs.getLong("studentId"),
                  rs.getString("fileURL"),
                  rs.getInt("status"),
                  rs.getString("addedTime"));
            }
         }
      );
      for(CoderSourceCodes r : results) {
         strOutput += "<tr><td>ID:</td><td>"+r.getId()+"</td></tr>";
         strOutput += "<tr><td>ID Решения:</td><td>"+r.getResultId()+"</td></tr>";
         strOutput += "<tr><td>ID Студента:</td><td>"+r.getStudentId()+"</td></tr>";
         strOutput += "<tr><td>Файл:</td><td>"+r.getFileURL()+"</td></tr>";
         strOutput += "<tr><td>Статус:</td><td>"+r.getStatus()+"</td></tr>";
         strOutput += "<tr><td>Дата создания:</td><td>"+r.getAddedTime()+"</td></tr>";
         strOutput += "<tr><td></td><td><a href='/adminSourcecodesEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminSourcecodesDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td><tr>";
      }

	  strOutput += "</table>";

	  return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body("{\"status\" : \"OK\", \"output\" : "+JSONObject.quote(strOutput)+"}");
   }
}

