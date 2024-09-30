package practice.testng;

import org.testng.annotations.Test;

public class ContactTest1 {
	@Test(priority = 1)
	public void createContactTest()
	{
		System.out.println("contact created");
	}
	
	@Test(priority = 2)
	public void modifyContactTest()
	{
		System.out.println("modified contact created");
	}
	
	@Test(priority = 3 )
	public void deleteContactTest()
	{
		System.out.println("delete contact created");
	}

}
