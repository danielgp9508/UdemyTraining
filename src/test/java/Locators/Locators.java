package Locators;

import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Locators {
	
	String url = "https://rahulshettyacademy.com/locatorspractice";
	String userNameId = "inputUsername";
	String passwordName = "inputPassword";
	String signInClassName = "submit";
	String errorMessageCssSelector = "p.error";
	String forgotPasswordLinkText = "Forgot your password?";
	
	String nameXPath = "//input[@placeholder='Name']";
	String emailCssSelector = "input[placeholder='Email']";
	String phoneNumberXPath = "//input[@placeholder='Phone Number']";
	//div[@id='divpaxOptions']//*[contains(text(),'Child')]/following::div[1]/span[text()='-']
	
	
	

	@Test
	public void test1() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().maximize();
		driverChrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driverChrome.get(url);
		driverChrome.navigate().to("https://www.google.com/");
		driverChrome.navigate().back();
		findElement(driverChrome, By.id(userNameId)).sendKeys("danilson");
		findElement(driverChrome, By.name(passwordName)).sendKeys("hola123");
		findElement(driverChrome, By.className(signInClassName)).click();
		System.out.println(findElement(driverChrome, By.cssSelector(errorMessageCssSelector)).getText());
		findElement(driverChrome, By.linkText(forgotPasswordLinkText)).click();
	}
	
	public WebElement findElement(WebDriver driver, By by) {
		return driver.findElement(by);
	}
}
