package com.coder.main;

import java.security.spec.KeySpec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coder.main.AuthData;
import com.coder.main.AuthUser;
import com.coder.main.CoderStudents;
import com.coder.main.CoderTeachers;
import com.coder.main.CoderAdmins;

@Controller
public class LoginPrcController {

   @Autowired
   private JdbcTemplate jdbc;

   private AuthData currentUser;

   @Autowired
   LoginPrcController(AuthData currentUser) {

       this.currentUser = currentUser;
   }

   @RequestMapping(value = "/loginprc", method = RequestMethod.POST)
   public ModelAndView processLogin(@RequestParam(value = "lgnx", required = false) String userLogin, 
           @RequestParam(value = "pwdx", required = false) String userPassword,
           HttpServletRequest request,
           Model model)
   {	  
	  /*System.out.println(userLogin);
	  System.out.println(userPassword);
	  System.out.println(request.getRequestURI());*/
	  
	  // PBKDF2 password hashing

	  String passwordHash = "";
	  try {		     
		 byte[] salt = {65, 69, 72, 67, 75};
         String strSalt = new String(salt);
          
		 KeySpec spec = new PBEKeySpec(userPassword.toCharArray(), salt, 65536, 128);

		 SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		 byte[] hash = factory.generateSecret(spec).getEncoded();
		     
		 String strHash = "";
		     
		 for(int f = 0; f < hash.length; f++)
		 {
		    strHash += hash[f]+"|";
		 }
		 passwordHash = strSalt+strHash;
	  } catch(Exception e) {}
	  
	  System.out.println("password hash: "+passwordHash);
	  
	  List<CoderAdmins> results = jdbc.query("SELECT * FROM c0d3r_admins WHERE adminLogin=? AND adminPassword=?",
	     new Object[] { userLogin, passwordHash },
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
		 HttpSession session = request.getSession();
		  
	     session.setAttribute("un", userLogin);
	     session.setAttribute("pw", passwordHash);
	      
		 CoderAdmins r = results.get(0);
	     this.currentUser.setCurrentUser(new AuthUser(r.getId(), 1, r.getAdminName()));

	     return new ModelAndView("redirect:/adminMain");
      }
	  else
	  {
		 List<CoderTeachers> results2 = jdbc.query("SELECT * FROM c0d3r_teachers WHERE teacherLogin=? AND teacherPassword=?",
		    new Object[] { userLogin, passwordHash },
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

		 if(!results2.isEmpty())
		 {
		    HttpSession session = request.getSession();
			  
		    session.setAttribute("un", userLogin);
		    session.setAttribute("pw", passwordHash);
		      
		    CoderTeachers r = results2.get(0);
			this.currentUser.setCurrentUser(new AuthUser(r.getId(), 2, r.getTeacherFirstName()+" "+r.getTeacherLastName()));

		    return new ModelAndView("redirect:/teacherMain");
         }
		 else
		 {
		    List<CoderStudents> results3 = jdbc.query("SELECT * FROM c0d3r_students WHERE studentLogin=? AND studentPassword=?",
		       new Object[] { userLogin, passwordHash },
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

		    if(!results3.isEmpty())
			{
			   HttpSession session = request.getSession();
				  
			   session.setAttribute("un", userLogin);
			   session.setAttribute("pw", passwordHash);
			      
			   CoderStudents r = results3.get(0);
			   this.currentUser.setCurrentUser(new AuthUser(r.getId(), 3, r.getStudentFirstName()+" "+r.getStudentLastName()));

			   return new ModelAndView("redirect:/studentMain");
	        }
	        else
	        {
		       ModelAndView mv = new ModelAndView("redirect:/login");
		       mv.addObject("operationStatus", "error");

		       return mv;
	        }
		 }
	  }
   }
}
