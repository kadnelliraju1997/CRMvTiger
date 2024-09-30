package practiceDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCbasics {
	public static void main(String[] args) throws SQLException {
		Connection connection =null;
		
		try {// step1: load or register the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		// step2: connect to Data base
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tekp","root","root");
		System.out.println("done");
		// step3: create "Sql" statement
		Statement statement = connection.createStatement();
		// step4: execute select query & get result
		ResultSet set = statement.executeQuery("select * from  tp07");
		
		}
		catch(Exception e) {
			System.out.println("handle exception");
		}
		finally {
		// step5: close the connection
		connection.close();
		}

	}

}
