package practiceDataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {
	public static void main(String[] args) throws Exception {

		// Step1: get excel path location & java object of physical excellFile
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Downloads\\TestScriptData.xlsx");
		// Step2: open the WorkBook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		// Step3: get the control of the "org" sheet
		Sheet sh = wb.getSheet("org");
		// Step4: get the control of the "1st" row
		Row row = sh.getRow(0);
		// Step5: get the control of the "1st" cell & read the String data
		Cell cell = row.getCell(0);
		
		String usn = cell.getStringCellValue();
		System.out.println(usn);
		// Step6: close the WorkBook
		wb.close();
	}
}
