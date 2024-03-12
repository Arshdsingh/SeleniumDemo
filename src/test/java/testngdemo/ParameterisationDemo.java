package testngdemo;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParameterisationDemo {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
	}
	
	@Test(dataProvider = "dp")
	public void login(String email, String pwd) {
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

		String exp_title = "nopCommerce demo store";
		String act_title = driver.getTitle();

		Assert.assertEquals(exp_title, act_title);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider(name = "dp")
	String[][] loginData() {
		String data[][]= {  
				{ "abc@gmail.com", "test123" }, 
				{ "iarsh8066@gmail.com", "Test123" },
				{ "pavanoltraining@gmail.com", "test3" },
				{ "pavanoltraining@gmail.com", "test@123" },
				{ "pavanoltraining@gmail.com", "test@123" } 
			};
		
		return data;
	}
	
}
