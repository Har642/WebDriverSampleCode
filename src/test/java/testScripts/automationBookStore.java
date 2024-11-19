package testScripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class automationBookStore {
	WebDriver driver; 
  @Test
  public void IsDisplayCheck() throws IOException {
	  driver = new ChromeDriver();
	  driver.get("https://automationbookstore.dev/");
	  driver.manage().window().maximize();
	  
	  WebElement searchbox = driver.findElement(By.xpath("//input[@id='searchBar']"));
	  searchbox.sendKeys("Test");
	  
	  TakesScreenshot screen = (TakesScreenshot)driver;
	  File srcImg = screen.getScreenshotAs(OutputType.FILE);
	  String path = System.getProperty("user.dir") +"/screenshots/" +System.currentTimeMillis() +".png" ;
	  FileUtils.copyFile(srcImg, new File(path));
	 
	  
	  String strPlaceHolder = driver.findElement(By.id("searchBar")).getAttribute("placeholder");
	  System.out.println(strPlaceHolder);
	  
	  WebElement closeIcon = driver.findElement(By.cssSelector("a[title='Clear text']"));
	  
	  File srcImg1 = closeIcon.getScreenshotAs(OutputType.FILE);
	  String path1 = System.getProperty("user.dir") +"/screenshots/" +System.currentTimeMillis() +".png" ;
	  FileUtils.copyFile(srcImg1, new File(path1));
	  
	  
	  System.out.println(closeIcon.isDisplayed());
	  
	  if(closeIcon.isDisplayed()) {
		  closeIcon.click();
//		  System.out.println(closeIcon.isDisplayed());
	  }
	  
  }
}
