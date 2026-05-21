package restassuredtest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.payload;

public class BasicsRestAssured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Validate if add place API is working as expected
		
		//Given - all input details
		//When - Submit the API - resource and http method
		//Then - validate the response
       
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParam("Key", "qaclick123").header("Content-Type", "application/json").body(payload.AddPlace()).
		
		when().post("/maps/api/place/add/json").
		
		then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)");
	}

}
