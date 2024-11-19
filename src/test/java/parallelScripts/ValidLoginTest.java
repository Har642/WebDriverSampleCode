package parallelScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


//The example for to get the data from the Properties file and based on that file, we can run the code.



public class ValidLoginTest {
	WebDriver driver;
	Properties prop;
	
	@BeforeTest
	public void readProperty() throws IOException {
		String path = System.getProperty("user.dir") + "//src//main//resources//configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		
		prop = new Properties();
		prop.load(fin);
		
	}	
	
	@BeforeMethod
	public void setUp() {
		String strBrowser = prop.getProperty("browser");
		
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(strBrowser.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}else if(strBrowser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
  public void locatorTest()  throws InterruptedException {
		  driver.get(prop.getProperty("url"));
		  WebElement username = driver.findElement(By.id("username"));
		  username.sendKeys("tomsmith");
		  
		  WebElement password = driver.findElement(By.id("password"));
		  password.sendKeys("SuperSecretPassword!");
		  
		  Thread.sleep(2000);

		  driver.findElement(By.className("radius")).click();

	  }
	
 }

