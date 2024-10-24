package utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class TestUtils {
    public static void verifyStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code should match");
    }

    public static void verifyResponseTime(Response response, long maxTimeInMillis) {
        Assert.assertTrue(response.getTime() < maxTimeInMillis, "Response time should be less than " + maxTimeInMillis + " milliseconds");
    }

    public static int getAPIEntriesCount(Response response) {
        return response.jsonPath().getList("entries").size();
    }
}
