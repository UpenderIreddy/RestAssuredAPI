package sample;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class RequestBodyusingExternalFile {

	@Test
	public void createUser() throws FileNotFoundException {

		    File file = new File(".\\body.json");
		
			FileReader filereader = new FileReader(file);

			JSONTokener jsontokener = new JSONTokener(filereader);

			JSONObject jsondata = new JSONObject(jsontokener);
		
		
		
		given()
		
			.contentType("application/json")
			.body(jsondata.toString())
			
			
		.when()
		
			.post("https://reqres.in/api/users")
			
		.then()
		
			.statusCode(201)
			.log().all();
			

	}

}
