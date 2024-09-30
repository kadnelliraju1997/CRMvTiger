package proctice.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateContactWithSupportDate {
	@Test
	public void createOrganization() throws FileNotFoundException, IOException, ParseException, InterruptedException {
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
		Row row = sh.getRow(4);
		String LastName = row.getCell(2).toString();
		wb.close();
		System.out.println(LastName);

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(imp_time));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		// create an Organization

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actLastName = driver.findElement(By.id("mouseArea_Last Name")).getText();

		if (actLastName.equals(LastName)) {
			System.out.println("This information is correct " + actLastName);
		} else {
			System.out.println("This information is not correct " + actLastName);
		}
		// capturing date
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String startDate = sdf.format(date);

		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String endDate = sdf.format(cal.getTime());

		// enter the support Date for 30days
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + startDate + "')",
				driver.findElement(By.xpath("//input[@name='support_start_date']")));
		js.executeScript("arguments[0].setAttribute('value', '" + endDate + "')",
				driver.findElement(By.xpath("//input[@name='support_end_date']")));
//		driver.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(startDate);
//		driver.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys(endDate);

		act.scrollToElement(driver.findElement(By.xpath("//td[@id='mouseArea_Support Start Date']")));
		String actDate1 = driver.findElement(By.xpath("//td[@id='mouseArea_Support Start Date']")).getText();
		act.scrollToElement(driver.findElement(By.xpath("//td[@id='mouseArea_Support End Date']")));
		String endDate1 = driver.findElement(By.xpath("//td[@id='mouseArea_Support End Date']")).getText();
		if (actDate1.equals(startDate)) {
			System.out.println("This information is correct " + actDate1);
		} else {
			System.out.println("This information is not correct " + actDate1);
		}
		if (endDate1.equals(endDate)) {
			System.out.println("This information is correct " + endDate1);
		} else {
			System.out.println("This information is not correct " + endDate1);
		}

		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();//
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		driver.quit();
	}

}
