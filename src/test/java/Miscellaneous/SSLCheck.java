package Miscellaneous;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class SSLCheck {
	
	WebDriver driver;
	String url = "https://expired.badssl.com";
	String url1 = "https://sodocumentation.net/xpath/topic/4463/get-the-count-of-nodes";
	
	
	@Test(enabled = true)
	public void SSL() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setHeadless(true);
		options.addArguments("--window-size=1920,1080");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url1);	
		
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("target" + File.separator + "ev1.png"));
			FileUtils.copyFile(src, new File("target" + File.separator + "ev2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
