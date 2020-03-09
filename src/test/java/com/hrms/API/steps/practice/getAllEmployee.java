package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import org.junit.Assert;
public class getAllEmployee {

	private Response response;
	private static RequestSpecification request;
	
	@Given("User call allEmployee API")
	public void user_call_allEmployee_API() {
	 request= given().header("Content-Type","application/json").header("Authorization",SyntaxAPIAuthenticationSteps.Token);
		
	}

	@When("User retrive response for allEmployee")
	public void user_retrive_response_for_allEmployee() {
	response= request.get("http://54.167.125.15/syntaxapi/api/getAllEmployees.php");
	System.out.println(response.prettyPrint());
	}

	@Then("AllEmploye Status code is {int}")
	public void allemploye_Status_code_is(Integer int1) {
	 response.then().assertThat().statusCode(int1) ;  
	}

	@Then("User validates get allEmployee")
	public void user_validates_get_allEmployee() {
		Boolean emp=response.prettyPrint().contains("employee_id");
		Assert.assertTrue("Getting AllEmployee is not success", emp);
//	 String emp= response.jsonPath().c  .getString("Employee")  ;
//	 Assert.assertEquals("Getting AllEmployee is not success",emp, "employee_id");
	}
	
	
}
