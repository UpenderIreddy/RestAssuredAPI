package sample;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ParsingJSONResponseBody {
	
	@Test
	public void validatingResponseBody() {
		
		
		
		Response res =given()
		
			.contentType(ContentType.JSON)
			
		
		
		.when()
		
			.get("https://reqres.in/api/users?page=2");
		
		
		//Approach 1:
		
		
				int responsecode = res.getStatusCode();
				
				System.out.println("Approach 1 : Response status code " + responsecode);
				String responsebody =res.getBody().asString();
				
				System.out.println("Approach 1 : Response Body is  " + responsebody) ;
				
				//JsonPath:
				
					String email_value =res.jsonPath().get("data[0].email").toString();
					
					System.out.println(email_value);
			
		//Approach 2: 
				
			
				Assert.assertEquals(res.getStatusCode(), 200);
				
				// In order to perform additional validations we have to use JSONObject and pass the response asa paramater by converting into string
				
				JSONObject jsonobject = new JSONObject(res.asString());
				
				for(int i=0;i<jsonobject.length();i++) {
					
					String usersemail = jsonobject.getJSONArray("data").getJSONObject(i).get("email").toString();
					
					System.out.println("Approach 2 : email value is " + usersemail);
					
					boolean status = false;
					if(usersemail.contains("@reqres.in")) {
						
						status = true;
						
					}
					
					Assert.assertEquals(status, true);
				}
				
				
				
				
				
				
		
		
		
		
		
	}

}
