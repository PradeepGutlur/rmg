package com.Rmgyantra.empolyee;



import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.Rmgyantra.Pojo.PojoEmplyoee;

import io.restassured.http.ContentType;

public class CreateEmployee {
	@Test
	public void createEmp() {
		
	PojoEmplyoee po = new PojoEmplyoee("software","05-8-1995", "jwfbkebf", "pradeep", 2, "9444848485", "tyss", "testenging","pradeep");
	given()
		.body(po)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/employess")
	.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	
		
	
	
	
	}
	
	

}
