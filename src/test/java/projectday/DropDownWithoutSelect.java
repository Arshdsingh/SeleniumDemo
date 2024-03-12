package projectday;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithoutSelect {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@type = 'button' and contains(@class,'multiselect')]")).click();
		
		List<WebElement> list =	driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]/li//label"));
		System.out.println(list.size());
		
		
		
		for (WebElement elem : list) {
			if (elem.getText().equals("Java")) {
				elem.click();
			}
			
		}
		

		
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
