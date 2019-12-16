create database alphaproject;
------------------------------
use alphaproject;
-------------------------------
CREATE TABLE IF NOT EXISTS admin (
  id int(11) NOT NULL AUTO_INCREMENT,
  email varchar(150) NOT NULL,
  password varchar(100) NOT NULL,
  PRIMARY KEY (id)  
);
-----------------------------------
CREATE TABLE IF NOT EXISTS departments (
  deptId int(11) NOT NULL AUTO_INCREMENT,
  deptName varchar(255) DEFAULT NULL,
  deptShortName varchar(100) NOT NULL,
  deptCode varchar(50) DEFAULT NULL,
  PRIMARY KEY (deptId)
);
----------------------------------------------------------
 CREATE TABLE IF NOT EXISTS employees (
       empId int(100) AUTO_INCREMENT,
       fname varchar(150) NOT NULL,
       lname varchar(150) NOT NULL,
       email varchar(200) NOT NULL,
       password varchar(180) NOT NULL,
       gender varchar(100) NOT NULL,
       dob varchar(100) NOT NULL,
       deptName varchar(255),
       deptId int(11),  
       city varchar(200) NOT NULL,
       country varchar(150) NOT NULL,
       phone char(11) NOT NULL,
       available int(11),
       PRIMARY KEY (empId),
       FOREIGN KEY (deptId) REFERENCES departments(deptId),
       FOREIGN KEY (deptName) REFERENCES departments(deptName) 
);
--------------------------------------------------------------
CREATE TABLE IF NOT EXISTS managers (
       empId int(100) AUTO_INCREMENT,
       fname varchar(150) NOT NULL,
       lname varchar(150) NOT NULL,
       email varchar(200) NOT NULL,
       password varchar(180) NOT NULL,
       gender varchar(100) NOT NULL,
       dob varchar(100) NOT NULL,
       deptId int(11),  
       city varchar(200) NOT NULL,
       country varchar(150) NOT NULL,
       phone char(11) NOT NULL,
       PRIMARY KEY (empId),
       FOREIGN KEY (deptId) REFERENCES departments(deptId)
);
---------------------------------------------------------------
CREATE TABLE IF NOT EXISTS leaves (
  leaveId int(11) NOT NULL AUTO_INCREMENT,
  leaveType varchar(110) NOT NULL,
  toDate varchar(120) NOT NULL,
  fromDate varchar(120) NOT NULL,
  description mediumtext NOT NULL,
  postingDate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  adminRemark mediumtext,
  status varchar(120) NOT NULL DEFAULT 'PENDING',
  empId int(11) DEFAULT NULL,
  deptId int(11),
  days int(11),
  PRIMARY KEY (leaveId),
  FOREIGN KEY (deptId) REFERENCES departments(deptId),
  FOREIGN KEY (empId) REFERENCES employees(empId)
);
--------------------------------------------------------------
CREATE TABLE IF NOT EXISTS leavetype (
  id int(11) NOT NULL AUTO_INCREMENT,
  leaveType varchar(200) DEFAULT NULL,
  Description mediumtext,
  PRIMARY KEY (id)
);
---------------------------------------------------------------
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);
---------------------------------------------------
ALTER TABLE `departments`
  ADD PRIMARY KEY (`DeptId`);
-----------------------------------------------------
ALTER TABLE `employees`
  ADD PRIMARY KEY (`EmpId`);
----------------------------------------------------
ALTER TABLE `managers`
  ADD PRIMARY KEY (`EmpId`);
-----------------------------------------------------
ALTER TABLE `leaves`
  ADD PRIMARY KEY (`id`),
  ADD KEY `UserEmail` (`EmpId`);
-----------------------------------------------------
ALTER TABLE `leavetype`
  ADD PRIMARY KEY (`id`);
-----------------------------------------------------
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
---------------------------------------------------------------------
ALTER TABLE `departments`
  MODIFY `DeptId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
----------------------------------------------------------------------
ALTER TABLE `employees`
  MODIFY `EmpId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
----------------------------------------------------------------------
ALTER TABLE `leaves`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
-------------------------------------------------------------------
ALTER TABLE `leavetype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;