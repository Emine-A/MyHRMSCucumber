package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;

import org.junit.Assert;
public class getAllJobTitle {
	private static RequestSpecification request;
	private Response response;

	@Given("User call for allJobTitle API")
	public void user_call_for_allJobTitle_API() {
	  request= given().header("Content-Type","application/json").header("Authorization",SyntaxAPIAuthenticationSteps.Token);
	
	}

	@When("User retrieve for allJobTitle")
	public void user_retrieve_for_allJobTitle() {
	   response= request.get("http://54.167.125.15/syntaxapi/api/jobTitle.php");
	}

	@Then("Status code is {int}")
	public void status_code_is(Integer expected) {
	  Integer code= response.getStatusCode();
	
	  
	  Assert.assertEquals("Status code cannot match",expected, code);
	}

	@Then("Getting allJobTitle")
	public void getting_allJobTitle() {
	Boolean title= response.prettyPrint().contains("Job Title List");
	Assert.assertTrue("Getting jobTitle cannot success", title);
	}

	
	
	
}
