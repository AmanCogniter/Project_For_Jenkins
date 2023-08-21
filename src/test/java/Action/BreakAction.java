package Action;

import javax.swing.text.AbstractDocument.BranchElement;

import org.openqa.selenium.WebDriver;

import pageobjects.BreakPage;

public class BreakAction {
	
	WebDriver driver;
	BreakPage breakpage;
	
	public  BreakAction(WebDriver driver)
	{
		this.driver= driver;
		 breakpage = new BreakPage(driver);
	}
	
	public void GoToBreakTab()
	{
		
		breakpage.clickFullMenuDropDown();
		breakpage.clickCompanySetupLink();
		breakpage.clickCompanySetupPage();
		breakpage.ClickBreakTab();
	}
	
	public void ValidationMessageCheck()
	{
		breakpage.AddBreakButton();
		breakpage.SaveButton();
		breakpage.VerifyMandatoryFieldValidation();	
		breakpage.UserGuideAndCancel();
	}
	public void AddBreak()
	{
		breakpage.AddBreakButton();
		breakpage.SelectShift();
		breakpage.EnterBreakName();
		breakpage.SelectStartDate();
		breakpage.SelectCloseDate();
	//	breakpage.BillableCheckbox();
		breakpage.SaveButton();	
		breakpage.HandleSuccessMessage();
		
		
	}
	
	//   search functionality with logoutlogin shows error message "StaleRefernceElementException"  . 
	
	  public void SearchBreak() {
		  breakpage.SearchBreak();
	  breakpage.searchButton(); 
	  breakpage.Resetbutton();
	  
	  }
	 
	public void EditBreak()
	{
		breakpage.BreakNameSorting();
		breakpage.ClickOnBreakName();
		breakpage.EnableIsBillable();
		breakpage.SaveButton();
	}
	
	 public void ActiveInActiveAndDelete()
	 {
			breakpage.SearchBreak();
			breakpage.searchButton();
			breakpage.SelectSingleCheckBox();
			breakpage.ActiveToInActive();
			breakpage.HandleSuccessMessage();
			breakpage.SelectSingleCheckBox();
			breakpage.InActiveToActive();
			breakpage.HandleSuccessMessage();
			breakpage.Resetbutton();
			breakpage.SearchBreak();
			breakpage.searchButton();
			breakpage.SelectSingleCheckBox();
			breakpage.ClickOnDelete();
			
		 
	 }
}
