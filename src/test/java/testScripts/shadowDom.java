package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class shadowDom {
  @Test
  public void shadow() {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://watir.com/examples/shadow_dom.html");
	  driver.manage().window().maximize();
	  WebElement shadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
	  
	  SearchContext context = shadowHost.getShadowRoot();
	  WebElement shadowContent = context.findElement(By.cssSelector("span#shadow_content"));
	  
	  System.out.println("Shadow DOM content:...." + shadowContent.getText());
//	  Assert.assertEquals(shadowContent.getText(), "Some Text1");   //Hard Assert Method
	  
	  SoftAssert softAssert = new SoftAssert();   //Soft Assert Method
	  softAssert.assertEquals(shadowContent.getText(), "Some Text1");
	  
	  
	  WebElement innerShadow = context.findElement(By.cssSelector("div#nested_shadow_host"));
	  SearchContext innerContext = innerShadow.getShadowRoot();
	  
	  WebElement innerText = innerContext.findElement(By.cssSelector("div#nested_shadow_content"));
	  System.out.println("InnerShadow DOM content:...." + innerText.getText());
	  
//	  Assert.assertEquals(innerText.getText(), "nested Text");  // Hard Assert
	  softAssert.assertEquals(innerText.getText(), "nested Text");  // Soft Assert
	  
	  softAssert.assertAll();
	

	  driver.close();

  }
}
