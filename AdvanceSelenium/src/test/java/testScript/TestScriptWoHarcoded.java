package testScript;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestScriptWoHarcoded {
	public static void main(String[] args) throws Exception {
		FileInputStream fis1 = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fis1);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("un");
		String psw = p.getProperty("psw");

		// Step1: get excel path location & java object of physical excellFile
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Downloads\\TestScriptData1.xlsx");
		// Step2: open the WorkBook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		// Step3: get the control of the "org" sheet
		Sheet sh = wb.getSheet("org");
		// Step4: get the control of the "1st" row
		Row row = sh.getRow(1);
		// Step5: get the control of the "1st" cell & read the String data
		String cell = row.getCell(2).toString();
		// Step6: close the WorkBook
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
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(psw);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//	    driver.findElement(By.xpath("//a[contains(text(),'Create an')]")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(cell);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
