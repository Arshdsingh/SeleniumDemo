package projectday;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenReadingDemo {

	
	public static void main(String args[]) throws Exception {
	
	
	// File --> WorkBook --> Sheet --> Row --> Cell
	
		//1. first we have to capture the file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/TestData/data.xlsx");
		//2. Then we have to capture workbook from the file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		// 3. Getting the sheet
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		// 4. Getting the rows
		int sheetRows = sheet.getLastRowNum();
		int sheetCells = sheet.getRow(1).getLastCellNum();
		
		//System.out.println("Rows : "+sheetRows+"\n"+"Cells : "+sheetCells);
		
		for (int r=0;r<=sheetRows;r++) {
			
			XSSFRow currentRow = sheet.getRow(r);
			for(int c=0;c<sheetCells;c++) {
				XSSFCell currentCell = currentRow.getCell(c);
				System.out.print(currentCell.toString()+"  ---  ");
				
			}
			System.out.println(" ");
		}
		workbook.close();
		file.close();
	}

}
