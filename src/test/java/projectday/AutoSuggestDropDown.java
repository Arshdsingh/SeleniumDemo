package projectday;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropDown {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("gsmarena");

		Thread.sleep(1000);
		List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
		//List<WebElement> list = driver.findElements(By.xpath("//ul[@jsname=\"bw4e9b\"]/li/div/div[2]"));

		for (WebElement elem : list) {
			String item = elem.getText();
			if(item.equals("gsmarena s24 ultra")) {
				elem.click();
				break;
			}
			
		}

		
		driver.quit();

	}

}
