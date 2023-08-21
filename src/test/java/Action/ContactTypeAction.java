package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.ContactTypePage;
import utils.WebBasePage;

public class ContactTypeAction {
	
	
	
	
	 WebDriver driver ;
	 ContactTypePage contactTypePage;
	 public ContactTypeAction( WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
		 contactTypePage = new  ContactTypePage(driver);
		  
	}
	 
	 
	 public void  goToChannelTab()
		{
		 contactTypePage.clickFullMenuDropDown();
		 contactTypePage.clickCompanySetupLink();
		 contactTypePage.clickCompanySetupPage();
		 contactTypePage.clickOnContactType();
		}
		
		public void  validationCheck()
		{
			contactTypePage.clickAddContact();
			contactTypePage.saveButton();
			contactTypePage.VerifyMandatoryFieldValidation();
			contactTypePage.UserGuideAndCancel();
		}
		
		public void addContactType()
		{
			contactTypePage.clickAddContact();
			contactTypePage.contactTypeName();
			contactTypePage.clickOnContactType();
			contactTypePage.saveButton();
			
		}
		
		public void editContactType()
		{
			contactTypePage.Entersearch();
			contactTypePage.searchButton();
			contactTypePage.refresh();
			contactTypePage.Entersearch();
			contactTypePage.searchButton();
			contactTypePage.clickContactTypeName();
			contactTypePage.saveButton();		
		}
		
		
		public void ActiveStatus()
		{
			contactTypePage.Entersearch();
			contactTypePage.searchButton();
			contactTypePage.selectcheckbox();
			contactTypePage.activeActionButton();
			contactTypePage.okConfirmButton();
			contactTypePage.verifyActiveStatusValue();
		}
		
		public void InactiveStatus()
		{
			contactTypePage.Entersearch();
			contactTypePage.searchButton();
			contactTypePage.selectcheckbox();
			contactTypePage.inactiveActionButton();
			contactTypePage.okConfirmButton();
			contactTypePage.verifyInactiveStatusValue();
		}
		
		 public void delete()
		 {
			 contactTypePage.selectcheckbox();
			 contactTypePage.deleteButton();
			 contactTypePage.okConfirmButton();
		 }
		
	 
	 

}
