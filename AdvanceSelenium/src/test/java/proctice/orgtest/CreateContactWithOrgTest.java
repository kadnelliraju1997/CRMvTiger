package proctice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrgTest {
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
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(8);
		String orgName = row.getCell(2).toString() + random;
		String LastName = row.getCell(3).toString() + random;
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
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		// switch to child window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains("Accounts&action")) {
				
			}
		}

		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		while (it1.hasNext()) {
			String windowID = it1.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains("Contacts&action")) {
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actLastName = driver.findElement(By.xpath("//td[@class='dvtCellInfo' and @id='mouseArea_Last Name']")).getText().trim();
		System.out.println(actLastName);
		if (actLastName.equals(LastName)) {
			System.out.println("This information is correct " + actLastName);
		} else {
			System.out.println("This information is not correct " + actLastName);
		}
		String actOrgName = driver.findElement(By.xpath("//td[@class='dvtCellInfo' and @id='mouseArea_Organization Name']")).getText().trim();
		System.out.println(actOrgName);
		if (actOrgName.equals(orgName)) {
			System.out.println("This information is correct " + actOrgName);
		} else {
			System.out.println("This information is not correct " + actOrgName);
		}
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
