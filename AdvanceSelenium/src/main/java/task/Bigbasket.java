package task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Bigbasket {
	
	@Test
	public void bigBasket()
	{
		WebDriver driver =new ChromeDriver();//a[@role='none']
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.bigbasket.com/?utm_source=google&utm_medium=cpc&utm_campaign=Brand-T1&gad_source=1&gclid=CjwKCAjw6c63BhAiEiwAF0EH1M72zwO2mJLJTGCaEzNj0KEHYKlBc27AHa-HqPY3AK9QzF0-5Zu1QRoC8FwQAvD_BwE");
	
	 driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:R5bab6:']//span[@class='Label-sc-15v1nk5-0 CategoryMenu___StyledLabel2-sc-d3svbp-2 gJxZPQ mbYld'][normalize-space()='Category']")).click();
 
	List<WebElement> elements = driver.findElements(By.xpath("//a[@role='none']"));
	
	List<WebElement> elements1 = driver.findElements(By.xpath("//ul[@class='jsx-1259984711 w-56 px-2.5 bg-silverSurfer-200 text-darkOnyx-800']/li"));
	List<WebElement> elements2 = driver.findElements(By.xpath("//ul[@class='jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs']/li"));
	
	Actions act=new Actions(driver);
	for(WebElement ele:elements) {
		act.moveToElement(ele).perform();
		for(WebElement ele1:elements1) {
			act.moveToElement(ele1).perform();
		for(WebElement ele2:elements2) {
			System.out.println(ele2.getText());
		}
			
		}
		
		
	}
	
	}

}
