package ActionsFramesWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsClass {
	
	WebDriver driver;
	String url = "https://www.amazon.com/-/es/";
	
	@BeforeClass
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}
	
	@Test
	public void mouseActions() {
		
		String mouseHoverId = "nav-link-accountList";
		String hoverScreenId = "nav-flyout-accountList";
		String textBoxId = "twotabsearchtextbox";
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id(mouseHoverId))).build().perform();
		System.out.println(driver.findElement(By.id(hoverScreenId)).isDisplayed());
		action.moveToElement(driver.findElement(By.id(textBoxId))).click().keyDown(Keys.LEFT_SHIFT).sendKeys("Motor").build().perform();
		
	}

}
