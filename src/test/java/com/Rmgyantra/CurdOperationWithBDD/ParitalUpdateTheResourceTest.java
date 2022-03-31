package com.Rmgyantra.CurdOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParitalUpdateTheResourceTest {
	@Test
	public void patch() {
		 JSONObject obj = new JSONObject();
		 obj.put("name", "raji");
		 obj.put("job","software");
		 given()
		 .patch("https://reqres.in/api/users/2")
		 .then()
		 .assertThat()
		 .statusCode(200)
		 .log().all();
		
	}

}
