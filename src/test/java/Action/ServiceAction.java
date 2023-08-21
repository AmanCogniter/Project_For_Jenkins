package Action;

import org.openqa.selenium.WebDriver;


import pageobjects.ServicePage;

public class ServiceAction {

	
	
	WebDriver driver ;
	ServicePage servicepage;
	
	public  ServiceAction(WebDriver driver)
	{
		this.driver= driver;
		servicepage = new ServicePage(driver);
	}
	
	
	public void  goToServiceTab()
	{
		servicepage.clickFullMenuDropDown();
		servicepage.clickCompanySetupLink();
		servicepage.clickCompanySetupPage();
		servicepage.clickOnService();
	}
	
	public void validationCheck()
	{
		servicepage.clickOnAdd();
		servicepage.save();
		servicepage.VerifyMandatoryFieldValidation();
		servicepage.UserGuideAndCancel();
	}
	
	
	public void addService()
	{
		servicepage.clickOnAdd();
		servicepage.enterServiceName();
		servicepage.selectUser();
		servicepage.selectStatus();
		servicepage.enterDescription();
		servicepage.save();
		servicepage.verifyAddConfirmationMessage();
		
	}
	
	public void editCreatedService()
	{
		
		servicepage.enterSearchText();
		servicepage.searchButton();
		servicepage.refresh();
		servicepage.enterSearchText();
		servicepage.searchButton();	
		servicepage.clickServiceName();
		servicepage.save();
		servicepage.verifyUpdateConfirmationMessage();
	}
	
	 public void ActiveStatus()
		{
		 servicepage.enterSearchText();
		 servicepage.searchButton();
		 servicepage.selectcheckbox();
		 servicepage.activeActionButton();
		 servicepage.okConfirmButton();
		 servicepage.verifyStatusConfirmationMessage();
		 servicepage.verifyActiveStatusValue();
		}
		
		public void InactiveStatus()
		{
			servicepage.enterSearchText();
			servicepage.searchButton();
			servicepage.selectcheckbox();
			servicepage.inactiveActionButton();
			servicepage.okConfirmButton();
			servicepage.verifyStatusConfirmationMessage();
			servicepage.verifyInactiveStatusValue();
		}
		
		 public void delete()
		 {
			 servicepage.selectcheckbox();
			 servicepage.deleteButton();
			 servicepage.okConfirmButton();
			 servicepage.verifyDeleteConfirmationMessage();
		 }


	 
}
