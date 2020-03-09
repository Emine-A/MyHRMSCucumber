package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.CommonMethods;

import static io.restassured.RestAssured.*;
public class SyntaxAPIAuthenticationSteps extends APIConstants{

	private Response response ;
	public static String Token;
	private static RequestSpecification request;
	
	@Given("user generates token")
	public void user_generates_token() {
	    request = given().header("Content-Type","application/json");
	    System.out.println(request.log().all());
	  response=  request.body(CommonMethods.readJson(APIConstants.CREATE_GENARATE_TOKEN_JSON))
	.when().post(APIConstants.CREATE_GENARATE_TOKEN_URI);
	    System.out.println(response.prettyPrint());
	    Token ="Bearer "+ response.jsonPath().getString("token");
		System.out.println(Token);  
	    
	}
	
	
}
