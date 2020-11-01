package com.coder.main;

public class CoderCourseSections {

   private long id;
   private long courseId;
   private String sectionName;
   private String localeName;
   private int sectionType;
   private String sectionDescription;
   private int status;
   private String addedTime;

    public CoderCourseSections() {

      this.id = 0;
      this.courseId = 0;
      this.sectionName = "";
      this.localeName = "";
      this.sectionType = 0;
      this.sectionDescription = "";
      this.status = 0;
      this.addedTime = "";
   }

    public CoderCourseSections(long id, long courseId, String sectionName, String localeName, int sectionType, String sectionDescription, int status, String addedTime) {

      this.id = id;
      this.courseId = courseId;
      this.sectionName = sectionName;
      this.localeName = localeName;
      this.sectionType = sectionType;
      this.sectionDescription = sectionDescription;
      this.status = status;
      this.addedTime = addedTime;
   }

   public long getId() {

      return id;
   }

   public void setId(long id) {

      this.id = id;
   }

   public long getCourseId() {

      return courseId;
   }

   public void setCourseId(long courseId) {

      this.courseId = courseId;
   }

   public String getSectionName() {

      return sectionName;
   }

   public void setSectionName(String sectionName) {

      this.sectionName = sectionName;
   }

   public String getLocaleName() {

      return localeName;
   }

   public void setLocaleName(String localeName) {

      this.localeName = localeName;
   }

   public int getSectionType() {

      return sectionType;
   }

   public void setSectionType(int sectionType) {

      this.sectionType = sectionType;
   }

   public String getSectionDescription() {

      return sectionDescription;
   }

   public void setSectionDescription(String sectionDescription) {

      this.sectionDescription = sectionDescription;
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

      return String.format("CoderCourseSections[id='%d', courseId='%d', sectionName='%s', localeName='%s', sectionType='%d', sectionDescription='%s', status='%d', addedTime='%s']",
         id, courseId, sectionName, localeName, sectionType, sectionDescription, status, addedTime);
   }
}

