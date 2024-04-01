package sample;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class RequestBodyUsingorgJson {
	
	
	@Test
	public void createTheUser() {
		
		JSONObject jsonobject = new JSONObject();
		
		jsonobject.put("name","Tester");
		jsonobject.put("job","Testerrole");
		
		
		given()
		
			.contentType("application/json")
			.body(jsonobject.toString())
			
		.when()
		
			.post("https://reqres.in/api/users")
			
			
		.then()
		
			.statusCode(201)
			.body("name",equalTo("Tester"))
			.log().all();
		
			
		
		
		
		
		
		
		
		
	}

}
