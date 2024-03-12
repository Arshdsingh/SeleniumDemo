package projectday;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionsDemo {

	public static void main(String[] args) throws AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://text-compare.com/");

		driver.findElement(By.id("inputText1")).sendKeys("Selenium");
		driver.findElement(By.id("inputText2"));
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
		
		
		act.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
		
		//act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		act.sendKeys(Keys.TAB); //only if we have single key
		
		act.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
	
		
	}

}
