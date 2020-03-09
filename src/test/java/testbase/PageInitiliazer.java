package testbase;

import page.AddEmployeePage;
import page.DashboardPageElements;
import page.LoginPageElement;
import page.PersonalDetails;

public class PageInitiliazer extends BaseClass{

	protected static LoginPageElement login;
	protected static DashboardPageElements dashboard;
	protected static AddEmployeePage addEmp;
	protected static PersonalDetails pdetails;
	public static void initializeAllPage() {

		login =new LoginPageElement();
		dashboard =new DashboardPageElements();
		addEmp    =new AddEmployeePage();
		pdetails  =new PersonalDetails();
	}   
}
