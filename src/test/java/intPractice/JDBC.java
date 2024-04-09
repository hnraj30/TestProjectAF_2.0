package intPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC {
	public static void main(String[]args) throws SQLException
	{
		//Register driver
		Driver driver =new Driver();
		DriverManager.registerDriver(driver);
				
		//Get connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Issue create statement
		Statement statement = con.createStatement();
		
		//Execute query
		ResultSet result = statement.executeQuery("select * from customerinfo where address='London';");
		
		//utilise data
		while(result.next())
		{
			String value = result.getString(1)+"         "+result.getString(2)+"        "+result.getString(3);
			System.out.println(value);
		}
		
		//Close database	
		con.close();
		
		
		
	}

}
