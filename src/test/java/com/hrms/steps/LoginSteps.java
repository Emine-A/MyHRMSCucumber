package com.hrms.steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.LoginPageElement;
import utils.CommonMethods;

public class LoginSteps extends CommonMethods {
	//here we use Junit assertion
	
	@Given("I open browser and navigated to the HRMS")
	public void i_open_browser_and_navigated_to_the_HRMS() {
	    //setUp(); already done in hooks class
	}
	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		login = new LoginPageElement();
	    sendText(login.username, "Admin");
	    sendText(login.password, "Syntax@123");
	}
	@When("I click on Login button")
	public void i_click_on_Login_button() {
		jsClick(login.loginBtn);
	}
	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
	//	Assert.assertTrue(false); // in purpose failed test case
		System.out.println("I logged in");
	}
	@Then("I close browser")
	public void i_close_browser() {
	   tearDown();
	}
	@When("I enter valid username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {
		login = new LoginPageElement();
		sendText(login.username, "Admin");
		sendText(login.password, "Hum@nhrm");
	}
	@Then("I see error message")
	public void i_see_error_message() {
		String expectedMsg = "Invalid credentials";
		String actualMsg = login.errorMsg.getText();
		Assert.assertEquals("Message is not displayed", expectedMsg, actualMsg);
		System.out.println("Error message displayed");
	}
	@When("I enter {string} and {string}")
	public void i_enter_and(String username, String password) {
	    login = new LoginPageElement();
	    sendText(login.username, username);
	    sendText(login.password, password);
	}
	@Then("I see {string}")
	public void i_see(String errorMsg) {
		 login = new LoginPageElement();
		 Assert.assertEquals("Expected message is NOT displayed", login.errorMsg.getText(), errorMsg);
	
	}
}