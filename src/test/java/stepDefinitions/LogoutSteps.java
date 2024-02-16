package stepDefinitions;

import java.util.List;

import org.junit.Assert;

import com.Pages.LoginPage;
import com.Pages.LogoutPage;
import com.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {
	private LogoutPage logoutPage = new LogoutPage(DriverFactory.getDriver());
	private LoginPage loginPage ;
	
	@Given("User is on Logout page")
	public void user_is_on_logout_page() {
		String logoutPagetitle = logoutPage.getLogoutPageTitle();
		System.out.println("Accounts Page title is: " + logoutPagetitle);
	}

	@Then("User gets logout section lables")
	public void user_gets_logout_section_lables(DataTable dataTable) {
		List<String> lableList = dataTable.asList();
		String expectedlable1 = lableList.get(0);
		String expectedlable2 = lableList.get(1);
		String expectedlable3 = lableList.get(2);
		System.out.println(expectedlable1);
		System.out.println(expectedlable2);
		System.out.println(expectedlable3);
		
		String actualLable1 = logoutPage.getLogoutPageLables1();
		String actualLable2 = logoutPage.getLogoutPageLables2();
		String actualLable3 = logoutPage.getLogoutPageLables3();
		System.out.println(actualLable1);
		System.out.println(actualLable2);
		System.out.println(actualLable3);
		
		Assert.assertTrue(expectedlable1.contains(actualLable1));
		Assert.assertTrue(expectedlable2.contains(actualLable2));
		Assert.assertTrue(expectedlable3.contains(actualLable3));				
	}
	
	@When("User clicks on logout button and should logedout from application")
	public void user_clicks_on_logout_button_and_should_logedout_from_application() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage = logoutPage.getClickLogoutButton();
	}
}
