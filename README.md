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
    │     ├── smoke
    │     │   └── SmokeTest.java
    │     ├── functional
    │     │   └── FunctionalTest.java
    │     ├── performance
    │     │   └── PerformanceTest.java
    │     ├── regression
    │     │   └── RegressionTest.java
    │     ├── utils
    │     │   └── TestUtils.java
    │     │   └── extentReports
    │     │        └── ExtentManager.java
    │     │        └── ExtentTestManager.java
    │     │   └── listeners
    │     │        └── AnnotationTransformer.java
    │     │        └── Retry.java
    │     │        └── TestListener.java
└── testng.xml

* base: Contains the base setup and teardown logic for the tests.
* smoke: Quick tests to verify the essential functionality.
* functional: Tests to validate specific functionalities.
* performance: Tests for assessing response time and performance.
* regression: Tests to ensure that changes don’t break existing functionality.
* utils: Utility classes for common reusable methods, listeners and extent report configurations.

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
1. Smoke Tests
* Verifies that crucial API endpoints are functional.
* Ensures basic GET requests for /entries and /categories work correctly.
2. Functional Tests
* Tests specific functionalities of the API.
* Validates search functionality and the ability to retrieve random API entries.
3. Performance Tests
* Assesses the response time for API endpoints.
* Ensures that the API responds within an acceptable time limit.
4. Regression Tests
* Ensures that existing functionalities remain unaffected after changes.
* Tests for consistency in the API response.

# Tools and Technologies
* Java: Programming language for writing the tests.
* REST Assured: Java library for testing RESTful APIs.
* TestNG: Testing framework for structuring the tests.
* Maven: Dependency management and build tool.

# How to Extend the Tests
1. Add New Test Cases:
    * Create a new class under the appropriate package (e.g., functional, regression).
    * Extend the BaseTest class and write new test methods.
2. Add New Utilities:
    * Add common utility methods in TestUtils.java for reuse across different test classes.
3. Configure TestNG Suite:
    * Edit testng.xml to add new test classes or groups.
      
# Test Reporting
Test reports are generated with aventstack extentreport in the reports directory. 
# License
This project is open-source 
