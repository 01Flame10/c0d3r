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
import com.coder.main.CoderTeachers;

@Controller
@RequestMapping(value = "/studentTeachersDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentTeachersDetailsController {

   @Autowired
   private JdbcTemplate jdbc;

   @PostMapping
   public ResponseEntity<String> showJSON(@RequestParam("id") String recordId) {

      String strOutput = "<table class='table table-striped'>";

      List<CoderTeachers> results = jdbc.query("SELECT * FROM c0d3r_teachers WHERE id=?",
         new Object[] { recordId },
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
         strOutput += "<tr><td>ID:</td><td>"+r.getId()+"</td></tr>";
         strOutput += "<tr><td>Имя:</td><td>"+r.getTeacherFirstName()+"</td></tr>";
         strOutput += "<tr><td>Отчество:</td><td>"+r.getTeacherMiddleName()+"</td></tr>";
         strOutput += "<tr><td>Фамилия:</td><td>"+r.getTeacherLastName()+"</td></tr>";
         strOutput += "<tr><td>Email:</td><td>"+r.getTeacherEmail()+"</td></tr>";
         strOutput += "<tr><td>Логин:</td><td>"+r.getTeacherLogin()+"</td></tr>";
         strOutput += "<tr><td>Пароль:</td><td>"+r.getTeacherPassword()+"</td></tr>";
         strOutput += "<tr><td>Пароль повторно:</td><td>"+r.getTeacherPasswordMatch()+"</td></tr>";
         strOutput += "<tr><td>Компания:</td><td>"+r.getTeacherCompanyName()+"</td></tr>";
         strOutput += "<tr><td>Адрес:</td><td>"+r.getTeacherAddress()+"</td></tr>";
         strOutput += "<tr><td>Телефон:</td><td>"+r.getTeacherPhone()+"</td></tr>";
         strOutput += "<tr><td>Город:</td><td>"+r.getTeacherCity()+"</td></tr>";
         strOutput += "<tr><td>Индекс:</td><td>"+r.getTeacherZip()+"</td></tr>";
         strOutput += "<tr><td>Регион:</td><td>"+r.getTeacherState()+"</td></tr>";
         strOutput += "<tr><td>Страна:</td><td>"+r.getTeacherCountry()+"</td></tr>";
         strOutput += "<tr><td>Обо мне:</td><td>"+r.getTeacherAboutMe()+"</td></tr>";
         strOutput += "<tr><td>Фото:</td><td>"+r.getProfilePhotoUrl()+"</td></tr>";
         strOutput += "<tr><td>Тип пользователя:</td><td>"+r.getTeacherType()+"</td></tr>";
         strOutput += "<tr><td>Авторизация:</td><td>"+r.getTeacherAuthority()+"</td></tr>";
         strOutput += "<tr><td>Тарифный план:</td><td>"+r.getTeacherMembership()+"</td></tr>";
         strOutput += "<tr><td>Пользователь активирован:</td><td>"+r.getTeacherActivated()+"</td></tr>";
         strOutput += "<tr><td>Код активации:</td><td>"+r.getActivationCode()+"</td></tr>";
         strOutput += "<tr><td>Ведет курсы:</td><td>"+r.getTeacherCoursesEnrolled()+"</td></tr>";
         strOutput += "<tr><td>Количество созданных задач:</td><td>"+r.getTeacherTasksCreated()+"</td></tr>";
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
         strOutput += "<tr><td></td><td><a href='/adminTeachersEdit?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm' style='margin-left:5px;'><i class='fas fa-edit'></i></a><a href='/adminTeachersDelete?id="+r.getId()+"' role='button' class='btn btn-primary btn-sm confirm' style='margin-left:5px;'><i class='fas fa-trash'></i></a></nobr></td><tr>";
      }

	  strOutput += "</table>";

	  return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body("{\"status\" : \"OK\", \"output\" : "+JSONObject.quote(strOutput)+"}");
   }
}

