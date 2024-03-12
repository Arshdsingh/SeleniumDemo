package projectday;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();

		//WebElement drop = driver.findElement(By.id("country-list"));
		
		List<WebElement> dropd = driver.findElements(By.xpath("//select[@id='country-list']/option"));
		
		System.out.println(dropd.size());
		
		for (WebElement elem : dropd) {
			if (elem.getText().equals("India")) {
				elem.click();
			}
			
		}
		
		/*
		Select select = new Select(drop);

		select.selectByIndex(3);
		select.selectByValue("4");
		select.selectByVisibleText("USA");

		List<WebElement> op = select.getOptions();

		for (WebElement elem : op) {
			System.out.println(elem.getText());
		}
		*/
		Thread.sleep(2000);
		driver.quit();
	}

}
