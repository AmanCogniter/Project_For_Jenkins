package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class BreakPage extends WebBasePage 
{
	
	 WebDriver driver;
	 String pattern="yyMMddHHmmss";
	 Date date = new Date();
	 SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	 String datevalue = dateformat.format(date);
		 
	  public static String breakname;
	 String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	    private final static String FILE_NAME = System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties";
	    private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	
	public BreakPage(WebDriver driver)
	{
		super(driver,"Break Page");
		this.driver= driver;
	}
	
	
	
	public void clickFullMenuDropDown() {
        click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);
        staticWait(2000);
    }
     public void clickCompanySetupLink()
     {
    	// click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"),"Company Setup Link", 30);
    	 click(By.xpath("//li[@data-name='COMPANY SETUP']"),"Company Setup Link", 30);
    	 staticWait(2000);
     }
     public void clickCompanySetupPage()
     {
    	 click(By.xpath("(//a[contains(text(),'Company Setup')])[last()]")," Company Setup Page", 30);
    	 staticWait(2000);
     }
	public void ClickBreakTab()
	{
		click(By.xpath("//a[text()='Break']"),"Break Tab",20);
	}
	public void AddBreakButton()
	{
		//String addButtonPath =" "
		clickByJavascript(By.xpath("//a[@id='ancAddBreak']"),"Add Break Button", 25);
	}
	
	 public void VerifyMandatoryFieldValidation()
	 {
		 int i=0;
		 String actualText;
		 String expectedText;
		 
	        List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 15);
	        String[] expectedValue = {"Shifts","Break Name","Start Time","End Time"};
	        for(Object expected : expectedValue)
	        {
	        	WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()='" + expected +"']"), 20);
	        	if (AsteriskField!= null)
	        	{
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
                    getTest().log(LogStatus.PASS, "Error message for \"" + expected + "\" field is displayed as expected");
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
	 public void SaveButton()
	 {
		 clickByJavascript(By.xpath("//a[@id='btnSave']"),"Save Button", 25);
	 }
	  public void UserGuideAndCancel()
	  {
		  click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"),"Open User Guide",20);
		  click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"),"Close User Guide",20);
		  clickByJavascript(By.xpath("//a[text()='Cancel']"),"Click on Cancel Button", 25);
	  }
	  public void SelectShift()
	  {
		  selectValueWithIndex(By.xpath("//select[@id='ShiftId']"),1,"Select Shift",25);
	  }
	  public void EnterBreakName()
	  {
		  String latestbreakname = prop.getProperty("breakname")+datevalue;
		  enter(By.xpath("//input[@id='breakDetail']"),latestbreakname," Break Name", 20);
		  
		  System.out.println(latestbreakname);
		  breakname =latestbreakname;
	  }
	  public void SelectStartDate()
	  {
		  
	  driver.findElement(By.id("StartTime")).clear();
		  enter(By.xpath("//input[@id='StartTime']"), "12:00 am", "Start time", 20);
//		  click(By.xpath("//div[@data-target='#StartTime']//i[@class='fa fa-clock-o']"),"Select Start Date", 30);
//		  click(By.xpath("//span[@class='timepicker-hour']"),"Select Hour",20);
//		  click(By.xpath("//table[@class='table-condensed']//td[contains(text(),'01')]"),"Select Particular Hour",25);  
	  }
	  
	  public void SelectCloseDate()
	  {
		  driver.findElement(By.id("EndTime")).clear();
		  enter(By.xpath("//input[@id='EndTime']"), "12:05 am", "End time", 20);
		  
//		  click(By.xpath("//div[@data-target='#EndTime']//i[@class='fa fa-clock-o']"),"Select End  Date", 30);
//		  click(By.xpath("//span[@class='timepicker-hour']"),"Select Hour",20);
//		  click(By.xpath("//table[@class='table-condensed']//td[contains(text(),'02')]"),"Select Particular Hour",25);
//		  click(By.xpath("//div[@data-target='#EndTime']//i[@class='fa fa-clock-o']"),"close End Date", 30); 
	  }
	  
	  // Pending need to check
	   public void BillableCheckbox()
	   {
		   
		   click(By.xpath("//div[@class='checkbox']//input[@type='checkbox']"),"Click Billable checkbox", 25);   
	   }
	   
	   public void SearchBreak()
	   {
		  // System.out.println("Check"+breakname);
		   staticWait(2000);
		     String searchinput = "//div/input[@id='search']";
		     click(By.xpath("//div/input[@id='search']"), "Text Feild Click", 25);	   
			   staticWait(2000);
		     
			    enter(By.xpath("//input[@id='search']"),BreakPage.breakname, "Enter Break Name in Search", 25);
		   
	
		  
	   }
	   public void searchButton()
	   {
		   clickByJavascript(By.xpath("//a[@id='Go']"), "Search Button Click", 25);	   
		   staticWait(2000);
		   try {
			   String searchBreak = driver.findElement(By.xpath("//table/tbody/tr/td/a[@id='ancEditshift']")).getText();
			if (breakname.equals(searchBreak)) {
				logger.info("Break Name Displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Break Name not Displayed successfully");
			e.printStackTrace();
		}
	   }
	    
	   public void Resetbutton() {
		   clickByJavascript(By.xpath("//i[@class='fa fa-refresh']"),"Reset Button Click", 35);
	   }
	   public void HandleSuccessMessage()
	     
	     {
	    	 click(By.xpath("//Button[@id='closenotifymessage']"), " Close Success Message", 25);
	     }
	   public void ClickOnBreakName()
	   {
		   
		   
		   clickByJavascript(By.xpath("//a[contains(text(),'"+breakname+"')]"),"Click on Break Name", 25);
		   staticWait(10000);
	   }
	   public void BreakNameSorting()
	   {
		   clickByJavascript(By.xpath("//span[@id='BREAKNAME']"), "click on sorting icon of Break Name", 25);
		   clickByJavascript(By.xpath("//span[@id='BREAKNAME']"), "click on sorting icon of Break Name", 25);
	   }
	   public void EnableIsBillable()
	   {
		   click(By.xpath("//span[@class='slider round']/span[text()='UnPaid']"), "Click on Is Billable", 30);
	   }
	   
	   public void ActiveToInActive()
	     {
	    	 click(By.xpath("//i[@class='fa fa-close']"),"Click Inactive Button", 25);
	    	 click(By.xpath("//button[@title='OK']"),"Confirmation popup", 20);
	     }
	     public void InActiveToActive()
	     {
	    	 click(By.xpath("//i[@class='fa fa-check']"),"Click Active Button", 25);
	    	 click(By.xpath("//button[@title='OK']"),"Confirmation popup", 20);
	     }
	
	     public void SelectSingleCheckBox()
	     {
	    	 
	    	staticWait(2000);
	    	 click(By.xpath("//table[@id='tblBreak']//tbody//tr[1]//td//div[contains(@class,'custom-checkbox')]"),"clickCheckBox",20);
	    	// String AnnouncementName = getText(By.xpath("//a[@id='ancEditdepartment']"),25);
	    	 //TitleName = AnnouncementName;
	    	 //staticWait(2000);
	     }
	     public void ClickOnDelete()
		   {
			   clickByJavascript(By.xpath("//a[@id='DeleteMultiple']"), "Delete Button", 25);
			   click(By.xpath("//button[@title='OK']"),"Confirmation popup", 20);
			   try {
				WebElement message = driver.findElement(By.xpath("//div/span[contains(text(),'Break has been successfully deleted')]"));
				if (message.isDisplayed()) {
					logger.info("Break Deleted successfully");
				}
			} catch (Exception e) {
				// TODO: handle exception
				logger.info("Break didn't Deleted successfully");
				e.printStackTrace();
			}
			   
		   }

}
