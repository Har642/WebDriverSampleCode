package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ToolTip {
  @Test
  public void toolTip() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
	  driver.get("https://jqueryui.com/tooltip/");
	  
	  Thread.sleep(2000);
	  driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
	  
	  driver.findElement(By.cssSelector("input#age")).sendKeys(Keys.ARROW_DOWN);
	  actions.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
	  
	  String strTxt = driver.findElement(By.className("ui-tooltip-content")).getText();
	  System.out.println("Tooltip text is:.." + strTxt);
	  
	  WebElement age = driver.findElement(By.id("age"));
	  
	  age.sendKeys("20"); 		
	  
	  
  }
}
