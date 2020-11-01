package com.coder.main;

public class AuthUser
{
   private long userId = 0;
   private int userType = 0;
   private String userName = "";
   
   public AuthUser(long userId, int userType, String userName) {

      this.userId = userId;
	  this.userType = userType;
	  this.userName = userName;
   }

   public long getUserId() {

       return userId;
   }

   public void setUserId(long userId) {

       this.userId = userId;
   }
   
   public int getUserType() {

       return userType;
   }

   public void setUserType(int userType) {

       this.userType = userType;
   }
 
   public String getUserName() {

       return userName;
   }

   public void setUserName(String userName) {

       this.userName = userName;
   }
}
