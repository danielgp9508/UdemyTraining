package ActionsFramesWindows;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Screenshot {

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
	
	
	@Test()
	public void screenShot() throws IOException {
		
		String nameField = "name";
		WebElement nameFieldInput = driver.findElement(By.name(nameField));
		nameFieldInput.sendKeys("El danilson");
		File file = nameFieldInput.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("target" + File.separator + "WebElement.png"));
	}
}
