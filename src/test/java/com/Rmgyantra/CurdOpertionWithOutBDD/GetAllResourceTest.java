package com.Rmgyantra.CurdOpertionWithOutBDD;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllResourceTest {
	@Test
	public void getResource() {
		
		Response res = RestAssured.get("http://localhost:8084/projects");
		//System.out.println(res.getContentType());
		System.out.println(res.getBody());
		System.out.println(res.asString());
		//System.out.println(res.getTime());
		//System.out.println(res.getHeaders());
		
		//System.out.println(res.prettyPeek());
		System.out.println(res.prettyPrint());
		
		System.out.println(res.getHeader("Vary"));
	
		ValidatableResponse val = res.then().statusCode(200);
		
		
	}

}
