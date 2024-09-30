package task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class ProKabaddi {
	@Test
	public void rankingOfOdi() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		JSONParser parse = new JSONParser();
		Object obj = parse.parse(new FileReader("C:\\Users\\Admin\\OneDrive\\Desktop\\TEK PYRAMID\\CommonData.json"));
		JSONObject map = (JSONObject) obj;
		String browser = map.get("browser").toString();
		String url = map.get("url").toString();
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
		driver.get("https://www.prokabaddi.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//div[@class='table-body']/div")));
		List<WebElement> teams = driver.findElements(
				By.xpath("(//div[@class='table-body']/descendant::div[@class='team-name'])[position()<6]"));
		List<WebElement> win_loss = driver
				.findElements(By.xpath("(//div[@class='table-body']/div/descendant::ul)[position()<6]"));

		ArrayList<String> l = new ArrayList<String>();

		for (int i = 0; i < teams.size(); i++) {
			String team = teams.get(i).getText();
			String Win_Loss = win_loss.get(i).getText();
			System.out.println(team +" / "+Win_Loss);
		}
		System.out.println();
//		for(Entry<String, String> o:l.entrySet())
//		{
//			{
//			System.out.println(o.getKey());
//
//			System.out.print(o.getValue());
//			}
//			System.out.print(" ");
//		}
		driver.quit();
	}

}
