package practiceDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JdbcUnitTestingWithbackEndvalidation {
	@Test
	public void unitTesting() throws SQLException {
		Connection con = null;
		String expected_Name = "Deepak sir";
		boolean flag = false;
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tekp", "root", "root");
			Statement stat = con.createStatement();
			ResultSet resultSet = stat.executeQuery("select * from tp07");
			while (resultSet.next()) {
				String actName = resultSet.getString(2);
				if (expected_Name.equals(actName)) {
					flag = true;
					System.out.println("actName is Availble"+"\t"+actName);
				}
			}

		} catch (Exception e) {
		} finally {
			con.close();
		}
		if(flag==false)
		{
			System.out.println("actName is Not Availble");
		}

	}

}
