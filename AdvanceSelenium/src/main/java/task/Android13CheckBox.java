package task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Android13CheckBox {

	@Test
	public void android13() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobiles", Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
				By.xpath("//span[@data-csa-c-slot-id='nav-pkr']/descendant::span[text()='Android 13.0']/..//i")));
		driver.findElement(
				By.xpath("//span[@data-csa-c-slot-id='nav-pkr']/descendant::span[text()='Android 13.0']/..//i"))
				.click();

		driver.quit();
	}

}
