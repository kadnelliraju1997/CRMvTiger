package practice.testng;

import org.testng.annotations.Test;

public class OrderTest {
	@Test(dependsOnMethods = "billingOrderTest" )
	public void createOrderTest()
	{
		System.out.println("order id is created");
	}
	@Test
	public void billingOrderTest()
	{
		System.out.println("biling is created");

	}

	

}
