package com.coder.main;

public class CoderStudents {

   private long id;
   private String studentFirstName;
   private String studentMiddleName;
   private String studentLastName;
   private String studentEmail;
   private String studentLogin;
   private String studentPassword;
   private String studentPasswordMatch;
   private String studentCompanyName;
   private String studentAddress;
   private String studentPhone;
   private String studentCity;
   private String studentZip;
   private String studentState;
   private String studentCountry;
   private String studentAboutMe;
   private String profilePhotoUrl;
   private int studentType;
   private String studentAuthority;
   private int studentMembership;
   private int studentActivated;
   private String activationCode;
   private int studentRating;
   private int studentCoursesEnrolled;
   private int studentTasksComplete;
   private String lastLoginTime;
   private String prevLoginTime;
   private String instagramId;
   private String facebookId;
   private String vkId;
   private String youtubeId;
   private String twitterId;
   private int status;
   private int agree;
   private String addedTime;

    public CoderStudents() {

      this.id = 0;
      this.studentFirstName = "";
      this.studentMiddleName = "";
      this.studentLastName = "";
      this.studentEmail = "";
      this.studentLogin = "";
      this.studentPassword = "";
      this.studentPasswordMatch = "";
      this.studentCompanyName = "";
      this.studentAddress = "";
      this.studentPhone = "";
      this.studentCity = "";
      this.studentZip = "";
      this.studentState = "";
      this.studentCountry = "";
      this.studentAboutMe = "";
      this.profilePhotoUrl = "";
      this.studentType = 0;
      this.studentAuthority = "";
      this.studentMembership = 0;
      this.studentActivated = 0;
      this.activationCode = "";
      this.studentRating = 0;
      this.studentCoursesEnrolled = 0;
      this.studentTasksComplete = 0;
      this.lastLoginTime = "";
      this.prevLoginTime = "";
      this.instagramId = "";
      this.facebookId = "";
      this.vkId = "";
      this.youtubeId = "";
      this.twitterId = "";
      this.status = 0;
      this.agree = 0;
      this.addedTime = "";
   }

    public CoderStudents(long id, String studentFirstName, String studentMiddleName, String studentLastName, String studentEmail, String studentLogin, String studentPassword, String studentPasswordMatch, String studentCompanyName, String studentAddress, String studentPhone, String studentCity, String studentZip, String studentState, String studentCountry, String studentAboutMe, String profilePhotoUrl, int studentType, String studentAuthority, int studentMembership, int studentActivated, String activationCode, int studentRating, int studentCoursesEnrolled, int studentTasksComplete, String lastLoginTime, String prevLoginTime, String instagramId, String facebookId, String vkId, String youtubeId, String twitterId, int status, int agree, String addedTime) {

      this.id = id;
      this.studentFirstName = studentFirstName;
      this.studentMiddleName = studentMiddleName;
      this.studentLastName = studentLastName;
      this.studentEmail = studentEmail;
      this.studentLogin = studentLogin;
      this.studentPassword = studentPassword;
      this.studentPasswordMatch = studentPasswordMatch;
      this.studentCompanyName = studentCompanyName;
      this.studentAddress = studentAddress;
      this.studentPhone = studentPhone;
      this.studentCity = studentCity;
      this.studentZip = studentZip;
      this.studentState = studentState;
      this.studentCountry = studentCountry;
      this.studentAboutMe = studentAboutMe;
      this.profilePhotoUrl = profilePhotoUrl;
      this.studentType = studentType;
      this.studentAuthority = studentAuthority;
      this.studentMembership = studentMembership;
      this.studentActivated = studentActivated;
      this.activationCode = activationCode;
      this.studentRating = studentRating;
      this.studentCoursesEnrolled = studentCoursesEnrolled;
      this.studentTasksComplete = studentTasksComplete;
      this.lastLoginTime = lastLoginTime;
      this.prevLoginTime = prevLoginTime;
      this.instagramId = instagramId;
      this.facebookId = facebookId;
      this.vkId = vkId;
      this.youtubeId = youtubeId;
      this.twitterId = twitterId;
      this.status = status;
      this.agree = agree;
      this.addedTime = addedTime;
   }

   public long getId() {

      return id;
   }

   public void setId(long id) {

      this.id = id;
   }

   public String getStudentFirstName() {

      return studentFirstName;
   }

   public void setStudentFirstName(String studentFirstName) {

      this.studentFirstName = studentFirstName;
   }

   public String getStudentMiddleName() {

      return studentMiddleName;
   }

   public void setStudentMiddleName(String studentMiddleName) {

      this.studentMiddleName = studentMiddleName;
   }

   public String getStudentLastName() {

      return studentLastName;
   }

   public void setStudentLastName(String studentLastName) {

      this.studentLastName = studentLastName;
   }

   public String getStudentEmail() {

      return studentEmail;
   }

   public void setStudentEmail(String studentEmail) {

      this.studentEmail = studentEmail;
   }

   public String getStudentLogin() {

      return studentLogin;
   }

   public void setStudentLogin(String studentLogin) {

      this.studentLogin = studentLogin;
   }

   public String getStudentPassword() {

      return studentPassword;
   }

   public void setStudentPassword(String studentPassword) {

      this.studentPassword = studentPassword;
   }

   public String getStudentPasswordMatch() {

      return studentPasswordMatch;
   }

   public void setStudentPasswordMatch(String studentPasswordMatch) {

      this.studentPasswordMatch = studentPasswordMatch;
   }

   public String getStudentCompanyName() {

      return studentCompanyName;
   }

   public void setStudentCompanyName(String studentCompanyName) {

      this.studentCompanyName = studentCompanyName;
   }

   public String getStudentAddress() {

      return studentAddress;
   }

   public void setStudentAddress(String studentAddress) {

      this.studentAddress = studentAddress;
   }

   public String getStudentPhone() {

      return studentPhone;
   }

   public void setStudentPhone(String studentPhone) {

      this.studentPhone = studentPhone;
   }

   public String getStudentCity() {

      return studentCity;
   }

   public void setStudentCity(String studentCity) {

      this.studentCity = studentCity;
   }

   public String getStudentZip() {

      return studentZip;
   }

   public void setStudentZip(String studentZip) {

      this.studentZip = studentZip;
   }

   public String getStudentState() {

      return studentState;
   }

   public void setStudentState(String studentState) {

      this.studentState = studentState;
   }

   public String getStudentCountry() {

      return studentCountry;
   }

   public void setStudentCountry(String studentCountry) {

      this.studentCountry = studentCountry;
   }

   public String getStudentAboutMe() {

      return studentAboutMe;
   }

   public void setStudentAboutMe(String studentAboutMe) {

      this.studentAboutMe = studentAboutMe;
   }

   public String getProfilePhotoUrl() {

      return profilePhotoUrl;
   }

   public void setProfilePhotoUrl(String profilePhotoUrl) {

      this.profilePhotoUrl = profilePhotoUrl;
   }

   public int getStudentType() {

      return studentType;
   }

   public void setStudentType(int studentType) {

      this.studentType = studentType;
   }

   public String getStudentAuthority() {

      return studentAuthority;
   }

   public void setStudentAuthority(String studentAuthority) {

      this.studentAuthority = studentAuthority;
   }

   public int getStudentMembership() {

      return studentMembership;
   }

   public void setStudentMembership(int studentMembership) {

      this.studentMembership = studentMembership;
   }

   public int getStudentActivated() {

      return studentActivated;
   }

   public void setStudentActivated(int studentActivated) {

      this.studentActivated = studentActivated;
   }

   public String getActivationCode() {

      return activationCode;
   }

   public void setActivationCode(String activationCode) {

      this.activationCode = activationCode;
   }

   public int getStudentRating() {

      return studentRating;
   }

   public void setStudentRating(int studentRating) {

      this.studentRating = studentRating;
   }

   public int getStudentCoursesEnrolled() {

      return studentCoursesEnrolled;
   }

   public void setStudentCoursesEnrolled(int studentCoursesEnrolled) {

      this.studentCoursesEnrolled = studentCoursesEnrolled;
   }

   public int getStudentTasksComplete() {

      return studentTasksComplete;
   }

   public void setStudentTasksComplete(int studentTasksComplete) {

      this.studentTasksComplete = studentTasksComplete;
   }

   public String getLastLoginTime() {

      return lastLoginTime;
   }

   public void setLastLoginTime(String lastLoginTime) {

      this.lastLoginTime = lastLoginTime;
   }

   public String getPrevLoginTime() {

      return prevLoginTime;
   }

   public void setPrevLoginTime(String prevLoginTime) {

      this.prevLoginTime = prevLoginTime;
   }

   public String getInstagramId() {

      return instagramId;
   }

   public void setInstagramId(String instagramId) {

      this.instagramId = instagramId;
   }

   public String getFacebookId() {

      return facebookId;
   }

   public void setFacebookId(String facebookId) {

      this.facebookId = facebookId;
   }

   public String getVkId() {

      return vkId;
   }

   public void setVkId(String vkId) {

      this.vkId = vkId;
   }

   public String getYoutubeId() {

      return youtubeId;
   }

   public void setYoutubeId(String youtubeId) {

      this.youtubeId = youtubeId;
   }

   public String getTwitterId() {

      return twitterId;
   }

   public void setTwitterId(String twitterId) {

      this.twitterId = twitterId;
   }

   public int getStatus() {

      return status;
   }

   public void setStatus(int status) {

      this.status = status;
   }

   public int getAgree() {

      return agree;
   }

   public void setAgree(int agree) {

      this.agree = agree;
   }

   public String getAddedTime() {

      return addedTime;
   }

   public void setAddedTime(String addedTime) {

      this.addedTime = addedTime;
   }

   public String toString() {

      return String.format("CoderStudents[id='%d', studentFirstName='%s', studentMiddleName='%s', studentLastName='%s', studentEmail='%s', studentLogin='%s', studentPassword='%s', studentPasswordMatch='%s', studentCompanyName='%s', studentAddress='%s', studentPhone='%s', studentCity='%s', studentZip='%s', studentState='%s', studentCountry='%s', studentAboutMe='%s', profilePhotoUrl='%s', studentType='%d', studentAuthority='%s', studentMembership='%d', studentActivated='%d', activationCode='%s', studentRating='%d', studentCoursesEnrolled='%d', studentTasksComplete='%d', lastLoginTime='%s', prevLoginTime='%s', instagramId='%s', facebookId='%s', vkId='%s', youtubeId='%s', twitterId='%s', status='%d', agree='%d', addedTime='%s']",
         id, studentFirstName, studentMiddleName, studentLastName, studentEmail, studentLogin, studentPassword, studentPasswordMatch, studentCompanyName, studentAddress, studentPhone, studentCity, studentZip, studentState, studentCountry, studentAboutMe, profilePhotoUrl, studentType, studentAuthority, studentMembership, studentActivated, activationCode, studentRating, studentCoursesEnrolled, studentTasksComplete, lastLoginTime, prevLoginTime, instagramId, facebookId, vkId, youtubeId, twitterId, status, agree, addedTime);
   }
}

