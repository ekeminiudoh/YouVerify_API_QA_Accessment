package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    protected static final Logger logger = LogManager.getLogger(TestBase.class);

    @BeforeClass
    public void setup() {
        // Setting up the base URI for all API requests
        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net";
        logger.info("Base URI set to: " + RestAssured.baseURI);
    }

    @BeforeSuite
    public void setupExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/API_Test_Report.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Fakerest API Test Report");
        sparkReporter.config().setReportName("API Automation Test Results");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester", "Ekemini Udoh");
        extentReports.setSystemInfo("Project", "Fakerest API Automation");
    }

    @AfterSuite
    public void tearDownExtentReports() {
        extentReports.flush();
    }

}
