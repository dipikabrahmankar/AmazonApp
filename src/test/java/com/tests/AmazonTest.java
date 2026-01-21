package com.tests;

import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonTest{
  WebDriver driver;
  @Parameters("browserName")
	
  @Test
  public void launchAndGetTitle(String browserName) throws MalformedURLException, InterruptedException {
	  
	  

      if (browserName.equalsIgnoreCase("chrome")) {
    	  ChromeOptions options = new ChromeOptions();
    	  driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(),options);          
    	  System.out.println("Connection established with Chrome Browser");
      }	else if (browserName.equalsIgnoreCase("firefox")) {
    	 FirefoxOptions options = new FirefoxOptions();
    	  driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(),options);          
    	  System.out.println("Connection established with firefox Browser");
      }	else if (browserName.equalsIgnoreCase("edge")) {
     	 EdgeOptions options = new EdgeOptions();
   	  driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(),options);          
   	  System.out.println("Connection established with Edge Browser");
      }
      Thread.sleep(5000);
      driver.get("https://www.amazon.in/");
      Thread.sleep(3000);
      try {
    	    String title = driver.getTitle();
    	    System.out.println("Title of page is: " + title);
    	} catch (WebDriverException e) {
    	    System.out.println("Amazon page loaded but browser became unstable");
    	}
      
      driver.quit();
  
  }
}
