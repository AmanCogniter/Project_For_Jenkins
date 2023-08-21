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
import utils.WebTestBase;

public class ShiftPage extends WebBasePage {
	
	WebDriver driver ;
	
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);
	
	
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String shiftnewname;
	static String flexibleshiftnewname;
	static String Activestatus;
	static String InActivestatus;
	
	
	public ShiftPage(WebDriver driver ) {
		
		super(driver, "Shift page");
		this.driver= driver ;	
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

	public void clickOnShift() {
		clickByJavascript(By.xpath("//a[text()='Shift']"), "Shift", 20);
		staticWait(2000);
	}
	

	public void clickOnAdd() {

		click(By.xpath("//a[@id='ancCreateShift']"), "Add Shift", 25);
	}
	
	public void save() {
		clickByJavascript(By.xpath("//a[@id='btnSave']"), "Save Shift Name", 20);
		staticWait(3000);
	}
	
	public void VerifyMandatoryFieldValidation() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = {"Shift Name","Start Time","End Time","Shift Rate","Over Time Rate","Location"};
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
		clickByJavascript(By.xpath("//a[text()=' Cancel']"), "Click on Cancel Button", 25);
	}
	
	
	 public void enterShiftName()
	 {
		 String shiftname = prop.getProperty("shift") + datevalue;
		 enter(By.id("ShiftName"), shiftname, "Shift Name", 25);
		 shiftnewname=shiftname;
	 }
	 
	 public void enterFlexibleShiftName()
	 {
		 String shiftname = prop.getProperty("flexibleshift") + datevalue;
		 enter(By.id("ShiftName"), shiftname, "Shift Name", 25);
		 flexibleshiftnewname=shiftname;
	 }
	 
	 public void startTime()
	 {
		 
		 click(By.xpath("//div[@data-target='#StartTime']"), "Click on Time Picker", 25);
		 click(By.xpath("//span[@title='Pick Hour']"), "Click on Hour" , 25);
		 click(By.xpath("//ul[@class='list-unstyled']/li[2]/div/div[2]//tbody//tr[3]/td[3]"), "Select 10 Hour", 25);
		 click(By.xpath("//span[@title='Pick Minute']"), "Click on Minute" , 25);
		 click(By.xpath("//ul[@class='list-unstyled']/li[2]/div/div[3]//tbody//tr[1]/td[1]"), "Select 00 time", 25);
		 
		String Value = getText(By.xpath("//button[@title='Toggle Period']"), 25);
		
		if (Value=="PM")
		{
			click(By.xpath("//button[@title='Toggle Period']"), "Check AM and PM", 25);
		}
		 
		 
		 
		// driver.findElement(By.id("StartTime")).clear();
		 //enter(By.id("StartTime"), prop.getProperty("starttime"), "Start Time",25);
	 }
	 
	 public void endTime()
	 {
		 click(By.xpath("//div[@data-target='#EndTime']"), "Click on Time Picker", 25);
		 click(By.xpath("//span[@title='Pick Hour']"), "Click on Hour" , 25);
		 click(By.xpath("//ul[@class='list-unstyled']/li[2]/div/div[2]//tbody//tr[2]/td[3]"), "Select 6 Hour", 25);
		 click(By.xpath("//span[@title='Pick Minute']"), "Click on Minute" , 25);
		 click(By.xpath("//ul[@class='list-unstyled']/li[2]/div/div[3]//tbody//tr[1]/td[1]"), "Select 00 time", 25);
		 
		String Value = getText(By.xpath("//button[@title='Toggle Period']"), 25);
		
		if (Value.equalsIgnoreCase("AM"))
		{
			click(By.xpath("//button[@title='Toggle Period']"), "Check AM and PM", 25);
		}
		 click(By.xpath("//table/tbody/tr/td/a/span[@class='fa fa-times text-dark']"), "Close end time picker popup", 25);
	 }
	 public void breakShift()
	 {
		 
		 selectValueWithIndex(By.xpath("//div/tg-select/select[@id='breakId']"), 2, "Break", 30);
	 }
	  public void shiftRate()
	  {
		  enter(By.id("ShiftRate"), prop.getProperty("shiftrate"), "Shift Rate", 30);
	  }
	  
	  public void OverTimeRate()
	  {
		  enter(By.id("OverTimeRate"), prop.getProperty("overtimerate"), "Over Time Rate", 30);
	  }
	  
	   public void SelectLocation()
	      {
	    	  click(By.xpath("//div/span[text()='Select']"),"Location dropdown", 25);
	    	 // WebElement LocationList = driver.findElement(By.id("CompantLocationSelect"));
	    	  click(By.xpath("//ol[@class='scrollbar']/li[2]/a")," Select Location" , 25);
	    	
	      }
	   
	   public void shiftTypeFlexible()
	   {
		   
		   //(By.id("shiftTypeN"), "Flexible shift ", 25);
		   clickByJavascript(By.xpath("//input[@id='shiftTypeN']/..//span[@class='slider round']/span[text()='No']"), "Flexible shift ", 25);
	   }
	   
	   public void Description()
	      {
	    	  
	    	  enter(By.xpath("//textarea[@id='ShiftDescription']"),prop.getProperty("Description"), "Enter Description", 20);
	      }
	   public void verifyAddConfirmationMessage()
		{
			findElementVisibility(By.xpath("//div[@id='notifymessage']/div/span"), 30);
			String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
			 if(Message.equalsIgnoreCase("Priority has been successfully added."))
			 {
				 getTest().log(LogStatus.PASS, "Priority has been successfully added.");
	            logger.info("Priority has been successfully added.");	
			 }
			 else
				 
			 {
				 getTest().log(LogStatus.FAIL, "Priority has not been successfully added." );
	            logger.info("Priority has not been successfully added.");
	            takeScreenshot(new Object() {
	            }.getClass().getEnclosingMethod().getName());
	            //Assert.fail("" + e);
			 }
		}
		
	   
	   public void enterSearchText() {
			staticWait(2000);

			enter(By.id("search"), flexibleshiftnewname, "Enter Text in Shift field", 25);
		}

		public void refresh() {
			clickByJavascript(By.xpath("//i[@class='fa fa-refresh']"), " Refresh Button", 25);
		}

		public void searchButton() {
			staticWait(1000);
			clickByJavascript(By.id("Go"), "Search Button", 20);
			staticWait(1000);

		}
		
		 public void clickShiftName()
		 {
			 click(By.xpath("//table[@id='tblShift']//a"), "Shift Name", 25);
		 }
		 
		 public void verifyUpdateConfirmationMessage()
			{
				String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
				 if(Message.equals("Shift has been successfully updated."))
				 {
					 getTest().log(LogStatus.PASS, "Shift has been successfully updated.");
		            logger.info("Shift has been successfully updated.");	
				 }
				 else
				 {
					 getTest().log(LogStatus.FAIL, "Shift  has not been successfully updated." );
		            logger.info("Shift has not been successfully updated.");
		            takeScreenshot(new Object() {
		            }.getClass().getEnclosingMethod().getName());
		            //Assert.fail("" + e);
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
				 if(Message.equals("Shift has been successfully deleted."))
				 {
					 getTest().log(LogStatus.PASS, "Shift has been successfully deleted.");
		            logger.info("Shift has been successfully deleted.");	
				 }
				 else
				 {
					 getTest().log(LogStatus.FAIL, "Shift has not been successfully deleted." );
		            logger.info("Shift has not been successfully deleted.");
		            takeScreenshot(new Object() {
		            }.getClass().getEnclosingMethod().getName());
		            //Assert.fail("" + e);
				 }
			}
			
			public void verifyActiveStatusValue() {
				verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Shift Status Value",
						prop.getProperty("activeStatus"), 20);
			}

			public void verifyInactiveStatusValue() {
				verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Shift Status Value",
						prop.getProperty("inactiveStatus"), 20);
			}
			
			public void verifyStatusConfirmationMessage()
			{
				String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
				 if(Message.equals("Status has been successfully updated."))
				 {
					 getTest().log(LogStatus.PASS, "Shift Status has been successfully updated.");
		            logger.info("Shift Status has been successfully updated.");	
				 }
				 else
				 {
					 getTest().log(LogStatus.FAIL, "Shift Status has not been successfully updated." );
		            logger.info("Shift Status has not been successfully updated.");
		            takeScreenshot(new Object() {
		            }.getClass().getEnclosingMethod().getName());
		            //Assert.fail("" + e);
				 }
			}
			
	       
	 
	 
}
