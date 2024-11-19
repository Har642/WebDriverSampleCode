package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AlertTest {
  @Test
  public void alerts() throws InterruptedException {
	  WebDriver driver = new EdgeDriver();
	  Actions actions = new Actions(driver);
	  driver.get("https://demoqa.com/alerts");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	 
	 WebElement alertBtn =  driver.findElement(By.cssSelector("button#alertButton"));
	 Thread.sleep(2000);
	 actions.scrollToElement(alertBtn).perform();
	 alertBtn.click();
	 Thread.sleep(2000);
	 Alert alert = driver.switchTo().alert();
	 System.out.println("Alert Text:..." +alert.getText());
	  
//	  alert.accept();
	  
	  
  }
}
