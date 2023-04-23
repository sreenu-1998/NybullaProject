# NybullaProject

This project is a an Assignment from Nybulla organisation.

Pre-requisites:
To run this project, you need to have the following installed on your machine:

1.Java JDK (version 8 or higher)
2.Maven
3.Selenium WebDriver
4.Cucumber
5.TestNG
6.An Eclipse IDE for running the tests


Installation:
1.Clone this repository to your local machine.
2.Import the project into your IDE as a Maven project.
3.Download the required dependencies by running the following command in the terminal:
 -> mvn clean install
 
 PlugIns:
 1. Install testNg plugin from Eclipse Market Space.
 2. Install Cucumber Plugin from Eclipse Market Space

Dependencies:
All the needed dependecies are in POM.xml file.

Configuration:
src/tset/Java: This folder contains 4 Packages:
1.Common Utils:This package contains 3 classes
     -> CommonMethods: All the commonly used methods are stored here.
     -> Asseretion: All assertions are stored here
     -> WebDriverSession: we can choose browser to be executed from here.
2. Output: All the output screenshots are available here.
3. StepDefinitions: Al the glue cods for thr feature files are stored here
4. WebPages: This packages contains the xpaths of the webpages.

Running Test Case:

To run testcases navigate to src/test/java/StepDefinition and select "TestRunner" file.
Type the suitable TAG and Run as JUnit file.

Reporting:

After running the tests, a test report is generated in the target directory.



 
