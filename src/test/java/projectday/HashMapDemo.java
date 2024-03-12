package projectday;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HashMapDemo {
	static HashMap<String, String> loginData() {
	
	HashMap<String, String> hm = new HashMap<String, String>();
	hm.put("x", "mercury@mercury");
	hm.put("y", "mercury1@mercury1");
	hm.put("z", "mercury2@mercury2");
		
	return hm;
}
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		
		String value[] = loginData().get("y").split("@");		
		
		
		
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(value[0]);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(value[1]);
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		
}
}

