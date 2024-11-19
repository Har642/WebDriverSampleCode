package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {
	
  @Test
  public void fileUploadTest() throws InterruptedException {
	  
//	  File Upload
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://blueimp.github.io/jQuery-File-Upload/");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  WebElement addFile = driver.findElement(By.xpath("//input[@type = 'file']"));
	  String strPath = System.getProperty("user.dir") + "//Capture.PNG";
	  Thread.sleep(2000);
	  addFile.sendKeys(strPath);
	  Thread.sleep(2000);
	  driver.findElement(By.cssSelector("button.btn.btn-primary.start")).click();
	  Thread.sleep(2000);

	  driver.close();
	  
	  //File download
	  
	  WebDriver driver1 = new ChromeDriver();
	  driver1.get("https://file-examples.com/index.php/text-files-and-archives-download/");
	  driver1.manage().window().maximize();
	  Thread.sleep(2000);
	  WebElement downloadFile = driver1.findElement(By.cssSelector("table#table-files tbody tr:nth-child(1) td:nth-child(5) a.btn")); 
	  downloadFile.click();
	  Thread.sleep(2000);
	  
  }
}
