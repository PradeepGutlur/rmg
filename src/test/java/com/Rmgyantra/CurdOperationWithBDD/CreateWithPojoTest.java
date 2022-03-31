package com.Rmgyantra.CurdOperationWithBDD;

import org.testng.annotations.Test;

import com.Rmgyantra.Pojo.PojoJson;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateWithPojoTest {
	@Test
	public void Create() {
		PojoJson obj = new PojoJson("pnu12233", "radha 66shyama", "completed", 10);
		
		given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
		
	}

}
