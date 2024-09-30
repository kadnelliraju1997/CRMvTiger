package task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Samsung {
	@Test
	public void test() throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("mobiles",
				Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement checkBox = driver.findElement(By.xpath("//div[.='SAMSUNG']//div[@class='XqNaEv']"));
		wait.until(ExpectedConditions.visibilityOf(checkBox));
		checkBox.click();
		try {
			List<WebElement> productsName = driver.findElements(By.xpath("//div[contains(text(),'SAMSUNG Galaxy')]"));
			List<WebElement> productsPrice = driver.findElements(By.xpath(
					"//div[contains(text(),'SAMSUNG Galaxy')]/ancestor::div[@class='yKfJKb row']/descendant::div[contains(text(),'99')]"));
			for (WebElement productName : productsName) {
				String samName = productName.getText();
				for (WebElement productPrice : productsPrice) {
					String samPrice = productPrice.getText();
					System.out.println(samName + "\t" + samPrice);
				}

			}
		} catch (Exception e) {
		}

		driver.quit();
	}

}
