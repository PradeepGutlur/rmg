package com.Rmggyantra.EndToEnd;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResourceFromDeleteTest {
	@Test
	public void ResorceDelete() {
		
		Response res = when().get("http://localhost:8084/projects");
			String project = res.jsonPath().get("[0].projectId");
			given().pathParam("projectId", project)
			
			.when().delete("http://localhost:8084/projects/{projectId}")
			.then().assertThat().statusCode(204)
			.log().all();
	}

}
