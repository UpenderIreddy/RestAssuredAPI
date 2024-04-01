package sample;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class parsingXMLResponseBody {

	@Test
	public void getXMLResposne() {

		Response res = given()

				.contentType("application/xml")

				.when()

				.get("http://restapi.adequateshop.com/api/Traveler");

		/*
		 * .then()
		 * 
		 * 
		 * .statusCode(200) .body("TravelerinformationResponse.page", equalTo("1"));
		 */

		// approach 1:

		int statuscode = res.getStatusCode();

		Assert.assertEquals(statuscode, 200);

		String responseBody = res.getBody().toString();

		System.out.println("Response body is " + responseBody);

		// XML path:

		String name = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name");

		System.out.println("approach 1 name is " + name);

		Assert.assertEquals(name, "Developer");

		// Approach 2:

		// In order to perform additional validations in XML , we have to use XmlPath
		// class

		XmlPath xmlobj = new XmlPath(res.asString());

		List<String> travellersnames = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");

			for(String travelername : travellersnames) {

			boolean status = false;

			if (travelername.equals("AS")) {

				status = true;
				break;

			}

			// System.out.println("traveller names are " + travelername);

		}

	}

}
