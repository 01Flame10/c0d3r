package com.coder.main;

public class CoderTasks {

   private long id;
   private long courseId;
   private long sectionId;
   private int languageId;
   private long teacherId;
   private String taskName;
   private String localeName;
   private int taskType;
   private float taskValue;
   private String taskDescription;
   private int status;
   private String addedTime;

    public CoderTasks() {

      this.id = 0;
      this.courseId = 0;
      this.sectionId = 0;
      this.languageId = 0;
      this.teacherId = 0;
      this.taskName = "";
      this.localeName = "";
      this.taskType = 0;
      this.taskValue = 0;
      this.taskDescription = "";
      this.status = 0;
      this.addedTime = "";
   }

    public CoderTasks(long id, long courseId, long sectionId, int languageId, long teacherId, String taskName, String localeName, int taskType, float taskValue, String taskDescription, int status, String addedTime) {

      this.id = id;
      this.courseId = courseId;
      this.sectionId = sectionId;
      this.languageId = languageId;
      this.teacherId = teacherId;
      this.taskName = taskName;
      this.localeName = localeName;
      this.taskType = taskType;
      this.taskValue = taskValue;
      this.taskDescription = taskDescription;
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

   public long getSectionId() {

      return sectionId;
   }

   public void setSectionId(long sectionId) {

      this.sectionId = sectionId;
   }

   public int getLanguageId() {

      return languageId;
   }

   public void setLanguageId(int languageId) {

      this.languageId = languageId;
   }

   public long getTeacherId() {

      return teacherId;
   }

   public void setTeacherId(long teacherId) {

      this.teacherId = teacherId;
   }

   public String getTaskName() {

      return taskName;
   }

   public void setTaskName(String taskName) {

      this.taskName = taskName;
   }

   public String getLocaleName() {

      return localeName;
   }

   public void setLocaleName(String localeName) {

      this.localeName = localeName;
   }

   public int getTaskType() {

      return taskType;
   }

   public void setTaskType(int taskType) {

      this.taskType = taskType;
   }

   public float getTaskValue() {

      return taskValue;
   }

   public void setTaskValue(float taskValue) {

      this.taskValue = taskValue;
   }

   public String getTaskDescription() {

      return taskDescription;
   }

   public void setTaskDescription(String taskDescription) {

      this.taskDescription = taskDescription;
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

      return String.format("CoderTasks[id='%d', courseId='%d', sectionId='%d', languageId='%d', teacherId='%d', taskName='%s', localeName='%s', taskType='%d', taskValue='%d', taskDescription='%s', status='%d', addedTime='%s']",
         id, courseId, sectionId, languageId, teacherId, taskName, localeName, taskType, taskValue, taskDescription, status, addedTime);
   }
}

