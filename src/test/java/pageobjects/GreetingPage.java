package pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class GreetingPage  extends WebBasePage {

		WebDriver driver;
		
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
		private final static String FILE_NAME = System.getProperty("user.dir")
				+ "\\src\\main\\resources\\testdata.properties";
		private static Properties prop = new PropertiesLoader(FILE_NAME).load();

		
		public  GreetingPage(WebDriver driver)
		{
			
			super(driver," Greeting Page");
			this.driver= driver;
		}
	
		
		public void clickFullMenuDropDown() {
			staticWait(2000);
			click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);
			
		}

		public void clickCompanySetupLink() {
			staticWait(2000);
			//click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"), "Company Setup Link", 30);
			click(By.xpath("//li[@data-name='COMPANY SETUP']"), "Company Setup Link", 30);
			
		}

		public void clickCompanySetupPage() {
			staticWait(2000);
			click(By.xpath("(//a[contains(text(),'Company Setup')])[last()]"), " Company Setup Page", 30);
			
		}

		public void clickOnGreeting() {
			staticWait(3000);
			clickByJavascript(By.xpath("//a[text()='Greeting']"), "Greeting", 20);
		}
		
		public void save() {
			clickByJavascript(By.xpath("//a[@id='btnSave']"), "Save Button", 20);
			waitForLoad(30);
		}
		
		public void validationMessage()
		{
			
		  String validationMessage=	getText(By.xpath("//div[@id='notifymessage']//span"),25);
		 String message =  prop.getProperty("ValidationMessage");
		  
		  
		  verifyValidationMessage(By.xpath("//div[@id='notifymessage']//span"),message, 20);
		  
		}
		
		public void deSelectTemplate()
		{
			staticWait(3000);
		//	WebElement selectelement = driver.findElement(By.id("TemplateId"));
			//Select select = new Select(selectelement);
			
			//selectValueWithText(By.xpath("//table[@id='example']/tbody/tr[1]/td[2]/select"),"Select Template","UnSelect Template", 20);
			selectValueWithText(By.xpath("//table[@id='example']/tbody/tr[1]/td[2]/tg-select/select"),"Select Template","UnSelect Template", 20);
			
		}
		
		public void EmailTemplateURL()
		{
			staticWait(3000);
			//open("https://sandbox2.talygen.com/emailtemplate/add");
			open("https://app.talygen.com/EmailTemplate/Edit/812?emailCount=0");
			
		}
		
		public void greetingURL()
		{
			staticWait(3000);
			//open("https://sandbox2.talygen.com/greeting/Index?search=&sortBy=&sortExp=&pageSize=&pageNum=javascript:;&isPartial=1");
			
				open("https://app.talygen.com/emailtemplate/Index?search=&sortBy=&sortExp=&pageSize=&pageNum=javascript:;&isPartial=1");
		}
		
		
		public void selectTemplatedropdown()
		{
			staticWait(3000);
			selectValueWithText(By.xpath("//table[@id='example']/tbody/tr[1]/td[2]/tg-select/select"), EmailTemplatePage.EmailTemplatename , "Anniversary Greeting", 25);
			staticWait(2000);
			selectValueWithText(By.xpath("//table[@id='example']/tbody/tr[2]/td[2]/tg-select/select"), EmailTemplatePage.EmailTemplatename , "Birthday Greeting", 25);
		}
		
		public void successMessage()
		{
			
			 String successMessage =	getText(By.xpath("//div[@id='notifymessage']//span"),25);
			 String message =  prop.getProperty("SuccessMessage");
			  
			  
			 verifySuccessMessage(By.xpath("//div[@id='notifymessage']//span"),message, 20);
		}
		
		
		
	
		
		
	

}
