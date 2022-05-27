package JavaStreams;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Miscellaneous.Assert;
import io.netty.handler.codec.rtsp.RtspHeaders.Values;

public class StreamsSelenium {

	WebDriver driver;
	String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
	
	@BeforeClass
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}
	
	@Test(enabled = false)
	public void addToCartArray() {
		
		String offersTable = "a[href='#/offers']";
		String sortButton = "//span[text() ='Veg/fruit name']//parent::th//child::span[2]";
		String tableElements = "//tbody/tr/td[1]";
		driver.findElement(By.cssSelector(offersTable)).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		driver.findElement(By.xpath(sortButton)).click();
		List<WebElement> tableList = driver.findElements(By.xpath(tableElements));
		List<String> originalList = tableList.stream().map(value -> value.getText())
		.collect(Collectors.toList());
		List<String> streamSortedList = originalList.stream().sorted()
		.collect(Collectors.toList());
		org.testng.Assert.assertEquals(originalList, streamSortedList);
		
	}
	
	@Test(enabled = false)
	public void getPriceStream() {
		String offersTable = "a[href='#/offers']";
		String sortButton = "//span[text() ='Veg/fruit name']//parent::th//child::span[2]";
		String tableElements = "//tbody/tr/td[1]";
		driver.findElement(By.cssSelector(offersTable)).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		List<WebElement> tableList = driver.findElements(By.xpath(tableElements));
		List<String> originalList = tableList.stream().filter(value -> value.getText().contains("Rice")).map(value -> getVeggiePrice(value))
		.collect(Collectors.toList());
		originalList.forEach(value -> System.out.println(value));
		
	}
	
	@Test(enabled = false)
	public void paginationStream() {
		
		String offersTable = "a[href='#/offers']";
		String sortButton = "//span[text() ='Veg/fruit name']//parent::th//child::span[2]";
		String tableElements = "//tbody/tr/td[1]";
		String nextbutton = "a[aria-label='Next']";
		driver.findElement(By.cssSelector(offersTable)).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		driver.findElement(By.xpath(sortButton)).click();
		List<WebElement> tableList = driver.findElements(By.xpath(tableElements));
		List<String> originalList;
		do {
			tableList = driver.findElements(By.xpath(tableElements));
			originalList = tableList.stream().filter(value -> value.getText().contains("Rice")).map(value -> getVeggiePrice(value))
					.collect(Collectors.toList()); 
			if(originalList.size() < 1) {
				driver.findElement(By.cssSelector(nextbutton)).click();
			}
		}while(originalList.size() < 1);
		System.out.println(originalList.get(0));
		
		
	}
	
	@Test(enabled = true)
	public void filteringStream() {
		String offersTable = "a[href='#/offers']";
		String sortButton = "//span[text() ='Veg/fruit name']//parent::th//child::span[2]";
		String tableElements = "//tbody/tr/td[1]";
		String nextbutton = "a[aria-label='Next']";
		String searchField = "search-field";
		driver.findElement(By.cssSelector(offersTable)).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		List<WebElement> tableWebElements = new ArrayList<WebElement>();
		List<String> tableValues = new ArrayList<String>();
		List<String> tableValuesTemp = new ArrayList<String>();
		boolean whileBool = true;
		while( whileBool) {
			if(driver.findElement(By.cssSelector(nextbutton)).getAttribute("aria-disabled").equals("false")) {
				tableWebElements = driver.findElements(By.xpath(tableElements));
				tableValuesTemp = tableWebElements.stream().map(value -> value.getText()).collect(Collectors.toList());
				tableValues.addAll(tableValuesTemp);
				driver.findElement(By.cssSelector(nextbutton)).click();
			}else {
				whileBool = false;
				tableWebElements = driver.findElements(By.xpath(tableElements));
				tableValuesTemp = tableWebElements.stream().map(value -> value.getText()).collect(Collectors.toList());
				tableValues.addAll(tableValuesTemp);
				
			}		
		}
		tableValues.stream().map(values -> values.toLowerCase()).filter(values -> values.contains("ch")).forEach(values -> System.out.println(values));

	}

	private static String getVeggiePrice(WebElement s) {
		return  s.findElement(By.xpath("following-sibling::td[1]")).getText();	
	}
	
	
	
}
