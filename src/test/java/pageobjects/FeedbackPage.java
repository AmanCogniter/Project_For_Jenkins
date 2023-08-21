package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class FeedbackPage extends WebBasePage {
	
	 WebDriver driver;
	 static String FeedbackName;
	 static String Type ;
	 static String Activestatus;
	 static String InActivestatus;
	 
	 String pattern = "yyMMddHHmmss";
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

		String datevalue = dateformat.format(date);
		
		
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
		private final static String FILE_NAME = System.getProperty("user.dir")
				+ "\\src\\main\\resources\\testdata.properties";
		private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	  public FeedbackPage(WebDriver driver )
	  {
			super(driver, "FeedbackPage");
			this.driver=driver;
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
	     }
	     public void clickCompanySetupPage()
	     {
	    	 click(By.xpath("(//a[contains(text(),'Company Setup')])[last()]")," Company Setup Page", 30);
	    	 staticWait(2000);
	     }
	     
	 	public void clickOnFeedBack() {
			clickByJavascript(By.xpath("//a[text()='Feedback']"), "Feedback", 20);
			staticWait(2000);
		}
	 	
	 	 public void addFeedBack()
	 	 {
	 		 click(By.id("ancCreateFeedBack"), "Add Feedback", 25);
	 	 }
	 	 
	 	 
	 	public void save() {
			clickByJavascript(By.id("aFeedbackTicketSave"), "Save Channel Name", 20);
			waitForLoad(20);
		}
	 	
	 	public void VerifyMandatoryFieldValidation() {
			int i = 0;
			String actualText;
			String expectedText;

			List<WebElement> errorMessageLocator = findMultipleElement(
					By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
			String[] expectedValue = { "Feedback Name" };
			for (Object expected : expectedValue) {
				WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()= '" + expected +":' ]"), 45);
				if (AsteriskField != null) {
					getTest().log(LogStatus.PASS, "The Asterisk symbol is displayed for " + expected + " field");
					logger.info("The Asterisk symbol is displayed for " + expected + " field");
				} else {
					getTest().log(LogStatus.FAIL, "The Asterisk symbol is not displayed for " + expected + " field");
					logger.info("The Asterisk symbol is not displayed for " + expected + " field");
					takeScreenshot(expected.toString());
				}
			

				String[] feedbackquestionexpectedvalue = {"Feedback Question" , "Answering Type"}; 
				for (Object expectedquestion : feedbackquestionexpectedvalue) 
				{
					WebElement AsteriskFieldSign = findElementVisibility(By.xpath("//label[text()='" + expectedquestion + ":']"), 45);
				if (AsteriskFieldSign != null) {
					getTest().log(LogStatus.PASS, "The Asterisk symbol is displayed for " + expectedquestion + " field");
					logger.info("The Asterisk symbol is displayed for " + expectedquestion + " field");
				} else {
					getTest().log(LogStatus.FAIL, "The Asterisk symbol is not displayed for " + expectedquestion + " field");
					logger.info("The Asterisk symbol is not displayed for " + expectedquestion + " field");
					takeScreenshot(expectedquestion.toString());
				}
				}
			
				
				{
				
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
		}
	 	
	 	 public void UserGuide()
	 	 {
	 		 
	 		 click(By.className("ancuserguide")," User Guide Link Open", 15);
	 		click(By.className("ancuserguide")," User Guide Link Close", 15);
	 	 }
	 	 
	 	 public void enterFeedbackName()
	 	 {
	 		 FeedbackName= prop.getProperty("feedbackname")+Type+datevalue;
	 		 
	 		 enter(By.id("FeedbackName"),FeedbackName, "FeedBack Name", 20);
	 	 }

		public void additionalComment() {
			// TODO Auto-generated method stub
			staticWait(2000);
			click(By.xpath("//input[@id='chkIsAdditionalComments']/..//span[text() ='No']"), "Enable Additional Comment Toggle", 15);
			
			enter(By.id("AdditionalComments"), prop.getProperty("additionalFeedback"), "Additional Comment", 20);
			
		}
		
		public void HandleSuccessMessage()
	     
	     {
	    	 click(By.xpath("//Button[@id='closenotifymessage']"), " Close Success Message", 25);
	     }
		
		public void selectDepartment()
		{
			selectValueWithIndex(By.id("DepartmentId"), 2 ," Department Name", 25);
		}
		
		public void feedbackQuestionAndAnswer()
		{
			for ( int i=1;i<=3;i++)
			{
				enter(By.xpath("//div[@class='row question-answer-list div_question_answer mb-3']["+ i +"]//label[text()='Feedback Question:']//following::input[2]"), prop.getProperty("feedbackquestion")+Type,  "Feedback Question", 25);
				selectValueWithIndex(By.xpath("//div[@class='row question-answer-list div_question_answer mb-3']["+ i +"]//label[text()='Answering Type:']/..//select"), i , "Feedback Answer", 25);
				if (i==3)
				{
					System.out.println(i);
					System.out.println("click on break");
					break;
				}
				click(By.id("ancSplit"), "Plus icon", 15);
			}	
		}
		
		 public void feedbackAddByType()
		 {
			 for( int i=0;i<=3;i++)
			 {
			  selectValueWithIndex(By.id("TypeCode"), i, "Type", 25);
			  Select select = new Select(driver.findElement(By.xpath("//select[@id ='TypeCode']")));
			  WebElement option = select.getFirstSelectedOption();
			  System.out.println(option.getText());
			  Type = option.getText();
			  System.out.println(Type);
			 enterFeedbackName(); 
			 /* only Ticketing type have department option that's why we are using below condition */
			 if (Type.equals("Ticketing"))
			 {
				 selectDepartment();
			 }
			 additionalComment();
			 feedbackQuestionAndAnswer();
			 save(); 
			 staticWait(2000);
			 if (i==3)
				{
					break;
				}
			 addFeedBack();	 
			 }		 
		 }	
		 
		 public void searchFeedback()
		 {
			 enter(By.id("search"), FeedbackName, "Search Field ", 25);	 
		 }
		 
		 public void searchButton()
			{
				clickByJavascript(By.id("Go"), " Search Button", 25);
				
				verifySearchRecord(By.xpath("//a[@class='edit_ticket_feedback']"), FeedbackName, "Feedback Search", 25);
			}
			public void refresh()
			{
				clickByJavascript(By.xpath("//i[@class='fa fa-refresh']")," Refresh Button", 25);
				staticWait(3000);
			}
			
			public void editfeedback()
			{
				
				clickByJavascript(By.xpath("//a[@class='edit_ticket_feedback']"),"Edit Feedback", 20);
			}
			
			
			public void selectcheckbox()
			{
				clickByJavascript(By.xpath("//input[@id='chk_1']"), "Click on checkbox", 25);
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
					
			 }
			 
			 public void verifyActiveStatusValue()
			 {
				 verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Designation Status Value", prop.getProperty("activeStatus"), 20);
			 }
			 public void verifyInactiveStatusValue()
			 {
				 verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Designation Status Value", prop.getProperty("inactiveStatus"), 20);
			 }
			 
			 public void deleteButton()
			 { 
				 
				 click(By.id("DeleteMultiple"), "Delete Button",25);
				 
			 }
			
			
}
