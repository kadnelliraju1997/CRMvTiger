package task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Cricbuzz_com {

	@Test
	public void menRankings() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath(
				"//nav[@id='cb-main-menu']/descendant::a[@href='/cricket-stats/icc-rankings/men/batting' and text()='Rankings']"))
				.click();
//		driver.findElement(By.xpath(
//				"//nav[@id='cb-main-menu']/descendant::a[@href='/cricket-stats/icc-rankings/men/batting' and text()='ICC Rankings - Men']"))
//				.click();
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(
				"//nav[@id='cb-main-menu']/descendant::a[@href='/cricket-stats/icc-rankings/men/batting' and text()='ICC Rankings - Men']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@id='teams-tab']")));
		List<WebElement> teamRow = driver
				.findElements(By.xpath("//div[@class='cb-rank-tabs cb-rank-tbl']/following-sibling::div"));

		List<WebElement> teamName = driver.findElements(By.xpath(

				"//div[@class='cb-rank-tabs cb-rank-tbl']/following-sibling::div/div[@class='cb-col cb-col-50 cb-lst-itm-sm text-left']"));
		List<WebElement> teamRating = driver.findElements(By.xpath(
				"//div[@class='cb-rank-tabs cb-rank-tbl']/following-sibling::div/div[@class='cb-col cb-col-14 cb-lst-itm-sm']"));
		for (int i = 0; i < teamName.size(); i++) {

			System.out.println("Team/Rating :" + teamName.get(i).getText() + "/s" + teamRating.get(i).getText());

		}

		driver.quit();
	}
}
