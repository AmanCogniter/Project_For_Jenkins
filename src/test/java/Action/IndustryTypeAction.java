package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.IndustryTypePage;

public class IndustryTypeAction {
	
	
	WebDriver driver;
	
	IndustryTypePage industrytypepage ;
	
	public IndustryTypeAction(WebDriver driver)
	{
		this.driver= driver;
		industrytypepage = new IndustryTypePage(driver);
		
	}
	
	
	public void goToIndurstryTypeTab()
	{
		industrytypepage.clickFullMenuDropDown();
		industrytypepage.clickCompanySetupLink();
		industrytypepage.clickCompanySetupPage();
		industrytypepage.clickIndustryTypeTab();
	}
	
	
	 public void ValidationCheck() {
		 industrytypepage.AddButton();
		 industrytypepage.Save();
		 industrytypepage.VerifyMandatoryFieldValidation();

		}
	 
	 public void userGuide()
	 {
		 
		 industrytypepage.openAndCloseUserGuide();
		 industrytypepage.cancelButton();
		 
	 }
	 
	 public void addIndustryType()
	 {
		 industrytypepage.AddButton();
		 industrytypepage.entryIndustryTypeName();
		 industrytypepage.enterDescription();
		 industrytypepage.Save(); 
	 }
	 
	  public void editIndustryType()
	  {
		  industrytypepage.searchIndustryType();
		  industrytypepage.searchButton();
		  industrytypepage.refresh();
		  industrytypepage.searchButton();
		  industrytypepage.editIndustryType();
		  industrytypepage.Save();
	  }
	  
	  public void ActionButton()
		{
			
		  industrytypepage.selectAll();	
		}
		
		 public void ActiveStatus()
		 {
			 industrytypepage.searchIndustryType();
			 industrytypepage.searchButton();
			 industrytypepage.selectcheckbox();
			 industrytypepage.activeActionButton();
			 industrytypepage.okConfirmButton();
			 industrytypepage.verifyActiveStatusValue();	 
		 }
		
		 public void InactiveStatus()
		 {
			 industrytypepage.searchIndustryType();
			 industrytypepage.searchButton();
			 industrytypepage.selectcheckbox();
			 industrytypepage.inactiveActionButton();
			 industrytypepage.okConfirmButton();
			 industrytypepage.verifyInactiveStatusValue();
		 }
		
		 public void delete()
		 {
			 industrytypepage.selectcheckbox();
			 industrytypepage.deleteButton();
			 industrytypepage.okConfirmButton();
		 }
	
	
	
	
	
	

}
