package genericUtils;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseApiClass  {
	public DataBaseUtility Datau = new DataBaseUtility();
  public JavaUtility jlib = new JavaUtility();
	@BeforeSuite
	public void bsconfige() {
		
		Datau.connetToDatabase();
		baseURI="http://localhost";
		port=8084;	
	}
	@AfterSuite
	public void afConfige() {
		Datau.getclose();
	}

}
