package pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataValidation.ErrorStyle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mongodb.diagnostics.logging.Logger;
import com.relevantcodes.extentreports.LogStatus;

import utils.Errors;
import utils.PropertiesLoader;
import utils.WebBasePage;
import static reporting.ComplexReportFactory.getTest;

public class AnnouncementPage extends WebBasePage {
	 
	WebDriver driver ;
	
	String TitleName;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	
	String datevalue=dateformat.format(date);
	static String TitleRandomValue;
	static String CreatedTitleRandomValue;
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	    private final static String FILE_NAME = System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties";
	    private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	    
	    public AnnouncementPage(WebDriver driver) {
			super(driver, "AnnouncementPage");
			this.driver=driver;
			// TODO Auto-generated constructor stub
		}
	    
	    public void clickFullMenuDropDown() {
	        click(By.xpath("//span[text()='Full Menu']"), "Full Menu", 30);
	        staticWait(2000);
	    }
	     public void clickCompanySetupLink()
	     {
	    	 click(By.xpath("//li[@data-name='COMPANY SETUP']"),"Company Setup Link", 30);
	    	 staticWait(2000);
	     }
	     public void clickCompanySetupPage()
	     {
	    	 click(By.xpath("(//a[contains(text(),'Company Setup')])[last()]")," Company Setup Page", 30);
	    	 staticWait(2000);
	     }
	     
	     public void AddButton()
	     {
	    	 click(By.xpath("//a[@id='ancCreateAnnouncementMessage']"),"AddButton",25);
	     }
	     
	     public void AnnouncementTitle()
	     
	     {
	    	TitleRandomValue= prop.getProperty("titlename") + datevalue;
	    	 enter(By.xpath("//input[@id='Title'] "),TitleRandomValue,"Announcement Title",30);
	    	 CreatedTitleRandomValue=TitleRandomValue;    	 
	     }
	     
	     public void UserGuide()
	     {
	    	 click(By.xpath("//span[@class='user-guide']"),"Open User guide", 20);
	    	 click(By.xpath("//span[@class='user-guide']"),"Close User guide", 20);
	     }
	     
	     public void EnableAcknowledgementRequired()
	     {
	   	 
	    	 clickByJavascript(By.cssSelector("input#IsAcknowledgementRequiredN"), "Enable the Acknowledgement Required Field Toggle Button", 30);
	    	// click(By.cssSelector("span.slider-yes")," Enable the Acknowledgement Required Field Toggle Button",30);
	     }
	     
			/*
			 * public void DisableAcknowledgementRequired() {
			 * 
			 * click(By.cssSelector("span.slider-no")
			 * ," Disable the Acknowledgement Required Field Toggle Button",30); }
			 */
	     
	     public void UploadAttachment()
	     {
	    	 
	    	 uploadDoc(By.cssSelector("input#flFile"),filePath+prop.getProperty("testfilejpg"), "Attachment", 30);
	     }
	     
	     public void EnterDescription()
	     {
				/*
				 * staticWait(3000); driver.switchTo().frame(
				 * driver.findElement(By.xpath("//div[@id='cke_188_contents']/iframe")));
				 * WebElement body = driver.findElement(By.tagName("body")); body.clear();
				 * enter(By.tagName("body"),prop.getProperty("titledescription")
				 * ,"Description field", 20);
				 */
				/*
				 * WebElement iframe = driver.findElement(By.tagName("iframe"));
				 * driver.switchTo().frame(iframe);
				 * 
				 * String someText =prop.getProperty("titledescription"); JavascriptExecutor js
				 * = (JavascriptExecutor) driver;
				 * js.executeScript("CKEDITOR.instances['editor1'].setData('"+someText+"')");
				 */
	    	 
	    	 WebElement iframe = driver.findElement(By.tagName("iframe"));
	    	    driver.switchTo().frame(iframe);
	    	    WebElement tinymce = driver.findElement(By.tagName("body"));
	    	    tinymce.clear();
	    	  enter(By.tagName("body"), prop.getProperty("titledescription"), "Description", 30);
	    	  driver.switchTo().defaultContent();
	     } 
	     
	     public void save()
	     {
	    	 clickByJavascript(By.xpath("//i[@class='fa fa-save pr-2']"),"Save Button", 25);
	     }
	     
	     public void TitleErrorMessageValidation()
	     {
	    	 String errormsg = Errors.TitleRequired;
	    	// scrollToWebelement(By.xpath("//input[@id='Title']/..//span[@class='field-validation-valid text-danger'"), "Title");
	    //	 String TitleErrorMessage=getText(By.xpath("//input[@id='Title']/..//span[@class='field-validation-valid text-danger']"),30 );
	    	 String TitleErrorMessage=getText(By.xpath("//label[text()='Title']/ancestor::tg-input/descendant::span[text()='Title is required']"),30 );
	    	 if (errormsg.equals(TitleErrorMessage))
	    	 	{
	    		 getTest().log(LogStatus.PASS, " Error Message is successfully displayed in Title field on Add announcement page as " + errormsg);
	    		 logger.info("Error Message is successfully displayed in Title field as " + errormsg);
	    	 	}
	    	else {
	    		getTest().log(LogStatus.FAIL, "Error Message is not displayed in Title field");
	    		logger.info("Error Message is not displayed in Title field");
	            takeScreenshot("Title");
	    		}
	     }
	     
	     public void MessageFieldErrorMessageValidation()
	     {
	    	 String errormsg = Errors.MessageRequired;
	    	 String  ErrorMessage= getText(By.xpath("//span[@id='spnContent']"),30);
	    	 if (errormsg.equals(ErrorMessage))
	    	 {
	    		 getTest().log(LogStatus.PASS, " Error Message is successfully displayed in Message field on Add announcement page as " + errormsg);
	    		 logger.info("Error Message is successfully displayed in Message field as " + errormsg);
	    	 }
	    	 else
	    	 {
	    		 getTest().log(LogStatus.FAIL, "Error Message is not displayed in Message field");
		    		logger.info("Error Message is not displayed in Message field");
		            takeScreenshot("Message");
	    	 }
	    	 
	     }
	     
	     public void HandleSuccessMessage()
	     
	     {
	    	 click(By.xpath("//Button[@id='closenotifymessage']"), " Close Success Message", 25);
	     }
	     
	     public void SelectSingleCheckBox()
	     {
	    	 
	    	
	    	 click(By.xpath("//table[@id='tblAnnouncement']//tbody//tr[1]//td//div[contains(@class,'custom-checkbox')]"),"clickCheckBox",20);
	    	 String AnnouncementName = getText(By.xpath("//a[@id='ancEditdepartment']"),25);
	    	 TitleName = AnnouncementName;
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
	     public void SearchAnnouncement()
	     {
	    	 enter(By.xpath("//input[@id='search']"),TitleName,"Input Title Name in Search field", 25);
	    	 click(By.xpath("//a[@id='Go']/i[@class='fa fa-search']"),"Click on search Button", 20);
	    	 String AnnouncementName = getText(By.xpath("//a[@id='ancEditdepartment']"),25);
	    	 if (AnnouncementName.equals(TitleName))
	    	 {
	    		 getTest().log(LogStatus.PASS, " After search it shows record which we have searched " + AnnouncementName);
	    		 logger.info("After search it shows record which we have searched " + AnnouncementName);
	    	 }
	    	 else
	    	 {
	    		 getTest().log(LogStatus.FAIL, "After search it does not shows record which we have searched");
		    		logger.info("After search it does not shows record which we have searched");
		            takeScreenshot("Search");
	    	 }
	    	 
	    	 staticWait(5000);
	      }
	     public void DeleteAnnoucement()
	     {
	    	click(By.xpath("//i[@class='fa fa-trash']"),"Delete Announcmenet", 25 );
	    	click(By.xpath("//button[@title='OK']"),"Confirmation popup", 20);
	    	 
	     }	     

}
