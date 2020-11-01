package com.coder.main;

public class CoderAutotestProperties {

   private long id;
   private long taskId;
   private int languageId;
   private String runTimeMillisecondsFrom;
   private String runTimeMillisecondsTo;
   private float rewardValue;
   private String inputData;
   private String outputData;
   private String inputURL;
   private String outputURL;
   private String inputFileName;
   private String outputFileName;
   private String inputMethod;
   private String outputMethod;
   private int status;
   private String addedTime;

    public CoderAutotestProperties() {

      this.id = 0;
      this.taskId = 0;
      this.languageId = 0;
      this.runTimeMillisecondsFrom = "";
      this.runTimeMillisecondsTo = "";
      this.rewardValue = 0;
      this.inputData = "";
      this.outputData = "";
      this.inputURL = "";
      this.outputURL = "";
      this.inputFileName = "";
      this.outputFileName = "";
      this.inputMethod = "";
      this.outputMethod = "";
      this.status = 0;
      this.addedTime = "";
   }

    public CoderAutotestProperties(long id, long taskId, int languageId, String runTimeMillisecondsFrom, String runTimeMillisecondsTo, float rewardValue, String inputData, String outputData, String inputURL, String outputURL, String inputFileName, String outputFileName, String inputMethod, String outputMethod, int status, String addedTime) {

      this.id = id;
      this.taskId = taskId;
      this.languageId = languageId;
      this.runTimeMillisecondsFrom = runTimeMillisecondsFrom;
      this.runTimeMillisecondsTo = runTimeMillisecondsTo;
      this.rewardValue = rewardValue;
      this.inputData = inputData;
      this.outputData = outputData;
      this.inputURL = inputURL;
      this.outputURL = outputURL;
      this.inputFileName = inputFileName;
      this.outputFileName = outputFileName;
      this.inputMethod = inputMethod;
      this.outputMethod = outputMethod;
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

   public int getLanguageId() {

      return languageId;
   }

   public void setLanguageId(int languageId) {

      this.languageId = languageId;
   }

   public String getRunTimeMillisecondsFrom() {

      return runTimeMillisecondsFrom;
   }

   public void setRunTimeMillisecondsFrom(String runTimeMillisecondsFrom) {

      this.runTimeMillisecondsFrom = runTimeMillisecondsFrom;
   }

   public String getRunTimeMillisecondsTo() {

      return runTimeMillisecondsTo;
   }

   public void setRunTimeMillisecondsTo(String runTimeMillisecondsTo) {

      this.runTimeMillisecondsTo = runTimeMillisecondsTo;
   }

   public float getRewardValue() {

      return rewardValue;
   }

   public void setRewardValue(float rewardValue) {

      this.rewardValue = rewardValue;
   }

   public String getInputData() {

      return inputData;
   }

   public void setInputData(String inputData) {

      this.inputData = inputData;
   }

   public String getOutputData() {

      return outputData;
   }

   public void setOutputData(String outputData) {

      this.outputData = outputData;
   }

   public String getInputURL() {

      return inputURL;
   }

   public void setInputURL(String inputURL) {

      this.inputURL = inputURL;
   }

   public String getOutputURL() {

      return outputURL;
   }

   public void setOutputURL(String outputURL) {

      this.outputURL = outputURL;
   }

   public String getInputFileName() {

      return inputFileName;
   }

   public void setInputFileName(String inputFileName) {

      this.inputFileName = inputFileName;
   }

   public String getOutputFileName() {

      return outputFileName;
   }

   public void setOutputFileName(String outputFileName) {

      this.outputFileName = outputFileName;
   }

   public String getInputMethod() {

      return inputMethod;
   }

   public void setInputMethod(String inputMethod) {

      this.inputMethod = inputMethod;
   }

   public String getOutputMethod() {

      return outputMethod;
   }

   public void setOutputMethod(String outputMethod) {

      this.outputMethod = outputMethod;
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

      return String.format("CoderAutotestProperties[id='%d', taskId='%d', languageId='%d', runTimeMillisecondsFrom='%s', runTimeMillisecondsTo='%s', rewardValue='%d', inputData='%s', outputData='%s', inputURL='%s', outputURL='%s', inputFileName='%s', outputFileName='%s', inputMethod='%s', outputMethod='%s', status='%d', addedTime='%s']",
         id, taskId, languageId, runTimeMillisecondsFrom, runTimeMillisecondsTo, rewardValue, inputData, outputData, inputURL, outputURL, inputFileName, outputFileName, inputMethod, outputMethod, status, addedTime);
   }
}

