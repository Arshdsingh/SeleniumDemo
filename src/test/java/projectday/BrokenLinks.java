package projectday;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());
		
		int brokenLinks = 0;
		
		for (WebElement elem : links) {
			String targetLink = elem.getAttribute("href");
			//System.out.println(targetLink);
			
			if(targetLink==null || targetLink.isEmpty()) {
				System.out.println("href Value is Empty");
				continue;
			}
			
			
			URL linkUrl = new URL(targetLink); //convert String to Url because we cannot open connection without converting this into url.
			
			
			//send request to sercver 
			//1. open connection
			//2. connect to server
			HttpURLConnection con = (HttpURLConnection) linkUrl.openConnection();
			con.connect();
			
			if(con.getResponseCode()>=400) {
				System.out.println(targetLink+"======> Broken Links");
				brokenLinks++;
			} else {
				System.out.println(targetLink+"======> Not Broken Links");
			}
			con.disconnect();
			
		}
		System.out.println("Total Broken links : "+brokenLinks);
	}

}
