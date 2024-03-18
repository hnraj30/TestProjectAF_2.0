package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC {
	public static void main(String[]args) throws SQLException
	{
		Driver driver = new Driver();
		
		//Register driver
		DriverManager.registerDriver(driver);
		
		//Get connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
		
		//Create statement
		Statement Statement = con.createStatement();
		
		//Execute query
		ResultSet result = Statement.executeQuery("select * from empinfo;");
		while(result.next())
		{
			String value = result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4);
			System.out.println(value);
		}
		
		
		
		//Close the database
		con.close();
		
		
		
	}

}
