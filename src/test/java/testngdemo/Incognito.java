package testngdemo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Incognito {

	public static void main(String[] args) throws Exception {
		List<String> lst = new ArrayList<String>();
		lst.add("--incognito");
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments(lst);
		
		
		
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://www.google.com");
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
