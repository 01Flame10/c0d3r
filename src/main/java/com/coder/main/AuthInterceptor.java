package com.coder.main;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.coder.main.AuthUser;
import com.coder.main.CoderAdmins;
import com.coder.main.CoderTeachers;
import com.coder.main.CoderStudents;

@Component
public class AuthInterceptor implements HandlerInterceptor
{
   @Autowired
   private JdbcTemplate jdbc;

   private AuthData currentUser;

   @Autowired
   AuthInterceptor(AuthData currentUser) {

       this.currentUser = currentUser;
   }

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
   {
	  String requestURI = request.getRequestURI();

	  String excludeURIs[] = {"/", "register", "/file", "/image", "/login", "/logout", "/loginprc"};
	  String excludeExtensions[] = {"css", "js", "map", "jpg", "png", "ico", "avi", "mov", "mpeg4", "mpg", "gz", "doc", "docx", "pdf", "csv", "exe", "apk", "woff", "woff2", "ttf"};

	  HttpSession session = request.getSession();
return true;
/*	  String ext = getPathExtension(requestURI);
	  for(String ex : excludeExtensions)
	  {
	     if(ext.equals(ex))
		 {
		    return true;
		 }
	  }
	  
	  for(String uri : excludeURIs)
	  {
	     if(requestURI.equals(uri))
	     {
	    	return true;
	     }
	  }

	  if(requestURI.length() > 6 && requestURI.substring(0, 6).equals("/admin"))
	  {
	     List<CoderAdmins> results = jdbc.query("SELECT * FROM c0d3r_admins WHERE adminLogin=? AND adminPassword=?",
		    new Object[] { (String)session.getAttribute("un"), (String)session.getAttribute("pw") },
			new RowMapper<CoderAdmins>() {
			   @Override
			   public CoderAdmins mapRow(ResultSet rs, int rowNum) throws SQLException {
				  return new CoderAdmins(rs.getLong("id"),
				     rs.getLong("vendorId"),
					 rs.getInt("adminType"),
					 rs.getString("adminName"),
					 rs.getString("adminEmail"),
					 rs.getString("adminAccessAreas"),
					 rs.getInt("adminAccessStudents"),
					 rs.getInt("adminAccessTeachers"),
					 rs.getInt("adminAccessClasses"),
					 rs.getInt("adminAccessCourses"),
					 rs.getInt("adminAccessTasks"),
					 rs.getInt("adminAccessSolutions"),
					 rs.getInt("adminAccessRatings"),
					 rs.getInt("adminAccessReports"),
					 rs.getString("adminLogin"),
					 rs.getString("adminPassword"),
					 rs.getString("adminAuthority"),
					 rs.getInt("adminStatus"),
					 rs.getString("lastLoginTime"),
					 rs.getString("addedTime")
			      );
			   }
			}
         );
						     
		 if(!results.isEmpty())
		 {
		    CoderAdmins r = results.get(0);
			this.currentUser.setCurrentUser(new AuthUser(r.getId(), 1, r.getAdminName()));
			return true;
         }
		 else
		 {
			 showError(response);
			 return false;
		 }
      }
	  
	  if(requestURI.length() > 8 && requestURI.substring(0, 8).equals("/teacher"))
	  {
	     List<CoderTeachers> results = jdbc.query("SELECT * FROM c0d3r_teachers WHERE teacherLogin=? AND teacherPassword=?",
	    	new Object[] { (String)session.getAttribute("un"), (String)session.getAttribute("pw") },
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
	    	         rs.getString("addedTime")
	    	      );
	    	   }
	    	}
	     );
						     
		 if(!results.isEmpty())
		 {
		    CoderTeachers r = results.get(0);
			this.currentUser.setCurrentUser(new AuthUser(r.getId(), 2, r.getTeacherFirstName()+" "+r.getTeacherLastName()));
			return true;
         }
		 else
		 {
			showError(response);
			return false;
		 }
      }

	  if(requestURI.length() > 8 && requestURI.substring(0, 8).equals("/student"))
	  {
	     List<CoderStudents> results = jdbc.query("SELECT * FROM c0d3r_students WHERE studentLogin=? AND studentPassword=?",
	    	new Object[] { (String)session.getAttribute("un"), (String)session.getAttribute("pw") },
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
	    	         rs.getString("addedTime")
	    	      );
	    	   }
	    	}
         );
						     
		 if(!results.isEmpty())
		 {
		    CoderStudents r = results.get(0);
			this.currentUser.setCurrentUser(new AuthUser(r.getId(), 3, r.getStudentFirstName()+" "+r.getStudentLastName()));
			return true;
         }
		 else
		 {
			showError(response);
			return false;
		 }
      }
	  
	  show404Page(response);

	  return false;*/
   }

   private void showError(HttpServletResponse response)
   {
	   try
	   {
	      PrintWriter writer = response.getWriter();
          writer.println("Authentication failed. Access denied.");
	   }
	   catch(Exception e) {}
   }
   
   private String getPathExtension(String pathName)
   {
      String extension = "";

      int i = pathName.lastIndexOf('.');
      int p = Math.max(pathName.lastIndexOf('/'), pathName.lastIndexOf('\\'));

      if(i > p) {
         extension = pathName.substring(i+1);
      }
   
      return extension;
   }

   public void show404Page(HttpServletResponse response)
   {
	  String strPage = "<html>";
	  strPage += "<body>";
	  strPage += "Page not found!";
	  strPage += "</body>";
	  strPage += "</html>";

      try {
	  
         PrintWriter writer = response.getWriter();
	     writer.println(strPage);
	  }
	  catch(Exception e) {}
   }
}
