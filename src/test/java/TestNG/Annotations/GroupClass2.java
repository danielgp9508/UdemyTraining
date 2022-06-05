package TestNG.Annotations;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupClass2 {
	
	@Test(groups = "regression")
	 public void testG11() {
		System.out.println("group 11");
	 }
	 
	 @Test(groups = "regression")
	 public void testG22() {
		 System.out.println("group 22");
	 }
	 
	 @Test
	 public void testG33() {
		 System.out.println("group 33");
	 }
	 
	 @Test(groups = "UAT")
	 public void testG44() {
		 System.out.println("group 44");
	 }
	 
	 
	 @BeforeClass(alwaysRun=true)
	 public void beforemethod() {
		 System.out.println("before method");
	 }
}
