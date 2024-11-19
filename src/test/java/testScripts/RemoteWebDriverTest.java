package testScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteWebDriverTest {
	WebDriver driver;

	@Test
	public void test() throws MalformedURLException {
		// first of all set the required capabilities as like below
		ChromeOptions options = new ChromeOptions();

		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		// Here in the above code, we are setting up the platform as windows and it will
		// automatically select the browser version from the available browser itself

		// If we want to set up the specific browser version, we can write it as
//	  options.setCapability(CapabilityType.BROWSER_VERSION, "120"); //so whatever the version do you need, include it there

		String strHub = " http://10.0.12.6:4444"; // my grid was running on this port
		driver = new RemoteWebDriver(new URL(strHub), options);
		
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");

		WebElement searchBox = driver.findElement(By.tagName("textarea"));

		searchBox.sendKeys("Java Tutorial");
		searchBox.submit();

		Assert.assertEquals("Java Tutorial - Google Search", driver.getTitle());

		System.out.println("The Page title:.." + driver.getTitle());

	}
}
