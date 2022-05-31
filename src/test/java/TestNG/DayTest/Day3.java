package TestNG.DayTest;

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
	
	@Test(priority = 1)
	public void APIlogin() {
		System.out.println("API");
	}
}
