package testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandles {
  @Test
  public void handleWindows() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://stqatools.com/demo/Windows.php");
	  String parentWin = driver.getWindowHandle();
	  System.out.println("Parent Window:..." + parentWin);
	  
	  WebElement tabBtn = driver.findElement(By.xpath("//button[contains(text(),'new Tab')]"));
	  tabBtn.click();
	  System.out.println("Page Title:.."+driver.getTitle());
	  
	  Set<String> tabs = driver.getWindowHandles();
	  System.out.println("Number of Windows..."+ tabs.size());
	  
	  for(String child:tabs) {
		  System.out.println("windows:.." +child);
		  if(!child.equalsIgnoreCase(parentWin)) {
			  driver.switchTo().window(child);
			  System.out.println("Child win title..."+driver.getTitle());
		  }
	  }
	  
	  Thread.sleep(2000); 
	  driver.close(); //It s for to close the currently handling window, means on which window the main focus will be there
	  
	  //Now If I do any work in parent window after closing this child active window, that doesnt work , why because we are in child window till now and we already switched to that, so thats why its wont work. so if we need to do anything in parent window then we need to bing the focus to parent window again
	  
	  driver.switchTo().window(parentWin);
	  System.out.println("Parent Page Title:..." + driver.getTitle());
	  driver.findElement(By.xpath("//button[contains(text(),'new Window')]")).click();
	  Set<String> wins = driver.getWindowHandles();
	  System.out.println("Number of Windows:..."+wins.size());
	  
	  for(String win:wins) {
		  System.out.println("windows:.." +win);
		  if(!win.equalsIgnoreCase(parentWin)) {
			  driver.switchTo().window(win);
			  System.out.println("Child win title..."+driver.getTitle());
		  }
	  }
	  
	  Thread.sleep(2000);
	  driver.close();
//	  driver.close();
	  driver.quit();
	  
	  
	  
	  
  }
}
