package api;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Sample1 {

    @Test
    public void verifyCreatePostSuccess() {
        // Sample request body for a POST call
        String requestBody = "{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": 1\n" +
                "}";

        // Send POST request
        Response response = RestAssured
            .given()
            .header("Content-type", "application/json; charset=UTF-8")
            .body(requestBody)
            .when()
            .post("https://jsonplaceholder.typicode.com/posts");

        // Verify status code is 201 Created
        int statusCode = response.getStatusCode();
        System.out.println("POST Status Code: " + statusCode);
        System.out.println("POST Response: " + response.getBody().asPrettyString());

        Assert.assertEquals(statusCode, 201, "Status code should be 201 Created");
    }
}