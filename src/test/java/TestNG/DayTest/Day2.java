package TestNG.DayTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day2 {
	
	@Parameters("parameterValueXML1")
	@Test
	public void test1Day2(String param) {
		System.out.println("day2 " + param);
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Runing BeforeTest");
	}
}
