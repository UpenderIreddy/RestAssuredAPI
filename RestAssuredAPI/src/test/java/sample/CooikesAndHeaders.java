package sample;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CooikesAndHeaders {

	@Test(priority = 1)

	public void getCookies()

	{

		Response res = given()

				.when()

				.get("https://www.google.com/");


		//instead of this, we can use log.cookies(), which returns cookies information
		// get single cookie value
		String cookie_value = res.getCookie("AEC");
		System.out.println("cookievalue is " + cookie_value);

		Map<String, String> cookiesvalues = res.getCookies();

		System.out.println(cookiesvalues.keySet());

		// returning the cookie keys

		for (String cookie : cookiesvalues.keySet()) {

			// getCookie() gets the value of the cookie

			String cookievalue = res.getCookie(cookie);

			// printing the cookie value

			System.out.println("cookies and values are " + cookie + ":" + cookievalue);

		}

	}

	@Test(priority = 2)
	public void getHeaders() {

		Response res1 = given()

				.when().get("https://www.google.com/");

		
		//instead of this, we can use log.headers();
		// getting the headers information
		Headers headerinfo = res1.getHeaders();

		for (Header head : headerinfo) {

			System.out.println("Headers are " + head.getName() + ":" + head.getValue());

		}

	}

}
