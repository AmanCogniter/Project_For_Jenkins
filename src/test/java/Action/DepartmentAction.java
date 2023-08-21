package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.CategoryPage;
import pageobjects.DepartmentPage;

public class DepartmentAction {

	
	
	WebDriver driver;

	DepartmentPage departmentPage;

	public DepartmentAction(WebDriver driver) {
		this.driver = driver;
		departmentPage = new DepartmentPage(driver);
	}
	
	 public void GoToDepartmentTab()
	 {
		 departmentPage.clickFullMenuDropDown();
		 departmentPage.clickCompanySetupLink();
		 departmentPage.clickCompanySetupPage();
		 departmentPage.ClickDepartmentTab();
	 }
	 
	 
	 public void ValidationCheck() {
		 departmentPage.AddButton();
		 departmentPage.Save();
		 departmentPage.VerifyMandatoryFieldValidation();

		}
	 
	 public void userGuide() {
		 departmentPage.openAndCloseUserGuide();
		 departmentPage.cancelButton();
		}
	 
	  public void addDepartmentNotVisibleClient()
	  
	  {
		  departmentPage.AddButton();
		  departmentPage.enterDepttNameNotVisibleClient();
		  departmentPage.departmentDesciption();
		  departmentPage.Save();
	  }
	  
	  public void addDepartmentVisibleClient()
	  
	  {
		  departmentPage.AddButton();
		  departmentPage.enterDepttNameVisibleClient();
		  departmentPage.visibleToClient();
		  departmentPage.departmentDesciption();
		  departmentPage.Save();
	  }
	  
	  public void editDepartment()

		{

		  departmentPage.SearchCategory();
		  departmentPage.searchButton();
		  departmentPage.refresh();
		  departmentPage.searchButton();
		  departmentPage.editDepartment();
		  departmentPage.Save();
		}
		
	  public void ActionButton()
		{
			
		  departmentPage.selectAll();	
		}
		
		 public void ActiveStatus()
		 {
			 departmentPage.SearchCategory();
			 departmentPage.searchButton();
			 departmentPage.selectcheckbox();
			 departmentPage.activeActionButton();
			 departmentPage.okConfirmButton();
			 departmentPage.verifyActiveStatusValue();	 
		 }
		
		 public void InactiveStatus()
		 {
			 departmentPage.SearchCategory();
			 departmentPage.searchButton();
			 departmentPage.selectcheckbox();
			 departmentPage.inactiveActionButton();
			 departmentPage.okConfirmButton();
			 departmentPage.verifyInactiveStatusValue();
		 }
		
		 public void delete()
		 {
			 departmentPage.selectcheckbox();
			 departmentPage.deleteButton();
			 departmentPage.okConfirmButton();
		 }


}
