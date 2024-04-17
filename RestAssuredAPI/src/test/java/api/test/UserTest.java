package api.test;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payloads.User;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userpayload;

	@BeforeClass 
	public void setUpData() {

		faker = new Faker();

		userpayload = new User();

		// generates the randomdata using Faker library
		userpayload.setID(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());

	}

	@Test(priority = 1)
	public void testPost() {

		Response response = UserEndpoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	//@Test(priority = 2)
	public void testGetuserByName() {

		Response response = UserEndpoints.readUser(userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();

	}
	//@Test(priority = 3)
	public void testUpdateUser() {

		// Updating the Firstname,lastname and email address

		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());

		Response response = UserEndpoints.updateUser(userpayload.getUsername(), userpayload);
		response.then().log().all();

		// Chai Assertion of rest assured

		response.then().log().body().statusCode(200);

		// TestNG assertion
	//	Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getStatusCode(), 200, "status code is not as expected");

		// checking the data after update

		Response responseafterupdate = UserEndpoints.readUser(userpayload.getUsername());
		Assert.assertEquals(responseafterupdate.getStatusCode(), 200);

	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		
		
		Response response = UserEndpoints.deleteUser(userpayload.getUsername());
		String contenttype = response.contentType();
		Headers headerslist = response.getHeaders();
		String dateheader = response.getHeader("Date");
		for(Header headers : headerslist) {
		System.out.println("headers are  " + "******" + headers);
		}
		Assert.assertEquals(contenttype,"application/json", " contenttype is not matched");
		
		
		
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
