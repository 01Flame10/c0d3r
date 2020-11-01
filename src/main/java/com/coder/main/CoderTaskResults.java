package com.coder.main;

public class CoderTaskResults {

   private long id;
   private long taskId;
   private long studentId;
   private int languageId;
   private String localeName;
   private float resultValue;
   private String resultDescription;
   private int status;
   private String addedTime;

    public CoderTaskResults() {

      this.id = 0;
      this.taskId = 0;
      this.studentId = 0;
      this.languageId = 0;
      this.localeName = "";
      this.resultValue = 0;
      this.resultDescription = "";
      this.status = 0;
      this.addedTime = "";
   }

    public CoderTaskResults(long id, long taskId, long studentId, int languageId, String localeName, float resultValue, String resultDescription, int status, String addedTime) {

      this.id = id;
      this.taskId = taskId;
      this.studentId = studentId;
      this.languageId = languageId;
      this.localeName = localeName;
      this.resultValue = resultValue;
      this.resultDescription = resultDescription;
      this.status = status;
      this.addedTime = addedTime;
   }

   public long getId() {

      return id;
   }

   public void setId(long id) {

      this.id = id;
   }

   public long getTaskId() {

      return taskId;
   }

   public void setTaskId(long taskId) {

      this.taskId = taskId;
   }

   public long getStudentId() {

      return studentId;
   }

   public void setStudentId(long studentId) {

      this.studentId = studentId;
   }

   public int getLanguageId() {

      return languageId;
   }

   public void setLanguageId(int languageId) {

      this.languageId = languageId;
   }

   public String getLocaleName() {

      return localeName;
   }

   public void setLocaleName(String localeName) {

      this.localeName = localeName;
   }

   public float getResultValue() {

      return resultValue;
   }

   public void setResultValue(float resultValue) {

      this.resultValue = resultValue;
   }

   public String getResultDescription() {

      return resultDescription;
   }

   public void setResultDescription(String resultDescription) {

      this.resultDescription = resultDescription;
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

      return String.format("CoderTaskResults[id='%d', taskId='%d', studentId='%d', languageId='%d', localeName='%s', resultValue='%d', resultDescription='%s', status='%d', addedTime='%s']",
         id, taskId, studentId, languageId, localeName, resultValue, resultDescription, status, addedTime);
   }
}

