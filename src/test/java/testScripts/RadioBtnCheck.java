package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioBtnCheck {
	WebDriver driver;
  @Test
  public void RadioButtonCheckTest() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/checkboxes");
	  driver.manage().window().maximize();
	  
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	  
	  boolean isSel = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected();
	  
	  Thread.sleep(2000);
	  if(isSel == false) {
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	  }
	  
	  driver.close();
	  
	  
  }
}
