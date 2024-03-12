package projectday;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollindDemo {

	public static void main(String[] args) throws Exception {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = driver;
		
		//js.executeScript("window.scrollBy(0,3000);", "");
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
		
		//WebElement indiaFlag = driver.findElement(By.xpath("//img[@alt='Flag of India']"));
		//js.executeScript("arguments[0].scrollIntoView();", indiaFlag);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
		
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight);");
	}

}
