package projectday;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bing.com");
		driver.manage().window().maximize();

		driver.findElement(By.id("sb_form_q")).sendKeys("Apple");
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='sa_tm']//strong"));
		
		for (WebElement elem : links) {
			System.out.println(elem.getText());
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
	}

}
