package com.Rmggyantra.EndToEnd;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.Rmgyantra.Pojo.PojoEmplyoee;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateEmpAndGetEmp {
	@Test
	public void createEmpAndEmp() {
		
		Random ran = new Random();
		int rand = ran.nextInt(1000);
		PojoEmplyoee pojo = new PojoEmplyoee("engineer", "18/1/1995", "pradee@gmail.com", "ajhfdi", 5, "9586421381", "vadafone", "tester", "pradeep"+rand);
		Response res = given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.post("http://localhost:8084/employees");
		res.then().log().all();
		String user = res.jsonPath().get("username");
		given().pathParam("userName",user)
		.when()
		.get("http://localhost:8084/employee/{userName}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
		
		
		
	}

}
