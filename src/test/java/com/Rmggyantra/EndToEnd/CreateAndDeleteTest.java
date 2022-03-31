package com.Rmggyantra.EndToEnd;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.Rmgyantra.Pojo.PojoJson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateAndDeleteTest {
	@Test
	public void createAndDelete() {
		Random ran = new Random();
		 int randomint = ran.nextInt(5000);
		PojoJson pojo = new PojoJson("pradeep", "puni"+randomint, "On Going", 5);
		Response res = given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.post("http://localhost:8084/addProject");
		res.then().assertThat().log().all();
		
		
		
		String ress = res.jsonPath().get("projectId");
		given().pathParam("projectId", ress)
		
		.when().delete("http://localhost:8084/projects/{projectId}")
		.then().assertThat().statusCode(204).log().all();
				
		
		
	
	}

}
