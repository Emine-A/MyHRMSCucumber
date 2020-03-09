package utils;
import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.BaseClass;
import testbase.PageInitiliazer;
public class CommonMethods extends PageInitiliazer{

	// method overloading i nasil kullandigina ornek commonmethods

	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}
	//this method will dismiss the alert
	//@throws will throw NoAlertPresentException if alert is not present
	public static void dismissAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		}catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}


	public static String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		}catch(NoAlertPresentException e) {
			System.out.println("Alert is not present");
			return null;
		}
	}
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);

		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
	public static void switchToFrame(int index)	{
		try {
			driver.switchTo().frame(index);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);

	}
	//*This method will scroll until specified element
	public static void scrollIntoElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0]scrollIntoView(true);",element);	
	}
	//*this method page down
	public static void scrollDown(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+pixel+")");
	}
	//*this method page up
	public static void scrollUp(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-"+ pixel +")");
	}

	public static byte[] takeScreenshot(String fileName) {

		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MMdd_HHmmss");
		String timeStamp=sdf.format(date.getTime());

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] picture = ts.getScreenshotAs(OutputType.BYTES);
		File file = ts.getScreenshotAs(OutputType.FILE);
		String scrshotFile=Constants.SCREENSHOTS_FILEPATH+fileName+timeStamp+".png";

		try {
			FileUtils.copyFile(file, new File(scrshotFile));
		} catch (IOException e) {
			System.out.println("Cannot take a screenshot");
		}

		return picture ;
	}
	public static void sendText(WebElement element,String value) {
		element.clear();
		element.sendKeys(value);
	}
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_LOAD_TIME);
		return wait;
	}
	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForInvisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.invisibilityOf(element));
	}

	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	public static void selectDdValue(WebElement element, String visibleText) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();

		boolean isFound = false;
		for (WebElement option : options) {
			if (option.getText().equals(visibleText)) {
				select.selectByVisibleText(visibleText);
				isFound = true;
				break;
			}
		}

		if (!isFound) {
			System.out.println("Value " + visibleText + "was not found in the dropdown");
		}
	}

	/**
	 * This method will select value from dd
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDdValue(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isFound = false;
		if (options.size() > index) {
			select.selectByIndex(index);
			isFound = true;
		}

		if (!isFound) {
			System.out.println("Value with index " + index + "was not selected");
		}
	}

	/**
	 * This method will click on the radio based on the text
	 * 
	 * @param elements
	 * @param radioText
	 */
	public static void clickRadio(List<WebElement> elements, String radioText) {

		for (WebElement el : elements) {

			if (el.getText().equals(radioText)) {
				el.click();
				break;
			}
		}
		}
	static String jsonFile;
	public static String readJson(String fileName) {
		try {
			jsonFile = new String (Files.readAllBytes(Paths.get(fileName)));
		}catch (IOException e) {
			e.printStackTrace();
		}
		return jsonFile;
		
	}
	}
	
	




