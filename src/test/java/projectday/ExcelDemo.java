package projectday;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");

		String file = System.getProperty("user.dir")+"/TestData/data1.xlsx";
		
		int rows = ExcelUtils.getRowCount(file, "Sheet1");
		
		for (int i=1;i<=rows;i++) {
			String intlDeposit = ExcelUtils.getCellData(file, "Sheet1", i, 0);
			String intrestRate = ExcelUtils.getCellData(file, "Sheet1", i, 1);
			String length = ExcelUtils.getCellData(file, "Sheet1", i, 2);
			String compounding = ExcelUtils.getCellData(file, "Sheet1", i, 3);
			String total = ExcelUtils.getCellData(file, "Sheet1", i, 4);
			
//			System.out.println("Initial Deposit : "+intlDeposit);
//			System.out.println("Intrest Rate : "+intrestRate);
//			System.out.println("Length : "+length);
//			System.out.println("Compounding : " + compounding);
		
			
			WebElement itlDepositBox = driver.findElement(By.id("mat-input-0"));
			WebElement lengthBox = driver.findElement(By.id("mat-input-1"));
			WebElement intrestBox = driver.findElement(By.id("mat-input-2"));
			
			itlDepositBox.clear();
			lengthBox.clear();
			intrestBox.clear();
			
			itlDepositBox.sendKeys(intlDeposit);
			lengthBox.sendKeys(length);
			intrestBox.sendKeys(intrestRate);
			driver.findElement(By.id("mat-select-value-1")).click();
			List<WebElement> options = driver.findElements(By.xpath("//div[@id ='mat-select-0-panel']/mat-option"));
			for (WebElement opt : options) {
				
				if (opt.getText().equals(compounding)) {
					opt.click();
				}
			}
			
			WebElement calcButton = driver.findElement(By.id("CIT-chart-submit"));
			calcButton.click();
			
			String totalValue = driver.findElement(By.id("displayTotalValue")).getText();
//			System.out.println("Total Value : "+totalValue);
//			System.out.println("Total : "+total);
			
			if(totalValue.equals(total)) {
				ExcelUtils.setCellData(file, "Sheet1", i, 6, "Pass");
				ExcelUtils.fillGreenColor(file, "Sheet1", i, 6);
			} else {
				ExcelUtils.setCellData(file, "Sheet1", i, 6, "Fail");
				ExcelUtils.fillRedColor(file, "Sheet1", i, 6);
			}
			Thread.sleep(2000);
			
		}
	}

}
