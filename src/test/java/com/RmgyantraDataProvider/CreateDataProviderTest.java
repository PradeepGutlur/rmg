package com.RmgyantraDataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Rmgyantra.Pojo.PojoJson;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateDataProviderTest {
	@Test(dataProvider = "getData")
	public void createdata(String createdBy,String projectName,String status, int teamSize ) {
		Random ran = new Random();
		int rand = ran.nextInt();
		PojoJson pojo = new PojoJson(createdBy, projectName, status, teamSize);
	      given()
	      	.body(pojo)
	      	.contentType(ContentType.JSON)
	      .when()
	      	.post("http://localhost:8084/addProject")
	      .then().statusCode(201).contentType(ContentType.JSON)
	      .log().all();
	}
	@DataProvider
	public Object[][] getData() throws Throwable  {
	  
		Object[][] objA = new Object[3][4];
		objA[0][0] = "pradeep";
		objA[0][1] = "pradeep562";
		objA[0][2]= "On Going";
		objA[0][3] = 17;
		
		objA[1][0] = "pradeep";
		objA[1][1] = "pradeep56sjb2";
		objA[1][2]= "On Going";
		objA[1][3] = 17;
		
		objA[2][0] = "pradeep";
		objA[2][1] = "pradeep5jfyy";
		objA[2][2]= "On Going";
		objA[2][3] = 17;
		
		return objA;
	}

}
