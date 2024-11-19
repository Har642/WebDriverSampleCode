package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {
  @Test
  public void iFrames() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/iframe");

	  driver.findElement(By.cssSelector("div.tox-icon")).click();
	  
	  Thread.sleep(2000);
	  
//	  driver.switchTo().frame("mce_0_ifr");
//	  driver.switchTo().frame(0);
	  	  
	  WebElement iFrameItem = driver.findElement(By.id("mce_0_ifr"));
	  driver.switchTo().frame(iFrameItem);

	  WebElement inputTxt = driver.findElement(By.id("tinymce"));
	  String strTxt = inputTxt.getText();
	  System.out.println("Txt from Frame:.."+strTxt);
	  
	  driver.switchTo().defaultContent();
//	  driver.switchTo().parentFrame();

	  WebElement linkText = driver.findElement(By.cssSelector("span.tox-statusbar__branding"));
	  Thread.sleep(2000);
	  linkText.click();
	  
//	  driver.close();
	  
	  
  }
}
