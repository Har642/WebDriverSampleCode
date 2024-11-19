package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class GooglePageTest {
	WebDriver driver;

	@Test
	public void searchJavaTest() {

//		ChromeOptions options = new ChromeOptions();
		//to get to use the headless browser we can use below one
//		options.addArguments("--headless");
		//If we want to set that which browser version do we want to use, we can use below 
//		options.setBrowserVersion("115");
//		driver = new ChromeDriver(options);

		driver = new ChromeDriver();
		
		//for dynamic pages you can use the below get() method
//		driver.get("https://www.google.com/");
		
		//for static web pages we can use below Navigate() method
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		
		//If we want whatever the size of the page we can use below
//		driver.manage().window().setSize(new Dimension(200, 768));
		
		//To find the web page elements , one of the method is findElement 
//		WebElement searchBox = driver.findElement(By.id("APjFqb"));
//		WebElement searchBox = driver.findElement(By.name("q"));
//		WebElement searchBox = driver.findElement(By.className("gLFyf"));
		WebElement searchBox = driver.findElement(By.tagName("textarea"));

		
		searchBox.sendKeys("Java Tutorial");
//		searchBox.sendKeys(Keys.ENTER);
		searchBox.submit();
		
		System.out.println("Page Title : " +driver.getTitle());
		driver.navigate().back();
		System.out.println("Page Title : after Back : " +driver.getTitle());
		driver.navigate().forward();
		System.out.println("Page Title : after forward : " +driver.getTitle());
		driver.navigate().refresh();
		
		//To get the current page URL we can use below command as
		
		System.out.println("Page URL : " +driver.getCurrentUrl());
//		System.out.println("Page URL : " +driver.getPageSource());

		
		driver.close();

	}
}
