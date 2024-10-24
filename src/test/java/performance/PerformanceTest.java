package performance;

import base.TestBase;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;

public class PerformanceTest extends TestBase {

    @Test
    public void testResponseTimeForGetAllAPIs() {
        long maxResponseTime = 2000L; // 2 seconds
        RestAssured
                .get("/entries")
                .then()
                .time(lessThan(maxResponseTime));
    }
}
