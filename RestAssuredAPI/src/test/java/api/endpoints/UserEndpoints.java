package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.User;

// created to perform CRUD operations on user module

public class UserEndpoints {

	// Need to have requestpayload
	// POST Request
	public static Response createUser(User Payload) {

		Response response = given()

				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Payload)

				.when()

				  	.post(Routes.post_url);

		return response;

	}

	// GET request
	// it returns the response variable
	public static Response readUser(String username) {

		Response response = given()

				.pathParam("username", username)

				.when()

				.get(Routes.get_url);

		return response;

		
	}

	public static Response updateUser(String username, User Payload) {

		Response response = given()

				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParams("username", username)
				.body(Payload)

				.when()

				.put(Routes.update_url);

		return response;

	}
	
	
	public static Response deleteUser(String username) {

		Response response = given()

				.pathParam("username", username)

				.when()

				.get(Routes.delete_url);

		return response;

	}
	


}
