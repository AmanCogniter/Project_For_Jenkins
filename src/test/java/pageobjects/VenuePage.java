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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class VenuePage extends WebBasePage {
	
	
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);
	
	
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String venuenewname;
	static int initialcount;
	static int finalcount;
	static String Activestatus;
	static String InActivestatus;
	public VenuePage(WebDriver driver) {

		super(driver, "Venue page");
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

	public void clickVenueTab() {
		
		enter(By.xpath("//input[@placeholder='Search by Name']"),"Venue","Search Venue Name" , 25);
		click(By.xpath("//input[@placeholder='Search by Name']/..//span"), "Click on search", 30);
		click(By.xpath("//a[text()='Venue']"), "Venue Tab", 20);
		staticWait(2000);
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
		String[] expectedValue = { "Venue","Capacity","Company Location"};
		for (Object expected : expectedValue) {
			WebElement asterikField = findElementVisibility(By.xpath("//label[text()='"+ expected +"']/ancestor::div[@class='form-group']/descendant::span[@class='mandatory']"), 20);

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
	
	public void openAndCloseUserGuide() {
		click(By.xpath("//div[@id='content']//a[@class='ancuserguide']"), "Open User Guide", 45);
		click(By.xpath("//div[@id='content']//a[@class='ancuserguide']"), "Close User Guide", 45);
	}

	
	public void cancelButton() {
		clickByJavascript(By.id("ancgotolistscreen"), " Cancel Button", 25);
	}
	
	
	
	 public void enterVenueName()
	 {
		String venuenname= prop.getProperty("venue")+datevalue;
		 enter(By.id("Name"), venuenname, "Venue Name", 25);	 
		 venuenewname = venuenname;
		 
		 
	 }
	 
	 
	 public void enterCapacity()
	 {
		 String capacityvalue= prop.getProperty("capacity");
		 enter(By.id("Capacity"), capacityvalue, "Venue Name", 25);	 
	 }
	 
	 public void selectCompanyLocation()
	 {
		 selectValueWithIndex(By.xpath("//select[@id='CompanyLocationId']"), 2,"Select Location",25);
	 }
	 
	 
	 public void enterInformation()
	 {
		 enter(By.id("Info"), prop.getProperty("Description")," Enter information", 25);
	 }
	 
	 public void SearchVenue()
		{
		  driver.navigate().refresh();
		 WebDriverWait wait = new WebDriverWait(driver,500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		 	//staticWait(2000);
			enter(By.id("search"),venuenewname, "Search Field ", 25);
			 
		}

	 
	 public void searchButton()
		{
			clickByJavascript(By.id("Go"), " Search Button", 25);
			
			verifySearchRecord(By.xpath("//table[@id='tblEvent']/tbody/tr[1]/td[2]/span"),venuenewname, "Venue Search", 25);
		}
		
		
		

		public void refresh()
		{
			clickByJavascript(By.xpath("//i[@class='fa fa-refresh']")," Refresh Button", 25);
		}
		
		
		public void editVenue()
		{ 
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='tblEvent']/tbody/tr[1]/td[6]//i")));
			clickByJavascript(By.xpath("//table[@id='tblEvent']/tbody/tr[1]/td[6]//i"), "Edit Venue", 25);
		}
		
		 public void clickAddLayout()
		 
		 {
			 initialcount = getCountAssignedLayout();
			 click(By.xpath("//a[@class='addvenuelayout']"), "Add Layout", 25);
		 }
		 
		 public void addLayoutButton()
		 {
			 click(By.xpath("//a[@id='andAddLayout']"), "Add Layout Button",25);
		 }
		 
		  public void clickRectanglePlanLayout()
		  {
			  click(By.id("toolboxRectanglePlan"),"Click on Rectangle layout",25);
			  
		  }
		  
		   public void addRectangleLayout()
		   {
			   enter(By.xpath("//input[@id='txtBlockName']"), "Rectangle Block","Rectangle Block", 25);
			   enter(By.xpath("//input[@id='txtLayoutRow']"), "2","Total Blocks", 25);
			   enter(By.xpath("//input[@id='txtLayoutColumn']"), "2","Table per Blocks", 25);
			   enter(By.xpath("//input[@id='txtLayoutSeatPerTable']"), "2","Seat per Table", 25);
			   enter(By.xpath("//input[@id='txtLayoutHorizontalSpacing']"), "2","Horizontal Spacing Between Tables", 25);
			   enter(By.xpath("//input[@id='txtVerticalalSpacing']"), "2","Vertical Spacing Between Tables", 25);  
		   }
	
		   public void clickOnApply()
		   {
				  
			   click(By.xpath("//button[@id='btnLayoutPlanApply']")," Click on Apply",25);
			   staticWait(2000);
			 
		   }
		   
		    public void clickCircleLayout()
		    {
		    	click(By.id("toolboxRoundPlan"),"Click on Circle layout",25);
		    }
		    
		    public void addCircleLayout()
			   {
				   enter(By.xpath("//input[@id='txtBlockName']"), "Circle Block","Circle Block", 25);
				   enter(By.xpath("//input[@id='txtLayoutRow']"), "2","Total Blocks", 25);
				   enter(By.xpath("//input[@id='txtLayoutColumn']"), "2","Table per Blocks", 25);
				   enter(By.xpath("//input[@id='txtLayoutSeatPerTable']"), "2","Seat per Table", 25);
				   enter(By.xpath("//input[@id='txtLayoutHorizontalSpacing']"), "2","Horizontal Spacing Between Tables", 25);
				   enter(By.xpath("//input[@id='txtVerticalalSpacing']"), "2","Vertical Spacing Between Tables", 25);  
			   }
		    
		    
		    public void clickHallLayout()
		    {
		    	click(By.id("toolboxHallPlan"),"Click on Hall layout",25);
		    }
		    
		    public void addHallLayout()
			   {
				   enter(By.xpath("//input[@id='txtBlockName']"), "Hall Block","Hall Block", 25);
				   enter(By.xpath("//input[@id='txtLayoutRow']"), "2","Total Blocks", 25);
				   enter(By.xpath("//input[@id='txtLayoutColumn']"), "2","Table per Blocks", 25);
				   enter(By.xpath("//input[@id='txtLayoutSeatPerTable']"), "2","Seat per Table", 25);
				   //enter(By.xpath("//input[@id='txtLayoutHorizontalSpacing']"), "2","Horizontal Spacing Between Tables", 25);
				   //enter(By.xpath("//input[@id='txtVerticalalSpacing']"), "2","Vertical Spacing Between Tables", 25);  
			   }
		    
		    public void saveButtonAndLayoutName()
		    {
		    	clickByJavascript(By.xpath("//a[text()='Save']"),"Final Save Button", 25);
		    	enter(By.xpath("//input[@id='txtLayoutName']"), venuenewname +" Layout Name", "Layout Name", 25);
		    }
		
		    public void SaveFinal() {
				clickByJavascript(By.id("btnSaveSvgData"), "save button", 30);
				staticWait(2500);
				
				finalcount = getCountAssignedLayout();
			}
		    
		    public void verifyConfirmationMessage()
			{
				//String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
				// if(Message.equals("Layout has been successfully added."))
		    	if(finalcount==initialcount+1)
				 {
					 getTest().log(LogStatus.PASS, "Layout has been successfully added.");
		            logger.info("Layout has been successfully added.");	
				 }
				 else
				 {
					 getTest().log(LogStatus.FAIL, "Layout has not been successfully added." );
		            logger.info("Layout has not been successfully added.");
		            takeScreenshot(new Object() {
		            }.getClass().getEnclosingMethod().getName());
		            //Assert.fail("" + e);
				 }
			}
		    
		      public int getCountAssignedLayout()
		      {
		    	  
		    	 String assignedCount =  getText(By.xpath("//a[@class='showvenuelayout']//span"),25);
		    	int intCountValue = Integer.parseInt(assignedCount);
		    	return intCountValue;
		    	
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
		      
		      public void deletevenue()
		      {
		    	  
		    	  click(By.xpath("//a[@class='eventDelete']"), "Delete Venue", 25);
		      }
	 
}
