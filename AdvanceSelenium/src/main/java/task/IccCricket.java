package task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class IccCricket {
	@Test
	public void rankingOfOdi() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		JSONParser parse=new JSONParser();
		Object obj = parse.parse(new FileReader("C:\\Users\\Admin\\OneDrive\\Desktop\\TEK PYRAMID\\CommonData.json"));
		JSONObject map=(JSONObject)obj;
		String browser= map.get("browser").toString();
		String url = map.get("url").toString();
		WebDriver driver=null;
		if(browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("Fire"))
		{
			driver=new FirefoxDriver();
		}
		else if (browser.equals("Edge"))
		{
			driver=new InternetExplorerDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
		driver.get("https://www.icc-cricket.com");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.findElement(By.xpath("//div[@class='menu-list-wrapper']//a[@aria-label='Rankings']")).click();
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[@data-tag='mens-team-rankings']")));
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@data-tag='mens-team-rankings']")));
//		driver.findElement(By.xpath("//a[@data-tag='mens-team-rankings']")).click();
//		driver.findElement(By.xpath("//a[@href='/rankings/team-rankings/mens/odi']/descendant::span[.='Full Rankings']")).click();
//		List<WebElement> teams = driver.findElements(By.xpath("//div[@class='si-table-body']/descendant::div[@class='si-table-row']//div[@class='si-table-data si-team']"));
//		List<WebElement> points = driver.findElements(By.xpath("//div[@class='si-table-body']/descendant::div[@class='si-table-row']//div[@class='si-table-data si-pts']"));
		
//		WebElement[] rows = driver.findElements(By.xpath("//div[@class='si-table-body']/div")).toArray(new WebElement[0]);
		LinkedHashMap<String, Integer> l=new LinkedHashMap<String, Integer>();
//		ArrayList<String> l1=new  ArrayList<String>();
//		ArrayList<Integer> l2=new  ArrayList<Integer>();
		
		
//		for (int i =0;i<=teams.size()-1;i++) {
//			String team=teams.get(i).getText();
//			String point = points.get(i).getText();
//			int poin = Integer.parseInt(point);
//			l.put(team, poin);
//			
//			
//		}
//		for (Entry<String, Integer> entry : l.entrySet()) {
//			
//			if(!l.equals("Pakistan"))
//			{
//				String key = entry.getKey();
//				int val = entry.getValue();
//				System.out.print(key+"\t "+val);
//			}
//			
//		}
		driver.quit();
	}

}
