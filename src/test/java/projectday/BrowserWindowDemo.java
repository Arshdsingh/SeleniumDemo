package projectday;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		
		//Approach 1 if we have only 2 windows
		
		
		Set<String> ids = driver.getWindowHandles();
		//List<String> lst = new ArrayList<String>(ids);
		/*
		String parent = lst.get(0);
		String child = lst.get(1);
		
		driver.switchTo().window(child);
		driver.findElement(By.linkText("Contact Sales")).click();
		driver.switchTo().window(parent);
		
		driver.findElement(By.xpath("//div[@class = 'orangehrm-login-forgot']")).click();
		*/
		
		for (String str : ids) {
			driver.switchTo().window(str);
			String title = driver.getTitle();
			
			if(title.equals("OrangeHRM HR Software | OrangeHRM")) {
				driver.findElement(By.linkText("Contact Sales")).click();
			}else if(title.equals("OrangeHRM")) {
				driver.findElement(By.xpath("//div[@class = 'orangehrm-login-forgot']")).click();
			}
			
		}
		
		
	}

}
