package proctice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateOrganizationVerifyPhoneNo {
	@Test
	public void createOrganizationVerifyPhoneNo() throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Admin\\eclips\\AdvanceSelenium\\src\\test\\resources\\CommonData.properties");
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
		FileInputStream fi = new FileInputStream(
				"C:\\Users\\Admin\\OneDrive\\Desktop\\TEK PYRAMID\\Data\\TestScriptData1.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString() + random;
		String phoneNumber = row.getCell(5).toString();
		

		wb.close();

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(imp_time));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		// create an Organization

		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneNumber);
		
	

		Select sel = new Select(driver.findElement(By.xpath("//select[@name='industry']")));
		WebDriverWait ew=new WebDriverWait(driver,Duration.ofSeconds(imp_time));
		ew.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@name='industry']"))));
		sel.selectByIndex(2);
		String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		
		//verifying Phone Number
		
		if(phoneNumber.equals(actPhoneNumber))
		{
			System.out.println("This is actual PhoneNo "+phoneNumber);
		}
		else {
			System.out.println("This is not actual PhoneNo "+phoneNumber);
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
