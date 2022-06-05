package TestNG.Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupClass1 {
	
	 
	 @AfterGroups(value = "regression")
	 public void afterGroup() {
		 System.out.println("After Group");
	 }
	
	 @Test(groups = {"regression", "UAT"})
	 public void testG1() {
		 System.out.println("group 1");
	 }
	 
	 @Test(groups = "regression", dependsOnGroups = "UAT")
	 public void testG2() {
		 System.out.println("group 2");
	 }
	 
	 @Test
	 public void testG3() {
		 System.out.println("group 3 void");
	 }
	 
	 @Test(groups = "smoke")
	 public void testG4() {
		 System.out.println("group 4");
	 }
	 
	 @AfterClass(alwaysRun=true)
	 public void beforemethod() {
		 System.out.println("After method");
	 }

}
