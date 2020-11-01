package com.coder.main;

public class CoderAutotestResults {

   private long id;
   private long taskId;
   private long resultId;
   private long autotestId;
   private int languageId;
   private String runTimeMilliseconds;
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

    public CoderAutotestResults() {

      this.id = 0;
      this.taskId = 0;
      this.resultId = 0;
      this.autotestId = 0;
      this.languageId = 0;
      this.runTimeMilliseconds = "";
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

    public CoderAutotestResults(long id, long taskId, long resultId, long autotestId, int languageId, String runTimeMilliseconds, float rewardValue, String inputData, String outputData, String inputURL, String outputURL, String inputFileName, String outputFileName, String inputMethod, String outputMethod, int status, String addedTime) {

      this.id = id;
      this.taskId = taskId;
      this.resultId = resultId;
      this.autotestId = autotestId;
      this.languageId = languageId;
      this.runTimeMilliseconds = runTimeMilliseconds;
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

   public long getResultId() {

      return resultId;
   }

   public void setResultId(long resultId) {

      this.resultId = resultId;
   }

   public long getAutotestId() {

      return autotestId;
   }

   public void setAutotestId(long autotestId) {

      this.autotestId = autotestId;
   }

   public int getLanguageId() {

      return languageId;
   }

   public void setLanguageId(int languageId) {

      this.languageId = languageId;
   }

   public String getRunTimeMilliseconds() {

      return runTimeMilliseconds;
   }

   public void setRunTimeMilliseconds(String runTimeMilliseconds) {

      this.runTimeMilliseconds = runTimeMilliseconds;
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

      return String.format("CoderAutotestResults[id='%d', taskId='%d', resultId='%d', autotestId='%d', languageId='%d', runTimeMilliseconds='%s', rewardValue='%d', inputData='%s', outputData='%s', inputURL='%s', outputURL='%s', inputFileName='%s', outputFileName='%s', inputMethod='%s', outputMethod='%s', status='%d', addedTime='%s']",
         id, taskId, resultId, autotestId, languageId, runTimeMilliseconds, rewardValue, inputData, outputData, inputURL, outputURL, inputFileName, outputFileName, inputMethod, outputMethod, status, addedTime);
   }
}

