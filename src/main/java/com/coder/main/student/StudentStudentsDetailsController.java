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
import com.coder.main.CoderStudents;

@Controller
@RequestMapping(value = "/studentStudentsDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentStudentsDetailsController {

   @Autowired
   private JdbcTemplate jdbc;

   @PostMapping
   public ResponseEntity<String> showJSON(@RequestParam("id") String recordId) {

      String strOutput = "<table class='table table-striped'>";

      List<CoderStudents> results = jdbc.query("SELECT * FROM c0d3r_students WHERE id=?",
         new Object[] { recordId },
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
         strOutput += "<tr><td>ID:</td><td>"+r.getId()+"</td></tr>";
         strOutput += "<tr><td>Имя:</td><td>"+r.getStudentFirstName()+"</td></tr>";
         strOutput += "<tr><td>Отчество:</td><td>"+r.getStudentMiddleName()+"</td></tr>";
         strOutput += "<tr><td>Фамилия:</td><td>"+r.getStudentLastName()+"</td></tr>";
         strOutput += "<tr><td>Email:</td><td>"+r.getStudentEmail()+"</td></tr>";
         strOutput += "<tr><td>Логин:</td><td>"+r.getStudentLogin()+"</td></tr>";
         strOutput += "<tr><td>Пароль:</td><td>"+r.getStudentPassword()+"</td></tr>";
         strOutput += "<tr><td>Пароль повторно:</td><td>"+r.getStudentPasswordMatch()+"</td></tr>";
         strOutput += "<tr><td>Компания:</td><td>"+r.getStudentCompanyName()+"</td></tr>";
         strOutput += "<tr><td>Адрес:</td><td>"+r.getStudentAddress()+"</td></tr>";
         strOutput += "<tr><td>Телефон:</td><td>"+r.getStudentPhone()+"</td></tr>";
         strOutput += "<tr><td>Город:</td><td>"+r.getStudentCity()+"</td></tr>";
         strOutput += "<tr><td>Индекс:</td><td>"+r.getStudentZip()+"</td></tr>";
         strOutput += "<tr><td>Регион:</td><td>"+r.getStudentState()+"</td></tr>";
         strOutput += "<tr><td>Страна:</td><td>"+r.getStudentCountry()+"</td></tr>";
         strOutput += "<tr><td>Обо мне:</td><td>"+r.getStudentAboutMe()+"</td></tr>";
         strOutput += "<tr><td>Фото:</td><td>"+r.getProfilePhotoUrl()+"</td></tr>";
         strOutput += "<tr><td>Тип пользователя:</td><td>"+r.getStudentType()+"</td></tr>";
         strOutput += "<tr><td>Авторизация:</td><td>"+r.getStudentAuthority()+"</td></tr>";
         strOutput += "<tr><td>Тарифный план:</td><td>"+r.getStudentMembership()+"</td></tr>";
         strOutput += "<tr><td>Пользователь активирован:</td><td>"+r.getStudentActivated()+"</td></tr>";
         strOutput += "<tr><td>Код активации:</td><td>"+r.getActivationCode()+"</td></tr>";
         strOutput += "<tr><td>Рейтинг студента:</td><td>"+r.getStudentRating()+"</td></tr>";
         strOutput += "<tr><td>Открытые курсы:</td><td>"+r.getStudentCoursesEnrolled()+"</td></tr>";
         strOutput += "<tr><td>Количество выполненных задач:</td><td>"+r.getStudentTasksComplete()+"</td></tr>";
         strOutput += "<tr><td>Последний логин:</td><td>"+r.getLastLoginTime()+"</td></tr>";
         strOutput += "<tr><td>Предпоследний логин:</td><td>"+r.getPrevLoginTime()+"</td></tr>";
         strOutput += "<tr><td>Instagram Id:</td><td>"+r.getInstagramId()+"</td></tr>";
         strOutput += "<tr><td>Facebook Id:</td><td>"+r.getFacebookId()+"</td></tr>";
         strOutput += "<tr><td>VK Id:</td><td>"+r.getVkId()+"</td></tr>";
         strOutput += "<tr><td>YouTube Id:</td><td>"+r.getYoutubeId()+"</td></tr>";
         strOutput += "<tr><td>Twitter Id:</td><td>"+r.getTwitterId()+"</td></tr>";
         strOutput += "<tr><td>Статус:</td><td>"+r.getStatus()+"</td></tr>";
         strOutput += "<tr><td>Согласие с условиями:</td><td>"+r.getAgree()+"</td></tr>";
         strOutput += "<tr><td>Дата создания:</td><td>"+r.getAddedTime()+"</td></tr>";
         strOutput += "<tr><td></td><td><a href='/adminStudentsEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminStudentsDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td><tr>";
      }

	  strOutput += "</table>";

	  return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body("{\"status\" : \"OK\", \"output\" : "+JSONObject.quote(strOutput)+"}");
   }
}

