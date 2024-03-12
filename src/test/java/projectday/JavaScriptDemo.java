package projectday;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement inputBox = driver.findElement(By.id("name"));
		
		js.executeScript("arguments[0].setAttribute('value','john');", inputBox);
		
		WebElement maleradio =  driver.findElement(By.id("male"));
		//maleradio.click();
		js.executeScript("arguments[0].click();", maleradio);
		
		WebElement sunrad = driver.findElement(By.id("sunday"));
		
		js.executeScript("arguments[0].click();", sunrad);
		
		
		//WebElement button = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
		
		//js.executeScript("arguments[0].click();", button);
	
		
		
	}

}
