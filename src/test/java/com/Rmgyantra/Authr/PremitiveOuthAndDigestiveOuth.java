package com.Rmgyantra.Authr;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PremitiveOuthAndDigestiveOuth {
	@Test
	public void premitiveOuth() {
		given()
			.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/login")
		.then()
			.statusCode(202)
			.log().all();	
	}
@Test
public void digestiveAuth() {
	given()
		.auth().digest("rmgyantra", "rmgy@9999")
	.when()
		.get("http://localhost:8084/login")
	.then()
		.statusCode(202)
		.log().all();
}
}
