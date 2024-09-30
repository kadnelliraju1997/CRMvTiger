package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadTheDataFromJsonWithIntegrateTestScript {
public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, InterruptedException {
	JSONParser parser =new JSONParser();
	Object obj = parser.parse(new FileReader("C:\\Users\\Admin\\OneDrive\\Desktop\\TEK PYRAMID\\CommonData.json"));
	JSONObject map=(JSONObject)obj;
	String browser = map.get("browser").toString();
	String url = map.get("url").toString();
	String username = map.get("username").toString();
	String password = map.get("password").toString();
	  
	
	Random random=new Random();
	int randomNumber = random.nextInt(1000);
	
	
	FileInputStream fis =new FileInputStream("C:\\Users\\Admin\\Downloads\\TestScriptData1.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("org");
	Row row = sh.getRow(1);
	String data = row.getCell(2).toString()+ randomNumber;
	
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
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[contains(@href,'index.php?module=Accounts&action=index')]")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.xpath("//tbody/tr[3]/td[2]")).sendKeys(data);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @value='  Save  ']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	Thread.sleep(2000);
	driver.close();
}
}
