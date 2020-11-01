package com.coder.main;

public class CoderCourses {

   private long id;
   private String courseName;
   private String localeName;
   private int courseType;
   private String courseDescription;
   private int status;
   private String addedTime;

    public CoderCourses() {

      this.id = 0;
      this.courseName = "";
      this.localeName = "";
      this.courseType = 0;
      this.courseDescription = "";
      this.status = 0;
      this.addedTime = "";
   }

    public CoderCourses(long id, String courseName, String localeName, int courseType, String courseDescription, int status, String addedTime) {

      this.id = id;
      this.courseName = courseName;
      this.localeName = localeName;
      this.courseType = courseType;
      this.courseDescription = courseDescription;
      this.status = status;
      this.addedTime = addedTime;
   }

   public long getId() {

      return id;
   }

   public void setId(long id) {

      this.id = id;
   }

   public String getCourseName() {

      return courseName;
   }

   public void setCourseName(String courseName) {

      this.courseName = courseName;
   }

   public String getLocaleName() {

      return localeName;
   }

   public void setLocaleName(String localeName) {

      this.localeName = localeName;
   }

   public int getCourseType() {

      return courseType;
   }

   public void setCourseType(int courseType) {

      this.courseType = courseType;
   }

   public String getCourseDescription() {

      return courseDescription;
   }

   public void setCourseDescription(String courseDescription) {

      this.courseDescription = courseDescription;
   }

   public int getStatus() {

      return status;
   }

   public void setStatus(int status) {

      this.status = status;
   }

   public String getAddedTime() {

      return addedTime;
   }

   public void setAddedTime(String addedTime) {

      this.addedTime = addedTime;
   }

   public String toString() {

      return String.format("CoderCourses[id='%d', courseName='%s', localeName='%s', courseType='%d', courseDescription='%s', status='%d', addedTime='%s']",
         id, courseName, localeName, courseType, courseDescription, status, addedTime);
   }
}

