package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import utils.APIConstants;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
public class E_DELETEEmploye {

	private Response response;
	private static RequestSpecification request;
	
	@Given("User call DeleteEmployee API")
	public void user_call_DeleteEmployee_API() {
	  request= given().header("Content-Type","application/json").header("Authorization",SyntaxAPIAuthenticationSteps.Token)
	   .param("employee_id", A_POSTCreateEmployeeApi.employee_ID);
	   
	}

	@When("User retrieve response for delete")
	public void user_retrieve_response_for_delete() {
	  response= request.when().delete(APIConstants.DELETE_EMPLOYEE_URI);
	}

	@Then("Status code is {int} for deleting")
	public void status_code_is_for_deleting(Integer int1) {
	 int statusCode= response.getStatusCode() ; 
	 response.then().assertThat().statusCode(int1);
	 System.out.println("Status code is: " + statusCode);
	// Assert.assertEquals(expected,statusCode );
	}

	@Then("User validates employee delete")
	public void user_validates_employee_delete() {
		 //response.jsonPath().getString("message") ; 
	  response.then().body("employee[0].employee_id",equalTo(A_POSTCreateEmployeeApi.employee_ID));
	 response.then().body("message", equalTo("Entry deleted"));
	 boolean responseMessage= response.asString().contains("Entry deleted");
	
	 if(responseMessage) {
		 System.out.println("Message is correct");
	 }else {
		 System.out.println("-----INVALID MESSAGE------");
	 }
	}


}
