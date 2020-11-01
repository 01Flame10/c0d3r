package com.coder.main;

public class CoderSourceCodes {

   private long id;
   private long resultId;
   private long studentId;
   private String fileURL;
   private int status;
   private String addedTime;

    public CoderSourceCodes() {

      this.id = 0;
      this.resultId = 0;
      this.studentId = 0;
      this.fileURL = "";
      this.status = 0;
      this.addedTime = "";
   }

    public CoderSourceCodes(long id, long resultId, long studentId, String fileURL, int status, String addedTime) {

      this.id = id;
      this.resultId = resultId;
      this.studentId = studentId;
      this.fileURL = fileURL;
      this.status = status;
      this.addedTime = addedTime;
   }

   public long getId() {

      return id;
   }

   public void setId(long id) {

      this.id = id;
   }

   public long getResultId() {

      return resultId;
   }

   public void setResultId(long resultId) {

      this.resultId = resultId;
   }

   public long getStudentId() {

      return studentId;
   }

   public void setStudentId(long studentId) {

      this.studentId = studentId;
   }

   public String getFileURL() {

      return fileURL;
   }

   public void setFileURL(String fileURL) {

      this.fileURL = fileURL;
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

      return String.format("CoderSourceCodes[id='%d', resultId='%d', studentId='%d', fileURL='%s', status='%d', addedTime='%s']",
         id, resultId, studentId, fileURL, status, addedTime);
   }
}

