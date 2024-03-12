package projectday;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Orange {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin12");
		driver.findElement(By.className("oxd-button")).click();
		Thread.sleep(2000);
		String actualTitle = "";
		try {
		actualTitle = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		} catch(Exception ex) {}
		String expectedTitle= "Dashboard";
		
		if(actualTitle.equals(expectedTitle))
			System.out.println("passed");
		else
			System.out.println("Failed");
			
		System.out.println(actualTitle);
		Thread.sleep(3000);
		driver.close();
	}

}
