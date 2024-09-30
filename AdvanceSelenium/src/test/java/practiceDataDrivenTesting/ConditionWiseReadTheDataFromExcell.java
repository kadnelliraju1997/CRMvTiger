package practiceDataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ConditionWiseReadTheDataFromExcell {
	public static void main(String[] args) throws Exception {
		String expected_id = "tc_100";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		boolean flag = false;

		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Downloads\\TestScriptData1.xlsx");
		// Step2: open the WorkBook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		// Step3: get the control of the "org" sheet
		Sheet sh = wb.getSheet("org");
		int count = sh.getLastRowNum();
		for (int i = 0; i <= count; i++) {
			String data = "";
			try {
				data = sh.getRow(i).getCell(0).toString();
				if (data.equals(expected_id)) {
					flag=true;
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
					data3 = sh.getRow(i).getCell(3).toString();

				}
			} catch (Exception e) {
			}

		}
		if(flag==true) {
			System.out.println(data1+"\t"+data2+"\t"+data3);
		}
		else {
			System.out.println(expected_id+" data is not available");
		}
		

	}
}
