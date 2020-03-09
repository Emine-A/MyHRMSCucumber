package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import utils.CommonMethods;

import static io.restassured.RestAssured.*;

import org.junit.Assert;
public class UpdateEmployee {
	private Response response;
	private static RequestSpecification request;
	
	@Given("User call UpdateEmployee API")
	public void user_call_UpdateEmployee_API() {
	 request=given().header("Content-Type","application/json").header("Authorization",SyntaxAPIAuthenticationSteps.Token);
	//request.body(CommonMethods.readJson("/Users/yc/eclipse-workspace/EmineJava/HrmsCucumberFramework/src/test/resources/JSONFiles/updateEmployee.json"));	
		
	}

	@When("User retrieves response for update")
	public void user_retrieves_response_for_update() {
		response= request.put("http://54.167.125.15/syntaxapi/api/updateEmployee.php") ;
	   
	}
	@Then("Status code for update is {int}")
	public void status_code_for_update_is(Integer expected) {
		 Integer code= response.getStatusCode();
		 System.out.println("Codeeeee"+code);
	     Assert.assertEquals("Status code cannot match",expected, code);
			
	}


	@Then("User validate updateEmployee")
	public void user_validate_updateEmployee() {
	Boolean str=  response.jsonPath().prettyPrint().contains("Freelance"); //  .getString("emp_status")  ;
	
	Assert.assertTrue("EmpStatus cannot be matched", str); //("EmpStatus cannot be matched","Freelance", str);
	}
	
	
	
	
	
}
