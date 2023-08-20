								IDENTIFY COURSES
								-----------------
Project Description:
--------------------

Suggested site: https://www.coursera.org

1. Search for web development courses for Beginners level & English Language and extract the course names, total learning hours & rating for first 2 courses
2. Look for Language Learning; Extract all the languages and different levels with its total count & display them
3. In Home page, go to "For Enterprise"; Look into Courses for Campus under Product; Fill the  "Ready to transform" form with any one input invalid (example: email); Capture the error message & display

Project Structure:
-----------------------
	In this project we have implemented the hybrid automation framework.
 
    ->IdentifyCoursesV2
	->src/main/java
	  ->com.pageObjects
	  ->com.testData
	  ->com.utilities
	->src/test/java
	  ->com.testCases
	->JRE System Library
	->Maven Dependencies
	->TestNG
	->Configuration
	->Drivers
	->log
	->Screenshots
	->src
	->target
	->test-output
	->extent-config.xml
	->log4j.properties
	->pom.xml
	->testng.xml

-----------------------------------------------------------------------

Steps to Run this project:
---------------------------
1. Import the project in your eclipse workspace.
2. Your system must have chrome and edge driver of your browsers version.
3. Place these browsers in the "Drivers" folder
4. If you want to configure anything like changing names of drivers You can change them "config.properties" file in "Configuration" folder
4. Right click the project --> go to maven --> click on update project
5. we can run this in 2 ways: 
	1.run the project using pom.xml:
	   --------------------------
                 right click on pom.xml --> runas ---> maven --> click on maven test
	2. run the project using testng.xml:
	   ---------------------------------
		right click on testng --> runas --> testNgSuite 

------------------------------------------------------------------------
