package sample;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class RequestBodyUsingPojo {
	
		@Test
		public void createUser() {
			
			POJOclass pojo = new POJOclass();
			pojo.setName("Upender");
			pojo.setJob("Tester");
			
			
		given()
		
			.contentType("application/json")
			.body(pojo)
			
		.when()
		
			.post("https://reqres.in/api/users")
			
			
		.then()
			
			.statusCode(201)
			.log().all();
			
			
		}
	

}
