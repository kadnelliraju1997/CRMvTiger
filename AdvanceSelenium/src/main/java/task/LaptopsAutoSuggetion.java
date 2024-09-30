package task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LaptopsAutoSuggetion {

	@Test
	public void laptops() {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in");
	driver.manage().window().maximize();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("laptops");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	driver.findElement(
			By.xpath("//div[@id='nav-flyout-searchAjax']/descendant::div[ text()='laptops']"))
			.click();
	driver.quit();
	}
}
