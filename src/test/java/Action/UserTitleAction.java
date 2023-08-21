package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.TripPage;
import pageobjects.UserTitlePage;

public class UserTitleAction {
	
	
	WebDriver driver ;
	UserTitlePage usertitlepage;
	
	public  UserTitleAction(WebDriver driver)
	{
		this.driver= driver;
		usertitlepage = new UserTitlePage(driver);
	}
	
	
	public void  clickOnUserTitleLink()
	{
		usertitlepage.clickFullMenuDropDown();
		usertitlepage.clickCompanySetupLink();
		usertitlepage.clickCompanySetupPage();
		usertitlepage.clickOnUserTitle();
	}
	
	
	 public void validationCheck()
	 {
		 usertitlepage.clickOnAdd();
		 usertitlepage.save();
		 usertitlepage.VerifyMandatoryFieldValidation();
	 }
	 
	 public void addUserTitle()
	 {
		 usertitlepage.clickOnAdd();
		 usertitlepage.enterUserTitleName();
		 usertitlepage.save(); 
	 }
	 
	  public  void EditUserTitle()
	  {
		  usertitlepage.enterSearchText();
		  usertitlepage.searchButton();
		  usertitlepage.refresh();
		  usertitlepage.enterSearchText();
		  usertitlepage.searchButton();	
		  usertitlepage.clickUserTitleName();
		  usertitlepage.save();
		  usertitlepage.verifyUpdateConfirmationMessage();

	  }
	  
	  public void ActiveStatus()
		{
		  usertitlepage.enterSearchText();
		  usertitlepage.searchButton();
		  usertitlepage.selectcheckbox();
		 usertitlepage.activeActionButton();
		 usertitlepage.okConfirmButton();
		 usertitlepage.verifyStatusConfirmationMessage();
		 usertitlepage.verifyActiveStatusValue();
		}
		
		public void InactiveStatus()
		{
			usertitlepage.enterSearchText();
			usertitlepage.searchButton();
			usertitlepage.selectcheckbox();
			usertitlepage.inactiveActionButton();
			usertitlepage.okConfirmButton();
			usertitlepage.verifyStatusConfirmationMessage();
			usertitlepage.verifyInactiveStatusValue();
		}
		
		 public void delete()
		 {
			 usertitlepage.selectcheckbox();
			 usertitlepage.deleteButton();
			 usertitlepage.okConfirmButton();
			 usertitlepage.verifyDeleteConfirmationMessage();
		 }

}
