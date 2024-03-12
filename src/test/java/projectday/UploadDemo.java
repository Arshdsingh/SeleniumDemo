package projectday;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class UploadDemo {
	public static void main(String[] args) {
		
		
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		WebElement bookapp = driver.findElement(By.tagName("book-app"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement shadowRoot = (WebElement)js.executeScript("return arguments[0].shadowRoot", bookapp);

		WebElement appheader = shadowRoot.findElement(By.tagName("app-header"));
		WebElement appheader1 = appheader.findElement(By.tagName("app-header"));
		WebElement apptoolbar = appheader1.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
		WebElement bookinput = apptoolbar.findElement(By.tagName("book-input-decorator"));
		bookinput.findElement(By.cssSelector("input#input")).sendKeys("french");

	}
}
