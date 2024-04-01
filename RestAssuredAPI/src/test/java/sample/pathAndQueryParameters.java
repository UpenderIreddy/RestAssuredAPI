package sample;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class pathAndQueryParameters {
	
	@Test
	public void paramsSetUP() {
		
		
		given()
		
		// The path parameter defines the resource location, while the query parameter defines sort, pagination, or filter operations
			.pathParam("mypath","users")
			.queryParam("page",2)
			
		.when()
		
		     .get("https://reqres.in/api/{mypath}")
		     
		 
		 .then()
		 
		 	.statusCode(200)
		 	.log().all();
		 	
		 
		     
		
	}

}
