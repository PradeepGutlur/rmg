package framework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Rmgyantra.Pojo.PojoJson;

import genericUtils.BaseApiClass;
import genericUtils.JavaUtility;
import genericUtils.api;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateResoureAndDataBase extends BaseApiClass {
	@Test
	public void create() throws Throwable {
		int rand = jlib.getrandom();
		String ExpectedData = "jio" + rand;
		System.out.println(ExpectedData);
		
		  PojoJson pojo = new PojoJson("puni111",ExpectedData,"completed", 200);
		 Response rers = given()
				 .body(pojo) 
				 .contentType(ContentType.JSON)
				 .when()
		  .post(api.POST); String actualData = rers.jsonPath().get("projectName");
		  System.out.println(actualData);
		  rers.then().assertThat().contentType(ContentType.JSON) .log().all();
		  
		 String projectData = Datau.getDataAndVerify("select * from project",actualData, 4, ExpectedData);
		  System.out.println(ExpectedData);
		  Assert.assertEquals(projectData, ExpectedData);
		 
	}

}



