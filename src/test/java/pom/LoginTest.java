package pom;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	LoginPage lp;
	Logger logger;
	@BeforeClass
	void setup() throws InterruptedException {
		logger = LogManager.getLogger(this.getClass());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		lp = new LoginPage(driver);
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	void testLogin() {
		logger.info("testLogin");
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		lp.clickSubmit();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test(priority = 1)
	void testLogo() {
		logger.info("testLogo");
		Boolean status = lp.checkLogoPresence();
		System.out.println(status);
		//Assert.assertEquals(status, true);
		Assert.assertTrue(status);
		
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
