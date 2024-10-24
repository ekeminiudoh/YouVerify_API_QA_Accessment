package client;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import payload.ApiPayload;

import static io.restassured.RestAssured.given;

public class ApiClient {
    private final ApiPayload activityPayload = new ApiPayload();
    private static final Logger logger = LogManager.getLogger(ApiClient.class);

    // POST: Create a new activity
    public Response createActivity() {
        String payload = activityPayload.createActivity();
        logger.info("Creating new activity with payload: " + payload);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/api/v1/Activities")
                .then()
                .extract()
                .response();
        logger.info("Received response: " + response.asString());
        return response;
    }

    // GET a specific activity by ID
    public Response getActivity(int activityId) {
        logger.info("Fetching activity with ID: " + activityId);
        Response response = given()
                .when()
                .get("/api/v1/Activities/" + activityId)
                .then()
                .extract()
                .response();
        // Logging the response details
        logger.info("GET /api/v1/Activities/{} - Response Status Code: {}", activityId, response.getStatusCode());
        logger.debug("GET /api/v1/Activities/{} - Response Body: {}", activityId, response.asString());
        return response;
    }

    // GET all activities
    public Response getAllActivities() {
        logger.info("Fetching all activities from the API...");
        Response response = given()
                .when()
                .get("/api/v1/Activities")
                .then()
                .extract()
                .response();

        logger.info("GET /api/v1/Activities - Response Status Code: " + response.getStatusCode());
        logger.debug("GET /api/v1/Activities - Response Body: " + response.asString());
        return response;
    }

}
