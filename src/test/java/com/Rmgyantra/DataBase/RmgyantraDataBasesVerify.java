package com.Rmgyantra.DataBase;

import org.apache.http.conn.params.ConnConnectionParamBean;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Rmgyantra.Pojo.PojoJson;
import com.mysql.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Random;

public class RmgyantraDataBasesVerify {
	@Test
	public void creat() throws Throwable {
		Random ran = new Random();
	int random = ran.nextInt(5000);
		 PojoJson pojo = new PojoJson("pradeep", "pradeep 123"+random, "On Going", 5);
	Response res = given()
		.body(pojo)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject");
	String Expected = res.jsonPath().get("projectName");
	System.out.println(Expected);
	Driver Driverref = new Driver();
	DriverManager.registerDriver( Driverref);
	Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root","root");
	Statement stat = Conn.createStatement();
	String qurey = "select project_name from project";
	ResultSet rest = stat.executeQuery(qurey);
	while(rest.next())
	{
			//System.out.println("\n"+rest.getString(1)+"./"+rest.getString(2)+"\n");
		String actual = rest.getString(1);	
			if (actual.equals(Expected)) {
				Assert.assertEquals(Expected,actual);
				System.out.println(actual);
			}		
	}
	//step 5 : colse the sql
		Conn.close();
		System.out.println("=======colse db connect  ====");
	}
}
