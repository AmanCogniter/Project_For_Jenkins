package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class CurrencyManagementPage extends WebBasePage {
	
	WebDriver driver ;
	static int  rowCount = 0;
	Actions  action;
	
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	
	
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	public CurrencyManagementPage (WebDriver driver)
	{
		super(driver , "CurrencyManagementPage");
		this.driver= driver;
		  action = new Actions(driver);
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
     
     public void clickOnCurrencyManagement()
     {
    	 clickByJavascript(By.xpath("//a[text()='Currency Management']"),"Currency Management",20);
     }
     
     public void saveButton()
     {
    	 staticWait(2000);
    	 click(By.id("aCurrencyManagementSave"), "Save Button", 25);
    	 
    	 
    	 
     }
     
      public void SaveButtonIsEnable()
      {
    	 // isDisplayed(By.id("aCurrencyManagementSave"), "Save Button", 25);
    	  WebElement element =  findElementClickable(By.className("btn btn-secondary disabled"), 25);
    	// WebElement element =  findElementClickable(By.id("aCurrencyManagementSave"), 25);
    	 if (element == null)
    	 {
    		 getTest().log(LogStatus.PASS , "Save Button Displayed");
        	 logger.info("Save Button Displayed");
         }
         else
         {
        	 try {
     			 getTest().log(LogStatus.FAIL , "Save Button is not Displayed");
             	 logger.info("Save Button is not Displayed");
             	takeScreenshot(new Object() {
                }.getClass().getEnclosingMethod().getName());
//                Assert.fail(" element is not displayed");
			} catch (Exception e) {
				 Assert.fail(" element is  not displayed "+e);
			}
         }
    	 
      }
      
      public void SaveButtonIsDisable()
      {
    	  
    	  staticWait(2000);
    	  WebElement element =  findElementClickable(By.className("btn btn-secondary disabled"), 25);
    	 // WebElement element =  driver.findElement(By.className("btn btn-secondary disabled"));
     	 if (element!=null)
     	 {
     		 try {
     			 getTest().log(LogStatus.FAIL , "Save Button Displayed");
             	 logger.info("Save Button Displayed");
             	takeScreenshot(new Object() {
                }.getClass().getEnclosingMethod().getName());
//                Assert.fail(" element is not displayed");
			} catch (Exception e) {
				 Assert.fail(" element is  displayed "+e);
			}
     		
          }
          else
          {
         	 getTest().log(LogStatus.PASS, "Save Button is not Displayed");
         	 logger.info( "Save Button is not Displayed");
              
          }
      
      }
      
	
    public void CompanyBaseCurrency()
    {
    	String value = getAtribute(By.xpath("//Select[@id='ManageCurrencyId']/option[@selected='selected']"),"value", 25);
    	System.out.println("value");
    	
    	int valuecount = Integer.parseInt(value);
    	
    	if (valuecount==157)
    	{
    		valuecount=0;
    	}
    	else
    	{
    		valuecount++;
    	}
    	
    	System.out.println(valuecount);
    	
    	 staticWait(2000);
    selectValueWithIndex(By.id("ManageCurrencyId"),valuecount, "Company Base currency", 30);
    	//staticWait(2000);
    }
    
    public void okConfirmButton() {
    	staticWait(1000);
		click(By.xpath("//button[@title='OK']"), "ok Button", 20);
		staticWait(2000);
	}
    
    public void  Addicon()
    {
    	clickByJavascript(By.id("btnAdd"), "Add icon" , 25);
    }
    
    public void cancelButton()
	  {
    	staticWait(1000);
		  click(By.xpath("//a[text()='Cancel']"), "Cancel Button", 20);
	  }
    
    public void mandatoryFieldMessage()
    {
    	
    	String actualsourcecurrencymessage;
    	String actualcurrencyratemessage;
    	
    	
    	rowCount = driver.findElements(By.xpath("//table[@id='tbContainer']/tbody/tr")).size();
    	
    	actualsourcecurrencymessage = driver.findElement(By.xpath("//table[@id='tbContainer']/tbody/tr["+rowCount+"]//span")).getText();
    	
    	actualcurrencyratemessage= driver.findElement(By.xpath("//table[@id='tbContainer']/tbody/tr["+rowCount+"]/td[4]/span")).getText();
    	
    	System.out.println("Actual source currency Message =" + actualsourcecurrencymessage);
    	System.out.println("Actual currency rate Message = " +actualcurrencyratemessage);
    	
    	String expectedsourcecurrencymessage = prop.getProperty("sourcecurrencyvalidation");
    	String  expectedcurrencyratemessage = prop.getProperty("currencyratevalidation");
    	
    	
    	
    	if (expectedsourcecurrencymessage.equals(actualsourcecurrencymessage))
    	{
    		getTest().log(LogStatus.PASS,
					"Validation message for Source currency field is displayed as expected");
			logger.info("Validation message for Source currency field is displayed as expected");
    	}
    	else
    	{
    		getTest().log(LogStatus.FAIL, "Validation message for Source currency field is not displayed as expected");
			logger.info("Validation  message for Source currency field is not displayed as expected");
			takeScreenshot("SourceCurrency");
    	}
    
    	System.out.println(expectedcurrencyratemessage);
    	System.out.println(actualcurrencyratemessage);
    	
    	 if (expectedcurrencyratemessage.equalsIgnoreCase(actualcurrencyratemessage))
    	{
    		 
    		 getTest().log(LogStatus.PASS,
 					"Validation message for Currency Rate field is displayed as expected");
 			logger.info("Validation message for Currency Rate field is displayed as expected");
     	}
     	else
     	{
     		getTest().log(LogStatus.FAIL, "Validation message for Currency Rate field is not displayed as expected");
 			logger.info("Validation  message for Currency Rate field is not displayed as expected");
 			takeScreenshot("Currency Rate");
     	}
    //	System.out.println(sourcecurrencymessage);
    	//System.out.println(rowCount);	
    	 
    	 
    	  
    }
    
    public void alreadySelectedCurrencyValidation()
	  {
    	
    	 String expectedAlreadyExistMessage= prop.getProperty("sourcescurrencyalreadyselected");
    	String selectedValue = getText(By.xpath("//Select[@id='SourceCurrencyId_0']/option[@selected='selected']"), 25);
    //	String CurrencyValueRowOne =  getAtribute(By.xpath("//Select[@id='SourceCurrencyId_0']/option[@selected='selected']"),"value",25);
    //	int currencyIntValue = Integer.parseInt(CurrencyValueRowOne);
    	int newrowCount = driver.findElements(By.xpath("//table[@id='tbContainer']/tbody/tr")).size();
    	
    	System.out.println(selectedValue);
    	int idValue = newrowCount-1;
	  	System.out.println(idValue);
	  	
	  	String  idConcatValue = "SourceCurrencyId_"+idValue;
    	System.out.println(idConcatValue);
    	WebElement selectvalue =driver.findElement(By.xpath("//select[@id='"+idConcatValue+"']"));
    	
    	Select se = new Select(selectvalue);
    	staticWait(3000);
    	click(By.xpath("//select[@id='"+idConcatValue+"']"), "Click Select", 20);
        se.selectByVisibleText(selectedValue);
        staticWait(3000);
        
       // saveButton();
        
       String actualAlreadyExistMessage = getText(By.xpath("//select[@id='"+idConcatValue+"']/..//span"), 30);
       System.out.println(actualAlreadyExistMessage);
       
       if (expectedAlreadyExistMessage.equals(actualAlreadyExistMessage))
       {
    	   
    	   getTest().log(LogStatus.PASS,
					"Validation message for duplicate source currency is displayed as expected");
			logger.info("Validation message for duplicate source currency is displayed as expected");
    	}
    	else
    	{
    		getTest().log(LogStatus.FAIL, "Validation message for duplicate source currency is not displayed as expected");
			logger.info("Validation  message for duplicate source currency is not displayed as expected");
			takeScreenshot(" Source Currency");
    	}
        
   
	  }
    
     public void alreadySelectedBaseValidation()
     {
    	 String selectedValue = getText(By.xpath("//select[@id='ManageCurrencyId']/option[@selected='selected']"), 25);
    	 
    	String expectedAlreadyExistMessage =   prop.getProperty("basecurrencyalreadyselected");
    	 
    	 int newrowCount = driver.findElements(By.xpath("//table[@id='tbContainer']/tbody/tr")).size();
     	
     	System.out.println(selectedValue);
     	int idValue = newrowCount-1;
 	  	System.out.println(idValue);

	  	String  idConcatValue = "SourceCurrencyId_"+idValue;
    	System.out.println(idConcatValue);
    	WebElement selectvalue =driver.findElement(By.xpath("//select[@id='"+idConcatValue+"']"));
    	
    	Select se = new Select(selectvalue);
    	staticWait(3000);
    	 se.selectByVisibleText(selectedValue);
    	 
    	 
    	 String actualAlreadyExistMessage = getText(By.xpath("//select[@id='"+idConcatValue+"']/..//span"), 30);
         System.out.println(actualAlreadyExistMessage);
         
         if (expectedAlreadyExistMessage.equals(actualAlreadyExistMessage))
         {
      	   
      	   getTest().log(LogStatus.PASS,
  					"Validation message for duplicate base currency is displayed as expected");
  			logger.info("Validation message for duplicate base currency is displayed as expected");
      	}
      	else
      	{
      		getTest().log(LogStatus.FAIL, "Validation message for Base currency is not displayed as expected");
  			logger.info("Validation  message for duplicate base currency is not displayed as expected");
  			takeScreenshot(" Source Currency");
      	}
 	  	
     }
     
      public void enterSourceAndRate  ()
      {
    	  
    	  staticWait(2000);
    	  rowCount = driver.findElements(By.xpath("//table[@id='tbContainer']/tbody/tr")).size();
    	  int idValue = rowCount-1;

  	  	String  sourceCurrencyID = "SourceCurrencyId_"+idValue;
      	WebElement selectvalue =driver.findElement(By.xpath("//select[@id='"+sourceCurrencyID+"']"));
      	Select se = new Select(selectvalue);
      	
      	 Random rand = new Random();

         int random = rand.nextInt(157);
      	se.selectByIndex(random);
      	String actualsourcecurrencymessage = driver.findElement(By.xpath("//table[@id='tbContainer']/tbody/tr["+rowCount+"]//span")).getText();
      	System.out.println(actualsourcecurrencymessage);
      	
      	String expectedsourcecurrencymessage = prop.getProperty("sourcescurrencyalreadyselected");
    	
    	if (expectedsourcecurrencymessage.equals(actualsourcecurrencymessage))
    	{
    		System.out.println(" Check 2 ");
    		
    		if (random==157)
        	{
    			random=0;
        	}
        	else
        	{
        		random++;
        	}
    		se.selectByIndex(random);
    		
    	}
    	
    	String  CurrencyRateID = "currency_rate_"+idValue;
      //	WebElement selectvalue =driver.findElement(By.xpath("//select[@id='"+CurrencyRateID+"']"));
    	enter(By.xpath("//input[@id='"+CurrencyRateID+"']"), "25", "Currency Rate", 30);
    	  
    	  saveButton();
    	
      }
      
      
      public void  delete()

      {
    	  
    	  rowCount = driver.findElements(By.xpath("//table[@id='tbContainer']/tbody/tr")).size();
    	  int idValue = rowCount-1;
    	  
    	  String  trid = "Currencytr_"+idValue;
    	  
    	  System.out.println(trid);
    	  staticWait(2000);
    	 // click(By.xpath("//tr[@id='"+trid+"']//a[@data-original-title='Remove']"), "Delete Button", 25);\
    	  WebElement deleteButton = driver.findElement(By.xpath("//tr[@id='"+trid+"']//i[@class='fa fa-trash']"));
    	  action.moveToElement(deleteButton).click().build().perform();
    	  staticWait(2000);
    	//  clickByJavascript(By.xpath("//tr[@id='"+trid+"']//a[@class='round-icon-small btn-danger-light']"), "Delete Button", 25);	  
      }
      
      public void HandleSuccessMessage()
	     
	     {
    	 
	    	 click(By.xpath("//Button[@id='closenotifymessage']"), " Close Success Message", 25);
	     }
      
      
      
    
    
  
	
}
