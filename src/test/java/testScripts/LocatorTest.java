package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorTest {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		  driver.get("https://the-internet.herokuapp.com/login");
		  driver.manage().window().maximize();
	}
	
  @Test
  public void loginTest() throws InterruptedException {
	  
	  
//	  driver.findElement(By.id("username")).sendKeys("tomsmith");
//	  driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

	  
	  WebElement username = driver.findElement(By.id("username"));
	  username.sendKeys("tomsmith");
	  
	  WebElement password = driver.findElement(By.id("password"));
	  password.sendKeys("SuperSecretPassword!");
	  
	  Thread.sleep(2000);

	  driver.findElement(By.className("radius")).click();
	  
//	  driver.findElement(By.linkText("Elemental Selenium")).click();
//	  driver.findElement(By.partialLinkText("Elemental")).click();
	  
	  
//	  driver = new ChromeDriver();
//	  driver.get("https://demo.opencart.com/");
//	  driver.manage().window().maximize();
//	  
//	  List<WebElement> items = driver.findElements(By.cssSelector("ul.nav.navbar-nav >li:nth-child(3) ul.list-unstyled > li"));
	  
  }
  @AfterMethod
  public void tearDown() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.close();
  }
}
