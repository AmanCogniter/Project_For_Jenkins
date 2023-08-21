package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class PaymentGatewayPage extends WebBasePage {
	
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	
	static String Activestatus;
	static String InActivestatus;
	static String Authorizedotnet;
	static String Paypal;
	static String Stripe;
	
	public PaymentGatewayPage (WebDriver driver)
	{
		super(driver,"PaymentGateway");
		this.driver= driver;
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

	public void clickPaymentGatewayTab() {
		
		click(By.xpath("//a[@role='tab'][normalize-space()='Payment Gateway Type']"), "Payment Gateway Tab", 20);
		staticWait(2000);
	}
	
	 public void clickOnAddPaymentGateway()
	 {
		 clickByJavascript(By.id("ancCreatePaymentGateway"), "Add Payment Gateway", 25);
	 }
	
	 

		public void Save() {
			clickByJavascript(By.id("btnSave"), "save button", 30);
			staticWait(2500);
		}
		
		
		 public void deleteMultipleRecord() {
			 
			int listOfRows = driver.findElements(By.xpath("//table[@id='tblPaymentGateway']//tbody/tr")).size();
			
			//System.out.println(listOfRows);
			WebElement record = driver.findElement(By.xpath("//table[@id='tblPaymentGateway']//tbody/tr[1]/td[1]"));
			String value = record.getText().trim();
			if(!value.equals("No record(s) found"))
			{
				staticWait(1000);
				clickByJavascript(By.xpath("//input[@id='chkAll_0']"),"Click on Multi Select", 25);
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, -250);");
				
				deleteButton();
				okConfirmButton();
				
			}
			else
			{
				System.out.println(" No records available");
			}
			

			
			 
			 
			 
		 }
		
		
		public void VerifyMandatoryFieldValidation() {
			
			

			int i = 0;

			String actualText;
			String expectedText;

			List<WebElement> errorMessageLocator = findMultipleElement(
					By.xpath("//div[@class='modal-content']//span[@class='invalid-feedback']"), 45);
			//String[] expectedValue = {"Payment Gateway Type","Status","Description"};
			String[] expectedValue = {"Payment Gateway Type","Description"};
			for (Object expected : expectedValue) {
				WebElement asterikField = findElementVisibility(By.xpath("//label[text()='" + expected + "']"), 45);

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

		
		public void openAndCloseUserGuide() {
			click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"), "Open User Guide", 45);
			click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"), "Close User Guide", 45);
		}
		
		
		public void selectPaymentGatewayType()
		{
			
			//deleteMultipleRecord();
			
			clickOnAddPaymentGateway();
			String paymentgatewaytypename;
			for(int count=1;count<=3;count++)
			{
				
//				if(count!=3)
//				{
//					clickOnAddPaymentGateway();
//				}
////				else
//			{
//			logger.info("Add Payment Gateway link not clicked");
//			}
				
				selectValueWithIndex(By.xpath("//select[@id='ddlPaymantGatewayType']"),count,"Payment Gateway",25);
				Select  select = new Select(driver.findElement(By.xpath("//select[@id='ddlPaymantGatewayType']")));
				
				 paymentgatewaytypename = select.getFirstSelectedOption().getText();
				 
				 System.out.println(paymentgatewaytypename);
				 
				 if (paymentgatewaytypename.equals("Authorize Dot Net"))
				 {
					 enterDataAuthorizeDotNet();
					 Save();
					 
					 String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
					 if(Message.equals("Payment Gateway Type has been successfully added."))
					 {
						 getTest().log(LogStatus.PASS, "Payment Gateway Type has been successfully added.");
		                 logger.info("Payment Gateway Type has been successfully added.");	
					 }
					 else if(Message.equals("Payment Gateway Type already exists"))
					 {
						 getTest().log(LogStatus.FAIL, "Payment Gateway Type already exists" );
		                 logger.info("Payment Gateway Type already exists");
		                 takeScreenshot(new Object() {
		                 }.getClass().getEnclosingMethod().getName());
		                 //Assert.fail("" + e);
					 }
					 driver.navigate().refresh();
					 clickOnAddPaymentGateway();
					 
					 
				 }
				 else if (paymentgatewaytypename.equals("Pay Pal"))
				 {
					 
					 
					 
					 enterdataPayPal();
					 Save();
					 String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
					 if(Message.equals("Payment Gateway Type has been successfully added."))
					 {
						 getTest().log(LogStatus.PASS, "Payment Gateway Type has been successfully added.");
		                 logger.info("Payment Gateway Type has been successfully added.");	
					 }
					 else if(Message.equals("Payment Gateway Type already exists"))
					 {
						 getTest().log(LogStatus.FAIL, "Payment Gateway Type already exists" );
		                 logger.info("Payment Gateway Type already exists");
		                 takeScreenshot(new Object() {
		                 }.getClass().getEnclosingMethod().getName());
		                 //Assert.fail("" + e);
					 }
					 driver.navigate().refresh();
					 clickOnAddPaymentGateway();
				}
				 else if (paymentgatewaytypename.equals("Stripe")) {
					 stripePaymentway();
					 Save();
					 String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
					 if(Message.equals("Payment Gateway Type has been successfully added."))
					 {
						 getTest().log(LogStatus.PASS, "Payment Gateway Type has been successfully added.");
		                 logger.info("Payment Gateway Type has been successfully added.");	
					 }
					 else if(Message.equals("Payment Gateway Type already exists"))
					 {
						 getTest().log(LogStatus.FAIL, "Payment Gateway Type already exists" );
		                 logger.info("Payment Gateway Type already exists");
		                 takeScreenshot(new Object() {
		                 }.getClass().getEnclosingMethod().getName());
		                 //Assert.fail("" + e);
					 }
					 driver.navigate().refresh();	
				}
				
				 
				 
			}	
		}
		
		
		public void editPaymentGatwayType()
		{
			
			enterSearchText();
			searchButton();
			refresh();
			enterSearchText();
			 searchButton();	
			 clickPaymentGatewayName();
			 Save();
			 verifyUpdateConfirmationMessage();
		}
		
		 public void editPaymentGatwayTypeOLD()
		 {
			 String paymentgatewaytypename;
			 for(int count=1;count<=3;count++)
				{
					
//					if(count!=3)
//					{
//						clickOnAddPaymentGateway();
//					}
////					else
//				{
//				logger.info("Add Payment Gateway link not clicked");
//				}
					
					selectValueWithIndex(By.xpath("//select[@id='ddlPaymantGatewayType']"),count,"Payment Gateway",25);
					Select  select = new Select(driver.findElement(By.xpath("//select[@id='ddlPaymantGatewayType']")));
					
					 paymentgatewaytypename = select.getFirstSelectedOption().getText();
					 
					 System.out.println(paymentgatewaytypename);
					 
					 if (paymentgatewaytypename.equals("Authorize Dot Net"))
					 {
						 enterDataAuthorizeDotNet();
						 Save();
						 
						 String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
						 if(Message.equals("Payment Gateway Type has been successfully updated."))
						 {
							 getTest().log(LogStatus.PASS, "Payment Gateway Type has been successfully updated.");
			                 logger.info("Payment Gateway Type has been successfully updated.");	
						 }
						 else if(Message.equals("Payment Gateway Type already exists"))
						 {
							 getTest().log(LogStatus.FAIL, "Payment Gateway Type already exists" );
			                 logger.info("Payment Gateway Type already exists");
			                 takeScreenshot(new Object() {
			                 }.getClass().getEnclosingMethod().getName());
			                 //Assert.fail("" + e);
						 }
						 driver.navigate().refresh();
						 clickOnAddPaymentGateway();
						 
						 
					 }
					 else if (paymentgatewaytypename.equals("Pay Pal"))
					 {
						 enterdataPayPal();
						 Save();
						 String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
						 if(Message.equals("Payment Gateway Type has been successfully updated."))
						 {
							 getTest().log(LogStatus.PASS, "Payment Gateway Type has been successfully updated.");
			                 logger.info("Payment Gateway Type has been successfully updated.");	
						 }
						 else if(Message.equals("Payment Gateway Type already exists"))
						 {
							 getTest().log(LogStatus.FAIL, "Payment Gateway Type already exists" );
			                 logger.info("Payment Gateway Type already exists");
			                 takeScreenshot(new Object() {
			                 }.getClass().getEnclosingMethod().getName());
			                 //Assert.fail("" + e);
						 }
						 driver.navigate().refresh();
						 clickOnAddPaymentGateway();
					}
					 else if (paymentgatewaytypename.equals("Stripe")) {
						 stripePaymentway();
						 Save();
						 String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
						 if(Message.equals("Payment Gateway Type has been successfully updated."))
						 {
							 getTest().log(LogStatus.PASS, "Payment Gateway Type has been successfully updated.");
			                 logger.info("Payment Gateway Type has been successfully updated.");	
						 }
						 else if(Message.equals("Payment Gateway Type already exists"))
						 {
							 getTest().log(LogStatus.FAIL, "Payment Gateway Type already exists" );
			                 logger.info("Payment Gateway Type already exists");
			                 takeScreenshot(new Object() {
			                 }.getClass().getEnclosingMethod().getName());
			                 //Assert.fail("" + e);
						 }
						 driver.navigate().refresh();	
					}
				}
		 }
		
		
		
		public void enterDataAuthorizeDotNet()
		{
			enter(By.xpath("//input[@label='API Login Id']"),prop.getProperty("APIID"),"Api Login ID",25);
			enter(By.xpath("//input[@label='Transaction Key']"),prop.getProperty("transactionKey"),"Transaction Key",25);
			
			enter(By.id("txtdescription"),prop.getProperty("Description"),"Description",20);
			
		}
		
		public void enterdataPayPal()
		{
			enter(By.xpath("//input[@label='User Name']"), prop.getProperty("username"), "User name", 25);
			enter(By.xpath("//input[@label='Password']"), prop.getProperty("password"), "Password", 25);
			enter(By.xpath("//input[@label='Signature']"), prop.getProperty("signature"), "Signature", 25);
			enter(By.id("txtdescription"),prop.getProperty("Description"),"Description",20);
		}
		
		 public void stripePaymentway()
		 {
			 enter(By.xpath("//input[@label='Secret Key']"),prop.getProperty("secretKey"), "SecretKey", 25);
			 enter(By.xpath("//input[@label='Publishable Key']"),prop.getProperty("publishablekey"), "Publishablekey", 25);
			 enter(By.id("txtdescription"),prop.getProperty("Description"),"Description",20);
			 
		 }
		
		
		
		
		
//		public void enterTransactionKey()
//		{
//			enter(By.xpath("//input[@label='Transaction Key']"),prop.getProperty("transactionKey"),"Transaction Key",25);
//		}
//		
//		public void enterDescription()
//		{
//			
//		}
		 
		  public void SearchActiveInactiveDelete()
		  {
			  
			//  List<WebElement> values= driver.findElements(By.xpath("//a[@id='ancEditPymntGtwy']"));
			  
//			  for(WebElement paymentValues : values)
//			  {
				//  for( int count =1; count<=values.size();count++)
				//  {
					   
				  String paymentGatewayValues = "Stripe";
				  enter(By.id("search"), paymentGatewayValues, "Search Field ", 25);
				  clickByJavascript(By.id("Go"), " Search Button", 25);
				 // refresh();
				  
				  selectAll();
				  activeActionButton();
				  okConfirmButton();
				  verifyActiveStatusValue();	 
				  selectAll();
				  inactiveActionButton();
				  okConfirmButton();
				  verifyInactiveStatusValue();
				  selectAll();
				  deleteButton();
				  okConfirmButton();
				 refresh();
				 selectAll();
				  deleteButton();
				  okConfirmButton();
				  
			//	  }
				 
				  
			  }
			  
			  
		  
//	 public void searchIndustryType()
//			{
//				enter(By.id("search"), industrytypename, "Search Field ", 25);
//			}
			
//		public void searchButton()
//			{
//				clickByJavascript(By.id("Go"), " Search Button", 25);
//				String SearchedValue = getText(By.id("ancEditdepartment"), 25);
//				afterSearchValue= SearchedValue;
//				verifySearchRecord(By.id("ancEditdepartment"), industrytypename, "Industry Type", 25);
//				
//				staticWait(4000);	
//			}
			
		

			public void refresh()
			{
				clickByJavascript(By.xpath("//i[@class='fa fa-refresh']")," Refresh Button", 25);
				staticWait(2000);
				
			}
			
			
			public void editIndustryType()
			{
				clickByJavascript(By.id("ancEditdepartment"), "Edit IndustryType", 25);
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
				 verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Department Status Value", prop.getProperty("activeStatus"), 20);
			 }
			 public void verifyInactiveStatusValue()
			 {
				 verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Department Status Value", prop.getProperty("inactiveStatus"), 20);
			 }
			 
			 public void deleteButton()
			 { 
				 
				 click(By.id("DeleteMultiple"), "Delete Button",25);
				 
			 }
			 
			 public void selectcheckbox()
				{
					clickByJavascript(By.xpath("//input[@id='chk_1']"), "Click on checkbox", 25);
				}
		
			 public void enterSearchText() {
					staticWait(2000);

					enter(By.id("search"), "Authorize Dot Net", "Enter Text in Payment Gateway field", 25);
				}

				

				public void searchButton() {
					staticWait(1000);
					clickByJavascript(By.id("Go"), "Search Button", 20);
					staticWait(1000);

				}
				
				public void clickPaymentGatewayName() {
					staticWait(2000);
					click(By.xpath("//table[@id='tblPaymentGateway']//a"), "Payment Gateway Name", 25);
				}
				
				public void verifyUpdateConfirmationMessage() {
					String Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText();
					if (Message.equals("Payment Gateway Type has been successfully updated.")) {
						getTest().log(LogStatus.PASS, "Payment Gateway Type has been successfully updated.");
						logger.info("Payment Gateway Type has been successfully updated.");
					} else {
						getTest().log(LogStatus.FAIL, "Payment Gateway Type has been successfully updated.");
						logger.info("Trip has not been successfully updated.");
						takeScreenshot(new Object() {
						}.getClass().getEnclosingMethod().getName());
						// Assert.fail("" + e);
					}
				}
		
	
	
	
	

}
