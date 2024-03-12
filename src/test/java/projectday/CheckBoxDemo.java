package projectday;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxDemo {

	public static void main(String[] args) throws Exception{
		
		ChromeOptions op = new ChromeOptions();
		
		op.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(op);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://test.rubywatir.com/checkboxes.php");
		driver.manage().window().maximize();
		List<WebElement> check = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(int i=0;i<check.size();i++) {
			if(check.get(i).isSelected()) {
			check.get(i).click();	
			}
			}
		
		for(int i=0;i<3;i++) {
			check.get(i).click();	
			}
		Thread.sleep(2000);
		
		
		for(int i=0;i<check.size();i++) {
			if(check.get(i).isSelected()) {
			check.get(i).click();
			}
			}
		
		/*
		System.out.println(check.size());
		for (WebElement ele : check) {
			ele.click();
		}
		
		*/
		
		
		System.out.println("Test Passsed");
		
	}

}
