package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class SeleniumTestReadFromCmdRuntime {
	@Test
	public void seleniumOrgTest() throws Exception {
		//read common data from command line
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		
		
		//read random number program
		Random random = new Random();
		int randomInt = random.nextInt(1000);

		// Step1: get excel path location & java object of physical excellFile
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Downloads\\TestScriptData1.xlsx");
 		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String cell = row.getCell(2).toString() + randomInt;
		
		wb.close();
		WebDriver driver = null;
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Fire")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("Edge")) {
			driver = new InternetExplorerDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
