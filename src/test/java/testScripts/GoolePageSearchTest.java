package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoolePageSearchTest {
	WebDriver driver;
	
//	@BeforeMethod
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
//  @Test(priority=1)
//	@Test(dependsOnMethods ="seleniumSearchTest")
	@Test(alwaysRun = true, dependsOnMethods ="seleniumSearchTest") //If selenium Test have any issues so that moment seleniumtest got failed and javatest will skipped. so without having any issues in JavaTest also got skipped. so if we want to get JavaTest to be run even the seleniumTest got failed. SO that time we have to use the "alwaysRun = true"

  public void javaSearchTest() {
		driver.navigate().to("https://www.google.com/");

		WebElement searchBox = driver.findElement(By.tagName("textarea"));

		searchBox.sendKeys("Java Tutorial");
		searchBox.submit();

		Assert.assertEquals("Java Tutorial - Google Search", driver.getTitle());
		
		System.out.println("The Page title:.."+driver.getTitle());
		
  }
  
//  @Test(priority=3)
  @Test
  public void seleniumSearchTest() {
		driver.navigate().to("https://www.google.com/");

//		WebElement searchBox = driver.findElement(By.tagName("textarea"));
		
		WebElement searchBox = driver.findElement(By.tagName("textBarea"));


		searchBox.sendKeys("Selenium Tutorial");
		searchBox.submit();

		Assert.assertEquals("Selenium Tutorial - Google Search", driver.getTitle());
		
		System.out.println("The Page title:.."+driver.getTitle());

		
}
//  @Test(priority=4)
  @Test(enabled=false)
  public void AppiumSearchTest() {
		driver.navigate().to("https://www.google.com/");

		WebElement searchBox = driver.findElement(By.tagName("textarea"));

		searchBox.sendKeys("Appium Tutorial");
		searchBox.submit();

		Assert.assertEquals("Appium Tutorial - Google Search", driver.getTitle());
		
		System.out.println("The Page title:.."+driver.getTitle());
		
}

//@Test(priority=2)
  @Test(enabled=false)
public void cucumberSearchTest() {
		driver.navigate().to("https://www.google.com/");

		WebElement searchBox = driver.findElement(By.tagName("textarea"));

		searchBox.sendKeys("Cucumber Tutorial");
		searchBox.submit();

		Assert.assertEquals("Cucumber Tutorial - Google Search", driver.getTitle());
		
		System.out.println("The Page title:.."+driver.getTitle());

		
}
  
  
//  @AfterMethod
  @AfterTest
  public void tearDown() {
	driver.close();
}

  
}
