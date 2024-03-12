package testngdemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ExtentDemo {

WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	void testLogo()
	{
		try
		{
			boolean status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
			Assert.assertEquals(status, true);
			System.out.println("inside Test Logo");
		}
		catch(Exception e)
		{
			Assert.assertTrue(false);
		}
		
	}
	
	@Test(priority=2)
	void testLogin() throws Exception
	{				
			driver.findElement(By.xpath("//a[normalize-space() = 'Log in']")).click(); //Login link
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abc123@gmail.com");
			
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("test123");
			
			driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
			
			//validation
			boolean status=driver.findElement(By.linkText("My account")).isDisplayed();
			
			System.out.println(status);
			
			Assert.assertEquals(status, true); // this makes testmethod fail
	}
	
	@Test(priority=3,dependsOnMethods= {"testLogin"})
	void testLogout() throws InterruptedException
	{
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(3000);
		boolean status=driver.findElement(By.linkText("Register")).isDisplayed();
		Assert.assertEquals(status,true);
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
}
