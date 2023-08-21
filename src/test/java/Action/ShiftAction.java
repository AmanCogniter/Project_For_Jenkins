package Action;

import org.openqa.selenium.WebDriver;


import pageobjects.ShiftPage;

public class ShiftAction {

	
	
	WebDriver driver ;
	ShiftPage shiftpage;
	
	public  ShiftAction(WebDriver driver)
	{
		this.driver= driver;
		shiftpage = new ShiftPage(driver);
	}
	
	
	public void  goToShiftTab()
	{
		shiftpage.clickFullMenuDropDown();
		shiftpage.clickCompanySetupLink();
		shiftpage.clickCompanySetupPage();
		shiftpage.clickOnShift();
	}
	
	public void validationCheck()
	{
		shiftpage.clickOnAdd();
		shiftpage.save();
		shiftpage.VerifyMandatoryFieldValidation();
		shiftpage.UserGuideAndCancel();
	}
	
	 public void addShiftFlexible()
	 {
		 shiftpage.clickOnAdd();
		 shiftpage.enterFlexibleShiftName();
		 shiftpage.startTime();
		 shiftpage.endTime();
		// shiftpage.breakShift();
		 shiftpage.shiftRate();
		 shiftpage.OverTimeRate();
		 shiftpage.SelectLocation();
		 shiftpage.shiftTypeFlexible();
		 shiftpage.Description();
		 shiftpage.save();	 
	 }
	 public void addShiftNotFlexible()
	 {
		 shiftpage.clickOnAdd();
		 shiftpage.enterShiftName();
		 shiftpage.startTime();
		 shiftpage.endTime();
		 //shiftpage.breakShift();
		 shiftpage.shiftRate();
		 shiftpage.OverTimeRate();
		 shiftpage.SelectLocation();
		 shiftpage.Description();
		 shiftpage.save();	 
	 }
	 
	 
	 public void editShiftFlexible()
	 {
		 shiftpage.enterSearchText();
		 shiftpage.searchButton();
		 shiftpage.refresh();
		 shiftpage.enterSearchText();
		 shiftpage.searchButton();	
		 shiftpage.clickShiftName();
		 shiftpage.save();
		 shiftpage.verifyUpdateConfirmationMessage();
		 
	 }
	 
	 public void ActiveStatus()
		{
		 shiftpage.enterSearchText();
		 shiftpage.searchButton();
		 shiftpage.selectcheckbox();
		 shiftpage.activeActionButton();
		 shiftpage.okConfirmButton();
		 shiftpage.verifyStatusConfirmationMessage();
		 shiftpage.verifyActiveStatusValue();
		}
		
		public void InactiveStatus()
		{
			shiftpage.enterSearchText();
			shiftpage.searchButton();
			shiftpage.selectcheckbox();
			shiftpage.inactiveActionButton();
			shiftpage.okConfirmButton();
			shiftpage.verifyStatusConfirmationMessage();
			shiftpage.verifyInactiveStatusValue();
		}
		
		 public void delete()
		 {
			 shiftpage.selectcheckbox();
			 shiftpage.deleteButton();
			 shiftpage.okConfirmButton();
			 shiftpage.verifyDeleteConfirmationMessage();
		 }

	 
	
	 
	 
	 
}
