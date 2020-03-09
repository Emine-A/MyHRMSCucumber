package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseClass;
import utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {
	

	@FindBy(xpath ="//b[contains(text(),'Leave')]")
	public WebElement leaveLnk;
	
	@FindBy(id ="menu_leave_viewLeaveList")///b[contains(text(),'Leave')]
	public WebElement leaveList;
	
	@FindBy(linkText="PIM")
	public WebElement pim;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmp;
	@FindBy(id="welcome")
	public WebElement welcome;
	@FindBy(id="menu_core_viewDefinedPredefinedReports")
	WebElement reports;
	
	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	public void navigateToLeaveList() {
		click(leaveLnk);
		click(leaveList);
	}
	
	public void navigateToAddEmploye() {
		click(pim)	;
		click(addEmp);	
	}
	public void navigateToReports() {
		click(pim);
		click(reports);
	}
	
}
