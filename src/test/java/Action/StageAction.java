package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.StagePage;

public class StageAction {

	
	WebDriver driver ;
	StagePage stagepage;
	
	public  StageAction(WebDriver driver)
	{
		this.driver= driver;
		stagepage = new StagePage(driver);
	}
	
	
	public void  goToStageTab()
	{
		stagepage.clickFullMenuDropDown();
		stagepage.clickCompanySetupLink();
		stagepage.clickCompanySetupPage();
		stagepage.clickOnStage();
	}
	
	
	public void validationCheck()
	{
		stagepage.clickOnAdd();
		stagepage.save();
		stagepage.VerifyMandatoryFieldValidation();
	}
	
	 public void addNewStage()
	 {
		 
		 stagepage.clickOnAdd();
		 
		 stagepage.selectPhaseName();
		 stagepage.enterStageName();
		 stagepage.enterDescription();
		 stagepage.save();
		 
	 }
	 
	 
	 public void EditStage()
	 {
		 stagepage.enterSearchText();
		 stagepage.searchButton();
		 stagepage.refresh();
		 stagepage.enterSearchText();
		 stagepage.searchButton();	
		 stagepage.clickStageName();
		 stagepage.save();
		 stagepage.verifyUpdateConfirmationMessage();
	 }
	 
	 public void ActiveStatus()
		{
		 stagepage.enterSearchText();
		 stagepage.searchButton();
		 stagepage.selectcheckbox();
		 stagepage.activeActionButton();
		 stagepage.okConfirmButton();
		 stagepage.verifyStatusConfirmationMessage();
		 stagepage.verifyActiveStatusValue();
		}
		
		public void InactiveStatus()
		{
			stagepage.enterSearchText();
			stagepage.searchButton();
			stagepage.selectcheckbox();
			stagepage.inactiveActionButton();
			stagepage.okConfirmButton();
			stagepage.verifyStatusConfirmationMessage();
			stagepage.verifyInactiveStatusValue();
		}
		
		 public void delete()
		 {
			 stagepage.selectcheckbox();
			 stagepage.deleteButton();
			 stagepage.okConfirmButton();
			 stagepage.verifyDeleteConfirmationMessage();
		 }
	 
}
