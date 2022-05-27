package RealTimeExercise;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scope {
	
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
	
	@Test(enabled = false)
	public void scope() {
		
		//all webpage links
		List<WebElement> listLinks = driver.findElements(By.tagName("a"));
		for(WebElement we : listLinks) {
			System.out.println(we.getAttribute("href"));
		}
		System.out.println("****");
		//all footer links
		List<WebElement> listLinksFooter = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		for(WebElement we : listLinksFooter) {
			System.out.println(we.getAttribute("href"));
		}
		
	}
	
	@Test
	public void openSeparateTab() {
		driver.findElement(By.xpath("//button[text() = 'Home']")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));
		driver.findElement(By.cssSelector("a[href='/consulting']")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		driver.findElement(By.cssSelector("a[href='/mentorship']")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		driver.switchTo().parentFrame();
		driver.findElement(By.cssSelector("a[href='http://www.restapitutorial.com/']")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		driver.findElement(By.xpath("//a[text()='Dummy Content for Testing.'][1]")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		for(String value : windows) {
			driver.switchTo().window(value);
			System.out.println(driver.getTitle());
		}
	}

}
