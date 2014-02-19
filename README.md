Vilage Data Manager
=======================

This is a Simple Desktop application for Village Management. java and netbeans ID were used here. Now project has started and still developing. First use case is to add a persion data into database. Database name is vilage it has two table named person and home. 

Setup the project

Before setup the project, it is good to study little bit about the project and how to make a team project using git hub. So first install git in your machine.

If you have installed git, You can type
git clone https://github.com/kasunsk/Vilage_Manager_netbeans.git in terminal or cmd.

Or Download the zip file if U don't have git installed.

Open netbeans and go to File
File ---> open project, then select the project on directory

*  Make sure to add mysql-java-connector to the class path in netbeans project. You can download it from 
(repo1.maven.org/maven2/mysql/mysql-connector-java/5.1.28/mysql-connector-java-5.1.28.jar) this link.  Copy the link and paste it in address bar and press Enter and Download it.
Then go to Netbeans Project. Select libraries and right click and select add jar/folder then select add external jar and select the downloaded connector. 

* Add slf4j-api-1.7.5.jar to the Libraries as above. Use this Link to Download repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.5/slf4j-api-1.7.5.jar
* Add slf4j-log4j12-1.7.5.jar to the Libraries. Use link repo1.maven.org/maven2/org/slf4j/slf4j-log4j12/1.7.5/slf4j-log4j12-1.7.5.jar
* Add log4j-1.2.17.jar to Libraries. Use repo1.maven.org/maven2/log4j/log4j/1.2.17/log4j-1.2.17.jar

And import sql file (in project folder vilage..sql) in phpmyadmin. It will create the suitable database for project.

Then run the main class and check whether it correctly run. You can develop the project. 

