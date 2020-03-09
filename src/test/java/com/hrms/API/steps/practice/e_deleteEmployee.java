package com.hrms.API.steps.practice;
//package com.hrms.API.steps.practice;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//import static io.restassured.RestAssured.*;
//
//import org.junit.Assert;
//public class deleteEmployee {
//
//	private Response response;
//	private static RequestSpecification request;
//	
//	@Given("User call DeleteEmployee API")
//	public void user_call_DeleteEmployee_API() {
//	request  = given().header("Content-Type","application/json").header("Authorization",SyntaxAPIAuthenticationSteps.Token)
//	.param("employee_id", "06818A");
//	//bu employee silindigi icin tekrar calistirinca hata verecek
//	}
//
//	@When("User retrieve response for delete")
//	public void user_retrieve_response_for_delete() {
//	 response =request.delete("http://54.167.125.15/syntaxapi/api/deleteEmployee.php") ; 
//	}
//
//	@Then("Status code is {int} for deleting")
//	public void status_code_is_for_deleting(Integer expected) {
//		Integer code = response.getStatusCode() ;
//		Assert.assertEquals(expected, code);
//	}
//
//	@Then("User validates employee delete")
//	public void user_validates_employee_delete() {
////	  String msg= response.jsonPath().getString("message");
////	  Assert.assertEquals("Entry deleted", msg);
//		Boolean del =response.prettyPrint().contains("Entry deleted");
//		Assert.assertTrue("not delete", del);
//	}
//	
//	
//	
//	
//}
