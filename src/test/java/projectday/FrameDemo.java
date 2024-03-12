package projectday;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.math")).click();
		System.out.println("Clicked...");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");		
		driver.findElement(By.linkText("BigDecimal")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Overview']")).click();
		
		
		
		System.out.println("Clicked...");
		
		
		driver.quit();
		
		
	
		
		
	}

}
