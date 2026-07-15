package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver()
	{
		 if(driver.get()==null)
		 {
			 System.out.println("Browser called..........");
			 String browser = ConfigReader.get("browser");
			 switch(browser)
			 {
			 case "firefox":
			 {
				 WebDriverManager.firefoxdriver().setup();
				 driver.set(new FirefoxDriver());
				 break;
			 }
			 case "chrome":
			 {
				 WebDriverManager.chromedriver().setup();
				 driver.set(new ChromeDriver());
				 break;
			 }
			 default :
				 System.out.println("Browser is not compatible...please pass the correct one");
			 }
			 driver.get().manage().window().maximize();
		 }
		return driver.get();
		
	}
	
	public static void  quitDriver()
	{
		if(driver.get()!=null)
		{
			driver.get().quit();
			driver.remove();
		}
	}

}
