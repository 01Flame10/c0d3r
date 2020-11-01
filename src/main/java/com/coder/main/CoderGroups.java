package com.coder.main;

public class CoderGroups {

   private long id;
   private long classId;
   private String groupName;
   private String localeName;
   private int groupType;
   private String groupDescription;
   private int status;
   private String addedTime;

    public CoderGroups() {

      this.id = 0;
      this.classId = 0;
      this.groupName = "";
      this.localeName = "";
      this.groupType = 0;
      this.groupDescription = "";
      this.status = 0;
      this.addedTime = "";
   }

    public CoderGroups(long id, long classId, String groupName, String localeName, int groupType, String groupDescription, int status, String addedTime) {

      this.id = id;
      this.classId = classId;
      this.groupName = groupName;
      this.localeName = localeName;
      this.groupType = groupType;
      this.groupDescription = groupDescription;
      this.status = status;
      this.addedTime = addedTime;
   }

   public long getId() {

      return id;
   }

   public void setId(long id) {

      this.id = id;
   }

   public long getClassId() {

      return classId;
   }

   public void setClassId(long classId) {

      this.classId = classId;
   }

   public String getGroupName() {

      return groupName;
   }

   public void setGroupName(String groupName) {

      this.groupName = groupName;
   }

   public String getLocaleName() {

      return localeName;
   }

   public void setLocaleName(String localeName) {

      this.localeName = localeName;
   }

   public int getGroupType() {

      return groupType;
   }

   public void setGroupType(int groupType) {

      this.groupType = groupType;
   }

   public String getGroupDescription() {

      return groupDescription;
   }

   public void setGroupDescription(String groupDescription) {

      this.groupDescription = groupDescription;
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

      return String.format("CoderGroups[id='%d', classId='%d', groupName='%s', localeName='%s', groupType='%d', groupDescription='%s', status='%d', addedTime='%s']",
         id, classId, groupName, localeName, groupType, groupDescription, status, addedTime);
   }
}

