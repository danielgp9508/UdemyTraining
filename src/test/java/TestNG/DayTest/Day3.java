package TestNG.DayTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {

	@Test(priority = 1)
	public void Mobilelogin() {
		System.out.println("Mobile");
	}
	
	@Test(priority = 2)
	public void Weblogin() {
		System.out.println("Web");
	}
	
	@Parameters("parameterValueXML2")
	@Test(priority = 3)
	public void APIlogin(String param) {
		System.out.println("API " + param);
	}
	
	@AfterTest()
	public void afterTest(){
		System.out.println("After Test");
	}
}
