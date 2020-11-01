package com.coder.main;

public class CoderClasses {

   private long id;
   private String className;
   private String localeName;
   private int classType;
   private String classDescription;
   private int status;
   private String addedTime;

    public CoderClasses() {

      this.id = 0;
      this.className = "";
      this.localeName = "";
      this.classType = 0;
      this.classDescription = "";
      this.status = 0;
      this.addedTime = "";
   }

    public CoderClasses(long id, String className, String localeName, int classType, String classDescription, int status, String addedTime) {

      this.id = id;
      this.className = className;
      this.localeName = localeName;
      this.classType = classType;
      this.classDescription = classDescription;
      this.status = status;
      this.addedTime = addedTime;
   }

   public long getId() {

      return id;
   }

   public void setId(long id) {

      this.id = id;
   }

   public String getClassName() {

      return className;
   }

   public void setClassName(String className) {

      this.className = className;
   }

   public String getLocaleName() {

      return localeName;
   }

   public void setLocaleName(String localeName) {

      this.localeName = localeName;
   }

   public int getClassType() {

      return classType;
   }

   public void setClassType(int classType) {

      this.classType = classType;
   }

   public String getClassDescription() {

      return classDescription;
   }

   public void setClassDescription(String classDescription) {

      this.classDescription = classDescription;
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

      return String.format("CoderClasses[id='%d', className='%s', localeName='%s', classType='%d', classDescription='%s', status='%d', addedTime='%s']",
         id, className, localeName, classType, classDescription, status, addedTime);
   }
}

