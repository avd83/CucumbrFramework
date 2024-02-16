package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.Pages.AccountPage;
import com.Pages.LoginPage;
import com.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	
	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credentialTable) {
	    
		List<Map<String, String>> credList = credentialTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver()
				  .get("https://rahulshettyacademy.com/locatorspractice/");
				//.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountPage = loginPage.doLogin(userName, password);		
	}

	@Given("User is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountPage.getAccountPageTitle();
		System.out.println("Accounts Page title is: " + title);
	}

	@Then("User gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		
		List<String> expAccountSectionsList = sectionTable.asList();		
		System.out.println("Expected accounts section list: " + expAccountSectionsList);

		List<String> actualAccountSectionsList = accountPage.getAccountSectionsList();
		System.out.println("Actual accounts section list: " + actualAccountSectionsList);

		Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));
	}

	@Then("Accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountPage.getAccountSectionCount() == expectedSectionCount);
	}
}
