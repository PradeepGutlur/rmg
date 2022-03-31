package com.Rmgyantra.CurdOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateTheResourceTest {
	@Test
	public void post() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "puni12");
		obj.put("projectName", "TySS--31");
		obj.put("status", "OnGoing");
		obj.put("teamSize", 20);
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}

}
