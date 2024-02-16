package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser){
		System.out.println("browser value is:"+browser);
		
		if(browser.equals("chrome")) {
			ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");            
            System.setProperty("webdriver.chrome.driver", "F:/15dec22_laptop/Selenium/Setup/chromedriver.exe");
			driver = new ChromeDriver(option);
			//WebDriverManager.chromedriver().setup();
			//tldriver.set(new ChromeDriver(option));
            tldriver.set(driver);            
		}
		else if(browser.equals("firefox")){
			FirefoxOptions option = new FirefoxOptions();
            option.addArguments("--remote-allow-origins=*");            
            System.setProperty("webdriver.firefox.driver", "F:/15dec22_laptop/Selenium/Setup/geckodriver.exe");
			driver = new FirefoxDriver(option);			
			//WebDriverManager.firefoxdriver().setup();
			//tldriver.set(new FirefoxDriver(option));
		}
		else {
		System.out.println("Plase pass the corrcet value in:"+ browser);
		}
				
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized  WebDriver getDriver() {
		return tldriver.get();
	}

}
