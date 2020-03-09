package com.hrms.API.steps.practice;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.junit.Assert;
import org.junit.Test;

public class sampleAPITest {

//@Test
//public void getAllJobTitles() {
//Response response =RestAssured.given().contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzM0MTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODYxMCwidXNlcklkIjoiMjYxIn0.IX38oFH-GkIAuiizTS29C9dAyKtvTCUR17gQMdbKf-0")
//
//.when().get("http://54.167.125.15/syntaxapi/api/jobTitle.php");	
//
//response.prettyPrint();
//int actualResponseCode=response.getStatusCode() ;
//System.out.println(actualResponseCode);

//	}	
	
//@Test
//public void getOneEmployee() {
//	Response response=RestAssured.given().param("employee_id", "3552").contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzM0MTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODYxMCwidXNlcklkIjoiMjYxIn0.IX38oFH-GkIAuiizTS29C9dAyKtvTCUR17gQMdbKf-0")
//.when()	.get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");
//
//response.prettyPrint();
//}

@Test
public void getAllEmployee() {
  Response response = RestAssured.given().contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzM0MTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODYxMCwidXNlcklkIjoiMjYxIn0.IX38oFH-GkIAuiizTS29C9dAyKtvTCUR17gQMdbKf-0")
.when().get("http://54.167.125.15/syntaxapi/api/employeeStatus.php");	
response.prettyPrint();
}

//@Test
//public void createEmployee() {

//	Response response =RestAssured.given().contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzM0MTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODYxMCwidXNlcklkIjoiMjYxIn0.IX38oFH-GkIAuiizTS29C9dAyKtvTCUR17gQMdbKf-0")
// 	.param("emp_firstname", "newPerson")
// 	.param("emp_lastname", "employee")
// 	.param("emp_middle_name", "syntax")
// 	.param("emp_gender", "2")
// 	.param("emp_birthday", "1989-02-22")
// 	.param("emp_status", "Employee")
// 	.param("emp_job_title", "Developer")
// 	//.body("emp_firstname", "newPerson")

	@Test
	public void allEmploye() {
		Response response =RestAssured.given().contentType("application/json")	.header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzM0MTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODYxMCwidXNlcklkIjoiMjYxIn0.IX38oFH-GkIAuiizTS29C9dAyKtvTCUR17gQMdbKf-0")
		.when().get("http://54.167.125.15/syntaxapi/api/employeeStatus.php");
		
		
	}	
	@Test
	public void createEmployee() {
        
         String body = ""
                + "{\r\n" + 
                "  \"emp_firstname\": \"Atakan\",\r\n" + 
                "  \"emp_lastname\": \"FilozofBEBE\",\r\n" + 
                "  \"emp_middle_name\": \"YazikEttilerCocuga\",\r\n" + 
                "  \"emp_gender\": \"1\",\r\n" + 
                "  \"emp_birthday\": \"2010-04-22\",\r\n" + 
                "  \"emp_status\": \"Employee\",\r\n" + 
                "  \"emp_job_title\": \"Developer\"\r\n" + 
                "}";
        
        Response response = RestAssured.given().contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzM0MTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODYxMCwidXNlcklkIjoiMjYxIn0.IX38oFH-GkIAuiizTS29C9dAyKtvTCUR17gQMdbKf-0")
                .body(body)
                .when().post("http://54.167.125.15/syntaxapi/api/createEmployee.php");
                
        response.prettyPrint();
        
    }
	}
	




