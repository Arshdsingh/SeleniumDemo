package projectday;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTableDemo {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Rows : " + rows);
		int column = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//th")).size();
		System.out.println("Columns  : " + column);
		

		System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]//td[1]")).getText());

		
		for(int i=2;i<rows;i++) {
			for(int j=1;j<column;j++) {
				System.out.print(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText()+"  |");
			}
			System.out.println("");
		}
		int total = 0;
		for(int i=2;i<=rows;i++) {
			String price = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+i+"]//td[4]")).getText();
				
			total = total + Integer.parseInt(price);
			
			}

		System.out.println("Total  : "+total);
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
