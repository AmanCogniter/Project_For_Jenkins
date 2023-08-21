package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.DepartmentPage;
import pageobjects.DesignationPage;

public class DesignationAction {

	
	WebDriver driver;

	DesignationPage designationpage;

	public DesignationAction(WebDriver driver) {
		this.driver = driver;
		designationpage = new DesignationPage(driver);
	}
	
	public void goToDesignationTab()
	 {
		designationpage.clickFullMenuDropDown();
		designationpage.clickCompanySetupLink();
		designationpage.clickCompanySetupPage();
		designationpage.clickDesignationTab();
	 }
	
	 public void validationCheck() {
		 designationpage.AddButton();
		 designationpage.Save();
		 designationpage.VerifyMandatoryFieldValidation();

		}
	 
	 public void userGuide() {
		 designationpage.openAndCloseUserGuide();
		 designationpage.cancelButton();
		}
	 
	 
	 public void addDesignation()
	  
	  {
		 designationpage.AddButton();
		 designationpage.enterDesignationName();
		 designationpage.designationDescription();
		 designationpage.Save();
	  }
	 
	 public void editDesignation()

		{

		 designationpage.SearchDesignation();
		 designationpage.searchButton();
		 designationpage.refresh();
		 designationpage.searchButton();
		 designationpage.editDesignation();
		 designationpage.Save();
		}
	 
	 
	 public void ActionButton()
		{
			
		 designationpage.selectAll();	
		}
		
		 public void ActiveStatus()
		 {
			 designationpage.SearchDesignation();
			 designationpage.searchButton();
			 designationpage.selectcheckbox();
			 designationpage.activeActionButton();
			 designationpage.okConfirmButton();
			 designationpage.verifyActiveStatusValue();	 
		 }
		
		 public void InactiveStatus()
		 {
			 designationpage.SearchDesignation();
			 designationpage.searchButton();
			 designationpage.selectcheckbox();
			 designationpage.inactiveActionButton();
			 designationpage.okConfirmButton();
			 designationpage.verifyInactiveStatusValue();
		 }
		
		 public void delete()
		 {
			 designationpage.selectcheckbox();
			 designationpage.deleteButton();
			 designationpage.okConfirmButton();
		 }
	 
	 
}
