package com.coder.main.admin;

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
import com.coder.main.CoderTasks;

@Controller
@RequestMapping(value = "/adminTasksDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminTasksDetailsController {

   @Autowired
   private JdbcTemplate jdbc;

   @PostMapping
   public ResponseEntity<String> showJSON(@RequestParam("id") String recordId) {

      String strOutput = "<table class='table table-striped'>";

      List<CoderTasks> results = jdbc.query("SELECT * FROM c0d3r_tasks WHERE id=?",
         new Object[] { recordId },
         new RowMapper<CoderTasks>() {
            @Override
            public CoderTasks mapRow(ResultSet rs, int rowNum) throws SQLException {
               return new CoderTasks(rs.getLong("id"),
                  rs.getLong("courseId"),
                  rs.getLong("sectionId"),
                  rs.getInt("languageId"),
                  rs.getLong("teacherId"),
                  rs.getString("taskName"),
                  rs.getString("localeName"),
                  rs.getInt("taskType"),
                  rs.getFloat("taskValue"),
                  rs.getString("taskDescription"),
                  rs.getInt("status"),
                  rs.getString("addedTime"));
            }
         }
      );
      for(CoderTasks r : results) {
         strOutput += "<tr><td>ID:</td><td>"+r.getId()+"</td></tr>";
         strOutput += "<tr><td>ID Курса:</td><td>"+r.getCourseId()+"</td></tr>";
         strOutput += "<tr><td>ID Раздела:</td><td>"+r.getSectionId()+"</td></tr>";
         strOutput += "<tr><td>Язык программирования:</td><td>"+r.getLanguageId()+"</td></tr>";
         strOutput += "<tr><td>Преподаватель:</td><td>"+r.getTeacherId()+"</td></tr>";
         strOutput += "<tr><td>Название задачи:</td><td>"+r.getTaskName()+"</td></tr>";
         strOutput += "<tr><td>Локализация:</td><td>"+r.getLocaleName()+"</td></tr>";
         strOutput += "<tr><td>Тип:</td><td>"+r.getTaskType()+"</td></tr>";
         strOutput += "<tr><td>Поинты:</td><td>"+r.getTaskValue()+"</td></tr>";
         strOutput += "<tr><td>Описание:</td><td>"+r.getTaskDescription()+"</td></tr>";
         strOutput += "<tr><td>Статус:</td><td>"+r.getStatus()+"</td></tr>";
         strOutput += "<tr><td>Дата создания:</td><td>"+r.getAddedTime()+"</td></tr>";
         strOutput += "<tr><td></td><td><a href='/adminTasksEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminTasksDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td><tr>";
      }

	  strOutput += "</table>";

	  return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body("{\"status\" : \"OK\", \"output\" : "+JSONObject.quote(strOutput)+"}");
   }
}

