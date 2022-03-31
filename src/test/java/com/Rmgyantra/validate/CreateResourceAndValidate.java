package com.Rmgyantra.validate;

import static org.testng.Assert.assertEquals;

import org.junit.internal.runners.model.EachTestNotifier;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Rmgyantra.Pojo.PojoJson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateResourceAndValidate {
	@Test
	public void create() {
		String exectatproId ="test11362";
		PojoJson pojo = new PojoJson("pradeep", "test11362", "on going", 5);
		Response res =given()
		.body(pojo)
		.contentType(ContentType.JSON)
		
		 .when().post("http://localhost:8084/addProject");
		res.getBody();
		res.then().log().all();
	 String actual = res.jsonPath().get("projectName");
	 Object flag = false;
	 if (exectatproId.equals(actual)) {
		flag = true;
	}
	
		
		Assert.assertEquals(flag, true);
		
	}

}
