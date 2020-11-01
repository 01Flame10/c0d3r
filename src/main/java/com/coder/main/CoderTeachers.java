package com.coder.main;

public class CoderTeachers {

   private long id;
   private String teacherFirstName;
   private String teacherMiddleName;
   private String teacherLastName;
   private String teacherEmail;
   private String teacherLogin;
   private String teacherPassword;
   private String teacherPasswordMatch;
   private String teacherCompanyName;
   private String teacherAddress;
   private String teacherPhone;
   private String teacherCity;
   private String teacherZip;
   private String teacherState;
   private String teacherCountry;
   private String teacherAboutMe;
   private String profilePhotoUrl;
   private int teacherType;
   private String teacherAuthority;
   private int teacherMembership;
   private int teacherActivated;
   private String activationCode;
   private int teacherCoursesEnrolled;
   private int teacherTasksCreated;
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

    public CoderTeachers() {

      this.id = 0;
      this.teacherFirstName = "";
      this.teacherMiddleName = "";
      this.teacherLastName = "";
      this.teacherEmail = "";
      this.teacherLogin = "";
      this.teacherPassword = "";
      this.teacherPasswordMatch = "";
      this.teacherCompanyName = "";
      this.teacherAddress = "";
      this.teacherPhone = "";
      this.teacherCity = "";
      this.teacherZip = "";
      this.teacherState = "";
      this.teacherCountry = "";
      this.teacherAboutMe = "";
      this.profilePhotoUrl = "";
      this.teacherType = 0;
      this.teacherAuthority = "";
      this.teacherMembership = 0;
      this.teacherActivated = 0;
      this.activationCode = "";
      this.teacherCoursesEnrolled = 0;
      this.teacherTasksCreated = 0;
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

    public CoderTeachers(long id, String teacherFirstName, String teacherMiddleName, String teacherLastName, String teacherEmail, String teacherLogin, String teacherPassword, String teacherPasswordMatch, String teacherCompanyName, String teacherAddress, String teacherPhone, String teacherCity, String teacherZip, String teacherState, String teacherCountry, String teacherAboutMe, String profilePhotoUrl, int teacherType, String teacherAuthority, int teacherMembership, int teacherActivated, String activationCode, int teacherCoursesEnrolled, int teacherTasksCreated, String lastLoginTime, String prevLoginTime, String instagramId, String facebookId, String vkId, String youtubeId, String twitterId, int status, int agree, String addedTime) {

      this.id = id;
      this.teacherFirstName = teacherFirstName;
      this.teacherMiddleName = teacherMiddleName;
      this.teacherLastName = teacherLastName;
      this.teacherEmail = teacherEmail;
      this.teacherLogin = teacherLogin;
      this.teacherPassword = teacherPassword;
      this.teacherPasswordMatch = teacherPasswordMatch;
      this.teacherCompanyName = teacherCompanyName;
      this.teacherAddress = teacherAddress;
      this.teacherPhone = teacherPhone;
      this.teacherCity = teacherCity;
      this.teacherZip = teacherZip;
      this.teacherState = teacherState;
      this.teacherCountry = teacherCountry;
      this.teacherAboutMe = teacherAboutMe;
      this.profilePhotoUrl = profilePhotoUrl;
      this.teacherType = teacherType;
      this.teacherAuthority = teacherAuthority;
      this.teacherMembership = teacherMembership;
      this.teacherActivated = teacherActivated;
      this.activationCode = activationCode;
      this.teacherCoursesEnrolled = teacherCoursesEnrolled;
      this.teacherTasksCreated = teacherTasksCreated;
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

   public String getTeacherFirstName() {

      return teacherFirstName;
   }

   public void setTeacherFirstName(String teacherFirstName) {

      this.teacherFirstName = teacherFirstName;
   }

   public String getTeacherMiddleName() {

      return teacherMiddleName;
   }

   public void setTeacherMiddleName(String teacherMiddleName) {

      this.teacherMiddleName = teacherMiddleName;
   }

   public String getTeacherLastName() {

      return teacherLastName;
   }

   public void setTeacherLastName(String teacherLastName) {

      this.teacherLastName = teacherLastName;
   }

   public String getTeacherEmail() {

      return teacherEmail;
   }

   public void setTeacherEmail(String teacherEmail) {

      this.teacherEmail = teacherEmail;
   }

   public String getTeacherLogin() {

      return teacherLogin;
   }

   public void setTeacherLogin(String teacherLogin) {

      this.teacherLogin = teacherLogin;
   }

   public String getTeacherPassword() {

      return teacherPassword;
   }

   public void setTeacherPassword(String teacherPassword) {

      this.teacherPassword = teacherPassword;
   }

   public String getTeacherPasswordMatch() {

      return teacherPasswordMatch;
   }

   public void setTeacherPasswordMatch(String teacherPasswordMatch) {

      this.teacherPasswordMatch = teacherPasswordMatch;
   }

   public String getTeacherCompanyName() {

      return teacherCompanyName;
   }

   public void setTeacherCompanyName(String teacherCompanyName) {

      this.teacherCompanyName = teacherCompanyName;
   }

   public String getTeacherAddress() {

      return teacherAddress;
   }

   public void setTeacherAddress(String teacherAddress) {

      this.teacherAddress = teacherAddress;
   }

   public String getTeacherPhone() {

      return teacherPhone;
   }

   public void setTeacherPhone(String teacherPhone) {

      this.teacherPhone = teacherPhone;
   }

   public String getTeacherCity() {

      return teacherCity;
   }

   public void setTeacherCity(String teacherCity) {

      this.teacherCity = teacherCity;
   }

   public String getTeacherZip() {

      return teacherZip;
   }

   public void setTeacherZip(String teacherZip) {

      this.teacherZip = teacherZip;
   }

   public String getTeacherState() {

      return teacherState;
   }

   public void setTeacherState(String teacherState) {

      this.teacherState = teacherState;
   }

   public String getTeacherCountry() {

      return teacherCountry;
   }

   public void setTeacherCountry(String teacherCountry) {

      this.teacherCountry = teacherCountry;
   }

   public String getTeacherAboutMe() {

      return teacherAboutMe;
   }

   public void setTeacherAboutMe(String teacherAboutMe) {

      this.teacherAboutMe = teacherAboutMe;
   }

   public String getProfilePhotoUrl() {

      return profilePhotoUrl;
   }

   public void setProfilePhotoUrl(String profilePhotoUrl) {

      this.profilePhotoUrl = profilePhotoUrl;
   }

   public int getTeacherType() {

      return teacherType;
   }

   public void setTeacherType(int teacherType) {

      this.teacherType = teacherType;
   }

   public String getTeacherAuthority() {

      return teacherAuthority;
   }

   public void setTeacherAuthority(String teacherAuthority) {

      this.teacherAuthority = teacherAuthority;
   }

   public int getTeacherMembership() {

      return teacherMembership;
   }

   public void setTeacherMembership(int teacherMembership) {

      this.teacherMembership = teacherMembership;
   }

   public int getTeacherActivated() {

      return teacherActivated;
   }

   public void setTeacherActivated(int teacherActivated) {

      this.teacherActivated = teacherActivated;
   }

   public String getActivationCode() {

      return activationCode;
   }

   public void setActivationCode(String activationCode) {

      this.activationCode = activationCode;
   }

   public int getTeacherCoursesEnrolled() {

      return teacherCoursesEnrolled;
   }

   public void setTeacherCoursesEnrolled(int teacherCoursesEnrolled) {

      this.teacherCoursesEnrolled = teacherCoursesEnrolled;
   }

   public int getTeacherTasksCreated() {

      return teacherTasksCreated;
   }

   public void setTeacherTasksCreated(int teacherTasksCreated) {

      this.teacherTasksCreated = teacherTasksCreated;
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

      return String.format("CoderTeachers[id='%d', teacherFirstName='%s', teacherMiddleName='%s', teacherLastName='%s', teacherEmail='%s', teacherLogin='%s', teacherPassword='%s', teacherPasswordMatch='%s', teacherCompanyName='%s', teacherAddress='%s', teacherPhone='%s', teacherCity='%s', teacherZip='%s', teacherState='%s', teacherCountry='%s', teacherAboutMe='%s', profilePhotoUrl='%s', teacherType='%d', teacherAuthority='%s', teacherMembership='%d', teacherActivated='%d', activationCode='%s', teacherCoursesEnrolled='%d', teacherTasksCreated='%d', lastLoginTime='%s', prevLoginTime='%s', instagramId='%s', facebookId='%s', vkId='%s', youtubeId='%s', twitterId='%s', status='%d', agree='%d', addedTime='%s']",
         id, teacherFirstName, teacherMiddleName, teacherLastName, teacherEmail, teacherLogin, teacherPassword, teacherPasswordMatch, teacherCompanyName, teacherAddress, teacherPhone, teacherCity, teacherZip, teacherState, teacherCountry, teacherAboutMe, profilePhotoUrl, teacherType, teacherAuthority, teacherMembership, teacherActivated, activationCode, teacherCoursesEnrolled, teacherTasksCreated, lastLoginTime, prevLoginTime, instagramId, facebookId, vkId, youtubeId, twitterId, status, agree, addedTime);
   }
}

