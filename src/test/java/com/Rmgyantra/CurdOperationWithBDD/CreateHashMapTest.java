package com.Rmgyantra.CurdOperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateHashMapTest {
@Test
public void createHashMap() {

	HashMap map = new HashMap();
	map.put("createdBy", "puni12");
	map.put("projectName", "manoj12sdff");
	map.put("status", "OnGoing");
	map.put("teamSize", 10);
	
	given()
		.body(map)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	
	
}
}
