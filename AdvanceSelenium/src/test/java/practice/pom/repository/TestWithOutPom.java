package practice.pom.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
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

public class TestWithOutPom {
	public static void main(String[] args) throws IOException, InterruptedException  {
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclips\\AdvanceSelenium\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		int imp_time = Integer.parseInt(p.getProperty("imp_time"));
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

		Random ranInt = new Random();
		int random = ranInt.nextInt(1000);
		FileInputStream fi = new FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\TEK PYRAMID\\Data\\TestScriptData1.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString() + random;
		wb.close();

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(imp_time));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username); 
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

	}

}
