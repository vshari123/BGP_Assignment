# BGP Assignment
BGP Assignment project is a test automation project covering the user stories given for the test. The task predominantly covers application submission process and to verify if it is successfully submitted. To cover this flow, a simple maven + page object model based framework is developed using extent reports for reporting.

# Concepts Included
* Page object model (without page factory)
* Data driven test data using Yaml
* Manage dependencies using Maven

# Tools
* Maven
* Java
* TestNG
* Selenium Webdriver
* Snake Yaml
* Extent reporting

# Requirements
In order to utilise this project you need to have the following installed locally:
* Maven 
* Chrome and Chromedriver (UI tests use Chrome by default, can be changed in config)
* Java 1.8
* IDE (IntelliJ or Eclipse)

# Design Pattern
* Framework is built based on simple page object model without page factory. src/main/java/pages package contains all the pages for this portal. 
* Inside each of the page clasess, element properties of all the elements of a specific page are captured and stored in By type of variables. Apart from these element properites, this class contains methods for the actions performed on these elements (that are necessary in that page). 
* TestBase class is the base class for the entire project. This is present in src/main/java/testBase package. Base class contains basic things such as reading the properties file, driver initialization, closing the driver once test is complete along with all the common reusable actions.
* Other utilities such as reading data, Timeout values and initializing Extent report is present in the testUtil package (src/main/java/testUtil)
* TestNG tests (test cases) are designed in src/test/java/testCases package. Each of the page in the flow is handled as a seperate test in the TestCase class. This class also contains integration with Extent reports; report will get updated based on the result of each @Test method in this class. 
* Test Data for this project is provided in the TestData.yaml file under src/main/java/resources/testData package. Datastore class under testUtil package will read this yaml file and pass data at runtime. In case of need to modify data, it has to be done in the TestData.yaml file.
* Driver executables required for execution are present in src/main/java/resources/drivers package
* config.properties file in src/main/java/resources/config package contains basic properties such as application url, driver path, etc.
* pom.xml contains all the dependencies required for the project.


# Usage
* In order to execute the automation test cases, user has to execute the testNG.xml file in the root directory of the project. Given use cases are already built in the testNG.xml file where all 3 test cases will get executed. 
* If the user choses to execute specific test cases, then he/she can update 'enabled="false"' attribute in the 'class' or 'test' tags against the test case which user wants to ignore.


# Reporting
Execution is performed sequentially and the report is generated in the root directory once execution is completed (ExtentReport.html).

