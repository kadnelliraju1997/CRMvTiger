package task;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExecutionOrder2 {

	@BeforeSuite
	void BS() {
		System.out.println("BS");
	}

	@BeforeSuite
	void BS1() {
		System.out.println("BS1");
	}

	@BeforeMethod
	void BM() {
		System.out.println("BM");

	}

	@Test
	void test() {
		System.out.println("test");
	}

	@BeforeMethod
	void BM1() {
		System.out.println("BM1");

	}

	@BeforeClass
	void BC() {
		System.out.println("BC");

	}

	@AfterMethod
	void AM() {
		System.out.println("AM");
	}

	@BeforeMethod
	void BM2() {
		System.out.println("BM2");

	}

	@AfterClass
	void AC() {
		System.out.println("AC");
	}

	@AfterClass
	void AC1() {
		System.out.println("AC1");
	}

	@AfterSuite
	void AS() {
		System.out.println("AS");
	}

}
