package com.Rmgyantra.CurdOperationWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;


public class GetAllResourceTest {
@Test
public void getresource() {
	when()
	 	.get("http://localhost:8084/projects")
	.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS)
			.log().all();
	
}
}
