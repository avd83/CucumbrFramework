package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	//private By emailId= By.id("email");
	//private By password= By.id("passwd");
	//private By signButton= By.id("SubmitButton");
	//private By forgotPasswordLink = By.linkText("Forgot your Passord");
	
	private By emailId= By.id("inputUsername");
	private By password= By.name("inputPassword");
	private By signButton= By.cssSelector("button[class=\'submit signInBtn\']");
	private By forgotPasswordLink = By.xpath("//a[text()='Forgot your password?']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;		
	}
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	public void  enterUserName(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}
	public void  enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void  clickSignButton() {
		driver.findElement(signButton).click();
	}
	public AccountPage doLogin(String un,String pwd) {
		System.out.println("login with: "+un+"and "+ pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signButton).click();	
		return new AccountPage(driver);
	}
}
