package com.Rmgyantra.validate;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest {
	@Test
	public void pathParameter() {
		String projId= "TY_PROJ_1406";
		given()
		.pathParam("projectId",projId)
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then().assertThat().statusCode(204)
		.log().all();
		
	}

}
