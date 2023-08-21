package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;
import utils.WebTestBase;

public class CannedReplyPage extends WebBasePage{
	
	WebDriver driver ;
	String CannedReplyName;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	
	String datevalue=dateformat.format(date);
	
	
	
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
    private final static String FILE_NAME = System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties";
    private static Properties prop = new PropertiesLoader(FILE_NAME).load();
    
    
    
    public CannedReplyPage (WebDriver driver)
    {
    	super(driver , "Canned Reply Page" );
    	this.driver = driver ;
    }
    
    public void clickFullMenuDropDown() {
        click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);
        staticWait(2000);
    }
     public void clickCompanySetupLink()
     {
    	 //click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"),"Company Setup Link", 30);
    	 click(By.xpath("//li[@data-name='COMPANY SETUP']"),"Company Setup Link", 30);
    	 staticWait(2000);
    	 staticWait(2000);
     }
     public void clickCompanySetupPage()
     {
    	 click(By.xpath("(//a[contains(text(),'Company Setup')])[last()]")," Company Setup Page", 30);
    	 staticWait(2000);
     }
     
     public void clickOnCannedReply()
     {
    	 clickByJavascript(By.xpath("//a[text()='Canned Reply']"),"Canned Reply",20);
     }
     
     public void AddButton()
     {
    	 
    	 clickByJavascript(By.id("ancCreateReplyTemplate"),"Add Canned Reply Button",20);
    	 staticWait(5000);
     }
     
     public void SaveButton()
     {
    	 
    	 click(By.id("btnSave"), "Save Button" ,30);
     }
     
     public void VerifyMandatoryFieldValidation()
	 {
		 int i=0;
		 String actualText;
		 String expectedText;
		 
	        List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
	        String[] expectedValue = {"Canned Reply Name","Description"};
	        for(Object expected : expectedValue)
	        {
	        	//WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()='" + expected +":']"), 45);
	        	
	        	//WebElement AsteriskField = findElementVisibility(By.xpath("//label[@class='lblctrlname']/span/parent::label[text()='" + expected +":']"), 45);
	        	WebElement AsteriskField = findElementVisibility(By.xpath("//span[@class='mandatory']/preceding-sibling::label[text()='"+expected+"']"), 45);
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
          public void UserGuideAndCancel()
      	  {
      		  click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"),"Open User Guide",20);
      		  click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"),"Close User Guide",20);
      		  clickByJavascript(By.xpath("//a[text()='Cancel']"),"Click on Cancel Button", 25);
      	  }
          
          public void EnterPrivateCannedReplyName()
          {
        	  
        	  enter(By.xpath("//input[@id='TemplateName']"),prop.getProperty("privatecannedreply")+datevalue, "PrivateCannedReply", 35);
        	  
         }
          public void selectStatus() {
        	  click(By.xpath("//select[@id='StatusId']"),"Status",20);
        	 // String status = driver.findElement(By.xpath("//select[@id='StatusId']/option")).getText();
        	  selectValueWithText(By.xpath("//select[@id='StatusId']"), "Active", "Status", 25);
        	  
          }
          public void EnterDescription()
 	     {
 				
 	    	 
 	    	 WebElement iframe = driver.findElement(By.tagName("iframe"));
 	    	    driver.switchTo().frame(iframe);
 	    	    WebElement tinymce = driver.findElement(By.tagName("body"));
 	    	    tinymce.clear();
 	    	  enter(By.tagName("body"), prop.getProperty("titledescription"), "Description", 30);
 	    	  driver.switchTo().defaultContent();
 	     } 
          public void EnterPublicCannedReplyName()
          {
        	  enter(By.xpath("//input[@id='TemplateName']"),prop.getProperty("publiccannedreply")+datevalue, "PublicCannedReply", 35);
          }
          
          public void PublicCheckBox()
          {
        	  clickByJavascript(By.xpath("//input[@id='rdo_0']"), "Public CheckBox" , 50);
          }
 	     public void GetTextCannedReply()
 	     {
 	    	 
 	    	//WebElement CannedReplytext = driver.findElement(By.xpath("//table[@id='tblCannedReply']//tbody/tr/td[2]/a"));
 	    	WebElement CannedReplytext = driver.findElement(By.xpath("//table[@id='tblCannedReply']//tbody/tr/td"));
 	    
 	    	 String CannedReply =(CannedReplytext.getText().trim());
 	    	 
 	    	CannedReplyName = CannedReply;
 	    	
 	    	// getText(By.xpath("//table[@id='tblCannedReply']//tbody/tr/td[2]/a"), 35);
 	     }
 	     
 	     public void EnterTextSearchCannedReply()
 	     {
 	    	 enter(By.xpath("//input[@id='search']"), CannedReplyName, "Enter Search text", 35);
 	    	 searchButton();	    	 
 	     }
 	    public void searchButton()
 	   {
 		   click(By.xpath("//a[@id='Go']"), "Search Button Click", 25);	   
 		   staticWait(2000);
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
	    	
	    	 click(By.xpath("//table[@id='tblCannedReply']//tbody//tr[1]//td//div[contains(@class,'custom-checkbox')]"),"clickCheckBox",60);
	    	// String AnnouncementName = getText(By.xpath("//a[@id='ancEditdepartment']"),25);
	    	 //TitleName = AnnouncementName;
	    	 //staticWait(2000);
	     }
	     
	     public void Delete()
	     {
	    	 staticWait(2000);
	     	 click(By.xpath("//i[@class='fa fa-trash']"),"Click Delete Button", 25);
	    	 click(By.xpath("//button[@title='OK']"),"Confirmation popup", 20);
	     }
	     
	     public void HandleSuccessMessage()
	     
	     {
	    	 click(By.xpath("//Button[@id='closenotifymessage']"), " Close Success Message", 25);
	     }
 	     
 	 
        
    }
    

