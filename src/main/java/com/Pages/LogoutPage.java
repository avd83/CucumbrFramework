package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
	
	private WebDriver driver;
	private By logoutButtton = By.tagName("button");
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;		
	}
	
	public String getLogoutPageTitle() {
		return driver.getTitle();
	}
	
	public String getLogoutPageLables1() {
		return driver.findElement(By.tagName("h2")).getText();
	}
	public String getLogoutPageLables2() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.tagName("h1")).getText();
	}
	public String getLogoutPageLables3() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText();
	}
	public LoginPage getClickLogoutButton() {
		 driver.findElement(logoutButtton).click();
		 return new LoginPage(driver);
		
	}

}
