package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonUtils.Utility;

public class ExtentReportsSampleTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;

	@BeforeTest
	public void setupExtent() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SparkReport.html");
		extentReports.attachReporter(spark);
	}

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void javaSearchTest() {
		extentTest = extentReports.createTest("Java Search Test");
		driver.navigate().to("https://www.google.com/");

		WebElement searchBox = driver.findElement(By.tagName("textarea"));

		searchBox.sendKeys("Java Tutorial");
		searchBox.submit();

		Assert.assertEquals("Java Tutorial - Google Search", driver.getTitle());

		System.out.println("The Page title:.." + driver.getTitle());

	}

	@Test(retryAnalyzer = RetryAnalyzerImpl.class) // Its for to try the retryAnalyzer concept
	public void seleniumSearchTest() {
		extentTest = extentReports.createTest("Selenium Search Test");

		driver.navigate().to("https://www.google.com/");

		WebElement searchBox = driver.findElement(By.tagName("textarea"));

		searchBox.sendKeys("Selenium Tutorial");
		searchBox.submit();

		Assert.assertEquals("Selenium Tutorial - Google Search Test", driver.getTitle());

		System.out.println("The Page title:.." + driver.getTitle());

	}

	@AfterTest
	public void finishExtent() {
		extentReports.flush();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			extentTest.log(Status.FAIL, result.getThrowable().getMessage());
			String strPath = Utility.getScreenshotPath(driver);
			extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
		} else if(ITestResult.SKIP == result.getStatus()) {
			extentTest.log(Status.SKIP,result.getThrowable().getMessage());
		}
		
		
		
		driver.close();
	}

}
