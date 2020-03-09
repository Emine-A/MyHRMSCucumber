package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseClass;
import utils.CommonMethods;


//TC:Add Employee
//Step1: navigate to the application
//Step2:login into the application
//Step3:navigate to add employee page
//Step4: add employee by providing fname, mname, lname
//Step5: verify employee has been added successfully
//


public class AddEmployeePage extends CommonMethods {
	
	
@FindBy(id="firstName")
public WebElement firsName;
@FindBy(id="middleName")
public WebElement middleName;
@FindBy(id="lastName")
public WebElement lastName;

@FindBy(id="btnSave")
public WebElement saveButton;
@FindBy()
public WebElement profileName;

@FindBy(id = "employeeId")
public WebElement empId;



// constructor . (classname) we use the constructor for initializing those elements
public AddEmployeePage() {
PageFactory.initElements(BaseClass.driver, this);	
}
public void addEmployee(String name, String mName,String lName) {
	
	sendText(firsName,name);
	sendText(middleName, mName);
	sendText(lastName,lName);
	click(saveButton);
}

	
}
