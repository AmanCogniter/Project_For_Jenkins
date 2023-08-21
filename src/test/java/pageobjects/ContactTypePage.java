package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.DateFormat;
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

public class ContactTypePage extends WebBasePage {

	WebDriver driver;
	
	static String ContactTypeName;
	static String Activestatus;
	static String InActivestatus;
	

	String pattern = "yyMMddHHmmss";

	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String dateValue = dateformat.format(date);
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public ContactTypePage(WebDriver driver) {

		super(driver, "Contact Type Page");
		this.driver = driver;

	}

	public void clickFullMenuDropDown() {
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);
		staticWait(2000);
	}
	
	public void clickCompanySetupLink() {
		//click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"), "Company Setup Link", 30);
		click(By.xpath("//li[@data-name='COMPANY SETUP']"), "Company Setup Link", 30);
		staticWait(2000);
	}

	public void clickCompanySetupPage() {
		click(By.xpath("(//a[contains(text(),'Company Setup')])[last()]"), " Company Setup Page", 30);
		staticWait(2000);
	}

	public void clickOnContactType() {
		clickByJavascript(By.xpath("//a[text()='Contact Type']"), "Contact Type", 20);
		staticWait(2000);
	}
	
	public void clickAddContact()
	{
		click(By.id("ancontacttype"),"Add Contact Button", 20);
	}
	
	public void contactTypeName()
	
	
	{
		String contacttypenameValue = prop.getProperty("contactTypeName")+ dateValue;
		enter(By.id("Name"), contacttypenameValue,  " Contact Type Name", 30);
		ContactTypeName= contacttypenameValue;
		
	}
	
	 public void selectStatus()
	 {
		 
		 selectValueWithText(By.id("StatusId"), prop.getProperty("contactType"), "Contact Type", 30);
	 }
	 
	  public void saveButton()
	  {
		  
		  click(By.id("btnSave"), "Save Button", 25);
	  }
	
	  public void cancelButton()
	  {
		  click(By.xpath("//a[text()='Cancel']"), "Cancel Button", 20);
	  }
	  
	  
	  public void VerifyMandatoryFieldValidation() {
			int i = 0;
			String actualText;
			String expectedText;

			List<WebElement> errorMessageLocator = findMultipleElement(
					By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
			String[] expectedValue = { "Contact Type","Status","Type" };
			for (Object expected : expectedValue) {
				WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()='"+ expected +"']/ancestor::div[@class='form-group']/descendant::span[@class='mandatory']"), 45);
				if (AsteriskField != null) {
					getTest().log(LogStatus.PASS, "The Asterisk symbol is displayed for " + expected + " field");
					logger.info("The Asterisk symbol is displayed for " + expected + " field");
				} else {
					getTest().log(LogStatus.FAIL, "The Asterisk symbol is not displayed for " + expected + " field");
					logger.info("The Asterisk symbol is not displayed for " + expected + " field");
					takeScreenshot(expected.toString());
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

		public void UserGuideAndCancel() {
			click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"), "Open User Guide", 20);
			click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"), "Close User Guide", 20);
			clickByJavascript(By.xpath("//a[text()='Cancel']"), "Click on Cancel Button", 25);
		}
		
		public void Entersearch()
		{
			staticWait(1000);
			enter(By.id("search"),ContactTypeName , "Enter search Data", 20);
		}

		public void refresh() {
			clickByJavascript(By.xpath("//i[@class='fa fa-refresh']"), " Refresh Button", 25);
		}

		public void searchButton() {
			staticWait(1000);
			clickByJavascript(By.id("Go"), "Search Button", 20);
			staticWait(1000);

		}
		
		public void clickContactTypeName()
		{
			click(By.xpath("//table[@id='tblContactType']//a"), "Contact Type Name", 25);
		}

		
		
		public void activeActionButton() {
			clickByJavascript(By.xpath("//a[@id='ancActInact']//span[contains(text(),' Active')]"), "Active Action Button",20);
			String activeText = getText(By.xpath("//a[@id='ancActInact']//span"), 24);
			Activestatus = activeText;
		}

		public void inactiveActionButton() {
			clickByJavascript(By.xpath("//a[@id='ancActInact']//span[contains(text(),'  Inactive')]"),
					"Inactive Action Button", 20);
			String inactiveText = getText(By.xpath("//a[@id='ancActInact']//span"), 24);
			InActivestatus = inactiveText;
		}

		public void okConfirmButton() {
			click(By.xpath("//button[@title='OK']"), "ok Button", 20);
			staticWait(2000);
			driver.navigate().refresh();

		}

		public void verifyActiveStatusValue() {
			verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Channel Status Value",
					prop.getProperty("activeStatus"), 20);
		}

		public void verifyInactiveStatusValue() {
			verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Channel Status Value",
					prop.getProperty("inactiveStatus"), 20);
		}

		public void selectcheckbox() {
			staticWait(2000);
			clickByJavascript(By.xpath("//input[@id='chk_1']"), "Click on checkbox", 25);
		}

		public void deleteButton() {

			click(By.id("DeleteMultiple"), "Delete Button", 25);

		}
		


}
