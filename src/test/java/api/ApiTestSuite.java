package api;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

public class ApiTestSuite {
    
    // Class variables to manage the report
    static ExtentReports extent;
    static ExtentSparkReporter spark;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        // Specify where you want the HTML file to be saved
        spark = new ExtentSparkReporter("target/API_Test_Report.html");
        spark.config().setReportName("API Automation Execution Results");
        spark.config().setDocumentTitle("Test Execution Report");
        
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Test
    public void verifyGetUserSuccess() {
        // Create a dedicated card/section in the HTML report for this test case
        test = extent.createTest("Verify Get User Profile", "Validates if user profile data returns 200 OK");
        test.info("Sending GET request to /api/users/2");

        Response response = given()
                                .baseUri("https://reqres.in")
                            .when()
                                .get("/api/users/2");

        // Validate and log success/failure
        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            
            // Log details directly into the HTML document
            test.pass("Step Passed: Status code is 200.");
            test.info("Response Body: " + response.getBody().asPrettyString());
        } catch (AssertionError e) {
            // Captures the exact reason for failure in red blocks on the report
            test.fail("Step Failed! Expected status code 200 but found: " + response.getStatusCode());
            test.fail(e.getMessage());
            throw e; // Ensures TestNG also marks the test as failed
        }
    }

    @AfterSuite
    public void generateReport() {
        // CRITICAL STEP: Writes everything to the HTML file
        extent.flush();
    }
}
