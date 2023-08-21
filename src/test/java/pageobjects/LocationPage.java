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

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class LocationPage extends WebBasePage {

		WebDriver driver;
		
		static String Parentlocationname;
		static String ChildLocationame;
		static String updateParentLocationName;
		static String updatedChildLocationName;
		
		
		String pattern = "yyMMddHHmmss";
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
		String datevalue = dateformat.format(date);

		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
		private final static String FILE_NAME = System.getProperty("user.dir")
				+ "\\src\\main\\resources\\testdata.properties";
		private static Properties prop = new PropertiesLoader(FILE_NAME).load();
		
		public LocationPage( WebDriver driver)
		{
			super(driver , "Location");
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

		public void clickLocationTab() {
			
			//JavascriptExecutor js = (JavascriptExecutor)driver;
			//js.executeScript("document.getElementById('divTabs').scrollTop= 450");
			click(By.xpath("//a[@role='tab'][normalize-space()='Location']"), "Location Tab", 20);
			staticWait(2000);
		}
		
		public void addLocationButton()
		{
			click(By.xpath("//span[normalize-space()='Add']"), " Add Parent Location Button", 20);
		}
		
		public void enterLocationName()
		{
			
			String locationame = prop.getProperty("Location")+ datevalue;
			Parentlocationname = locationame;
			
			enter(By.xpath("//input[@id='LocationName']"),locationame, " Location Name", 25);
		}
		
		public void enterChildLocationName()
		{
			
			String locationame = prop.getProperty("childlocation")+ datevalue;
			ChildLocationame = locationame;
			
			enter(By.xpath("//input[@id='LocationName']"),locationame, " Location Name", 25);
		}
		
		
		
		public void enterAddress1()
		{
			
			enter(By.xpath("//input[@id='Address1']"),prop.getProperty("locationaddress"),"Address 1", 25);
		}
		
		//input[@id='City']
		
		public void enterCity()
		{
			 
			enter(By.xpath("//input[@id='City']"), prop.getProperty("locationcity"),"City", 20);
		}
		
		public void selectCountry()
		{
			selectValueWithText(By.xpath("//select[@id='ddlCountry']"), "United States", "Country", 25);
		}
		
		public void selectState()
		{
			staticWait(2000);
			selectValueWithText(By.xpath("//select[@id='ddlState']"),"New York(NY)", "State", 25);
		}
		
		public void enterPostalCode()
		{
			enter(By.xpath("//input[@id='PinCode']"), prop.getProperty("locationpostalcode"),"Postal Code", 25);
		}
		
		public void enterEmail()
		{
			enter(By.xpath("//input[@id='Email']"), prop.getProperty("locationemail"), "Email", 25);
		}
		
		public void enterPhone1()
		{
			enter(By.xpath("//input[@id='Phone1']"), prop.getProperty("locationphone1"),"Phone1",25);
		}
		
		public void enterPhone2()
		{
			enter(By.xpath("//input[@id='Phone2']"), prop.getProperty("locationphone2"), "Phone2",25);
		}
		
		public void locationCode()
		{
			enter(By.xpath("//input[@id='LocationCode']"),prop.getProperty("locationcode"),"Location Code",25);
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
					By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 45);
			String[] expectedValue = {"Location Name","Address Line 1","City","Country"};
			for (Object expected : expectedValue) {
				WebElement asterikField = findElementVisibility(By.xpath("//label[contains(text(),'"+expected+"')]/parent::tg-input/descendant::span[contains(text(),'*')]"), 45);

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
			staticWait(2000);
			clickByJavascript(By.xpath("//div/a[@data-original-title='Cancel']"), " Cancel Button", 25);
		}

		
		public void openAndCloseUserGuide() {
			staticWait(2000);
			click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"), "Open User Guide", 45);
			staticWait(2000);
			click(By.xpath("//span[@class='user-guide']/a[@class='ancuserguide']"), "Close User Guide", 45);
		}
		
		
		 
		 public void searchParentLocation()
			{
				enter(By.id("search"), Parentlocationname, "Search Field ", 25);
			}
		 
		 public void searchUpdatedParentLocation()
		 {
			 enter(By.id("search"), updateParentLocationName, "Search Field ", 25); 
		 }
		 public void searchUpdatedChildLocation()
		 {
			 enter(By.id("search"), updatedChildLocationName, "Search Field ", 25); 
		 }
		 
		  public void searchChildLocation()
		  {
			  enter(By.id("search"), ChildLocationame, "Search Field ", 25);
		  }
			
		public void searchButton()
			{
				clickByJavascript(By.id("Go"), " Search Button", 25);
				//String SearchedValue = getText(By.id("ancEditLocation"), 25);
			//	afterSearchValue= SearchedValue;
			}
		 public void verifyParentSearch()
		 {
				verifySearchRecord(By.id("ancEditLocation"), Parentlocationname, "ParentLocation", 25);
				
				staticWait(4000);	
		}
		 
		 public void verifyChildSearch()
		 {
				verifySearchRecord(By.xpath("//ul[@class='parentbasemaster']//a[@id='ancEditLocation']"), ChildLocationame, "ParentLocation", 25);
				
				staticWait(4000);	
		}
		
		public void addChildLocationButton()
		{
			click(By.xpath("//a[@class='addchildtoparent']"), "Click on Add Child" ,25);
			
			
		}
		
		 public void clickParentLocationName()
		 {
			 clickByJavascript(By.xpath("//ul[@class='ullocation']/li/div[@class='mainlinebase']//a[@id='ancEditLocation']"), " Click on the Parent Location name", 25);
		 }
		 
		  public void  clearLocationNameText()
		  {
			  driver.findElement(By.xpath("//input[@id='LocationName']")).clear();
			  
		  }
		  
		  public void updatedParentLocation()
		  {
			  
				String locationame = prop.getProperty("updatedlocationname")+ datevalue;
				updateParentLocationName = locationame;
				
				enter(By.xpath("//input[@id='LocationName']"),locationame, " Location Name", 25);	  
			  
		  }
		  
		  public void updatedChildLocation()
		  {
			  String locationame = prop.getProperty("updatedchildlocationname")+ datevalue;
			  updatedChildLocationName = locationame;
				
				enter(By.xpath("//input[@id='LocationName']"),locationame, " Location Name", 25);
		  }
		  
		  public void clickOnChildLocationName()
		  {
			  clickByJavascript(By.xpath("//ul[@class='parentbasemaster']//a[@id='ancEditLocation']"), " Click on the Child Location name", 25);
		  }
		
//		  public void inactiveParentChildLocation()
//		  {
//			  public void searchParentLocation()
//				{
//					enter(By.id("search"), Parentlocationname, "Search Field ", 25);
//				}
//			  
//		  }
		  
		   public void clickChildInactiveStatus()
		   {
			   selectValueWithText(By.xpath("//ul[@class='parentbasemaster']//div[@class='mainlinebase']/div[6]//select[contains(@class,'ddlupdatestatus')]"), "Inactive", "Inactive Status",25);
		   }
		   
		   public void clickParentInactiveStatus()
		   {
			   selectValueWithText(By.xpath("//ul[@class='ullocation']/li/div[@class='mainlinebase']//div[6]//select[contains(@class,'ddlupdatestatus')]"), "Inactive", "Inactive Status",25);
			 //ul[@class='ullocation']/li[@class='parentli']/div//a[@id='ancEditLocation']
		   }
		   
		   public void deleteChildLocation()
		   {
			   //((JavascriptExecutor driver).executeScript('window.scrollBy(2000,0)');
			   
			   JavascriptExecutor executor = (JavascriptExecutor) driver;
			   executor.executeScript("window.scrollBy(element.clientWidth),0)");
			   click(By.xpath("//ul[@class='parentbasemaster']//div[@class='mainlinebase']//div[8]/a/i"),"Delete Child Location", 25);
		   }
		   public void deleteParentLocation()
		   {
			   
			   JavascriptExecutor executor = (JavascriptExecutor) driver;
			   executor.executeScript("window.scrollBy(element.clientWidth),0)");
			   click(By.xpath("//ul[@class='ullocation']/li/div[@class='mainlinebase']//div[8]//a/i"),"Delete Parent Location", 25);
		   }
		   
		   
		   public void okConfirmButton()
			 {
				 click(By.xpath("//button[@title='OK']"),"ok Button", 20);
				 staticWait(2000);
				 
				 driver.navigate().refresh();
				
			 }
			 
		
	
		
	

}
