CREATE DATABASE vilage;

USE vilage;

CREATE TABLE persion(Name varchar(40) not NULL, ID varchar(12) not NULL PRIMARY KEY,Sex varchar(6) not NULL, Address varchar(60) not NULL, TPNum varchar(15) not NULL, Birth_Date varchar(25));

CREATE TABLE home(Home_Number varchar(5) not NULL PRIMARY KEY, Owner varchar(40) not NULL,Address varchar(60) not NULL, TP_Number  varchar(13), NumberOfMembers int(2));
