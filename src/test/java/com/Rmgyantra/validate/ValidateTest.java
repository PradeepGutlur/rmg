package com.Rmgyantra.validate;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

public class ValidateTest {
	@Test
	public void validate() {
		String expectedproId = "TY_PROJ_1003";
	Response res = when()
			.get("http://localhost:8084/projects");
	List<String> actualProID = res.jsonPath().get("projectId");
	boolean flag = false;
		for (String Proid : actualProID) {
			if (Proid.equals(expectedproId)) {
				flag = true;
				
			}			
		}	
		Assert.assertEquals(flag, true);
	}
	}


