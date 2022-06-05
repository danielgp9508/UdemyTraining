package TestNG.Listeners;

import java.util.List;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Listeners implements  ITestListener{
	
	@Override
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test ok " + result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test fail " + result.getName());
	}
	

}
