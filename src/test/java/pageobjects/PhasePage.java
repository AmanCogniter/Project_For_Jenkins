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

public class PhasePage extends WebBasePage {
	

	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);
	
	
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String phasenewname;
	static String Activestatus;
	static String InActivestatus;
	public PhasePage(WebDriver driver) {

		super(driver, "Phase page");
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

	public void clickOnPhase() {
		clickByJavascript(By.xpath("//a[text()='Phase']"), "Phase", 20);
		staticWait(2000);
	}
	

	public void clickOnAdd() {

		click(By.xpath("//a[@id='ancCreatePhase']"), "Add Phase", 25);

	}
	
	public void save() {
		clickByJavascript(By.xpath("//a[@id='btnSave']"), "Save Phase Name", 20);
		waitForLoad(20);
		staticWait(2000);
	}
	public void closeManagePhase() {
		staticWait(3000);
		click(By.xpath("//div[@class='modal-header ui-draggable-handle']/h5[text()='Manage Phase']/ancestor::div[@class='modal-content']/descendant::button[@data-original-title='Close']"), " Close Manage Phase", 30);
	}
	
	public void VerifyMandatoryFieldValidation() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Phase Name" };
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
	
	public String enterPhaseName() {

		String phasename = prop.getProperty("phase") + datevalue;
		System.out.println(phasename);
		enter(By.id("PhaseName"), phasename, "PhaseName", 25);
		phasenewname = phasename;
		
		return phasename;

	}

	public void enterDescription() {
		enter(By.id("PhaseDescription"), prop.getProperty("Description"), "Phase Description", 25);
	}
	

	public void enterSearchText() {
		staticWait(2000);

		enter(By.id("search"), phasenewname, "Enter Text in Phase field", 25);
	}

	public void refresh() {
		clickByJavascript(By.xpath("//i[@class='fa fa-refresh']"), " Refresh Button", 25);
	}

	public void searchButton() {
		staticWait(1000);
		clickByJavascript(By.id("Go"), "Search Button", 20);
		staticWait(1000);

	}

	public void clickPhaseName()
	{
		click(By.xpath("//table[@id='tblPhase']//a"), "Phase Name", 25);
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
		//driver.navigate().refresh();

	}

	public void verifyActiveStatusValue() {
		verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Phase Status Value",
				prop.getProperty("activeStatus"), 20);
	}

	public void verifyInactiveStatusValue() {
		verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Phase Status Value",
				prop.getProperty("inactiveStatus"), 20);
	}
	
	public void verifyStatusConfirmationMessage()
	{
	
		String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
		logger.info(Message);
		 if(Message.contains("Status has been successfully updated."))
		 {
			 getTest().log(LogStatus.PASS, "Phase Status has been successfully updated.");
            logger.info("Phase Status has been successfully updated.");	
		 }
		 else
		 {
			 getTest().log(LogStatus.FAIL, "Phase Status has not been successfully updated." );
            logger.info("Phase Status has not been successfully updated.");
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            //Assert.fail("" + e);
		 }
	}
	public void verifyAddConfirmationMessage()
	{
		String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
		 if(Message.equals("Phase successfully added."))
		 {
			 getTest().log(LogStatus.PASS, "Phase has been successfully added.");
            logger.info("Phase has been successfully added.");	
		 }
		 else
		 {
			 getTest().log(LogStatus.FAIL, "Phase  has not been successfully added." );
            logger.info("Phase has not been successfully added.");
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            //Assert.fail("" + e);
		 }
	}

	public void verifyUpdateConfirmationMessage()
	{
		String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
		 if(Message.equals("Phase has been successfully updated."))
		 {
			 getTest().log(LogStatus.PASS, "Phase has been successfully updated.");
            logger.info("Phase has been successfully updated.");	
		 }
		 else
		 {
			 getTest().log(LogStatus.FAIL, "Phase  has not been successfully updated." );
            logger.info("Phase has not been successfully updated.");
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            //Assert.fail("" + e);
		 }
	}
	public void verifyDeleteConfirmationMessage()
	{
		
		String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
		 if(Message.contains("Phase has been successfully deleted."))
		 {
			 getTest().log(LogStatus.PASS, "Phase has been successfully deleted.");
            logger.info("Phase has been successfully deleted.");	
		 }
		 else
		 {
			 getTest().log(LogStatus.FAIL, "Phase has not been successfully deleted." );
            logger.info("Phase has not been successfully deleted.");
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            //Assert.fail("" + e);
		 }
	}
	public void selectcheckbox() {
		clickByJavascript(By.xpath("//input[@id='chk_1']"), "Click on checkbox", 25);
	}

	public void deleteButton() {

		click(By.id("DeleteMultiple"), "Delete Button", 25);

	}
	
	public void HandleSuccessMessage()
    
    {
   	 click(By.xpath("//Button[@id='closenotifymessage']"), " Close Success Message", 25);
    }



}
