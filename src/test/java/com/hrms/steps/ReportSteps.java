package com.hrms.steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import page.DashboardPageElements;
import page.ReportsPageElements;
import utils.CommonMethods;

public class ReportSteps extends CommonMethods {

	ReportsPageElements rp;
	@Given("I navigated to the reports page")
	public void i_navigated_to_the_reports_page() {
		DashboardPageElements ds = new DashboardPageElements();
    	ds.navigateToReports(); 
	}

	@When("I enter invalid {string} report")
	public void i_enter_invalid_report(String string) {
		rp=new ReportsPageElements();
		sendText(rp.searchBox,string);
		
	}

	@When("I click search button")
	public void i_click_search_button() {
		click(rp.srcBtn);
	}

	@Then("I see {string} error message")
	public void i_see_error_message(String string) {
		rp.invalidSearchResult.isDisplayed(); 
	}

	@When("I enter valid {string} report")
	public void i_enter_valid_report(String string) {
		rp=new ReportsPageElements();
		sendText(rp.searchBox,string);
	}

	@Then("I see the search {string} report is displayed")
	public void i_see_the_search_report_is_displayed(String string) {
		rp.validSearchResult.isDisplayed();
	}


}