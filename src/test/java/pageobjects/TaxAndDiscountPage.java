package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.j2objc.annotations.Property;
import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class TaxAndDiscountPage extends WebBasePage {

	
WebDriver driver ;
	
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);
	
	
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String taxnewname;
	static String Discountnewname;
	
	
	
	public TaxAndDiscountPage(WebDriver driver ) {
		
		super(driver, "Tax and Discount page");
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

	public void clickOnTaxAndDiscount() {
		clickByJavascript(By.xpath("//a[text()='Tax & Discount']"), "Tax and Discount Tab ", 20);
		staticWait(2000);
	}
	
	
	
	public void save() {
		clickByJavascript(By.xpath("//a[@id='Save']"), "Save Shift Name", 20);
		staticWait(3000);
	}
	
	
	public void VerifyMandatoryFieldValidation() {
		
		try {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = {"Name","Type","Percentage","Status"};
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
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	public void addTax()
	{
		String taxname= prop.getProperty("tax") + datevalue;
		enter(By.xpath("//input[@id='AdjName']"), taxname, " Tax Name", 25);
		taxnewname=taxname;
	}
	
	 public void selectStatus()
	 {
		 selectValueWithText(By.xpath("//select[@id='StatusId']"),"Active", "Select Status", 25);
	 }
	 
	 public void percentage()
	 {
		 
			enter(By.xpath("//input[@id='AdjPercentage']"),  prop.getProperty("percentage") , "Tax Percentage", 25);
	 }
	 
	 public void selectTax()
	 {
		 selectValueWithText(By.xpath("//select[@id='ddlOperator']"),"Tax", "Select Type", 25);
	 }
	 
	 public void addDiscount()
	 {
		 String discountname= prop.getProperty("discount") + datevalue;
			enter(By.xpath("//input[@id='AdjName']"), discountname, " Discount Name", 25);
			Discountnewname=discountname;
	 }
	 
	  public void selectDiscount()
	  {
		  selectValueWithText(By.xpath("//select[@id='ddlOperator']"),"Discounts", "Select Type", 25);
	  }
	  
	  
	 // Record(s) has been successfully saved.
	  
	  
	  public void verifyTaxConfirmationMessage()
		{
			findElementVisibility(By.xpath("//div[@id='notifymessage']/div/span"), 30);
			String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
			 if(Message.equalsIgnoreCase("Record(s) has been successfully saved."))
			 {
				 getTest().log(LogStatus.PASS, "Tax has been successfully added.");
	            logger.info("Tax has been successfully added.");	
			 }
			 else
				 
			 {
				 getTest().log(LogStatus.FAIL, "Tax has not been successfully added." );
	            logger.info("Tax has not been successfully added.");
	            takeScreenshot(new Object() {
	            }.getClass().getEnclosingMethod().getName());
	            //Assert.fail("" + e);
			 }
		}
	 
	  public void verifyDiscountConfirmationMessage()
		{
			findElementVisibility(By.xpath("//div[@id='notifymessage']/div/span"), 30);
			String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
			 if(Message.equalsIgnoreCase("Record(s) has been successfully saved."))
			 {
				 getTest().log(LogStatus.PASS, "Discount has been successfully added.");
	            logger.info("Discount has been successfully added.");	
			 }
			 else
				 
			 {
				 getTest().log(LogStatus.FAIL, "Discount has not been successfully added." );
	            logger.info("Discount has not been successfully added.");
	            takeScreenshot(new Object() {
	            }.getClass().getEnclosingMethod().getName());
	            //Assert.fail("" + e);
			 }
		}
	  
	  
	  public void ChangeTaxStatus()
	  {
		  
		 selectValueWithText(By.xpath("//table[@id='tblTaxandDiscount']/tbody/tr/td/a[@adjname='"+taxnewname+"']/../..//td[4]//select"), "Inactive", "Tax Active to Inactive", 25);
	  }
	  
	  public void taxokConfirmButton() {
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='OK']")));
			click(By.xpath("//button[@title='OK']"), "ok Button", 20);
			
	//		driver.navigate().refresh();

		}
	  public void discountOkButton() {
		  WebDriverWait wait = new WebDriverWait(driver,30);
			/*
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * "//button[@data-original-title='OK']")));
			 * click(By.xpath("//button[@data-original-title='OK']"), "ok Button", 20);
			 */
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='OK']")));
			click(By.xpath("//button[@title='OK']"), "ok Button", 20);
			
	//		driver.navigate().refresh();

		}
	  
	  public void ChangeDiscountStatus()
	  {
		  staticWait(3000);
		  selectValueWithText(By.xpath("//table[@id='tblTaxandDiscount']/tbody/tr/td/a[@adjname='"+Discountnewname+"']/../..//td[4]//select"), "Inactive", "Discount Active to Inactive", 25);
	  
	  }
	   public void cancelButton()
	   {
		   clickByJavascript(By.xpath("//a[text()='Cancel']"), "Click on Cancel Button", 25);
	   }
	 
	
}
