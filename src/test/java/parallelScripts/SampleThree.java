package parallelScripts;

import org.testng.annotations.Test;

public class SampleThree {
	@Test
	  public void testOne() {
		  System.out.println("Test31 in SampleParallel");
	  }
	  
	  @Test(groups="Feature3")
	  public void testTwo() {
		  System.out.println("Test32 in SampleParallel");
	  }
	  
	  @Test(groups="FeatureOne")
	  public void testThree() {
		  System.out.println("Test33 in SampleParallel");
	  }
	  
	  @Test(groups="Feature2")
	  public void testFour() {
		  System.out.println("Test34 in SampleParallel");
	  }
	  
}
