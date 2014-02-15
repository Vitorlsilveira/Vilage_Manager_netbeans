CREATE DATABASE vilage;

USE vilage;

CREATE TABLE persion(Name varchar(150) not NULL, ID varchar(100) not NULL PRIMARY KEY,Sex varchar(60) not NULL, Address varchar(250) not NULL, TPNum varchar(60) not NULL, Birth_Date varchar(150), Home_Number varchar(30) not Null);

CREATE TABLE home(Home_Number varchar(30) not NULL PRIMARY KEY, Owner varchar(80) not NULL,Address varchar(150) not NULL, TP_Number  varchar(45), NumberOfMembers int(15));
