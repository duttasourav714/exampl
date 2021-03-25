package utilities;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import baseClasses.BaseClass;

public class writeExcelFile extends BaseClass{
	
	public static XSSFWorkbook workbook;
	public static void writeExcel(ArrayList<String> arr) { //writing in an excel file
		//XSSFWorkbook
		workbook = new XSSFWorkbook();
		//XSSFSheet
		XSSFSheet sheet = workbook.createSheet("Most popular used cars in chennai");
		//Writing the data
		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("Chennai: ");
		int count = 0;
		for(int i = 1;i<=arr.size();i++) {
			
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(arr.get(count++));
		}
		try {
			FileOutputStream file = new FileOutputStream("cars.xlsx");
			workbook.write(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
