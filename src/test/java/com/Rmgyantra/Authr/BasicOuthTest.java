package com.Rmgyantra.Authr;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicOuthTest {
	@Test
	public void basicOuth() {
		given()
			.auth().basic("rmgyantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/login")
		.then()
			.statusCode(202)
			.log().all();
	}

}
