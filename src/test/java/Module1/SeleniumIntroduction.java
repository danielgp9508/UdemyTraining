package Module1;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class SeleniumIntroduction {

	
	@Test
	public void firstRun() {
		// Invoking Browser
		// Chrome - ChromeDriver
		//all browser WebDriver
		
		String url = "https://rahulshettyacademy.com/";
		
		//Chrome
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driverChrome = new ChromeDriver();
		
		//FireFox
		System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver-v0.31.0-win32/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		WebDriver driverFireFox = new FirefoxDriver(options);
		
		//Edge
		System.setProperty("webdriver.edge.driver", "./src/test/resources/drivers/edgedriver_win32/msedgedriver.exe");
		WebDriver driverEdge = new EdgeDriver();
		
		
		
		driverFireFox.get(url);
		System.out.println(driverFireFox.getTitle());
		driverFireFox.findElement(By.cssSelector("a[class='theme-btn register-btn']")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		driverFireFox.close();
		System.out.println(driverFireFox.findElement(By.cssSelector("a[class='theme-btn register-btn']")).getText());
	}
	
	
}
