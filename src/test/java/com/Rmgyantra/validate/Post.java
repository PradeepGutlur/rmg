package com.Rmgyantra.validate;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Rmgyantra.Pojo.PojoJson;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post {
	@Test
	public void validate() {
		
		String expectedproId = "pradeep113";
	 PojoJson pojo = new PojoJson("pradep", "pradeep113", "On Going", 10);
		given()
		.body(pojo)
		.contentType(ContentType.JSON);
	Response res = when()
			.post("http://localhost:8084/addProject");
	res.then()
	.log().all();
	String actualProID = res.jsonPath().get("[0].projectName");
/*	boolean flag = false;
		for (String Proid : actualProID) {
			if (Proid.equals(expectedproId)) {
				flag = true;
				
			}			
		}	*/
		Assert.assertEquals(actualProID, expectedproId);
	}
	}


