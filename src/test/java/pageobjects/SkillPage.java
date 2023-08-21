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

public class SkillPage extends WebBasePage {

	WebDriver driver;

	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String skillnewname;
	static String Activestatus;
	static String InActivestatus;

	public SkillPage(WebDriver driver) {

		super(driver, "skill page");
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

	public void clickOnSkill() {
		clickByJavascript(By.xpath("//a[text()='Skill']"), "Skill", 20);
		staticWait(2000);
	}

	public void clickOnAdd() {

		click(By.xpath("//a[@id='ancCreateSkill']"), "Add Skill", 25);
	}

	public void save() {
		clickByJavascript(By.xpath("//a[@id='btnSave']"), "Save Skill Name", 20);
		staticWait(3000);
	}

	public void VerifyMandatoryFieldValidation() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Title" };
		for (Object expected : expectedValue) {
			//WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()='" + expected + ":']"), 45);
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
		clickByJavascript(By.xpath("//a[text()=' Cancel']"), "Click on Cancel Button", 25);
	}

	public void enterTitleName() {
		staticWait(2000);
		String skillname = prop.getProperty("skilltitle") + datevalue;
		//enter(By.id("SkillTitle"), skillname, "skill Title", 25);
		enter(By.xpath("//tg-input/descendant::input[@id='SkillId']"), skillname, "skill Title", 25);
		skillnewname = skillname;
	}

	public void Description() {

		enter(By.xpath("//textarea[@id='Description']"), prop.getProperty("Description"), "Enter Description", 20);
	}

	public void enterSearchText() {
		staticWait(2000);

		enter(By.id("search"), skillnewname, "Enter Text in Shift field", 25);
	}

	public void refresh() {
		clickByJavascript(By.xpath("//i[@class='fa fa-refresh']"), " Refresh Button", 25);
	}

	public void searchButton() {
		staticWait(1000);
		clickByJavascript(By.id("Go"), "Search Button", 20);
		staticWait(1000);

	}

	public void clickSkillName() {
		staticWait(2000);
		click(By.xpath("//table[@id='tblSkill']//a"), "Skill Name", 25);
	}

	public void verifyUpdateConfirmationMessage() {
		String Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText();
		if (Message.equals("Skill has been successfully updated.")) {
			getTest().log(LogStatus.PASS, "Skill has been successfully updated.");
			logger.info("Skill has been successfully updated.");
		} else {
			getTest().log(LogStatus.FAIL, "Skill  has not been successfully updated.");
			logger.info("Skill has not been successfully updated.");
			takeScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName());
			// Assert.fail("" + e);
		}
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
	//		driver.navigate().refresh();

		}
		
		public void selectcheckbox() {
			clickByJavascript(By.xpath("//input[@id='chk_1']"), "Click on checkbox", 25);
		}

		public void deleteButton() {

			click(By.id("DeleteMultiple"), "Delete Button", 25);

		}
		
		public void verifyDeleteConfirmationMessage()
		{
			String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
			 if(Message.equals("Skill has been successfully deleted."))
			 {
				 getTest().log(LogStatus.PASS, "Skill has been successfully deleted.");
	            logger.info("Skill has been successfully deleted.");	
			 }
			 else
			 {
				 getTest().log(LogStatus.FAIL, "Skill has not been successfully deleted." );
	            logger.info("Skill has not been successfully deleted.");
	            takeScreenshot(new Object() {
	            }.getClass().getEnclosingMethod().getName());
	            //Assert.fail("" + e);
			 }
		}
		
		public void verifyActiveStatusValue() {
			verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Skill Status Value",
					prop.getProperty("activeStatus"), 20);
		}

		public void verifyInactiveStatusValue() {
			verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Skill Status Value",
					prop.getProperty("inactiveStatus"), 20);
		}
		
		public void verifyStatusConfirmationMessage()
		{
			String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
			 if(Message.equals("Status has been successfully updated."))
			 {
				 getTest().log(LogStatus.PASS, "Skill Status has been successfully updated.");
	            logger.info("Skill Status has been successfully updated.");	
			 }
			 else
			 {
				 getTest().log(LogStatus.FAIL, "Skill Status has not been successfully updated." );
	            logger.info("Skill Status has not been successfully updated.");
	            takeScreenshot(new Object() {
	            }.getClass().getEnclosingMethod().getName());
	            //Assert.fail("" + e);
			 }
		}
		
    

}
