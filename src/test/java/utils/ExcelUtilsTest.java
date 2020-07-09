package utils;

public class ExcelUtilsTest {

	public static void main(String[] args) {

		String excelPath="./data/RestAssuredTestData.xlsx";
		String sheetName="Sheet1";
		ExcelUtilsXlsx excel=new ExcelUtilsXlsx(excelPath, sheetName);
		excel.getRowCount();
		for(int i=1; i<3; i++) {
			for(int j=0; j<3; j++)
			{ System.out.println("row:"+i+" "+"column"+j);
				excel.getCellData(i, j);
				}
		}
	}

}
