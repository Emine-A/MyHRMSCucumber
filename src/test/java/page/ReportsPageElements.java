package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseClass;
import utils.CommonMethods;

public class ReportsPageElements extends CommonMethods {

	
	
	@FindBy(id="search_search")
	public WebElement searchBox;
	
	@FindBy(xpath="//input[@class='searchBtn']")
	public WebElement srcBtn;
	
	@FindBy (xpath="//input[@name='_reset']")
	public WebElement resetBtn;
	
	@FindBy(xpath="//table/tbody/tr/td")
	public WebElement invalidSearchResult;
	
	@FindBy(xpath="//table/tbody/tr/td[2]")
	public WebElement validSearchResult;
	
	public  ReportsPageElements () {
		PageFactory.initElements(BaseClass.driver, this);	
		
	}
	public void report(String rpr) {
		sendText(searchBox,rpr);
		click(srcBtn);
	}
}
