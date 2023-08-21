package pageobjects;

import java.util.List;
import static reporting.ComplexReportFactory.getTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.WebBasePage;

public class CompanyNotificationPage extends WebBasePage {

	
	WebDriver driver;
	static String Emailmodulename;
	static String Inboxmodulename;
	static String Mobilemodulename;
	public CompanyNotificationPage(WebDriver driver){
		super(driver," Company Notification Page");
		this.driver= driver;
		
	}
	public void clickFullMenuDropDown() {
	        click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);
	        staticWait(2000);
	   }
	public void clickCompanySetupLink(){
	    	 //click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"),"Company Setup Link", 30);
	    	 click(By.xpath("//li[@data-name='COMPANY SETUP']"),"Company Setup Link", 30);
	    	 staticWait(2000);
	     }
	public void clickCompanySetupPage(){
	    	 click(By.xpath("(//a[contains(text(),'Company Setup')])[last()]")," Company Setup Page", 30);
	    	 staticWait(2000);
	     }
	
	public void clickCompanyNotificationPage()
	{
		clickByJavascript(By.xpath("//a[text()='Company Notifications']"), "Company Notifications", 20);
		staticWait(2000);
	}
	
	public void Save() {
		clickByJavascript(By.id("asave"), "save button", 30);
		staticWait(2500);
	}
	
	
	
	
	 public void selectAllFromEmailCheckbox()
	 {
			
			
			  WebElement input = driver.findElement(By.xpath("//input[@id='chk_0']"));
			  Boolean checked = isAttribtuePresent(input, "checked");
			  
			  if ( checked==false) 
			  { 
				  clickByJavascript(By.xpath("//label[@for='chk_0']"), " Active Email Multi checkbox ", 25); staticWait(2000);
			  
			  } 
			  else
			  {
			clickByJavascript(By.xpath("//label[@for='chk_0']")  ," InActive Email Multi checkbox ",25);
			  clickByJavascript(By.xpath("//label[@for='chk_0']"), " Active Email Multi checkbox ", 25);
			  
			  }
			 
		 
			/*
			 * JavascriptExecutor jse =(JavascriptExecutor) driver;
			 * jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			 */
		 		List<WebElement>  modulemultiCheck = driver.findElements(By.xpath("//span[@class='table-plus-minus']"));
		 	int count =	modulemultiCheck.size();
		 	System.out.println(count);
		 	
		 	for(int index=1;index<=count;index++)
		 	{
		 		WebElement modulemulticheckbox = driver.findElement(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/td[3]//input[@type='checkbox']"));
		 		//WebElement modulemulticheckbox = driver.findElement(By.xpath("//tbody//tr[@class='high-bar']["+ index +"]/td[3]//input[@type='checkbox']"));
				 Boolean checkedattribute = isAttribtuePresent(modulemulticheckbox, "checked");
				 
				 if ( checkedattribute==true)
				 {
					 String currentmodulename= driver.findElement(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/td[3]//input[@type='checkbox']/../../../td[2]")).getText();
					 Emailmodulename=currentmodulename;
					// System.out.println(  Emailmodulename + " multi checkbox is checked ");
					 
					 getTest().log(LogStatus.PASS, "Email multi checkbox is checked in :" + Emailmodulename);
						logger.info("Email multi checkbox is checked in :" + Emailmodulename);
					 
				 }
				 else 
				 {
					// System.out.println(  Emailmodulename + " multi checkbox is not  checked ");
					 getTest().log(LogStatus.FAIL, "Email multi checkbox is not checked in :" + Emailmodulename);
						logger.info("Email multi checkbox is not checked in :" + Emailmodulename);
						takeScreenshot("Email multi checkbox is not checked");
						Assert.fail("Email multi checkbox is not checked");
				 }	 
		 	}        
	 }
	 
	 public void selectAllFromInboxCheckbox()
	 {
		 WebElement input = driver.findElement(By.xpath("//input[@id='chk_1']"));
		 Boolean checked = isAttribtuePresent(input, "checked");
		 
		 if ( checked==false)
		 {
			clickByJavascript(By.xpath("//label[@for='chk_1']"), " Active Inbox Multi checkbox ", 25); 
			staticWait(2000);
		 }
		 else
		 {
			 clickByJavascript(By.xpath("//label[@for='chk_1']"), " InActive Inbox Multi checkbox ",25);
			 clickByJavascript(By.xpath("//label[@for='chk_1']"), " Active Inbox Multi checkbox ", 25);
		 }
		 
		 
		 JavascriptExecutor jse =(JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		 		List<WebElement>  modulemultiCheck = driver.findElements(By.xpath("//span[@class='table-plus-minus']"));
		 	int count =	modulemultiCheck.size();
		 	System.out.println(count);
		 	
		 	for(int index=1;index<=count;index++)
		 	{
		 		WebElement modulemulticheckbox = driver.findElement(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/td[3]//input[@type='checkbox']"));
		 		//WebElement modulemulticheckbox = driver.findElement(By.xpath("//tbody//tr[@class='high-bar']["+ index +"]/td[3]//input[@type='checkbox']"));
				 Boolean checkedattribute = isAttribtuePresent(modulemulticheckbox, "checked");
				 
				 if ( checkedattribute==true)
				 {
					 String currentmodulename= driver.findElement(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/td[3]//input[@type='checkbox']/../../../td[2]")).getText();
					 Inboxmodulename=currentmodulename;
					// System.out.println(  Inboxmodulename + " multi checkbox is checked ");
					 getTest().log(LogStatus.PASS, "Inbox multi checkbox is checked in :" + Inboxmodulename);
						logger.info("Inbox multi checkbox is checked in :" + Inboxmodulename);
					 
				 }
				 else 
				 {
					// System.out.println(  Inboxmodulename + " multi checkbox is not  checked ");
					 
					 getTest().log(LogStatus.FAIL, "Inbox multi checkbox is not checked in :" + Inboxmodulename);
						logger.info("Inbox multi checkbox is not checked in :" + Inboxmodulename);
						takeScreenshot("Inbox multi checkbox is not checked");
						Assert.fail("Inbox multi checkbox is not checked");
					 
				 }
				 
				 
				 
				 
		 	}
		 
		 
	 }
	 public void selectAllFromMobileCheckbox()
	 {
		 WebElement input = driver.findElement(By.xpath("//input[@id='chk_2']"));
		 Boolean checked = isAttribtuePresent(input, "checked");
		 
		 if ( checked==false)
		 {
			clickByJavascript(By.xpath("//label[@for='chk_2']"), " Active Mobile Multi checkbox ", 25); 
			staticWait(2000);
		 }
		 else
		 {
			 clickByJavascript(By.xpath("//label[@for='chk_2']"), " InActive Mobile Multi checkbox ",25);
			 clickByJavascript(By.xpath("//label[@for='chk_2']"), " Active Mobile Multi checkbox ", 25);
		 }
		 
		 
		 JavascriptExecutor jse =(JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		 		List<WebElement>  modulemultiCheck = driver.findElements(By.xpath("//span[@class='table-plus-minus']"));
		 	int count =	modulemultiCheck.size();
		 	System.out.println(count);
		 	
		 	for(int index=1;index<=count;index++)
		 	{
		 		WebElement modulemulticheckbox = driver.findElement(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/td[3]//input[@type='checkbox']"));
		 		//WebElement modulemulticheckbox = driver.findElement(By.xpath("//tbody//tr[@class='high-bar']["+ index +"]/td[3]//input[@type='checkbox']"));
				 Boolean checkedattribute = isAttribtuePresent(modulemulticheckbox, "checked");
				 
				 if ( checkedattribute==true)
				 {
					 String currentmodulename= driver.findElement(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/td[3]//input[@type='checkbox']/../../../td[2]")).getText();
					 Mobilemodulename=currentmodulename;
					// System.out.println(  Mobilemodulename + " multi checkbox is checked ");
					 
					 getTest().log(LogStatus.PASS, "Mobile multi checkbox is checked in :" + Mobilemodulename);
						logger.info("Mobile multi checkbox is checked in :" + Mobilemodulename);
				 }
				 else 
				 {
					 //System.out.println(  Mobilemodulename + "  Mobile multi checkbox is not  checked ");
					 
					 getTest().log(LogStatus.FAIL, "Mobile multi checkbox is not checked in :" + Mobilemodulename);
						logger.info("Mobile multi checkbox is not checked in :" + Mobilemodulename);
						takeScreenshot("Mobile multi checkbox is not checked");
						Assert.fail("Mobile multi checkbox is not checked");
				 }
				 	 
		 	} 
		 
	 }
	 
	 public void selectSubModuleCheckCheckboxes()
	 {
		 
		 selectAllFromEmailCheckbox();
		 selectAllFromInboxCheckbox();
		selectAllFromMobileCheckbox();
		
		 WebElement input = driver.findElement(By.xpath("//input[@id='chk_2']"));
		 Boolean checked = isAttribtuePresent(input, "checked");
		 
		 if ( checked==false)
		 {
			clickByJavascript(By.xpath("//label[@for='chk_2']"), " Active Mobile Multi checkbox ", 25); 
			staticWait(2000);
		 }
		 else
		 {
			 clickByJavascript(By.xpath("//label[@for='chk_2']"), " InActive Mobile Multi checkbox ",25);
			 clickByJavascript(By.xpath("//label[@for='chk_2']"), " Active Mobile Multi checkbox ", 25);
		 }
		 
		 List<WebElement>  modulemultiCheck = driver.findElements(By.xpath("//span[@class='table-plus-minus']"));
		 	int count =	modulemultiCheck.size();
		 	
		 	for(int index=1;index<=count;index++)
		 	{
		 		
		 		String  modulename =getText(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/td[2]"), 25);
		 	
		 		for (int checkboxindex=3; checkboxindex<=5;checkboxindex++)
		 		{
		 			WebElement submodulemulticheckbox = driver.findElement(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/td["+checkboxindex+"]//input[@type='checkbox']"));
		 			 Boolean submodulecheckedattribute = isAttribtuePresent(submodulemulticheckbox, "checked"); 
		 			if ( submodulecheckedattribute==true)
					 {
						
		 				
		 				System.out.println(  modulename + " multi checkbox is checked ");
		 				clickByJavascript(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]//i[contains(@class,'fa')]"), " Plus Icon ", 25);
				 		List<WebElement> submodulelist =driver.findElements(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/following-sibling::tr[contains(@style,'table-row')]"));
				 		int submodule = submodulelist.size();
				 		
				 		for( int submoduleindex=1 ; submoduleindex<=submodule ;submoduleindex++)
					 		{
					 			String  submodulename =getText(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/following-sibling::tr[contains(@style,'table-row')]["+ submoduleindex +"]//td[2]"), 25);
					 			System.out.println( modulename+ "has submodule " + submodulename );
					 			
					 			WebElement submoduleemailcheckbox = driver.findElement(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/following-sibling::tr[contains(@style,'table-row')]["+ submoduleindex +"]//td[3]//input[contains(@class,'chkItems')]"));
					 			Boolean submodemailcheckbox = isAttribtuePresent(submoduleemailcheckbox, "checked"); 
					 			if (submodemailcheckbox== true )
					 			{
					 				//System.out.println("submodule" + submodulename + " Email Checkbox has been checked" );
					 				getTest().log(LogStatus.PASS, "submodule" + submodulename + " Email Checkbox has been checked");
									logger.info("submodule" + submodulename + " Email Checkbox has been checked");
					 			}
					 			
					 			else 
					 				
					 			{
					 				//System.out.println("submodule" + submodulename+ "  Email Checkbox has not been checked" );
					 				getTest().log(LogStatus.FAIL, "submodule" + submodulename + "  Email Checkbox has not been checked");
									logger.info("submodule" + submodulename + "  Email Checkbox has not been checked");
									takeScreenshot("submodule email checkbox has not been checked");
									Assert.fail("submodule email checkbox has not been checked");
					 			}
					 			
					 			WebElement submoduleinboxcheckbox = driver.findElement(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/following-sibling::tr[contains(@style,'table-row')]["+ submoduleindex +"]//td[4]//input[contains(@class,'InboxchkItem')]"));
					 			Boolean submodeinboxcheckbox = isAttribtuePresent(submoduleinboxcheckbox, "checked"); 
					 			if (submodeinboxcheckbox== true )
					 			{
					 				//System.out.println("submodule" + submodulename + " Inbox Checkbox has been checked" );
					 				getTest().log(LogStatus.PASS, "submodule" + submodulename + " Inbox Checkbox has been checked");
									logger.info("submodule" + submodulename + " Inbox Checkbox has been checked");
					 			}
					 			
					 			else 
					 				
					 			{
					 				//System.out.println("submodule" + submodulename+ "  Inbox Checkbox has not been checked" );
					 				
					 				getTest().log(LogStatus.FAIL, "submodule" + submodulename + "  Inbox Checkbox has not been checked");
									logger.info("submodule" + submodulename + "  Inbox Checkbox has not been checked");
									takeScreenshot("submodule Inbox checkbox has not been checked");
									Assert.fail("submodule Inbox checkbox has not been checked");
					 			}
					 			
					 			WebElement submodulemobilecheckbox = driver.findElement(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/following-sibling::tr[contains(@style,'table-row')]["+ submoduleindex +"]//td[5]//input[contains(@class,'MobilechkItems')]"));
					 			Boolean submodmobilecheckbox = isAttribtuePresent(submodulemobilecheckbox, "checked"); 
					 			if (submodmobilecheckbox== true )
					 			{
					 				//System.out.println("submodule" + submodulename + "Mobile Checkbox has been checked" );
					 				getTest().log(LogStatus.PASS, "submodule" + submodulename + " Mobile Checkbox has been checked");
									logger.info("submodule" + submodulename + " Mobile Checkbox has been checked");
					 			}
					 			
					 			else 
					 				
					 			{
					 				//System.out.println("submodule"+ submodulename+ " Mobile Checkbox has not been checked" );
					 				
					 				getTest().log(LogStatus.FAIL, "submodule" + submodulename + "  Mobile Checkbox has not been checked");
									logger.info("submodule" + submodulename + "  Mobile Checkbox has not been checked");
									takeScreenshot("submodule Mobile checkbox has not been checked");
									Assert.fail("submodule Mobile checkbox has not been checked");
					 				
					 			}
					 			
					 			
					 			
					 			
					 		}
		 				
		 				
					 }
					 else 
					 {
						// System.out.println(  modulename + " multi checkbox is not  checked ");
						 
						 getTest().log(LogStatus.FAIL,   modulename + " Module multi checkbox is not  checked");
							logger.info( modulename + "Module multi checkbox is not  checked");
							takeScreenshot("Module multi checkbox is not  checked");
							Assert.fail("Module multi checkbox is not  checked");
					 }		
		 		}
		 		
//		 		clickByJavascript(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]//i[contains(@class,'fa')]"), " Plus Icon ", 25);
//		 		List<WebElement> submodulelist =driver.findElements(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/following-sibling::tr[contains(@style,'table-row')]"));
//		 		int submodule = submodulelist.size();
//		 		System.out.println(submodule);
//		 		
//		 		for( int submoduleindex=1 ; submoduleindex<=submodule ;submoduleindex++)
//		 		{
//		 			String  submodulename =getText(By.xpath("//tbody//tr[contains(@class,'high-bar')]["+ index +"]/following-sibling::tr[contains(@style,'table-row')]["+ submoduleindex +"]//td[2]"), 25);
//		 			System.out.println( modulename+ "has submodule " + submodulename );
//		 		}
//		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 	}
		 
	 }
	
	
	
	
	
}
