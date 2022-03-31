package com.Rmgyantra.Authr;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class Auth2Test {
	@Test
	public void auth2() {
		
		Response res = given()
			.formParam("client_id", "pradeepform")
			.formParam("client_secret", "ac976e5db272c439010d15bcd049e00b")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri" , "https://example.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		String token = res.jsonPath().get("access_token");
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 2944)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then().assertThat()
		.log().all();
			
	}

}
