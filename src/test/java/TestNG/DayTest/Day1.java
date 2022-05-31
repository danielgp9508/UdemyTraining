package TestNG.DayTest;

import org.testng.annotations.Test;

public class Day1 {

	
	@Test
	public void test1() {
		System.out.println("Hello");
	}
	
	@Test
	public void test2() {
		System.out.println("Bye");
	}
	
	@Test
	public void includeTest2() {
		System.out.println("Inc1");
	}
	
	@Test
	public void IncludeTest2() {
		System.out.println("Inc2");
	}
	
	
}
