package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.LoginAutorizationPage;
import pageobjects.TripPage;

public class LoginAuthorizationAction {
	
	
	WebDriver driver ;
	LoginAutorizationPage loginauthorizationpage;
	
	public  LoginAuthorizationAction(WebDriver driver)
	{
		this.driver= driver;
		loginauthorizationpage = new LoginAutorizationPage(driver);
	}
	
	
	public void  goToLoginAuthorizationTab()
	{
		loginauthorizationpage.clickFullMenuDropDown();
		loginauthorizationpage.clickCompanySetupLink();
		loginauthorizationpage.clickCompanySetupPage();
		loginauthorizationpage.clickOnLoginAuthorization();
	}
	
	
	public void validationCheck()
	{
		loginauthorizationpage.clickOnAdd();
		loginauthorizationpage.save();
		loginauthorizationpage.VerifyMandatoryFieldValidation();
		loginauthorizationpage.UserGuideAndCancel();
	}
	
	 public void addNew()
	 {
		 loginauthorizationpage.clickOnAdd();
		 loginauthorizationpage.enterStartingIP();
		 loginauthorizationpage.enterEndingIP();
		 loginauthorizationpage.enterDescription();
		 
		 loginauthorizationpage.save();
	 }
	 
	 
	 public void EditLoginAuthorization()
	 {
		
		 loginauthorizationpage.enterSearchText();
		 loginauthorizationpage.searchButton();
		 loginauthorizationpage.refresh();
		 loginauthorizationpage.enterSearchText();
		 loginauthorizationpage.searchButton();	
		 loginauthorizationpage.clickStartingIP();
		 loginauthorizationpage.save();
		 loginauthorizationpage.verifyUpdateConfirmationMessage();
		 
	 }
	 
	 
	 public void ActiveStatus()
		{
		 loginauthorizationpage.enterSearchText();
		 loginauthorizationpage.searchButton();
		 loginauthorizationpage.selectcheckbox();
		 loginauthorizationpage.activeActionButton();
		 loginauthorizationpage.okConfirmButton();
		 loginauthorizationpage.verifyStatusConfirmationMessage();
		 loginauthorizationpage.verifyActiveStatusValue();
		}
		
		public void InactiveStatus()
		{
			loginauthorizationpage.enterSearchText();
			loginauthorizationpage.searchButton();
			loginauthorizationpage.selectcheckbox();
			loginauthorizationpage.inactiveActionButton();
			loginauthorizationpage.okConfirmButton();
			loginauthorizationpage.verifyStatusConfirmationMessage();
			loginauthorizationpage.verifyInactiveStatusValue();
		}
		
		 public void delete()
		 {
			 loginauthorizationpage.selectcheckbox();
			 loginauthorizationpage.deleteButton();
			 loginauthorizationpage.okConfirmButton();
			 loginauthorizationpage.verifyDeleteConfirmationMessage();
		 }
	 

}
