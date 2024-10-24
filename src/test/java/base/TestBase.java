package base;

import io.restassured.RestAssured;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://github.com/public-apis/public-apis";
    }

    @AfterClass
    public void tearDown() {
        // Any teardown operations if needed (e.g., closing resources)
    }
}
