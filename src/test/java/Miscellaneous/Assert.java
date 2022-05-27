package Miscellaneous;

import static org.testng.Assert.assertEquals;


import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class Assert {
	
	WebDriver driver;
	String url = "https://www.rahulshettyacademy.com/AutomationPractice/";
	
	@Test(enabled = true)
	public void SSL() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		SoftAssert softassert = new SoftAssert();
		//assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Practice Page1");
		softassert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Practice Page1");
		softassert.assertAll();
	
	}

}
