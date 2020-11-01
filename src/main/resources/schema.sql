CREATE TABLE c0d3r_students (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   studentFirstName char(64) NOT NULL default '',
   studentMiddleName char(64) NOT NULL default '',
   studentLastName char(64) NOT NULL default '',
   studentEmail char(128) NOT NULL default '',
   studentLogin char(64) NOT NULL default '',
   studentPassword char(128) NOT NULL default '',
   studentPasswordMatch char(128) NOT NULL default '',
   studentCompanyName char(255) NOT NULL default '',
   studentAddress char(255) NOT NULL default '',
   studentPhone char(64) NOT NULL default '',
   studentCity char(32) NOT NULL default '',
   studentZip char(32) NOT NULL default '',
   studentState char(32) NOT NULL default '',
   studentCountry char(32) NOT NULL default '',
   studentAboutMe BLOB,
   profilePhotoUrl char(128) NOT NULL default '',
   studentType int(2) NOT NULL default '0',
   studentAuthority char(16) NOT NULL default '',
   studentMembership int(2) NOT NULL default '0',
   studentActivated int(2) NOT NULL default '0',
   activationCode char(128) NOT NULL default '',
   studentRating float(12) NOT NULL default '0.00',
   studentCoursesEnrolled int(2) NOT NULL default '0',
   studentTasksComplete int(2) NOT NULL default '0',
   lastLoginTime datetime not null,
   prevLoginTime datetime not null,
   instagramId char(64) NOT NULL default '',
   facebookId char(64) NOT NULL default '',
   vkId char(64) NOT NULL default '',
   youtubeId char(64) NOT NULL default '',
   twitterId char(64) NOT NULL default '',
   status int(2) NOT NULL default '1',
   agree int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_teachers (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   teacherFirstName char(64) NOT NULL default '',
   teacherMiddleName char(64) NOT NULL default '',
   teacherLastName char(64) NOT NULL default '',
   teacherEmail char(128) NOT NULL default '',
   teacherLogin char(64) NOT NULL default '',
   teacherPassword char(128) NOT NULL default '',
   teacherPasswordMatch char(128) NOT NULL default '',
   teacherCompanyName char(255) NOT NULL default '',
   teacherAddress char(255) NOT NULL default '',
   teacherPhone char(64) NOT NULL default '',
   teacherCity char(32) NOT NULL default '',
   teacherZip char(32) NOT NULL default '',
   teacherState char(32) NOT NULL default '',
   teacherCountry char(32) NOT NULL default '',
   teacherAboutMe BLOB,
   profilePhotoUrl char(128) NOT NULL default '',
   teacherType int(2) NOT NULL default '0',
   teacherAuthority char(16) NOT NULL default '',
   teacherMembership int(2) NOT NULL default '0',
   teacherActivated int(2) NOT NULL default '0',
   activationCode char(128) NOT NULL default '',
   teacherCoursesEnrolled int(2) NOT NULL default '0',
   teacherTasksCreated int(2) NOT NULL default '0',
   lastLoginTime datetime not null,
   prevLoginTime datetime not null,
   instagramId char(64) NOT NULL default '',
   facebookId char(64) NOT NULL default '',
   vkId char(64) NOT NULL default '',
   youtubeId char(64) NOT NULL default '',
   twitterId char(64) NOT NULL default '',
   status int(2) NOT NULL default '1',
   agree int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_classes (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   className char(255) NOT NULL default '',
   localeName char(8) NOT NULL default '',
   classType int(2) NOT NULL default '0',
   classDescription BLOB,
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_groups (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   classId int(11) NOT NULL default '0',
   groupName char(255) NOT NULL default '',
   localeName char(8) NOT NULL default '',
   groupType int(2) NOT NULL default '0',
   groupDescription BLOB,
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_courses (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   courseName char(255) NOT NULL default '',
   localeName char(8) NOT NULL default '',
   courseType int(2) NOT NULL default '0',
   courseDescription BLOB,
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_course_sections (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   courseId int(11) NOT NULL default '0',
   sectionName char(255) NOT NULL default '',
   localeName char(8) NOT NULL default '',
   sectionType int(2) NOT NULL default '0',
   sectionDescription BLOB,
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_student_class_connect (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   studentId int(11) NOT NULL default '0',
   classId int(11) NOT NULL default '0',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_student_group_connect (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   studentId int(11) NOT NULL default '0',
   groupId int(11) NOT NULL default '0',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_student_course_connect (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   studentId int(11) NOT NULL default '0',
   courseId int(11) NOT NULL default '0',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_tasks (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   courseId int(11) NOT NULL default '0',
   sectionId int(11) NOT NULL default '0',
   languageId int(2) NOT NULL default '0',
   teacherId int(11) NOT NULL default '0',
   taskName char(255) NOT NULL default '',
   localeName char(8) NOT NULL default '',
   taskType int(2) NOT NULL default '0',
   taskValue float(12) NOT NULL default '0.00',
   taskDescription BLOB,
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_task_results (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   taskId int(11) NOT NULL default '0',
   studentId int(11) NOT NULL default '0',
   languageId int(2) NOT NULL default '0',
   localeName char(8) NOT NULL default '',
   resultValue float(12) NOT NULL default '0.00',
   resultDescription BLOB,
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_task_result_source_codes (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   resultId int(11) NOT NULL default '0',
   studentId int(11) NOT NULL default '0',
   fileURL char(255) NOT NULL default '',
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_task_results_history (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   taskId int(11) NOT NULL default '0',
   studentId int(11) NOT NULL default '0',
   actionId int(2) NOT NULL default '0',
   localeName char(8) NOT NULL default '',
   languageId int(2) NOT NULL default '0',
   resultValue float(12) NOT NULL default '0.00',
   resultDescription BLOB,
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_task_results_history_source_codes (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   historyId int(11) NOT NULL default '0',
   studentId int(11) NOT NULL default '0',
   fileURL char(255) NOT NULL default '',
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_task_autotest_properties (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   taskId int(11) NOT NULL default '0',
   languageId int(2) NOT NULL default '0',
   runTimeMillisecondsFrom char(32) NOT NULL default '',
   runTimeMillisecondsTo char(32) NOT NULL default '',
   rewardValue float(12) NOT NULL default '0.00',
   inputData BLOB,
   outputData BLOB,
   inputURL char(255) NOT NULL default '',
   outputURL char(255) NOT NULL default '',
   inputFileName char(255) NOT NULL default '',
   outputFileName char(255) NOT NULL default '',
   inputMethod char(8) NOT NULL default '',
   outputMethod char(8) NOT NULL default '',
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_task_autotest_results (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   taskId int(11) NOT NULL default '0',
   resultId int(11) NOT NULL default '0',
   autotestId int(11) NOT NULL default '0',
   languageId int(2) NOT NULL default '0',
   runTimeMilliseconds char(32) NOT NULL default '',
   rewardValue float(12) NOT NULL default '0.00',
   inputData BLOB,
   outputData BLOB,
   inputURL char(255) NOT NULL default '',
   outputURL char(255) NOT NULL default '',
   inputFileName char(255) NOT NULL default '',
   outputFileName char(255) NOT NULL default '',
   inputMethod char(8) NOT NULL default '',
   outputMethod char(8) NOT NULL default '',
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_settings (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   setting1 int(2) NOT NULL default '1',
   setting2 int(2) NOT NULL default '1',
   setting3 int(2) NOT NULL default '1',
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_chats (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   studentId int(11) NOT NULL default '0',
   teacherId int(11) NOT NULL default '0',
   adminId int(11) NOT NULL default '0',
   folderId int(2) NOT NULL default '1',
   isPublicChat int(2) NOT NULL default '1',
   courseId int(11) NOT NULL default '1',
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_chat_records (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   chatId int(11) NOT NULL default '0',
   studentId int(11) NOT NULL default '0',
   teacherId int(11) NOT NULL default '0',
   adminId int(11) NOT NULL default '0',
   chatRecord BLOB,
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_chat_files_connect (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   chatRecordId int(11) NOT NULL default '0', 
   fileURL char(255) NOT NULL default '',
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_content_pages (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   pageId int(2) NOT NULL default '0',
   languageName char(3) NOT NULL default '',
   pageTitle char(128) NOT NULL default '',
   contentBody BLOB,
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_admins (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   adminType int(2) NOT NULL default '0',
   adminName char(55) NOT NULL default '',
   adminEmail char(255) NOT NULL default '',
   adminAccessAreas char(25) NOT NULL default '',
   adminAccessStudents int(2) NOT NULL default '0',
   adminAccessTeachers int(2) NOT NULL default '0',
   adminAccessClasses int(2) NOT NULL default '0',
   adminAccessCourses int(2) NOT NULL default '0',
   adminAccessTasks int(2) NOT NULL default '0',
   adminAccessSolutions int(2) NOT NULL default '0',
   adminAccessRatings int(2) NOT NULL default '0',
   adminAccessReports int(2) NOT NULL default '0',
   adminAccessSettings int(2) NOT NULL default '0',
   adminAccessContentPages int(2) NOT NULL default '0',
   adminAccessAdmins int(2) NOT NULL default '0',
   adminAccessChat int(2) NOT NULL default '0',
   adminAccessEditor int(2) NOT NULL default '0',
   adminLogin char(55) NOT NULL default '',
   adminPassword char(128) NOT NULL default '',
   adminAuthority char(16) NOT NULL default '',
   adminStatus int(2) NOT NULL default '1',
   lastLoginTime datetime not null,
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE c0d3r_editor_state
(
    id         int(11) unsigned NOT NULL AUTO_INCREMENT,
    path       varchar(255)     NOT NULL default '0',
    projectId  int(11)          NOT NULL,
    language   char(16)         NOT NULL default '',
    content    BLOB,
    addedTime  datetime        not null,
    updateTime datetime        not null,
    PRIMARY KEY (id)
);

CREATE TABLE c0d3r_editor_project
(
    id         int(11) unsigned NOT NULL AUTO_INCREMENT,
    name       varchar(32)      NOT NULL default '0',
    task       int(11)          NOT NULL default '0',
    startTime  datetime        not null,
    updateTime datetime        not null,
    PRIMARY KEY (id)
);