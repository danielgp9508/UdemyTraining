package TestNG.DayTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.reflect.Parameter;



public class Day1 {

	@Parameters({"parameterValueXML","parameterValueXMLSecond"})
	@Test
	public void test1(String parameter, String secondParameter) {
		System.out.println("Hello " + parameter + " " + secondParameter);
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
