package api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Sample1 {
	
	@Test
	public void sample() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		RestAssured.given().header("Content-Type", "application/json") // Telling the server we are sending JSON data
        .body("{\n" +                               // The actual data payload we want to create
                "    \"name\": \"Rahul\",\n" +
                "    \"job\": \"Automation Learner\"\n" +
                "}")
        .when().post("/api/users").then().assertThat().statusCode(200)
        ;
		
		
		 	
	
		

	}

}
