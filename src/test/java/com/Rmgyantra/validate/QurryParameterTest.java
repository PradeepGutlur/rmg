package com.Rmgyantra.validate;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QurryParameterTest {
	@Test
	public void qurreyParameter() {
		given()
		.queryParam("page", "2")
		.when()
		.get("https://reqres.in/api/users")
		.then().statusCode(200)
		.log().all();
		
	}

}
