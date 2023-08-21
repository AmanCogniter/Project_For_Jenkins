package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.StagePage;
import pageobjects.TripPage;

public class TripAction {

	
	WebDriver driver ;
	TripPage trippage;
	
	public  TripAction(WebDriver driver)
	{
		this.driver= driver;
		trippage = new TripPage(driver);
	}
	
	
	public void  goToTripTab()
	{
		trippage.clickFullMenuDropDown();
		trippage.clickCompanySetupLink();
		trippage.clickCompanySetupPage();
		trippage.clickOnTrip();
	}
	
	
	public void validationCheck()
	{
		trippage.clickOnAdd();
		trippage.save();
		trippage.VerifyMandatoryFieldValidation();
		trippage.UserGuideAndCancel();
	}
	
	
	 public void addNewTrip()
	 {
		 
		 trippage.clickOnAdd();
		
		 trippage.enterTripName();
		 trippage.enterDescription();
		 trippage.save();
		 
	 }
	 
	 public void EditTrip()
	 {
		
		 trippage.enterSearchText();
		 trippage.searchButton();
		 trippage.refresh();
		 trippage.enterSearchText();
		 trippage.searchButton();	
		 trippage.clickTripName();
		 trippage.save();
		 trippage.verifyUpdateConfirmationMessage();
		 
	 }
	 
	 
	 public void ActiveStatus()
		{
		 trippage.enterSearchText();
		 trippage.searchButton();
		 trippage.selectcheckbox();
		 trippage.activeActionButton();
		 trippage.okConfirmButton();
		 trippage.verifyStatusConfirmationMessage();
		 trippage.verifyActiveStatusValue();
		}
		
		public void InactiveStatus()
		{
			trippage.enterSearchText();
			trippage.searchButton();
			trippage.selectcheckbox();
			trippage.inactiveActionButton();
			trippage.okConfirmButton();
			trippage.verifyStatusConfirmationMessage();
			trippage.verifyInactiveStatusValue();
		}
		
		 public void delete()
		 {
			 trippage.selectcheckbox();
			 trippage.deleteButton();
			 trippage.okConfirmButton();
			 trippage.verifyDeleteConfirmationMessage();
		 }
	 
}
