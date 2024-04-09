package intPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC2 {

	public static void main(String[] args) throws SQLException {
		//register driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		//Get Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		//Issue create statement
		Statement statement = con.createStatement();
		//Execute update
		String query = "insert into customerinfo values('Johny',9,'London')";
		int result = statement.executeUpdate(query);
		if(result==1)
		{
			System.out.println("Data added successfully");
		}
		con.close();
	}

}
