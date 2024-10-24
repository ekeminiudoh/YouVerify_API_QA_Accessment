package functional;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.TestUtils;

public class FunctionalTest extends TestBase {

    @Test
    public void testSearchAPIByTitle() {
        String searchTerm = "Weather";
        Response response = RestAssured
                .given()
                .queryParam("title", searchTerm)
                .get("/entries");

        TestUtils.verifyStatusCode(response, 200);
        int matchingEntries = TestUtils.getAPIEntriesCount(response);
        assert matchingEntries > 0 : "There should be at least one entry matching the search term";
    }

    @Test
    public void testGetRandomAPI() {
        Response response = RestAssured.get("/random");
        TestUtils.verifyStatusCode(response, 200);
        String apiName = response.jsonPath().get("entries[0].API");
        assert apiName != null : "API name should not be null";
    }
}
