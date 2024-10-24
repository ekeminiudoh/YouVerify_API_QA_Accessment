package test;

import base.TestBase;
import client.ApiClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApiTest extends TestBase {
    private final ApiClient activityClient = new ApiClient();

    @Test
    public void testCreateActivity() {
        extentTest = extentReports.createTest("Test: Create New Activity");
        extentTest.info("Starting the create activity test");
        Response response = activityClient.createActivity();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), "Fresh Activity");
        response.jsonPath().getInt("id");
    }

    @Test
    public void testGetSpecificActivity() {
        extentTest = extentReports.createTest("Test: Fetch a specific activity by ID");
        extentTest.info("Starting the get specific activity test");
        Response response = activityClient.getActivity(1);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getString("title"));
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
    }

    @Test
    public void testGetAllActivities() {
        // Fetch all activities
        extentTest = extentReports.createTest("Test: Fetch all activities");
        extentTest.info("Starting the get all activities test");
        Response response = activityClient.getAllActivities();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertFalse(response.jsonPath().getList("$").isEmpty(), "No activities found!");
    }
}
