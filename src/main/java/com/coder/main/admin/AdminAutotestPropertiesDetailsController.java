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
import com.coder.main.CoderAutotestProperties;

@Controller
@RequestMapping(value = "/adminAutotestPropertiesDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminAutotestPropertiesDetailsController {

   @Autowired
   private JdbcTemplate jdbc;

   @PostMapping
   public ResponseEntity<String> showJSON(@RequestParam("id") String recordId) {

      String strOutput = "<table class='table table-striped'>";

      List<CoderAutotestProperties> results = jdbc.query("SELECT * FROM c0d3r_task_autotest_properties WHERE id=?",
         new Object[] { recordId },
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
         strOutput += "<tr><td>ID:</td><td>"+r.getId()+"</td></tr>";
         strOutput += "<tr><td>ID Задачи:</td><td>"+r.getTaskId()+"</td></tr>";
         strOutput += "<tr><td>Язык программирования:</td><td>"+r.getLanguageId()+"</td></tr>";
         strOutput += "<tr><td>Время выполнения (от, мсек):</td><td>"+r.getRunTimeMillisecondsFrom()+"</td></tr>";
         strOutput += "<tr><td>Время выполнения (до, мсек):</td><td>"+r.getRunTimeMillisecondsTo()+"</td></tr>";
         strOutput += "<tr><td>Поинты:</td><td>"+r.getRewardValue()+"</td></tr>";
         strOutput += "<tr><td>Входные данные:</td><td>"+r.getInputData()+"</td></tr>";
         strOutput += "<tr><td>Выходные данные:</td><td>"+r.getOutputData()+"</td></tr>";
         strOutput += "<tr><td>Входные данные (URL):</td><td>"+r.getInputURL()+"</td></tr>";
         strOutput += "<tr><td>Выходные данные (URL):</td><td>"+r.getOutputURL()+"</td></tr>";
         strOutput += "<tr><td>Входные данные (Файл):</td><td>"+r.getInputFileName()+"</td></tr>";
         strOutput += "<tr><td>Выходные данные (Файл):</td><td>"+r.getOutputFileName()+"</td></tr>";
         strOutput += "<tr><td>Метод входных данных:</td><td>"+r.getInputMethod()+"</td></tr>";
         strOutput += "<tr><td>Метод выходных данных:</td><td>"+r.getOutputMethod()+"</td></tr>";
         strOutput += "<tr><td>Статус:</td><td>"+r.getStatus()+"</td></tr>";
         strOutput += "<tr><td>Дата создания:</td><td>"+r.getAddedTime()+"</td></tr>";
         strOutput += "<tr><td></td><td><a href='/adminAutotestpropertiesEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminAutotestpropertiesDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td><tr>";
      }

	  strOutput += "</table>";

	  return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body("{\"status\" : \"OK\", \"output\" : "+JSONObject.quote(strOutput)+"}");
   }
}

