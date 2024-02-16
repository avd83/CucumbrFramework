package stepDefinitions;

import org.junit.Assert;
import com.Pages.LoginPage;
import com.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private String loginPageTitle;

	@Given("User is on Login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				  .get("https://rahulshettyacademy.com/locatorspractice/");
				//.get("http://www.automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		loginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("login page tilte:" + loginPageTitle);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(loginPageTitle.contains(expectedTitle));
	}

	@Then("Forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	@When("User eneters username {string}")
	public void user_eneters_username(String userName) {
		loginPage.enterUserName(userName);
	}

	@When("User eneters password {string}")
	public void user_eneters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickSignButton();
	}
}
