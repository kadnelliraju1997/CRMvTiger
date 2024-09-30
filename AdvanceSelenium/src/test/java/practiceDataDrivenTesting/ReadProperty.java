package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadProperty {
	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("un");
		String psw = p.getProperty("psw");
		System.out.println(url);
		System.out.println(un);
		System.out.println(psw);
		System.out.println(browser);
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
		driver.quit();

	}

}
