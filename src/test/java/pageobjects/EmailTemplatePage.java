package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mongodb.Tag;
import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class EmailTemplatePage extends WebBasePage {
	
	WebDriver driver;
	
	static String EmailTemplatename;
	static String AdvacneEmailTemplatename;
	static String GreetingTemplatename;
	
	static String EmailTemplatesubject;
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
	
	
	
	public EmailTemplatePage(WebDriver driver) {

		super(driver, "EmailTemplatePage");
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
		click(By.xpath("(//a[contains(text(),'Company Setup')])[last()]"), " Company Setup Page", 30);
		staticWait(2000);
	}

	public void clickOnEmailemplate() {
		clickByJavascript(By.xpath("//a[text()='Email Template']"), "Email Template", 20);
	}
	
	public void addTemplate()
	{
		click(By.xpath("//a[@id='ancCreateDepartment']"),"Click on Add", 20);
	}
	
	
	  public void VerifyMandatoryFieldValidation()
		 {
		  try
		  {
			 int i=0;
			 String actualText;
			 String expectedText;
			 
			 /* In Dom Template Name label text different from another field */
		        List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
		        String[] expectedValue = {"Template Name","Subject"};
		        for(Object expected : expectedValue)
		        {
		        	//WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()='" + expected +":']"), 45);
		        	//label[@class='lblctrlname']/span/parent::label[starts-with(text(),'TemplateContent')]
		        	//label[@class='lblctrlname']/span/parent::label[text()='" + expected +":']
		        	
		        	WebElement AsteriskField = findElementVisibility(By.xpath("//label[contains(text(),'"+ expected +"')]/ancestor::div[@class='form-group']/descendant::span"), 45);
		        	if (AsteriskField!= null)
		        	{
		        		  getTest().log(LogStatus.PASS, "The Asterisk symbol is displayed for " + expected + " field");
		                  logger.info("The Asterisk symbol is displayed for " + expected + " field");
		              } else {
		                  getTest().log(LogStatus.FAIL, "The Asterisk symbol is not displayed for " + expected + " field");
		                  
		                  logger.info("The Asterisk symbol is not displayed for " + expected + " field");
		                  Assert.fail("The Asterisk symbol is not displayed for " + expected + " field");
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
	                    Assert.fail("Error message for \"" + expected + "\" field is displayed as expected");
	                    takeScreenshot(expectedText);
	                }
	            }
	            
		        }
		  }
		  catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error message for this field is displayed as expected");

		}
		 }
	
	/*
	 * public void VerifyMandatoryFieldValidation() { int i = 0; String actualText;
	 * String expectedText;
	 * 
	 * List<WebElement> errorMessageLocator = findMultipleElement( By.xpath(
	 * "//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"),
	 * 30); String[] expectedValue = {"Template Name","Subject","TemplateContent"};
	 * for (Object expected : expectedValue) { WebElement AsteriskField =
	 * findElementVisibility(By.xpath("//label[text()='" + expected + ":']"), 30);
	 * if (AsteriskField != null) { getTest().log(LogStatus.PASS,
	 * "The Asterisk symbol is displayed for " + expected + " field");
	 * logger.info("The Asterisk symbol is displayed for " + expected + " field"); }
	 * else { getTest().log(LogStatus.FAIL,
	 * "The Asterisk symbol is not displayed for " + expected + " field");
	 * logger.info("The Asterisk symbol is not displayed for " + expected +
	 * " field"); takeScreenshot(expected.toString()); }
	 * 
	 * List<WebElement> expectedElements = errorMessageLocator; for (WebElement
	 * element : expectedElements) { i++; actualText = element.getText();
	 * expectedText = expected.toString();
	 * 
	 * if (actualText.indexOf(expectedText) != -1) { getTest().log(LogStatus.PASS,
	 * "Error message for \"" + expected + "\" field is displayed as expected");
	 * logger.info("Error message for \"" + expected +
	 * "\" field is displayed as expected"); i = 0; break; } else if (i ==
	 * expectedValue.length && !element.getText().contains(expectedText)) {
	 * getTest().log(LogStatus.FAIL, "Error message for \"" + expected +
	 * "\" field is not displayed"); logger.info("Error message for \"" + expected +
	 * "\" field is displayed as expected"); takeScreenshot(expectedText); } }
	 * 
	 * } }
	 */
	 
	public void save() {
		clickByJavascript(By.xpath("//a[@id='btnSave']"), "Save button", 20);
		waitForLoad(30);
		staticWait(2000);
	}
	
	public void userGuideAndCancel() {
		click(By.xpath("//a[@class='ancuserguide']"), "Open User Guide", 20);
		click(By.xpath("//a[@class='ancuserguide']"), "Close User Guide", 20);
		clickByJavascript(By.xpath("//a[text()='Cancel']"), "Click on Cancel Button", 25);
	}
	
	
	 public void templateName()
	 {
		 
		 String currentURl = driver.getCurrentUrl();
		    
		    
		    if (currentURl.contains("emailtemplate/add"))
		    {
		 String Templatename =prop.getProperty("emailtemplatename")+datevalue;
		 enter(By.id("TemplateName"),Templatename,"Template Name", 20);
		 EmailTemplatename=Templatename;
		    }
		    else
		    {
		    	 String Templatename =prop.getProperty("advanceemailtemplatename")+datevalue;
				 enter(By.id("TemplateName"),Templatename," Advance Template Name", 20);
				 AdvacneEmailTemplatename=Templatename;
		    }
		    
	 }
	 
	 public void greetingTemplateName()
	 {
		 
		 String Greetingtemplatename =prop.getProperty("greetingtemplatename")+datevalue;
		 enter(By.id("TemplateName"),Greetingtemplatename,"Template Name", 20);
		 GreetingTemplatename=Greetingtemplatename;
	 }
	 
	 public void subjectName()
	 {
		 String Subjectname =prop.getProperty("subjectname")+datevalue;
		 enter(By.id("TemplateSubject"),Subjectname,"Template Name", 20);
		 EmailTemplatesubject=Subjectname;
		 
	 }
	 
	 
	 
	 public void selectCategory()
	 {
		 selectValueWithText(By.id("TemplateCategoryId"),prop.getProperty("emailtemplatecategory"),"Email Template Category", 25);
		 staticWait(1000);
		 
		 verifySelectedValue(By.id("TemplateCategoryId")," verify Email Template Category",prop.getProperty("emailtemplatecategory") ,20);	 
	 }
	 
	 public void selectCategoryTicketing()
	 {
		 selectValueWithText(By.id("TemplateCategoryId"),"Ticketing","Email Template Category", 25);
		 staticWait(1000);
		 
		
	 }
	  
	 public void selectGreetingCategory()
	 {
		 selectValueWithText(By.id("TemplateCategoryId"),prop.getProperty("emailtemplategreetingcategory"),"Email Template  Greeting Category", 25);
		 staticWait(1000);
		 
		 verifySelectedValue(By.id("TemplateCategoryId")," verify Email  Template Greeting Category",prop.getProperty("emailtemplategreetingcategory") ,20);
		 
		 staticWait(2500);
	 }
	 
	 public void subCategory()
	 {
		 selectValueWithText(By.id("TemplateSubCategoryId"), prop.getProperty("emailtemplatesubcategory")," Email Template Sub Category", 20);
		 staticWait(1000);
		 verifySelectedValue(By.id("TemplateSubCategoryId"), " verify Email Template Sub Category", prop.getProperty("emailtemplatesubcategory"),20);
	 }
	 
	 
	  public void templateContent()
	  
	  {
		    String currentURl = driver.getCurrentUrl();
		    
		    
		    if (currentURl.contains("add"))
		    {
		    	WebElement iframe= driver.findElement(By.tagName("iframe"));
				  driver.switchTo().frame(iframe);
				  WebElement body = driver.findElement(By.tagName("body"));
				//  body.clear();
				  enter(By.tagName("body"), prop.getProperty("Description"), "Template Content", 35);
				  driver.switchTo().defaultContent();
		    }
		    else 
		    {
		    	System.out.println("Advanced Email Template Add screen");
		    }
			  
		  
	  }
	  
	  public void enterSearchText() {
			staticWait(2000);

			enter(By.xpath("//input[@id='search']"), EmailTemplatename, "Enter Text in Template Name search field", 25);
		}
	  
	  public void refresh() {
			clickByJavascript(By.xpath("//i[@class='fa fa-refresh']"), " Refresh Button", 25);
		}

		public void searchButton() {
			staticWait(1000);
			clickByJavascript(By.id("Go"), "Search Button", 20);
			staticWait(1000);

		}
		
		public void clickTemplateName()
		{
			click(By.xpath("//table[@id='tblEmailTemplate']//a"), "Template Name", 25);
		}
		public void selectcheckbox() {
			staticWait(3000);
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
			staticWait(2000);
			click(By.xpath("//button[@title='OK']"), "ok Button", 20);
			staticWait(1000);
			driver.navigate().refresh();

		}

		public void verifyActiveStatusValue() {
			verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Channel Status Value",
					prop.getProperty("activeStatus"), 20);
		}

		public void verifyInactiveStatusValue() {
			verifySelectedValue(By.xpath("//div[@class='cstm-drop-btn']/select"), "Channel Status Value",
					prop.getProperty("inactiveStatus"), 20);
		}

		public void deleteButton() {
			staticWait(2000);

			click(By.id("DeleteMultiple"), "Delete Button", 25);
		}
		
		public void advancedEmailTemplateButton()
		{
			click(By.xpath("//span[text()='Add Advanced Email Template']"), " Add Advanced Email Template button", 20);
//			staticWait(5000);
		}

		
		public void headingSetup()
		{
			try {
 
//				staticWait(8000);
				
				
//			WebElement iframe=driver.findElement(By.tagName("iframe"));
//			System.out.println("switch to frame");
//			
//			driver.switchTo().frame(iframe);
//			Actions action = new Actions(driver);
//			staticWait(2000);
//			WebElement drag = driver.findElement(By.xpath("//div[@class='blockbuilder-content-tool'][3]"));
//		
//			//WebElement drag=	driver.findElement(By.xpath("//div[text()='Heading']"));
//			WebElement drop = driver.findElement(By.xpath("//div[@class='blockbuilder-placeholder-empty']"));
//			
//			action.dragAndDrop(drag, drop);
//			staticWait(2000);
			
				
			    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//Actions class method to drag and drop 
				WebElement iframe=driver.findElement(By.tagName("iframe"));
				System.out.println("switch to frame");
                staticWait(5000);				
				driver.switchTo().frame(iframe);

				Actions builder = new Actions(driver);
				staticWait(5000);
				WebElement from = driver.findElement(By.xpath("//div[@class='blockbuilder-content-tool'][3]"));
				from.click();
				WebElement to = driver.findElement(By.xpath("//div[@class='blockbuilder-placeholder-empty']")); 
				//Perform drag and drop
				builder.dragAndDrop(from, to).build().perform();
				
				//verify text changed in to 'Drop here' box 
				String textTo = to.getText();
				if(textTo.equals("Heading")) {
				System.out.println("PASS: File is dropped to target as expected");
				getTest().log(LogStatus.PASS, textTo + " entered with value - " + textTo);
				}else {
				System.out.println("FAIL: File couldn't be dropped to target as expected");
				Assert.fail("drag drop does not work" );
				}
			
			
		
			
			
			/*
			 * WebElement headingdropelement
			 * =driver.findElement(By.xpath("//div[@class='blockbuilder-placeholder-empty']"
			 * )); Point droppoint = headingdropelement.getLocation(); int dropxcord =
			 * droppoint.getX();
			 * System.out.println("Position of the dragwebelement from left side is "
			 * +dropxcord +" pixels"); int dropycord = droppoint.getY();
			 * 
			 * WebElement headingdragelement =
			 * driver.findElement(By.xpath("//div[@class='blockbuilder-content-tool'][3]"));
			 * action.dragAndDropBy(headingdragelement, dropxcord,
			 * dropycord).build().perform();;
			 */
			
			
			/*Point dragpoint = headingdragelement.getLocation();
			int dragxcord = dragpoint.getX();
			System.out.println("Position of the dragwebelement from left side is "+dragxcord +" pixels");
			int dragycord = dragpoint.getY();
			System.out.println("Position of the dragwebelement from top side is "+dragycord +" pixels");
			
			WebElement headingdropelement =driver.findElement(By.xpath("//div[@class='blockbuilder-placeholder-empty']"));
			Point droppoint = headingdragelement.getLocation();
			int dropxcord = droppoint.getX();
			System.out.println("Position of the dragwebelement from left side is "+dropxcord +" pixels");
			int dropycord = droppoint.getY();
			System.out.println("Position of the dragwebelement from top side is "+dropycord +" pixels");
			*/
			
			
			
		//	action.clickAndHold(driver.findElement(By.xpath("//div[@class='blockbuilder-content-tool'][3]"))).moveToElement(headingdropelement).release(headingdragelement).build().perform();

			//Actions action = new Actions(driver);
			
			//staticWait(2000);
			//action.dragAndDrop(headingdragelement, headingdropelement).build().perform();
		
			driver.switchTo().defaultContent();
//			staticWait(2000);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}


}
