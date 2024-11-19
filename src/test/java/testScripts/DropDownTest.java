package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownTest {
	WebDriver driver;
  @Test
  public void dropDownCheck() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	  driver.get("https://stqatools.com/demo/Multiselect.php");
	  driver.manage().window().maximize();
	  
	//  Thread.sleep(2000);
	  
	  Select dateSel = new Select(driver.findElement(By.cssSelector("select.date_s")));
	  dateSel.selectByVisibleText("1985");
	  
	  Select nameSel = new Select(driver.findElement(By.cssSelector("select.name_s")));
	  nameSel.selectByIndex(0);
	  nameSel.selectByValue("Martina");
	  nameSel.selectByVisibleText("Gustaf");
	  nameSel.getAllSelectedOptions();
	  
	  
	  driver.close();
  }
}
