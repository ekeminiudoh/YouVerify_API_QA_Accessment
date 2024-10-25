# YouVerify_API_QA_Accessment
# Public APIs Test Suite
This project aims to automate the testing of the Public APIs using REST Assured, Java, and TestNG. The test suite covers different types of tests such as Smoke, Functional, Performance, and Regression tests to ensure the API's reliability and performance.

# Project Structure
The test suite follows a modular structure, with each type of test organized into separate packages:

src
└── test
    ├── java
    │   
    │     ├── base
    │     │   └── TestBase.java
    │     ├── client
    │     │   └── ApiClient.java
    │     ├── payload
    │     │   └── ApiPayload.java
    │     ├── test
    │     │   └── ApiTest.java
    ├── resources
    │     └── log4j2.xml
    │     └── testNG.xml
└── testng.xml

* base: Contains the base setup and teardown logic for the tests.
* client: contains class that contains reusable methods.
* payload: contains class that contains request body that returns in json format.
* test: contains the API tests
* resources: contains log4j2 files for logging config and testng runner file to run the tests.

# Prerequisites
* Java 8 or higher
* Maven 3.x
* An IDE (IntelliJ, Eclipse, etc.)
* Internet connection for downloading dependencies

# Setup
1. Clone the Repository: bash   git clone <repository-url>
2. cd public-apis-test-suite   
3. Open the Project in an IDE: Import the project as a Maven project in your preferred IDE (e.g., IntelliJ, Eclipse).
4. Install Dependencies: Run the following command to install dependencies: bash   mvn clean install
   

# Running the Tests
You can run the tests using Maven and TestNG.
1. Run All Tests:
   bash   mvn clean test
2. And run from testng.xml file  
3. Run Specific Test Suites: To run only a particular type of test, specify the suite file. For example, to run the smoke tests: bash Copy code   mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml -Dtest=SmokeTest
   

# Test Coverage
1. Create Activity: Verifies new activity creation, checks status code 200, title "Fresh Activity," and retrieves ID.
2. Get Specific Activity: Verifies fetching activity by ID, checks status code 200, title not null, and correct ID.
3. Get All Activities: Verifies retrieval of all activities, checks status code 200, and confirms list is not empty.

# Tools and Technologies
* Java: Programming language for writing the tests.
* REST Assured: Java library for testing RESTful APIs.
* TestNG: Testing framework for structuring the tests.
* Maven: Dependency management and build tool.

# How to Extend the Tests
1. Add New Test Cases:
    * Create a new class under the test package .
    * Extend the TestBase class and write new test methods.
2. Add New payloads:
    * Add common payload methods in ApiPayload.java for reusage.
3. Configure TestNG Suite:
    * Edit testng.xml to add new test classes or groups.
      
# Test Reporting
Test reports are generated with aventstack extentreport in the reports directory. 
# License
This project is open-source 
