package ActionsFramesWindows;

import java.util.Iterator;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowsHandle {
	
	WebDriver driver;
	String url = "https://rahulshettyacademy.com/loginpagePractise/";
	
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
		
		String childLinkCssSelector = "a[href=\"https://rahulshettyacademy.com/#/documents-request\"]";
		driver.findElement(By.cssSelector(childLinkCssSelector)).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.findElement(By.xpath("//strong[text()=' Learn Earn & Shine']")).getText();
		driver.switchTo().defaultContent();
	}

}
