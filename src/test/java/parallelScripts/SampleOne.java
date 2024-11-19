package parallelScripts;

import org.testng.annotations.Test;

public class SampleOne {
  
  @Test
  public void testOne() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test11 in SampleParallel.."+id);
  }
  
  @Test
  public void testTwo() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test12 in SampleParallel.."+id);
  }
  
  @Test
  public void testThree() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test13 in SampleParallel.."+id);
  }
  
  @Test
  public void testFour() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test14 in SampleParallel.."+id);
  }
  
}
