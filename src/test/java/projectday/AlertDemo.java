package projectday;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		String msg = driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]")).getText();

		if (msg.equals("Congratulations! You must have the proper credentials."))
			System.out.println("true");
		else
			System.out.println("False");

		/*
		 * driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		 * 
		 * //Alert alrt = wait.until(ExpectedConditions.alertIsPresent()); Alert alrt =
		 * driver.switchTo().alert(); System.out.println(alrt.getText());
		 * alrt.sendKeys("welcome");
		 * 
		 * alrt.accept();
		 * 
		 * String res = driver.findElement(By.id("result")).getText();
		 * if(res.equals("You entered: welcome")) System.out.println("True"); else
		 * System.out.println("False");
		 */

		driver.quit();

	}

}
