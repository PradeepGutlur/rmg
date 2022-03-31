package genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.Query;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DataBaseUtility {
	Connection conn= null;	
	public void connetToDatabase() {
		/*
		 * this method is used to get connection to database
		 */
		try {
			Driver dri = new Driver();
			DriverManager.registerDriver(dri);
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*
	 * this method used to close the Database
	 * 
	 * */
	public void getclose() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getDataAndVerify(String Query, String actualdata, int columnNumber, String execpted) throws Throwable{
		
			ResultSet result = conn.createStatement().executeQuery(Query);
			 boolean flag = false;
			 actualdata = null;
			while (result.next()) {
				try {
				 String data = result.getString(columnNumber);	 
				if (data.equals(execpted)) {
					flag = true;
				actualdata = data;
					break;
				}
			}		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
			if (flag) {
				return actualdata;
			}else {
				return actualdata;
			}
		
	}
	
}
