package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	
	// 1. Constructor 
	 LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	 
	// 2. Locators
	By img_logo_loc = By.xpath("//img[@alt='company-branding']");
	
	By txt_username_loc = By.xpath("//input[@placeholder='Username']");
	By txt_password_loc = By.xpath("//input[@placeholder='Password']");
	By button_login_loc = By.xpath("//button[normalize-space()='Login']");
	
	
	// 3. Action methods
	public void setUserName(String username) {
		driver.findElement(txt_username_loc).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(txt_password_loc).sendKeys(password);
	}
	
	public void clickSubmit() {
		driver.findElement(button_login_loc).click();
	}
	
	public Boolean checkLogoPresence() {
		Boolean status = driver.findElement(img_logo_loc).isDisplayed();
		return status;
	}
}
