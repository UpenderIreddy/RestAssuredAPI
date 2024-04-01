package sample;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class RequestBodyUsingHashMap {
	
	@Test
	public void CreatheUser() {
		
		
		HashMap<String,String> hashmap = new HashMap<String,String>();

			hashmap.put("name", "xyz");
			hashmap.put("job", "Tester");

		given()

				.contentType("applicaion/json")
				
				.body(hashmap)

		.when()

				.post("https://reqres.in/api/users")

	   .then()

				.statusCode(201)
				.log().all();

	}

}
