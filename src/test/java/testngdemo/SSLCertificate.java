package testngdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

public class SSLCertificate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		WebElement inputbox = driver.findElement(By.id("ap_email"));
		
		
		String text = driver.findElement(RelativeLocator.with(By.tagName("label")).near(inputbox)).getText();
		String text_1 = driver.findElement(RelativeLocator.with(By.tagName("a")).below(inputbox)).getText();
		System.out.println(text);
		System.out.println(text_1);
		
		
		WebElement privacy_notice = driver.findElement(By.xpath("//a[@class = 'a-link-normal'][normalize-space() = 'Privacy Notice']"));
		
		String privacy_notice_1 = driver.findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(privacy_notice)).getText();
		
		String privacy_notice_2 = driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(privacy_notice)).getText();
		
		System.out.println(privacy_notice_1);
		System.out.println(privacy_notice_2);
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
