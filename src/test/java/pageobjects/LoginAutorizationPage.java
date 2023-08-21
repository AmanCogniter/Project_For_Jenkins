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

public class LoginAutorizationPage extends WebBasePage 
{
	
	
	WebDriver driver;

	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String LoginAuthorization;
	static String Activestatus;
	static String InActivestatus;
	static String StartIP;
	static String EndIP;
	


	public LoginAutorizationPage(WebDriver driver) {

		super(driver, "Login Authorization page");
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
		click(By.xpath("//a[contains(text(),'Company Setup')]"), " Company Setup Page", 30);
		staticWait(2000);
	}

	public void clickOnLoginAuthorization() {
		clickByJavascript(By.xpath("//ul[@id='upper']//li/a[text()='Login Authorization']"), "Login Authorization", 20);
		staticWait(2000);
	}
	
	public void clickOnAdd() {

		click(By.xpath("//a[@id='ancCreateLoginAuthorization']"), "Add Login Authorization", 25);
	}

	public void save() {
		clickByJavascript(By.xpath("//a[@id='btnSave']"), "Save Login Authorization Name", 20);
		staticWait(3000);
	}

	public void VerifyMandatoryFieldValidation() {
		try {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = {"Starting IP","Ending IP","Description"};
		for (Object expected : expectedValue) {
			WebElement AsteriskField = findElementVisibility(By.xpath("//form[@id='AddEditLoginAuthorization']//label[text()='" + expected + ":']"), 45);
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
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
	public void UserGuideAndCancel() {
		click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"), "Open User Guide", 20);
		click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"), "Close User Guide", 20);
		clickByJavascript(By.xpath("//a[text()=' Cancel']"), "Click on Cancel Button", 25);
	}
	
	
	 public void enterStartingIP()
	 {
		 String StartingIP = prop.getProperty("startingIP");
		 enter(By.xpath("//input[@id='starting_ip']"), StartingIP, "Starting IP", 25);
		 StartIP=StartingIP;
	 }
	 
	  public void enterEndingIP()
	  {
		  String EndingIP = prop.getProperty("endingIP");
			 enter(By.xpath("//input[@id='ending_ip']"), EndingIP, "Ending IP", 25);
			 EndIP=EndingIP;
	  }
	  public void enterDescription() {
			enter(By.id("description"), prop.getProperty("Description"), "Login Authorization Description", 25);
		}
	 
	  
	  
	  public void enterSearchText() {
			staticWait(2000);

			enter(By.id("search"), StartIP, "Enter Text in Starting IP field", 25);
		}

		public void refresh() {
			clickByJavascript(By.xpath("//i[@class='fa fa-refresh']"), " Refresh Button", 25);
		}

		public void searchButton() {
			staticWait(1000);
			clickByJavascript(By.id("Go"), "Search Button", 20);
			staticWait(1000);

		}
		
		public void clickStartingIP() {
			staticWait(2000);
			click(By.xpath("//table[@id='tblLoginAuthorization']//a"), "Starting IP", 25);
		}

		public void verifyUpdateConfirmationMessage() {
			String Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText();
			if (Message.equals("IP Address has been successfully updated.")) {
				getTest().log(LogStatus.PASS, "IP Address has been successfully updated.");
				logger.info("IP Address has been successfully updated.");
			} else {
				getTest().log(LogStatus.FAIL, "IP Address has been successfully updated.");
				logger.info("IP Address has been successfully updated.");
				takeScreenshot(new Object() {
				}.getClass().getEnclosingMethod().getName());
				// Assert.fail("" + e);
			}
		}
	
		
		public void selectcheckbox() {
			clickByJavascript(By.xpath("//input[@id='chk_1']"), "Click on checkbox", 25);
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
			
			
			public void deleteButton() {

				click(By.id("DeleteMultiple"), "Delete Button", 25);

			}
			
			public void verifyDeleteConfirmationMessage()
			{
				String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
				 if(Message.equals("IP Address has been successfully deleted."))
				 {
					 getTest().log(LogStatus.PASS, "Login Authorization has been successfully deleted.");
		            logger.info("Login Authorization has been successfully deleted.");	
				 }
				 else
				 {
					 getTest().log(LogStatus.FAIL, "Login Authorization has not been successfully deleted." );
		            logger.info("Login Authorization has not been successfully deleted.");
		            takeScreenshot(new Object() {
		            }.getClass().getEnclosingMethod().getName());
		            //Assert.fail("" + e);
				 }
			}
			
			public void verifyActiveStatusValue() {
				verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Trip Status Value",
						prop.getProperty("activeStatus"), 20);
			}

			public void verifyInactiveStatusValue() {
				verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Trip Status Value",
						prop.getProperty("inactiveStatus"), 20);
			}
			
			public void verifyStatusConfirmationMessage()
			{
				String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
				 if(Message.equals("Status has been successfully updated."))
				 {
					 getTest().log(LogStatus.PASS, "Login Authorization has been successfully updated.");
		            logger.info("Login Authorization has been successfully updated.");	
				 }
				 else
				 {
					 getTest().log(LogStatus.FAIL, "Login Authorization has not been successfully updated." );
		            logger.info("Login Authorization has not been successfully updated.");
		            takeScreenshot(new Object() {
		            }.getClass().getEnclosingMethod().getName());
		            //Assert.fail("" + e);
				 }
			}
			

		
	

	
	

}
