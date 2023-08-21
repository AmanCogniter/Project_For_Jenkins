package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class TrainingFeedbackPage  extends WebBasePage {
	
	
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);
	
	static String FeedbackTitle;
	
	static String Activestatus;
	static String InActivestatus;
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public TrainingFeedbackPage(WebDriver driver) {
		super(driver, " Training Feedback Page");
		this.driver = driver;	
	}
	
	public void clickFullMenuDropDown() {
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);
		staticWait(2000);
	}

	public void clickCompanySetupLink() {
		//click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"), "Company Setup Link", 30);
		click(By.xpath("//li[@data-name='COMPANY SETUP']"),"Company Setup Link", 30);
		staticWait(2000);
	}

	public void clickCompanySetupPage() {
		click(By.xpath("(//a[contains(text(),'Company Setup')])[last()]"), " Company Setup Page", 30);
		staticWait(2000);
	}

	public void clickTrainingFeedbackTab() {
		//click(By.xpath("//a[text()='Training Feedback']"), "Training Feedback Tab", 20);
		//staticWait(2000);
		
		
		enter(By.xpath("//input[@placeholder='Search by Name']"),"Training Feedback","Search Training Feedback Name" , 25);
		click(By.xpath("//input[@placeholder='Search by Name']/..//span"), "Click on search", 30);
		click(By.xpath("//a[text()='Training Feedback']"), "Training Feedback Tab", 20);
		staticWait(2000);
	}
	
	public void AddButton() {
		clickByJavascript(By.id("ancCreateTicketFeedBack"), "Add Training feedback", 25);
	}

	public void Save() {
		clickByJavascript(By.id("btnSave"), "save button", 30);
		staticWait(2500);
	}
	
	
	public void VerifyMandatoryFieldValidation() {

		int i = 0;

		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 20);
		String[] expectedValue = {"Title"};
		for (Object expected : expectedValue) {
			WebElement asterikField = findElementVisibility(By.xpath("//table[@id='tableGlobalTaskList']//span[text()='" + expected + "']"), 20);

			if (asterikField != null) {
				getTest().log(LogStatus.PASS, "The Asterisk symbol is displayed for" + expected + " field");
				logger.info("The Asterisk symbol is displayed for " + expected + " field");

			} else {
				getTest().log(LogStatus.FAIL, "The Asterisk symbol is not displayed for" + expected + " field");
				logger.info("The Asterisk symbol is not displayed for " + expected + " field");

			}

			List<WebElement> expectedElements = errorMessageLocator;
			for (WebElement element : expectedElements) {
				i++;
				actualText = element.getText();
				expectedText = expected.toString();

				if (actualText.indexOf(expectedText) != -1) {
					getTest().log(LogStatus.PASS,
							"Error message for \"" + expected + "\" field is displayed as expected");
					logger.info("Error message for \"" + expected + "\" field is displayed as expected");
					i = 0;
					break;
				} else if (i == expectedValue.length && !element.getText().contains(expectedText)) {
					getTest().log(LogStatus.FAIL, "Error message for \"" + expected + "\" field is not displayed");
					logger.info("Error message for \"" + expected + "\" field is displayed as expected");
					takeScreenshot(expectedText);
				}
			}

		}
	}
	
	public void enterTitleName()
	 {
		 
		 FeedbackTitle= prop.getProperty("trainingfeedbacktitle")+datevalue;
		 enter(By.xpath("//table[@id='tableGlobalTaskList']//tbody/tr[4]//input[@id='taskname']"), FeedbackTitle, "Feedback Name", 25);
	 }
	
	 public void enterDescription()
	 {
		 String  description = prop.getProperty("Description");
		 enter(By.xpath("//table[@id='tableGlobalTaskList']//tbody/tr[4]//textarea[@id='taskdescription']"), description, "Description", 25);
	 }
	 
	 public void Search()
		{
		 driver.navigate().refresh();
			enter(By.id("search"), FeedbackTitle, "Search Field ", 25);
		}
		
		public void searchButton()
		{
			clickByJavascript(By.id("Go"), " Search Button", 25);
			
			verifySearchRecord(By.xpath("//a[@id='ancEditphase']"), FeedbackTitle, "Feedback Search", 25);
		}
		
		
		

		public void refresh()
		{
			clickByJavascript(By.xpath("//i[@class='fa fa-refresh']")," Refresh Button", 25);
		}
		
		
		public void editFeedback()
		{
			clickByJavascript(By.xpath("//a[@id='ancEditphase']/span"), "Edit Feedback", 25);
			
		}
	
		public void selectAll()
		{
			clickByJavascript(By.xpath("//input[@id='chkAll_0']"), "Select All", 25);
		}

		public void activeActionButton()
		 {
			 clickByJavascript(By.xpath("//a[@id='ancActInact']//span[contains(text(),' Active')]"),"Active Action Button", 20);
			 String activeText = getText(By.xpath("//a[@id='ancActInact']//span"),24);
			 Activestatus=activeText;
			 
			 
			 
		 }
		 
		 public void inactiveActionButton()
		 {
			 clickByJavascript(By.xpath("//a[@id='ancActInact']//span[contains(text(),'  Inactive')]"),"Inactive Action Button", 20);
		 String inactiveText = getText(By.xpath("//a[@id='ancActInact']//span"),24);
		 InActivestatus=inactiveText;
		 }
		 public void okConfirmButton()
		 {
			 click(By.xpath("//button[@title='OK']"),"ok Button", 20);
			 staticWait(2000);
			 driver.navigate().refresh();
				/*
				 *  WebElement
				 * statuselement
				 * =driver.findElement(By.xpath("//div[@class='cstm-drop-btn']/select")); Select
				 * select = new Select(statuselement); String selectedValue=
				 * select.getFirstSelectedOption().getText(); System.out.println(selectedValue);
				 */
		 }
		 
		 public void verifyActiveStatusValue()
		 {
			 verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Training Feedback Status Value", prop.getProperty("activeStatus"), 20);
		 }
		 public void verifyInactiveStatusValue()
		 {
			 verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Training Feedback Status Value", prop.getProperty("inactiveStatus"), 20);
		 }
		 
		 public void deleteButton()
		 { 
			 
			 click(By.id("DeleteMultiple"), "Delete Button",25);
			 
		 }
		 
		 public void selectcheckbox()
			{
				clickByJavascript(By.xpath("//input[@id='chk_1']"), "Click on checkbox", 25);
			}

}
