package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderCreateContactTest {
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName,String lastName ,long phoneNo) {
		System.out.println("firstName:"+firstName+", lastName:"+lastName +", phoneNo:"+phoneNo);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="deepak";
		objArr[0][1]="Hr";
		objArr[0][2]= 7556211455l;
		
		objArr[1][0]="raju";
		objArr[1][1]="ae";
		objArr[1][2]=8546542654l;
		
		objArr[2][0]="megha";
		objArr[2][1]="ae";
		objArr[2][2]=8546542656l;
		return objArr;
	}
	
	

	
}
