package restassuredtest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.payload;

public class BasicsRestAssured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Validate if add place API is working as expected
		
		//Add place -> Update place with new address -> Get Place to validate if new address is present in Response  		
		//Given - all input details
		//When - Submit the API - resource and http method
		//Then - validate the response
       
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response = given().log().all().queryParam("Key", "qaclick123").header("Content-Type", "application/json").body(payload.AddPlace()).
		
		when().post("/maps/api/place/add/json").
		
		then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
		
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response); // for parsing Json
		String placedId = js.getString("place_id");
		System.out.println(placedId);
		
		//update place
		
		given().log().all().queryParam("key", "quick123").header("Content-Type", "application/json").body("{\r\n"
				+ "\"place_id\":\""+placedId+"\",\r\n"
				+ "\"address\":\"70 winter walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").
		
		when().put("/maps/api/place/update/json").
		
		then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		 //get place
		
		
	}

}
