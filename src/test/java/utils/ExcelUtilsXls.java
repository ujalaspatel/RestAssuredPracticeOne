package utils;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsXls {
	static HSSFWorkbook workbook;
	static HSSFSheet sheet;
	public ExcelUtilsXls(String excelPath, String sheetName) {
//we have added constructor to call the method from another class.
// here we will provide excelPath and sheetName when we call it.
		try {
			InputStream file =new FileInputStream(excelPath);
		workbook =new HSSFWorkbook(new POIFSFileSystem(file)); //HSSFWorkbook is the class in apache.poi to get the xls excel file
		sheet=workbook.getSheet(sheetName);		// HSSFSheet is the class in apache.poi to get the excel Sheet
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
//	public static void main(String[] args) { // don't need the main method 
//		getRowCount();    //we created main method to check functions are working properly
//		getCellData();
//	}
	public static void getRowCount() {
//here we have used ./ because xslx file in the same project folder 
//but if it is somewhere else then use the full location path for the xlsx file
		//String excelPath="./data/RestAssuredTestData.xlsx"; 
		//you can also use below line to get the path for the project to add before xlsx file path
		//String projDir=System.getProperty("user.dir");
		//System.out.println(projDir);
		//String excelPath=projDir+"/data/RestAssuredTestData.xlsx"; 
		
	
		try {
		
		int rowCount =sheet.getPhysicalNumberOfRows();
		System.out.println("No. of Rows:"+ rowCount);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
	}
	public static void getCellData(int rowNum, int colNum) {
		
		try {
		
		// DataFormatter will covert any kind of data in the excelsheet to object so that 
		//so that no need to worry about data type in excel sheet
		DataFormatter formatter=new DataFormatter();
		Object value=formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		//it is the method to get cell value which is string only
		//String value=sheet.getRow(1).getCell(0).getStringCellValue(); 
		System.out.println(value);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}
