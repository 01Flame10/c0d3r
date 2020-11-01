package com.coder.main;

public class CoderAdmins {

   private long id;
   private long vendorId;
   private int adminType;
   private String adminName;
   private String adminEmail;
   private String adminAccessAreas;
   private int adminAccessStudents;
   private int adminAccessTeachers;
   private int adminAccessClasses;
   private int adminAccessCourses;
   private int adminAccessTasks;
   private int adminAccessSolutions;
   private int adminAccessRatings;
   private int adminAccessReports;
   private String adminLogin;
   private String adminPassword;
   private String adminAuthority;
   private int adminStatus;
   private String lastLoginTime;
   private String addedTime;

   public CoderAdmins() {

      this.id = 0;
      this.vendorId = 0;
      this.adminType = 0;
      this.adminName = "";
      this.adminEmail = "";
      this.adminAccessAreas = "";
      this.adminAccessStudents = 0;
      this.adminAccessTeachers = 0;
      this.adminAccessClasses = 0;
      this.adminAccessCourses = 0;
      this.adminAccessTasks = 0;
      this.adminAccessSolutions = 0;
      this.adminAccessRatings = 0;
      this.adminAccessReports = 0;
      this.adminLogin = "";
      this.adminPassword = "";
      this.adminAuthority = "";
      this.adminStatus = 0;
      this.lastLoginTime = "";
      this.addedTime = "";
   }

   public CoderAdmins(long id, long vendorId, int adminType, String adminName, String adminEmail, String adminAccessAreas, int adminAccessStudents, int adminAccessTeachers, int adminAccessClasses, int adminAccessCourses, int adminAccessTasks, int adminAccessSolutions, int adminAccessRatings, int adminAccessReports, String adminLogin, String adminPassword, String adminAuthority, int adminStatus, String lastLoginTime, String addedTime) {

      this.id = id;
      this.vendorId = vendorId;
      this.adminType = adminType;
      this.adminName = adminName;
      this.adminEmail = adminEmail;
      this.adminAccessAreas = adminAccessAreas;
      this.adminAccessStudents = adminAccessStudents;
      this.adminAccessTeachers = adminAccessTeachers;
      this.adminAccessClasses = adminAccessClasses;
      this.adminAccessCourses = adminAccessCourses;
      this.adminAccessTasks = adminAccessTasks;
      this.adminAccessSolutions = adminAccessSolutions;
      this.adminAccessRatings = adminAccessRatings;
      this.adminAccessReports = adminAccessReports;
      this.adminLogin = adminLogin;
      this.adminPassword = adminPassword;
      this.adminAuthority = adminAuthority;
      this.adminStatus = adminStatus;
      this.lastLoginTime = lastLoginTime;
      this.addedTime = addedTime;
   }

   public long getId() {

      return id;
   }

   public void setId(long id) {

      this.id = id;
   }

   public long getVendorId() {

      return vendorId;
   }

   public void setVendorId(long vendorId) {

      this.vendorId = vendorId;
   }

   public int getAdminType() {

      return adminType;
   }

   public void setAdminType(int adminType) {

      this.adminType = adminType;
   }

   public String getAdminName() {

      return adminName;
   }

   public void setAdminName(String adminName) {

      this.adminName = adminName;
   }

   public String getAdminEmail() {

      return adminEmail;
   }

   public void setAdminEmail(String adminEmail) {

      this.adminEmail = adminEmail;
   }

   public String getAdminAccessAreas() {

      return adminAccessAreas;
   }

   public void setAdminAccessAreas(String adminAccessAreas) {

      this.adminAccessAreas = adminAccessAreas;
   }
  
   public int getAdminAccessStudents() {

      return adminAccessStudents;
   }

   public void setAdminAccessStudents(int adminAccessStudents) {

      this.adminAccessStudents = adminAccessStudents;
   }
	   
   public int getAdminAccessTeachers() {

      return adminAccessTeachers;
   }

   public void setAdminAccessTeachers(int adminAccessTeachers) {

      this.adminAccessTeachers = adminAccessTeachers;
   }	   
	   
   public int getAdminAccessClasses() {

      return adminAccessClasses;
   }

   public void setAdminAccessClasses(int adminAccessClasses) {

      this.adminAccessClasses = adminAccessClasses;
   }	   

   public int getAdminAccessCourses() {

      return adminAccessCourses;
   }

   public void setAdminAccessCourses(int adminAccessCourses) {

      this.adminAccessCourses = adminAccessCourses;
   }
   
   public int getAdminAccessTasks() {

      return adminAccessTasks;
   }

   public void setAdminAccessTasks(int adminAccessTasks) {

      this.adminAccessTasks = adminAccessTasks;
   }
   
   public int getAdminAccessSolutions() {

      return adminAccessSolutions;
   }

   public void setAdminAccessSolutions(int adminAccessSolutions) {

      this.adminAccessSolutions = adminAccessSolutions;
   }
   
   public int getAdminAccessRatings() {

      return adminAccessRatings;
   }

   public void setAdminAccessRatings(int adminAccessRatings) {

      this.adminAccessRatings = adminAccessRatings;
   }

   public int getAdminAccessReports() {

      return adminAccessReports;
   }

   public void setAdminAccessReports(int adminAccessReports) {

      this.adminAccessReports = adminAccessReports;
   }

   public String getAdminLogin() {

      return adminLogin;
   }

   public void setAdminLogin(String adminLogin) {

      this.adminLogin = adminLogin;
   }

   public String getAdminPassword() {

      return adminPassword;
   }

   public void setAdminPassword(String adminPassword) {

      this.adminPassword = adminPassword;
   }

   public String getAdminAuthority() {

      return adminAuthority;
   }

   public void setAdminAuthority(String adminAuthority) {

      this.adminAuthority = adminAuthority;
   }

   public int getAdminStatus() {

      return adminStatus;
   }

   public void setAdminStatus(int adminStatus) {

      this.adminStatus = adminStatus;
   }

   public String getLastLoginTime() {

      return lastLoginTime;
   }

   public void setLastLoginTime(String lastLoginTime) {

      this.lastLoginTime = lastLoginTime;
   }

   public String getAddedTime() {

      return addedTime;
   }

   public void setAddedTime(String addedTime) {

      this.addedTime = addedTime;
   }

   public String toString() {

      return String.format("CoderAdmins[id='%d', vendorId='%d', adminType='%d', adminName='%s', adminEmail='%s', adminAccessAreas='%s', adminAccessStudents='%d', adminAccessTeachers='%d', adminAccessClasses='%d', adminAccessCourses='%d', adminAccessTasks='%d', adminAccessSolutions='%d', adminAccessRatings='%d', adminAccessReports='%d', adminLogin='%s', adminPassword='%s', adminAuthority='%s', adminStatus='%d', lastLoginTime='%s', addedTime='%s']",
         id, vendorId, adminType, adminName, adminEmail, adminAccessAreas, adminAccessStudents, adminAccessTeachers, adminAccessClasses, adminAccessCourses, adminAccessTasks, adminAccessSolutions, adminAccessRatings, adminAccessReports, adminLogin, adminPassword, adminAuthority, adminStatus, lastLoginTime, addedTime);
   }
}
