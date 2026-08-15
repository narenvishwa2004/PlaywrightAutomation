package api;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTestSuite {

    @Test
    public void verifyGetUserSuccess() {
        // Free, open public GET API
        Response response = RestAssured
            .given()
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/1");

        // Print details to console
        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);
        System.out.println("Response Body: " + response.getBody().asPrettyString());
        
        // Assert status code is 200
        Assert.assertEquals(statusCode, 200, "Status code should be 200");
    }
}