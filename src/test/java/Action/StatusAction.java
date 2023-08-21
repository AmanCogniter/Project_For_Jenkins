package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.StagePage;
import pageobjects.StatusPage;

public class StatusAction {
	
	WebDriver driver ;
	StatusPage statuspage;
	
	public  StatusAction(WebDriver driver)
	{
		this.driver= driver;
		statuspage = new StatusPage(driver);
	}
	
	
	public void  goToStatusTab()
	{
		statuspage.clickFullMenuDropDown();
		statuspage.clickCompanySetupLink();
		statuspage.clickCompanySetupPage();
		statuspage.clickOnStatus();
	}
	
	
	public void validationCheck()
	{
		statuspage.clickOnAdd();
		statuspage.save();
		statuspage.VerifyMandatoryFieldValidation();
		statuspage.UserGuideAndCancel();
	}

	 public void addProductStatus()
	 {
		 
		 statuspage.clickOnAdd(); 
		 statuspage.enterProductStatusName();
		 statuspage.selectProductStatusType();
		 statuspage.SelectProductAction();
		 statuspage.enterDescription();
		 statuspage.save(); 
		 statuspage.verifyaddConfirmationMessage(); 
	 }
	 
	 public void addCRMStatus()
	 {
		 statuspage.clickOnAdd(); 
		 statuspage.enterCrmStatusName();
		 statuspage.selectCRMStatusType();
		 //statuspage.enterPercentage();
		 statuspage.enterDescription();
		 statuspage.save(); 
		 statuspage.verifyaddConfirmationMessage(); 
	 }
	 
	 public void addApplicantStatus()
	 {
		 statuspage.clickOnAdd(); 
		 statuspage.enterApplicantStatusName();
		statuspage.selectApplicanttatusType();
		 statuspage.enterDescription();
		 statuspage.save(); 
		 statuspage.verifyaddConfirmationMessage();  
	 }
	 
	 public void EditStatus()
	 {
		 statuspage.enterSearchText();
		 statuspage.searchButton();
		 statuspage.refresh();
		 statuspage.enterSearchText();
		 statuspage.searchButton();	
		 statuspage.clickStatusName();
		 statuspage.save();
		 statuspage.verifyUpdateConfirmationMessage();
	 }
	 
	 
	 public void ActiveStatus()
		{
		 statuspage.enterSearchText();
		 statuspage.searchButton();
		 statuspage.selectcheckbox();
		 statuspage.activeActionButton();
		 statuspage.okConfirmButton();
		 statuspage.verifyStatusConfirmationMessage();
		 statuspage.verifyActiveStatusValue();
		}
		
		public void InactiveStatus()
		{
			statuspage.enterSearchText();
			statuspage.searchButton();
			statuspage.selectcheckbox();
			statuspage.inactiveActionButton();
			statuspage.okConfirmButton();
			statuspage.verifyStatusConfirmationMessage();
			statuspage.verifyInactiveStatusValue();
		}
		
		 public void delete()
		 {
			 statuspage.selectcheckbox();
			 statuspage.deleteButton();
			 statuspage.okConfirmButton();
			 statuspage.verifyDeleteConfirmationMessage();
		 }
	 
}
