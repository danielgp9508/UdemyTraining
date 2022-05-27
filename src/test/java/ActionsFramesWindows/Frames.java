package ActionsFramesWindows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Frames {
	
	
	WebDriver driver;
	String url = "https://jqueryui.com/droppable/";
	
	@BeforeClass
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}
	
	@Test
	public void switchFrame() {
		
		String frameCssSelector = "iframe[class='demo-frame']";
		String objectDragId = "draggable";
		String objectDropId = "droppable";
		driver.switchTo().frame(driver.findElement(By.cssSelector(frameCssSelector)));
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.id(objectDragId))).moveToElement(driver.findElement(By.id(objectDropId))).build().perform();
	}
}
