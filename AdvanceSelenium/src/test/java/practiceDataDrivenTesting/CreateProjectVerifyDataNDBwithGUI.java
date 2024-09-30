package practiceDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class CreateProjectVerifyDataNDBwithGUI {
	@Test
	public void createProject() throws SQLException, InterruptedException {
		String Project_Name = "Instagram_03";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://106.51.90.215:8084");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();

		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();

		driver.findElement(By.name("projectName")).sendKeys(Project_Name);
		driver.findElement(By.name("createdBy")).sendKeys("Raju");
		Select sel = new Select(driver.findElement(By.name("status")));
		sel.selectByIndex(0);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Thread.sleep(5000);
		// verify the Project in  BackEnd[DB] using JDBC
		Connection con = null;
		boolean flag = false;
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
			Statement stat = con.createStatement();
			System.out.println("connection Established");
			ResultSet resultSet = stat.executeQuery("select * from project");
			while (resultSet.next()) {
				String actProjectName = resultSet.getString(4);
				if (Project_Name.equals(actProjectName)) {
					flag = true;
					System.out.println("project is available==Pass " + Project_Name);

				}
			}
		} catch (SQLException e) {
		} finally {
			con.close();
		}
		if (flag == false) {
			System.out.println("project is not available==Fail"+"\t"+  Project_Name);

		}
		driver.quit();
	}
	

}
