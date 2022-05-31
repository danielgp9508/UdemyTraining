package ActionsFramesWindows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultiplesWindows {

	
	WebDriver driver;
	String url = "https://rahulshettyacademy.com/angularpractice/";
	String url1 = "https://rahulshettyacademy.com/";
	
	@BeforeClass
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}
	
	
	@Test
	public void switchWindows() {
		
		//open a new tab
		driver.switchTo().newWindow(WindowType.TAB);
	}
}
