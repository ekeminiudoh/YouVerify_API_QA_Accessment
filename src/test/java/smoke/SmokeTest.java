package smoke;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.TestUtils;

public class SmokeTest extends TestBase {

    @Test
    public void testGetAllAPIs() {
        Response response = RestAssured.get("/entries");
        TestUtils.verifyStatusCode(response, 200);
        int entriesCount = TestUtils.getAPIEntriesCount(response);
        assert entriesCount > 0 : "There should be at least one entry";
    }

    @Test
    public void testGetCategories() {
        Response response = RestAssured.get("/categories");
        TestUtils.verifyStatusCode(response, 200);
        assert response.jsonPath().getList("").size() > 0 : "There should be at least one category";
    }
}
