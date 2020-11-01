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
import com.coder.main.CoderGroups;

@Controller
@RequestMapping(value = "/adminGroupsDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminGroupsDetailsController {

   @Autowired
   private JdbcTemplate jdbc;

   @PostMapping
   public ResponseEntity<String> showJSON(@RequestParam("id") String recordId) {

      String strOutput = "<table class='table table-striped'>";

      List<CoderGroups> results = jdbc.query("SELECT * FROM c0d3r_groups WHERE id=?",
         new Object[] { recordId },
         new RowMapper<CoderGroups>() {
            @Override
            public CoderGroups mapRow(ResultSet rs, int rowNum) throws SQLException {
               return new CoderGroups(rs.getLong("id"),
                  rs.getLong("classId"),
                  rs.getString("groupName"),
                  rs.getString("localeName"),
                  rs.getInt("groupType"),
                  rs.getString("groupDescription"),
                  rs.getInt("status"),
                  rs.getString("addedTime"));
            }
         }
      );
      for(CoderGroups r : results) {
         strOutput += "<tr><td>ID:</td><td>"+r.getId()+"</td></tr>";
         strOutput += "<tr><td>ID Класса:</td><td>"+r.getClassId()+"</td></tr>";
         strOutput += "<tr><td>Группа:</td><td>"+r.getGroupName()+"</td></tr>";
         strOutput += "<tr><td>Локализация:</td><td>"+r.getLocaleName()+"</td></tr>";
         strOutput += "<tr><td>Тип:</td><td>"+r.getGroupType()+"</td></tr>";
         strOutput += "<tr><td>Описание:</td><td>"+r.getGroupDescription()+"</td></tr>";
         strOutput += "<tr><td>Статус:</td><td>"+r.getStatus()+"</td></tr>";
         strOutput += "<tr><td>Дата создания:</td><td>"+r.getAddedTime()+"</td></tr>";
         strOutput += "<tr><td></td><td><a href='/adminGroupsEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminGroupsDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td><tr>";
      }

	  strOutput += "</table>";

	  return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body("{\"status\" : \"OK\", \"output\" : "+JSONObject.quote(strOutput)+"}");
   }
}

