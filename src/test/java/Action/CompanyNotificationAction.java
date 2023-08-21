package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjects.CompanyNotificationPage;

public class CompanyNotificationAction {
	
	WebDriver driver;
	
	CompanyNotificationPage companynotificationpage;
	public  CompanyNotificationAction ( WebDriver driver)
	{
		this.driver =driver; 
		companynotificationpage = new CompanyNotificationPage(driver);
	}
	
	
	 public void GoToCompanyNotificationTab()
		{
		 companynotificationpage.clickFullMenuDropDown();
		 companynotificationpage.clickCompanySetupLink();
		 companynotificationpage.clickCompanySetupPage();
		 companynotificationpage.clickCompanyNotificationPage();
		}
	 
	  public void VerificationMainMultiCheck()
	  {
		  
		  companynotificationpage.selectAllFromEmailCheckbox();	 
		  companynotificationpage.selectAllFromInboxCheckbox();	 
		  companynotificationpage.selectAllFromMobileCheckbox();	 
		  companynotificationpage.Save();
		  
	  }
	  
	 public void moduleSubModuleverification()
	 {
		 companynotificationpage.selectSubModuleCheckCheckboxes();
		
		 
		 
	 }
	  
	
	

}
