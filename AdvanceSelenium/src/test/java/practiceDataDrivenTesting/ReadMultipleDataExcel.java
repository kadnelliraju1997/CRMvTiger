package practiceDataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataExcel {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Downloads\\TestScriptData1.xlsx");
		// Step2: open the WorkBook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		// Step3: get the control of the "Prod" sheet
		Sheet sh = wb.getSheet("Prod");
		int count = sh.getLastRowNum();
		for(int i=0;i<=count;i++)
		{	Row row = sh.getRow(i);
			String data = row.getCell(0).toString();
			String data1 = row.getCell(1).toString();
			System.out.println(data+" \t"+data1);
			
		}
		
	}

}
