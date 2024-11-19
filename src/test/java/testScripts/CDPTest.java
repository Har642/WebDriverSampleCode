package testScripts;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.Put;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CDPTest {
	ChromeDriver driver;
	DevTools devTools;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		devTools = driver.getDevTools();
		devTools.createSession(driver.getWindowHandle());
	}

	// by using the below method we are testing our application in a different view port nothing but different resolution

	@Test
	public void deviceModeTest() {
		driver.manage().window().maximize();
		Map deviceMetrics = new HashMap(){
			{
				put("width", 600);
				put("height",1200);
				put("deviceScaleFactor",50);
				put("mobile",true);
			}	
		};
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		driver.get("https://www.selenium.dev/");
	}
	
	//To confirm the location , then we can try to utilize this below method , for to findout the geolocation value
	
	@Test
	
	public void geoLocationTest() {
		driver.manage().window().maximize();
		Map deviceMetrics = new HashMap(){
			{
				put("latitude", 27.664827);
				put("longitude",-84.387985);
				put("accuracy",100);
			}	
		};
		driver.executeCdpCommand("Emulation.setGeolocationOverride", deviceMetrics);
		driver.get("https://oldnavy.gap.com/stores");
	}
	
	
	
}
