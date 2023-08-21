package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.PhasePage;
import pageobjects.PriorityPage;

public class PriorityAction {
	
	WebDriver driver ;
	PriorityPage prioritypage;
	
	public  PriorityAction(WebDriver driver)
	{
		this.driver= driver;
		prioritypage = new PriorityPage(driver);
	}
	
	
	public void  goToPriorityTab()
	{
		prioritypage.clickFullMenuDropDown();
		prioritypage.clickCompanySetupLink();
		prioritypage.clickCompanySetupPage();
		prioritypage.clickOnPriority();
	}
	
	public void validationCheck()
	{
		prioritypage.clickOnAdd();
		prioritypage.save();
		prioritypage.VerifyMandatoryFieldValidation();
		prioritypage.UserGuideAndCancel();
	}
	
	public void addPriority()
	{
		prioritypage.clickOnAdd();
		prioritypage.enterPriorityName();
		prioritypage.selectStatus();
		prioritypage.displayOrder();
		prioritypage.enterDescription();
		prioritypage.save();
		prioritypage.verifyAddConfirmationMessage();
		
	}
	
	 public void editCreatedPriority()
	 {
		 
		 prioritypage.enterSearchText();
		 prioritypage.searchButton();
		 prioritypage.refresh();
		 prioritypage.enterSearchText();
		 prioritypage.searchButton();	
		 prioritypage.clickPriorityName();
		 prioritypage.save();
		 prioritypage.verifyUpdateConfirmationMessage();
		 
	 }
	 public void ActiveStatus()
		{
		 prioritypage.enterSearchText();
		 prioritypage.searchButton();
		 prioritypage.selectcheckbox();
		 prioritypage.activeActionButton();
		 prioritypage.okConfirmButton();
		 prioritypage.verifyStatusConfirmationMessage();
		 prioritypage.verifyActiveStatusValue();
		}
		
		public void InactiveStatus()
		{
			prioritypage.enterSearchText();
			prioritypage.searchButton();
			prioritypage.selectcheckbox();
			prioritypage.inactiveActionButton();
			prioritypage.okConfirmButton();
			prioritypage.verifyStatusConfirmationMessage();
			prioritypage.verifyInactiveStatusValue();
		}
		
		 public void delete()
		 {
			 prioritypage.selectcheckbox();
			 prioritypage.deleteButton();
			 prioritypage.okConfirmButton();
			 prioritypage.verifyDeleteConfirmationMessage();
		 }
		 
//		 public void displayOrderCheck()
//		 {
//			 prioritypage.getAllRecords();
//			 
//		 }
//		
		

}
