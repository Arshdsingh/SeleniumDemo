package projectday;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZoomDemo {
	
	@Test
	void zoom() {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	//Dimension dm = new Dimension(200,200);
	//driver.manage().window().setSize(dm);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.body.style.zoom='50%'");
	}
	
}
