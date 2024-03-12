package projectday;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Assin2 {
	
	public static void main(String[] args) throws Exception {
		
		Logger logger =LogManager.getLogger();
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://demo.opencart.com/");
		
		
//		WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
//		WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
//		
		Actions actions = new Actions(driver);
//		
//		actions.moveToElement(desktop).click().build().perform();
//		actions.moveToElement(mac).click().build().perform();
//		
//		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
//		
//		WebElement right = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
//		
//		//right click
//		actions.contextClick(right).build().perform();
//		
//		driver.findElement(By.xpath("//li[normalize-space() = 'Cut']")).click();
//		
//		driver.switchTo().alert().accept();
		
		//double click
		
//		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");
//		
//		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
//		System.out.println("here");
//		WebElement doublebtn = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
//		Thread.sleep(3000);
//		actions.doubleClick(doublebtn).build().perform();
		String random = RandomStringUtils.randomAlphabetic(5);
		System.out.println(random);
		
		logger.info("Test Passed");
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		WebElement leftSlider = driver.findElement(By.xpath("//span[1]"));
		WebElement rightSlider = driver.findElement(By.xpath("//span[2]"));
		System.out.println(leftSlider.getLocation());
		System.out.println(rightSlider.getLocation());
		actions.dragAndDropBy(leftSlider,150,250).build().perform();
		actions.dragAndDropBy(rightSlider, -50, 250).build().perform();
		
		
		
		
		
		
	}

}
