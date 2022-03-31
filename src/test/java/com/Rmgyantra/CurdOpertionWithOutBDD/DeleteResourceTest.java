package com.Rmgyantra.CurdOpertionWithOutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteResourceTest {
	@Test
	public void deleteResource() {
	Response res = RestAssured.delete("http://localhost:8084/projects/TY_Proj_006");
	System.out.println(res.getContentType());
	System.out.println(res.getStatusCode());
	System.out.println(res.getHeaders());
	
	res.then().assertThat().statusCode(204).log().all();
	}
	

}
