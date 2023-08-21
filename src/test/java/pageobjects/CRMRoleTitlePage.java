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

public class CRMRoleTitlePage extends WebBasePage {
WebDriver driver;
	
	
	static String titleName;
	static String afterSearchValue;
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

	public CRMRoleTitlePage(WebDriver driver) {

		super(driver, "CRMRoleTitlePage");
		this.driver = driver;

	}

	public void clickFullMenuDropDown() {
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);
		staticWait(2000);
	}
	
	public void clickCompanySetupLink() {

		click(By.xpath("//li[@data-name='COMPANY SETUP']"), "Company Setup Link", 30);
		staticWait(2000);
	}

	public void clickCompanySetupPage() {
		click(By.xpath("(//a[contains(text(),'Company Setup')])[last()]"), " Company Setup Page", 30);
		staticWait(2000);
	}
	public void clickOnCRMRoleTitle() {
		clickByJavascript(By.xpath("//a[@data-text='CRMRoleTitle']"), "CRM Role Title", 20);
		staticWait(2000);
	}
	public void clickAddCRMRoleTitle()
	{
		click(By.xpath("//a[@id='ancRoletitle']"),"Add CRM Role Title Button", 20);
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
				By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = {"Role Title"};
		for (Object expected : expectedValue) {
			WebElement asterikField = findElementVisibility(By.xpath("//label[text()='"+ expected +"']/ancestor::div[@class='form-group']/descendant::span[@class='mandatory']"), 45);

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
	
	
	
	public void cancelButton() {
		clickByJavascript(By.id("ancgotolistscreen"), " Cancel Button", 25);
	}
	public void enterCRMRoleTitle()
	
	{
		staticWait(3000);
		String name = prop.getProperty("titlename")+dateValue ;
		titleName = name;
		
		enter(By.xpath("//input[@id='RoleTitle']"), name, "Title Name", 25);
	}
	
	 public void enterCRMRoleTitleDescription()
	 {
		 enter(By.xpath("//tg-textarea/label[text()='Description']/following-sibling::textarea[@name='RoleTitleDescription']"),prop.getProperty("Description"),"Description", 25);
	 }
	 public void searchCRMRoleTitle()
		{
			enter(By.xpath("//input[@id='search']"), titleName, "Search Field ", 25);
		}
	 public void searchButton()
		{
			clickByJavascript(By.id("Go"), " Search Button", 25);
			String SearchedValue = getText(By.id("ancEditRoleTitle"), 25);
			afterSearchValue= SearchedValue;
			verifySearchRecord(By.id("ancEditRoleTitle"), titleName, "Title Name", 25);
			
			
			staticWait(4000);	
		}
	 public void editCRMRoleTitle() 
	 {
		 click(By.xpath("//a[contains(text(),'"+titleName+"')]"), "Edit CRM Role Title", 45); 
	 }
	 public void selectAllCRMRoleTitle()
	 {
			click(By.xpath("//table[@id='tblRoleTitle']/thead/tr/th/div[@class='custom-control custom-checkbox']"), "Select all CRM Role Title", 45);

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
	 }
	 public void verifyActiveStatusValue()
	 {
		 verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "CRM Role Title Status Value", prop.getProperty("activeStatus"), 20);
	 }
	 public void verifyInactiveStatusValue()
	 {
		 verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "CRM Role Title Status Value", prop.getProperty("inactiveStatus"), 20);
	 }
	 
	 public void deleteButton()
	 { 
		 
		 click(By.id("DeleteMultiple"), "Delete Button",25);
		 
	 }

}


