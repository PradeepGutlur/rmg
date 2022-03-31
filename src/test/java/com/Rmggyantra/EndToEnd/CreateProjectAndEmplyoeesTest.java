package com.Rmggyantra.EndToEnd;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.Rmgyantra.Pojo.PojoEmplyoee;
import com.Rmgyantra.Pojo.PojoJson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectAndEmplyoeesTest {
	@Test
	public void createProject() {
		Random ran = new Random();
		 int randomint = ran.nextInt(5000);
		PojoJson pojo = new PojoJson("pradeep", "puni"+randomint, "On Going", 5);
		Response res = given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.post("http://localhost:8084/addProject");
		res.then().assertThat().log().all();
				
		String projectname = res.jsonPath().get("projectName");
		
		
		
		given().pathParam("projectName", projectname);
		PojoEmplyoee pojoemp = new PojoEmplyoee( "SDET","28-14-195","nithesh@gmail.com", "nithesh", 15, "9888777657","{projectName}", "ROLE_ADMIN", "nithesh"+randomint) ;
		given().body(pojoemp).contentType(ContentType.JSON)
		.when().post("http://localhost:8084/employees")
		.then().assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
		
	}

}
