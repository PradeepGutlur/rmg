package com.Rmgyantra.CurdOpertionWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchTheResourceTest {
	@Test
	public void patchTheRes() {
		JSONObject obj = new JSONObject();
		obj.put("name", "pnni");
		obj.put("job", "jobless");
		
		 RequestSpecification res = RestAssured.given();
		 res.body(obj);
		 res.contentType(ContentType.JSON);
		
		Response re = res.patch("https://reqres.in/api/users");
		re.then().assertThat().contentType(ContentType .JSON).log().all();
	}

}
