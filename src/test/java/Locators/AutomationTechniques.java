package Locators;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationTechniques {
	
	WebDriver driver;
	String url = "https://rahulshettyacademy.com/dropdownsPractise/";
	String url1 = "https://rahulshettyacademy.com/AutomationPractice/";
	String url2 = "https://rahulshettyacademy.com/seleniumPractise/#/";
	
	@BeforeClass
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}
	
	@Test(enabled = false)
	public void dropDownPractice() {	
		String selectorId = "ctl00_mainContent_DropDownListCurrency";
		Select select = new Select(driver.findElement(By.id(selectorId)));
		select.selectByIndex(3);
		System.out.println(select.getFirstSelectedOption().getText());
		
	}
	
	@Test(enabled = false)
	public void clickDropDownPractice() {	
		String dropId = "divpaxinfo";
		driver.findElement(By.id(dropId)).click();
		String addRest = "";
		String passengerAge = "Adult";
		addRest = "+";
		String addRestPassenger = "//div[@id='divpaxOptions']//*[contains(text(),'" + passengerAge + "')]/following::div[1]/span[text()='" + addRest + "']";
		for(int i = 1; i <= 5; i++) {
			driver.findElement(By.xpath(addRestPassenger)).click();
		}
		
	}
	
	@Test(enabled = false)
	public void checkBox() {
		
		String dateCssSelector = "input#ctl00_mainContent_view_date1";
		driver.findElement(By.cssSelector(dateCssSelector)).click();
		
	}
	
	@Test(enabled = false)
	public void alerts() throws InterruptedException {
		driver.navigate().to(url1);
		String alertId = "alertbtn";
		driver.findElement(By.id(alertId)).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		//driver.switchTo().alert().;
		//driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().accept();
	}
	 
	@Test(enabled = true)
	public void addToCartArray() {
		String[] list = {"Brocolli", "Cauliflower", "Beans", "Carrot"};
		String itemsXpath = "//*[contains(text(),'#Item#')]//following-sibling::div[@class='product-action']";
		driver.navigate().to(url2);
		List cartItems = Arrays.asList(list);
		for(Object value : cartItems) {
			driver.findElement(By.xpath(itemsXpath.replace("#Item#", (CharSequence) value))).click();
		}
	}
}
