package task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task {

	@Test
	public void testBigBasket() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get(
				"https://www.bigbasket.com/?utm_source=google&utm_medium=cpc&utm_campaign=Brand-T1&gad_source=1&gclid=CjwKCAjw6c63BhAiEiwAF0EH1M72zwO2mJLJTGCaEzNj0KEHYKlBc27AHa-HqPY3AK9QzF0-5Zu1QRoC8FwQAvD_BwE");

		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		js.executeScript("document.body.style.zoom='65%'");

		Actions act = new Actions(driver);
		WebElement shopByCategory = driver.findElement(By.xpath(
				"//button[@id='headlessui-menu-button-:R5bab6:']//span[@class='Label-sc-15v1nk5-0 CategoryMenu___StyledLabel2-sc-d3svbp-2 gJxZPQ mbYld'][normalize-space()='Category']"));
		shopByCategory.click();

		List<WebElement> categories = driver.findElements(By.xpath("//a[@role='none']"));
		try {
		for (WebElement category : categories) {
			act.scrollToElement(category).perform();
			act.moveToElement(category).perform();

			List<WebElement> productsCategory = driver
					.findElements(By.xpath("//header[@class='sm:hidden z-30 flex flex-col col-span-12']//ul[2]//li"));

			for (WebElement productCategory : productsCategory) {
				act.moveToElement(productCategory).perform();
				List<WebElement> products = driver
						.findElements(By.xpath("//ul[@class='jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs']/li"));
				for (WebElement product : products) {
					String productName = product.getText();
					System.out.println("Product: " + productName);
				}
			}
		}
		}catch(Exception e) {}

		driver.quit();
	}
}
