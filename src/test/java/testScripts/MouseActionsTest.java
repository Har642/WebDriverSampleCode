package testScripts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActionsTest {
  @Test
  public void mouseActionsTest() throws InterruptedException {
	  ChromeOptions options = new ChromeOptions();
	  
	  options.addArguments("--blink-settings=imagesEnabled=false");
	  WebDriver driver = new ChromeDriver(options);
	  driver.manage().window().maximize();
	  
	  Actions actions = new Actions(driver);
	  driver.get("https://demo.opencart.com/");
	  
	  WebElement srcBox = driver.findElement(By.name("search"));
	  
//	  actions.contextClick(srcBox).perform();
  
//	  Thread.sleep(2000);
//	  
//	  //ul.nav.navbar-nav li:nth-child(3) ul.list-unstyled li      => It is for to select multiple list elements
//	
//	  WebElement menu = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li//a[text()='Components']"));
//	  
//	  actions.moveToElement(menu).perform();
//	  
//	  WebElement menuitem = driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[contains(text(),'Printers')]"));
//	  
////	  actions.contextClick(menuitem);
//	  
//	  actions.moveToElement(menu).click(menuitem).build().perform();
//	  
//	  driver.close();
	  
	  Thread.sleep(2000);
	  actions.scrollToElement(driver.findElement(By.xpath("//a[contains(text(),'Terms & Conditions')]"))).perform();
  }
  
}
