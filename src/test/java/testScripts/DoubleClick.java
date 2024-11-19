package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClick {
	WebDriver driver;
  @Test
  public void doblueClickTest() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("https://stqatools.com/demo/DoubleClick.php");
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
	  Thread.sleep(2000);
	  WebElement btn = driver.findElement(By.cssSelector("p button"));
	  
	  
	  for (int i=0;i<=3; i++) {
		  actions.doubleClick(btn).perform();
		  Thread.sleep(2000);
	  }
	  System.out.println(driver.findElement(By.cssSelector("span#dblClicks")).getText());
	  
//	  actions.doubleClick(btn).doubleClick(btn).build().perform();
	  Thread.sleep(2000);
	  driver.close();
	  
  }
}
