package Files;

import io.restassured.path.json.JsonPath;

public class reUseableMethod {

	public static JsonPath rawToJson(String response) {
		JsonPath js1 = new JsonPath(response);
		return js1;
		// TODO Auto-generated method stub

	}

}
