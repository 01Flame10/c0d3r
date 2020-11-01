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
import com.coder.main.CoderAutotestResults;

@Controller
@RequestMapping(value = "/adminAutotestResultsDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminAutotestResultsDetailsController {

   @Autowired
   private JdbcTemplate jdbc;

   @PostMapping
   public ResponseEntity<String> showJSON(@RequestParam("id") String recordId) {

      String strOutput = "<table class='table table-striped'>";

      List<CoderAutotestResults> results = jdbc.query("SELECT * FROM c0d3r_task_autotest_results WHERE id=?",
         new Object[] { recordId },
         new RowMapper<CoderAutotestResults>() {
            @Override
            public CoderAutotestResults mapRow(ResultSet rs, int rowNum) throws SQLException {
               return new CoderAutotestResults(rs.getLong("id"),
                  rs.getLong("taskId"),
                  rs.getLong("resultId"),
                  rs.getLong("autotestId"),
                  rs.getInt("languageId"),
                  rs.getString("runTimeMilliseconds"),
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
      for(CoderAutotestResults r : results) {
         strOutput += "<tr><td>ID:</td><td>"+r.getId()+"</td></tr>";
         strOutput += "<tr><td>ID Задачи:</td><td>"+r.getTaskId()+"</td></tr>";
         strOutput += "<tr><td>ID Ответа:</td><td>"+r.getResultId()+"</td></tr>";
         strOutput += "<tr><td>ID Автотеста:</td><td>"+r.getAutotestId()+"</td></tr>";
         strOutput += "<tr><td>Язык программирования:</td><td>"+r.getLanguageId()+"</td></tr>";
         strOutput += "<tr><td>Время выполнения (мсек):</td><td>"+r.getRunTimeMilliseconds()+"</td></tr>";
         strOutput += "<tr><td>Оценка:</td><td>"+r.getRewardValue()+"</td></tr>";
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
         strOutput += "<tr><td></td><td><a href='/adminAutotestresultsEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminAutotestresultsDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td><tr>";
      }

	  strOutput += "</table>";

	  return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body("{\"status\" : \"OK\", \"output\" : "+JSONObject.quote(strOutput)+"}");
   }
}

