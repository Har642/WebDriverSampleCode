package parallelScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SampleTwoParallelTest {
	WebDriver driver;
	
	  @Test
	  public void testOne() {
		//  driver= new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test21 in SampleParallel...." +id);
	  }
	  
	  @Test
	  public void testTwo() {
	//	  driver= new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test22 in SampleParallel......" +id);
	  }
	  
	  @Test
	  public void testThree() {
		//  driver= new EdgeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test23 in SampleParallel......" + id);
	  }
	  
	  @Test
	  public void testFour() {
	//	  driver= new EdgeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test24 in SampleParallel....."+ id);
	  }
	  
  }

