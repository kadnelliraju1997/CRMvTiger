package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteBackTheDataToExcel {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Downloads\\TestScriptData1.xlsx");
		// Step2: open the WorkBook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		// Step3: get the control of the "org" sheet
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		Cell cell = row.createCell(4);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("PASS");
		FileOutputStream fio=new FileOutputStream("C:\\Users\\Admin\\Downloads\\TestScriptData1.xlsx");
		wb.write(fio);
		wb.close();
		System.out.println("excute");
	}

}
