package RealTimeExercise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollTableGrids {
	
	WebDriver driver;
	String url = "https://www.rahulshettyacademy.com/AutomationPractice/";
	
	@BeforeClass
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}
	
	@Test(enabled = true)
	public void SCroll() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Scroll FullPage
		js.executeScript("window.scrollTo(0 , 500)");
		//Scroll table
		js.executeScript("document.querySelector(\"div.tableFixHead\").scrollBy(0 , 100)");
		
	
		
	}

}
