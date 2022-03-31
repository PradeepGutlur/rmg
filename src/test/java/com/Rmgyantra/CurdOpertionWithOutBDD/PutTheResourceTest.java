package com.Rmgyantra.CurdOpertionWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutTheResourceTest {
	@Test
	public void putResource() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "puni12");
		obj.put("projectName", "TySS---06");
		obj.put("status", "OnGoing");
		obj.put("teamSize", 20);
		
		RequestSpecification res = RestAssured.given();
		res.body(obj);
		res.contentType(ContentType.JSON);
		Response re = res.put("http://localhost:8084/projects/TY_PROJ_003");

		re.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();		
		
	}

}
