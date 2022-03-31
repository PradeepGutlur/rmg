package com.Rmgyantra.Authr;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
	@Test
	public void Beartoken() {
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/users/PradeepGutlur/repos")
		.then()
		.statusCode(200).contentType(ContentType.JSON)
		.log().all();
	}

}
