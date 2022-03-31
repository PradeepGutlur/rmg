package com.Rmgyantra.CurdOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UpdateFullyTest {
@Test
public void put() {
	Random ram = new Random();
	int rad = ram.nextInt(100);
	JSONObject obj = new JSONObject();
	obj.put("createdBy", "puni12");
	obj.put("projectName", "TySS--03"+rad);
	obj.put("status", "OnGoing");
	obj.put("teamSize", 20);
	given()
	.body(obj)
	.contentType(ContentType.JSON)
	.when()
	.put("http://localhost:8084/projects/TY_PROJ_1002")
	.then()
	.assertThat()
	.contentType(ContentType.JSON)
	.statusCode(200)
	.log().all();
}
}
