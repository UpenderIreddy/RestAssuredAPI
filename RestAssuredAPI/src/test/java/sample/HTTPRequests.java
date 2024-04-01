package sample;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class HTTPRequests {

	@Test(priority = 1)

	public void getTheUsersList() {

		given()

				.when()

				.get("https://reqres.in/api/users?page=2")

				.then()

				.statusCode(200).body("page", equalTo(2)).log().all();

	}

	//@Test(priority = 2)
	public void createTheUser() {

		// creating the request body using hashmap

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
