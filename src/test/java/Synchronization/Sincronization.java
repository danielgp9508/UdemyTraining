package Synchronization;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sincronization {
	
	WebDriver driver;
	String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
	
	@BeforeClass
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}
	
	@Test
	public void explicitWaits() throws InterruptedException {
		String[] list = {"Brocolli", "Cauliflower", "Beans", "Carrot"};
		String itemsXpath = "//*[contains(text(),'#Item#')]//following-sibling::div[@class='product-action']";
		driver.navigate().to(url);
		List cartItems = Arrays.asList(list);
		for(Object value : cartItems) {
			driver.findElement(By.xpath(itemsXpath.replace("#Item#", (CharSequence) value))).click();
		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.promoInfo")));
		driver.findElement(By.cssSelector("span.promoInfo")).getText();
	}

}
