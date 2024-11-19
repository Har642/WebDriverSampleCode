package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AlertsCheck {
  @Test
  public void alertValidation() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("https://demoqa.com/alerts");
	  Thread.sleep(5000);
	  driver.findElement(By.id("alertButton")).click();
	  
//	  Alert alert = driver.switchTo().alert();
//	  System.out.println("Alert Text:..." +alert.getText());
  }
}
