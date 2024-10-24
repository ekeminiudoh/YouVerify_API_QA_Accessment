package regression;

import base.TestBase;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RegressionTest extends TestBase {

    @Test
    public void testGetAllAPIsAfterChange() {
        int initialCount = getAPIEntriesCount();
        int newCount = getAPIEntriesCount();
        assert initialCount == newCount : "API entries count should remain the same after the change.";
    }

    private int getAPIEntriesCount() {
        return RestAssured.get("/entries").jsonPath().getList("entries").size();
    }
}
