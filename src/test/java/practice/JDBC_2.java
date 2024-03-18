package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBC_2 {
	public static void main(String[]args) throws SQLException
	{
		Driver driver = new Driver();
		
		//Register driver
		DriverManager.deregisterDriver(driver);
		
		//Get Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
		
		//Create statement
		Statement st = con.createStatement();
		
		//Execute query 
		String query = "create table dept8(dname varchar(5),dloc varchar(5),dnum int(2));";
		try
		{
			int res = st.executeUpdate(query);
			System.out.println("Table created succesfully");
		}
		catch(Exception e)
		{
			System.out.println("Table not created");
		}
		
		st.close();
		
	}

}
