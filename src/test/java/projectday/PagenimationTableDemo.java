package projectday;

import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.checkerframework.checker.units.qual.mol;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PagenimationTableDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		driver.findElement(By.id("dob")).click();
		List<WebElement> elements =  driver.findElements(By.xpath("//select[@class = 'ui-datepicker-month']/option"));
		System.out.println(elements.size());
		
		
		
		//Select select = new Select(driver.findElement(By.xpath("//select[@class = 'ui-datepicker-month']")));
		 for (WebElement elem : elements) {
			if (elem.getText().equals("Dec")) {
				elem.click();
			}
		}
		 /*
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		String date = "30";
		String month = "December";
		String year = "2024";
		
	
		driver.findElement(By.id("datepicker")).click();
		
		
		while (true) {
			String m = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String y = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if (m.equals(month) && y.equals(year))
				break;
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			
		}
		
		List<WebElement> dateRow =  driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']//td"));
		
		for (WebElement elem : dateRow) {
			System.out.println(elem.getText());
			
			if (elem.getText().equals(date)) {
				elem.click();
			}
		}
		
		//String tempdate = "";
		
		for (int i= 1; i<dateRow ; i++) {
			for (int j = 1 ; j<=7 ; j++) {
				tempdate = driver.findElement(By.xpath("//table[@class = 'ui-datepicker-calendar']//tr["+i+"]//td["+j+"]")).getText();
				
				if (tempdate.equals(date)) {
					driver.findElement(By.xpath("//table[@class = 'ui-datepicker-calendar']//tr["+i+"]//td["+j+"]")).click();
				}				
			}
		}
		*/
		Thread.sleep(3000);
		driver.quit();
	
	}

}
