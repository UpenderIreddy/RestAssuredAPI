package sample;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.github.fge.jsonschema.main.JsonValidator;

import io.restassured.matcher.RestAssuredMatchers;

public class JsonSchemaValidate {

	@Test
	public void JsonSchemavalidatorTest() {

		given()

				.when()

				.get("https://reqres.in/api/users/2")

				.then()

				.log().all();

	}

}
