package projectday;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotCapture {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		//File src = ts.getScreenshotAs(OutputType.FILE);
		
		//File target = new File("/Users/arshdeepsingh/eclipse-workspace/SeleniumProject/ScreenShots/fullpage.png");
		
		//FileUtils.copyFile(src,target);
		
		
		WebElement srcscreen = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src =  srcscreen.getScreenshotAs(OutputType.FILE);
		
		File target = new File("/Users/arshdeepsingh/eclipse-workspace/SeleniumProject/ScreenShots/fullpage.png");
		
		FileUtils.copyFile(src, target);
		
	}

}
