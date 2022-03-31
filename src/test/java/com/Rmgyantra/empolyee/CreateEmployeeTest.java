package com.Rmgyantra.empolyee;

import org.testng.annotations.Test;

import com.Rmgyantra.Pojo.PojoEmplyoee;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateEmployeeTest {
@Test
public void createEmployee() {
     	PojoEmplyoee pojo = new PojoEmplyoee("software", "17/05/1995", "pradepphsj@Gmail.com", "pradeep", 2, "9888777657111", "tyess", "team leader", "pradeep123");
	given()
			.body(pojo)
			.contentType(ContentType.JSON)
	.when()
			.post("http://localhost:8084/employees")
	.then()
			.assertThat().statusCode(422)
			.contentType(ContentType.JSON)
			.log().all();



}
}
