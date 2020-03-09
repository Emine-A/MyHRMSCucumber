package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseClass;



public class LeaveListPageElement {

	@FindBy(xpath="//a[@class='toggle tiptip']")
	public WebElement leaveListLbl;
	
	public LeaveListPageElement() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}

