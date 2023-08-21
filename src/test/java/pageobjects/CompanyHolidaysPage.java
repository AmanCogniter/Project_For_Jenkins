package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class CompanyHolidaysPage extends WebBasePage {

	WebDriver driver ;
	String pattern="yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	
	String datevalue = dateformat.format(date);
	
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
    private final static String FILE_NAME = System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties";
    private static Properties prop = new PropertiesLoader(FILE_NAME).load();
    
    String SelectedDate;
    String HolidayDate; 
    String[]  holidaylistingdates;
    String HolidayName;
    
    ArrayList Datelist= new ArrayList();
	
	public CompanyHolidaysPage (WebDriver driver)
    {
		
		
    	super(driver , "Company Holiday Page" );
    	this.driver = driver ;
    }
    
    public void clickFullMenuDropDown() {
        click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);
        staticWait(2000);
    }
     public void clickCompanySetupLink()
     
     {
    	 staticWait(1000);
    	 //click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"),"Company Setup Link", 30);
    	 click(By.xpath("//li[@data-name='COMPANY SETUP']"),"Company Setup Link", 30);
     }
     public void clickCompanySetupPage()
     {
    	 staticWait(1000);
    	 click(By.xpath("(//a[contains(text(),'Company Setup')])[last()]")," Company Setup Page", 30);
     }
     
     public void clickOnCompanyHolidays()
     {
    	 staticWait(3000);
    	 clickByJavascript(By.xpath("//a[text()='Company Holidays']"),"Company Holidays",20);
     }
     
      public void clickOnAdd()
      {
    	staticWait(3000);
    	/* List<WebElement> rows = table.findElements(By.tagName("tr"));
    	 List<WebElement> columncount = null;
    	 
    	 for (WebElement rowcount: rows)
    	 {
    		//System.out.println (rowcount);
    		 columncount = rowcount.findElements(By.tagName("td"));
    		 for(WebElement column : columncount)
    		 {
    			// System.out.print(column.getText()+",");
    			 System.out.print(column.ge);
    		 }
    		 System.out.println();
    	 }
    	 
    	 */
    	 click(By.xpath("//a[@id='ancCreateHR']"),"Add Company Holiday", 25 ); 	  
      }
      
      
      public void getHolidayDates()
      {
    	  staticWait(3000);
    	  selectValueWithValue(By.xpath("//select[@id='pageSize']"),"100", "Page Size",35);
          waitForLoader(20);
         List<WebElement> holidaydates=  findMultipleElement(By.xpath("//table[@id='tblHR']//tr/td[2]"), 35);
          int iteration =0;
         for(WebElement date : holidaydates)
         {
        	 iteration++; 
        	 String holidayDateValue = driver.findElement(By.xpath("//table[@id='tblHR']//tr["+iteration+"]//td[2]")).getText().trim();
        	 
        	 //System.out.println(holidayDateValue);	
        	 Datelist.add(holidayDateValue); 	 
         }
         System.out.println(Datelist);
         
        
    	  
    	  
      }
      public void SelectNextMonth()
      {
    	  
    	  clickByJavascript(By.xpath("//input[@id='txtHolidateDate']/..//i[@class='fa fa-calendar']")," calendar popup open", 35);
    	  click( By.xpath("//span[@title='Next Month']"),"Next Month", 25);
    	  
    	  String[] Temp = SelectedDate.split("/");
         	String Month= Temp[0].toString();
          	String Day = Temp[1].toString();
          	String Year = Temp[2].toString();
          	System.out.println(Month);
          	System.out.println(Day);
          	System.out.println(Year);
          	
          	int  NewMonth = Integer.parseInt(Month)+1;
          	
          	System.out.println(NewMonth);
    	  
    	  String NewDate = NewMonth+"/"+Day+"/"+Year;
    	  System.out.println(NewMonth+"/"+Day+"/"+Year);
    	  
    	  driver.findElement(By.id("txtHolidateDate")).clear();
    	  System.out.println("clear Date text");
    	  driver.findElement(By.id("txtHolidateDate")).sendKeys(NewDate.toString());
    	  waitForLoad(20);
    	  
    	  
    	//span[contains(text(), 'Duplicate company')]
      }
      
      public void save()
      {
    	  clickByJavascript(By.xpath("//a[@id='btnSaveHoliday']"),"Save Holiday Button", 20); 
    	  waitForLoad(20);
      }
      public void clickOnAddHoliDayInCheckBOx()
      { staticWait(2000);
    	  click(By.xpath("//input[@name='Company']/parent::div[@class='custom-control custom-checkbox']"),"Add HoliDay Check Box", 20); 
    	  
      }
      
   /*   public void VerifyMandatoryFieldValidation()
 	 {
 		 int i=0;
 		 String actualText;
 		 String expectedText;
 		 ArrayList<String> FieldValue = new ArrayList<String>();
 		
// 		List<WebElement> Value = driver.findElements(By.xpath("//*[@id='frmHoliday']/div[1]/div[1]/div/label/text()"));
 		 
  		WebElement Value = driver.findElement(By.xpath("//*[@id='frmHoliday']/div[1]/div[1]/div/label/text()"));

  		System.out.println("values are :::" +Value);
  		  
 		//List<WebElement> Value = driver.findElements(By.xpath("//span[text()='*']/parent::label/text()"));
// 		for(int j = 0 ; i<Value.size();i++)
// 		{
// 			 System.out.println(Value.get(j).getText()); 
// 		}
 		
 		
 		 
 		
 		 
 	
 		List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
 		
 		
 		
 		 
 	     //   List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
 	        String[] expectedValue = {"Name","Date ","Location"};
 	        for(Object expected : expectedValue)
 	        {
 	        	WebElement AsteriskField = findElementVisibility(By.xpath("//label[@class='lblctrlname']/span/parent::label[starts-with(text(),'"+ expected +"')] | //span[text()='*']/parent::label[starts-with(text(),'"+ expected +"')]"), 45);
 	        	if (AsteriskField!= null)
 	        	{
 	        		  getTest().log(LogStatus.PASS, "The Asterisk symbol is displayed for " + expected + " field");
 	                  logger.info("The Asterisk symbol is displayed for " + expected + " field");
 	              } else {
 	                  getTest().log(LogStatus.FAIL, "The Asterisk symbol is not displayed for " + expected + " field");
 	                  logger.info("The Asterisk symbol is not displayed for " + expected + " field");
 	                  takeScreenshot(expected.toString());
 	                 Assert.fail("VerifyMandatoryFieldValidation");
 	        	}
 	        
 	        List<WebElement> expectedElements = errorMessageLocator;
             for (WebElement element : expectedElements) {
                 i++;
                 actualText = element.getText();
                 System.out.println("Actual Value" +actualText);
                 
                 expectedText = expected.toString();
                 System.out.println("Expected Value" + expectedText);
                
                 if (actualText.indexOf(expectedText) != -1) {
                     getTest().log(LogStatus.PASS, "Error message for \"" + expected + "\" field is displayed as expected");
                     logger.info("Error message for \"" + expected + "\" field is displayed as expected");
                     i = 0;
                     break;
                 } else if (i == expectedValue.length && !element.getText().contains(expectedText)) {
                     getTest().log(LogStatus.FAIL, "Error message for \"" + expected + "\" field is not displayed");
                     logger.info("Error message for \"" + expected + "\" field is displayed as expected");
                     takeScreenshot(expectedText);
                     Assert.fail("VerifyMandatoryFieldValidation");
                 }
             }
             
 	        }
 	 }
      */
      
      
      public void VerifyMandatoryFieldValidation() {
    		int i = 0;
    		String actualText;
    		String expectedText;

    		List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
    		String[] expectedValue = {"Name","Date ","Location"};
    		for (Object expected : expectedValue) {
    			//WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()='" + expected + ":']"), 45);
    			WebElement AsteriskField = findElementVisibility(By.xpath("//label[contains(text(),'" + expected + "')]/ancestor::div[@class='form-group']/descendant::span[contains(@class,'mandatory')]"), 45);
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
      public void UserGuideAndCancel()
  	  {
  		  click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"),"Open User Guide",20);
  		  click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"),"Close User Guide",20);
  		  clickByJavascript(By.xpath("//a[text()='Cancel']"),"Click on Cancel Button", 25);
  	  }
      
      public void EnterHolidayName()
      {
    	  enter(By.xpath("//input[@id='HolidayName']"),prop.getProperty("HolidayName")+datevalue ,"Holiday Name", 25);
      }
      
      public void SelectLocation()
      {
    	  click(By.xpath("(//div/button/span[text()='Select'])[last()]"),"Location dropdown", 25);
    	 // WebElement LocationList = driver.findElement(By.id("CompantLocationSelect"));
    	  click(By.xpath("(//div/ul/li/a/label[contains(text(),'Dallas')])[last()]")," Select Location" , 25);
    	
      }
      
      public void Description()
      {
    	  
    	  enter(By.xpath("//textarea[@id='Description']"),prop.getProperty("Description"), "Enter Description", 20);
      }
      
      public void SelectDate()
      {
    	  
    	  clickByJavascript(By.xpath("//input[@id='txtHolidateDate']/..//i[@class='fa fa-calendar']")," calendar popup open", 35); 
    	  clickByJavascript(By.xpath("//input[@id='txtHolidateDate']/..//i[@class='fa fa-calendar']")," calendar Icon Close", 35); 
    	//span[@title='Next Month']
    	  waitForLoader(20);
    	 SelectedDate = driver.findElement(By.id("txtHolidateDate")).getAttribute("value");
    //	System.out.println(SelectedDate);
    	VerifyDate();
    	
    	
    	 //if (Arrays.asList(Datelist).contains(SelectedDate))
    	//for ( int i=0; i <=  Datelist.length(); i++)
      }
      
      public void VerifyDate()
      {
    	  try
    	  {
    	  
    		if(Datelist.contains(SelectedDate))
    		{
        	 System.out.println("Selected Date already exist");
        	 SelectNextMonth();  
        	save();
        	staticWait(2000);
        	if (driver.findElement(By.xpath("//span[contains(text(), 'Duplicate company')]")).isDisplayed());
        	{
        		HandleSuccessMessage();
        		SelectDate();
         	SelectNextMonth();
         	save();
        	HandleSuccessMessage();
        	}
    		}
			/*
			 * else { save(); HandleSuccessMessage(); }
			 */
    	  }
    	  catch(NoSuchElementException e)
    	  {
    		  save(); 
      		HandleSuccessMessage();
    	  }
    	//  WebElement CurrentDate = driver.findElement(By)
    	//  HolidayDate = getText(By.id("txtHolidateDate"), 25);
    	//  System.out.println(HolidayDate);
    	  	  
      }
      public void SaveHoliday()
      {
    	  
    	
    	  clickByJavascript(By.xpath("//a[@id='btnSaveHoliday']"), "Save Button", 30);
      }
      
      public void HandleSuccessMessage()
	     
	     {
	    	 click(By.xpath("//Button[@id='closenotifymessage']"), " Close Success Message", 25);
	     }
      
      public void GetTextCompanyHoliday()
      {
    	  WebElement HolidayNametext = driver.findElement(By.xpath("//table[@id='tblHR']//tbody/tr[1]/td/a"));
    	 HolidayName= HolidayNametext.getText().trim();
    	
      }
      
      public void EntertextIntoNameSearchHoliday()
      {
    	  enter(By.xpath("//div/input[@name='HolidayName']"), HolidayName, "Enter Search text", 35);
	    	 searchButton();
      }
    
      
      public void searchButton()
	   {
		   click(By.xpath("//a[@id='btnSearch']"), "Search Button", 25);	   
		   staticWait(2000);
	   }
      
       public void VerifySearch()
       {
    	   
    	   WebElement AfterSearchHolidayName = driver.findElement(By.xpath("//table[@id='tblHR']//tbody/tr[1]/td/a"));
    	  String AfterSearchHolidayNametext= AfterSearchHolidayName.getText().trim();
    	  
    	  if (AfterSearchHolidayNametext.equals(HolidayName))
    	  {
    		  System.out.println(" Search shows correct Record");
    	  }
    	  else
    	  {
    		  System.out.println(" Search   does not shows correct Record");
    	  }
    	  
       }
       

	    
	   public void Resetbutton() {
		   clickByJavascript(By.xpath("//i[@class='fa fa-refresh']"),"Reset Button Click", 35);
		   waitForLoad(40);
		   driver.navigate().refresh();
		   
	   }
        public void SelectInactive()
        {
        	//Select status = new Select(driver.findElement(By.xpath("//table[@id='tblHR']//tbody/tr[1]/td[8]")));
			/*
			 * waitForLoad(20);
			 * click(By.xpath("//table[@id='tblHR']//tbody/tr[1]/td[8]//select")
			 * ,"Click on Status", 35);
			 * 
			 * // click(By.xpath(
			 * "//table[@id='tblHR']//tbody/tr[1]/td[8]//option[text()='Active']"),
			 * "Select Active status", 35); waitForLoad(20);
			 * click(By.xpath("//button[@title='OK']"),"Confirmation popup", 20);
			 */        	
  	 Select status = new Select(driver.findElement(By.xpath("//table[@id='tblHR']//Select [contains(@class,'ddlupdatestatus ')]")));
        	status.selectByVisibleText("Inactive");
//        	 
//        	   	
        }
        public void okConfirmButton() {
        	staticWait(1000);
			click(By.xpath("//button[text()=' OK']"), "ok Button", 20);
			staticWait(1000);
	//		driver.navigate().refresh();

		}
      
        public void SelectActive()
        {
        	//Select status = new Select(driver.findElement(By.xpath("//table[@id='tblHR']//tbody/tr[1]/td[8]")));
			/*
			 * waitForLoad(20);
			 * click(By.xpath("//table[@id='tblHR']//tbody/tr[1]/td[8]//select")
			 * ,"Click on Status", 35);
			 * 
			 * // click(By.xpath(
			 * "//table[@id='tblHR']//tbody/tr[1]/td[8]//option[text()='Active']"),
			 * "Select Active status", 35); waitForLoad(20);
			 * click(By.xpath("//button[@title='OK']"),"Confirmation popup", 20);
			 */        	
  	 Select status = new Select(driver.findElement(By.xpath("//table[@id='tblHR']//Select [contains(@class,'ddlupdatestatus ')]")));
        	status.selectByVisibleText("Active");
//        	 
//        	   	
        }
      
      
     
     
}
