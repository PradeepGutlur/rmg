package com.Rmgyantra.validate;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HeaderValidateTest {
	@Test
	public void header() {
		String expetedhader = "Access-Control-Request-Headers";
		 Response res = when().get("http://localhost:8084/projects");
		  String actual = res.getHeader("vary");
			res.then().statusCode(200);
		Assert.assertEquals(expetedhader,actual );
			
	
	
	}

}
