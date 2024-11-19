package parallelScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LocatorTest {
	
	WebDriver driver;
	

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String strBrowser) {
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(strBrowser.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}else if(strBrowser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
  @Test
  public void loginTest() throws InterruptedException {
	  driver.get("https://the-internet.herokuapp.com/login");
	  WebElement username = driver.findElement(By.id("username"));
	  username.sendKeys("tomsmith");
	  
	  WebElement password = driver.findElement(By.id("password"));
	  password.sendKeys("SuperSecretPassword!");
	  
	  Thread.sleep(2000);

	  driver.findElement(By.className("radius")).click();

  }
 
@AfterMethod
  public void tearDown() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.close();
  }
}
