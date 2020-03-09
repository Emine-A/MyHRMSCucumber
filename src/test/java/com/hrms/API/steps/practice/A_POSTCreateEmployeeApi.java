package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.CommonMethods;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
//import org.junit.Assert;

public class A_POSTCreateEmployeeApi {
	private Response response;
	private static RequestSpecification request;
	public static Object employee_ID;

	@Given("user calls createEmployee API")
	public void user_calls_createEmployee_API() {
	request= given().header("Content-Type","application/json").header("Authorization",
			SyntaxAPIAuthenticationSteps.Token); 
	
	request.body(CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON));
			
	 
	}

	@When("user retrieves response")
	public void user_retrieves_response() {
	response=  request.post(APIConstants.CREATE_EMPLOYEE_URI) ; 
	System.out.println(response.prettyPrint());
	}

	@Then("status code is {int}")
	public void status_code_is(int expected) {
	response.then().assertThat().statusCode(expected);
	// int actualC=response.statusCode();
	// Assert.assertEquals("Status code cannot match",expectedC, actualC);
	}

	@Then("user validates employee is created")
	public void user_validates_employee_is_created() {
		
		//String str = response.jsonPath().getString("Message");
		//Assert.assertEquals("Employee cannot be  created","Entry Created", str);
		
		//import static org.hamcrest.Matchers.equalTo; -->eklenen importtan gelen methodlar
		response.then().body("Message", equalTo("Entry Created"));
		response.then().body("Employee[0].emp_firstname", equalTo("Emily"));
	
		JsonPath jsonPathEvaluator = response.jsonPath();
		 employee_ID =jsonPathEvaluator.get("Employee[0].employee_id");
		System.out.println("Employee ID is: "+employee_ID);
		
	}

}
