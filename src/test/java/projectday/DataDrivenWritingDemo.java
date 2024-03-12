package projectday;

import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenWritingDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileOutputStream file = new  FileOutputStream(System.getProperty("user.dir")+"/TestData/demofile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet mySheet = workbook.createSheet();
		
		/*
		//creating rows and cells without loop
		XSSFRow myRow1 = mySheet.createRow(0);
		myRow1.createCell(0).setCellValue("ABC");
		myRow1.createCell(1).setCellValue("1234");
		myRow1.createCell(2).setCellValue("Hello");
		XSSFRow myRow2 = mySheet.createRow(1);
		myRow2.createCell(0).setCellValue("DEF");
		myRow2.createCell(1).setCellValue("5678");
		myRow2.createCell(2).setCellValue("Bye");
		
		
		workbook.write(file);
		*/
		
		
		//creating rows and colums with loop
		
		Scanner sc = new Scanner(System.in);
		
		for(int r=0;r<2;r++) {
			XSSFRow myRow= mySheet.createRow(r);
			for(int c=0;c<3;c++) {
				System.out.print("Enter Data : ");
				String value = sc.next();
				myRow.createCell(c).setCellValue(value);
			}
		}
		
		workbook.write(file);
		
		workbook.close();
		file.close();
		
		
		
		
		System.out.println("Writing Done.....");
	}

}
