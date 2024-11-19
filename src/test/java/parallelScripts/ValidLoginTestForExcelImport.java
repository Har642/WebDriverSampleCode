package parallelScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//This is the code for to work with any excel sheets or import the data from excel sheet.


public class ValidLoginTestForExcelImport {
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

		if (strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (strBrowser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test
	public void locatorTest() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		WebElement username = driver.findElement(By.id(readFromExcel("username")));
		username.sendKeys("tomsmith");

		WebElement password = driver.findElement(By.id(readFromExcel("password")));
		password.sendKeys("SuperSecretPassword!");

		Thread.sleep(2000);

		driver.findElement(By.className(readFromExcel("loginBtn"))).click();

	}

	public String readFromExcel(String objName) {
		String objPath = "";

		String path = System.getProperty("user.dir") + "//src//main//resources//testData//LoginDataTest.xlsx";

		// HSSF ...> for .xls
		// XSSF ...> for .xlsx

		FileInputStream fin;
		XSSFWorkbook workbook = null;

		try {
			fin = new FileInputStream(path);
			workbook = new XSSFWorkbook(fin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet loginSheet = workbook.getSheet("loginPage");
		int numRows = loginSheet.getLastRowNum();
		
		for (int i = 1; i<=numRows; i++) {
			XSSFRow  row = loginSheet.getRow(i);
			
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(objName)) {
				objPath = row.getCell(1).getStringCellValue();
			}
		}
		return objPath;

	}

}

//The data which we need to maintain on the excel sheet as 
//ObjName			ObjPath
//username		username
//password		password
//loginBtn		radius
//successMsg		div.flash.success