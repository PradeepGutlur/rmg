package com.Rmgyantra.CurdOpertionWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostTheResourceTest {
	@Test
	public void postTheResource() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "puni");
		obj.put("projectName", "TySS---031");
		obj.put("status", "OnGoing");
		obj.put("teamSize", 20);
		
		 RequestSpecification respec = RestAssured.given();
		 respec.contentType(ContentType.JSON);
		 respec.body(obj);
		 
		Response re = respec.post("http://localhost:8084/addProject");
		int status = re.getStatusCode();
		Assert.assertEquals(status, 201);
		System.out.println(status);
		String con = re.getContentType();
		System.out.println(con);
	//re.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}
	

}
