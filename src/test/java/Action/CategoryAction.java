package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.BreakPage;
import pageobjects.CategoryPage;

public class CategoryAction {

	WebDriver driver;

	CategoryPage categorypage;

	public CategoryAction(WebDriver driver) {
		this.driver = driver;
		categorypage = new CategoryPage(driver);
	}

	public void GoToCategoryTab() {
		categorypage.clickFullMenuDropDown();
		categorypage.clickCompanySetupLink();
		categorypage.clickCompanySetupPage();

		categorypage.ClickCategoryTab();
	}

	public void ValidationCheck() {
		categorypage.AddButton();
		categorypage.Save();
		categorypage.VerifyMandatoryFieldValidation();

	}

	public void AddCategory() {
		categorypage.AddButton();
		categorypage.EnterCategoryName();
		categorypage.SelectCategoryType();
		categorypage.EnterDescription();
		categorypage.saveAndClose();

	}

	public void userGuide() {
		categorypage.openAndCloseUserGuide();
		categorypage.cancelButton();
	}

	public void editCategory()

	{

		categorypage.SearchCategory();
		categorypage.searchButton();
		categorypage.refresh();
		categorypage.searchButton();
		categorypage.editCategory();
		categorypage.saveAndClose();
	}
	
	public void ActionButton()
	{
		
		categorypage.selectAll();	
	}
	
	 public void ActiveStatus()
	 {
		 categorypage.SearchCategory();
		categorypage.searchButton();
		categorypage.selectcheckbox();
		categorypage.activeActionButton();
		categorypage.okConfirmButton();
		categorypage.verifyActiveStatusValue();	 
	 }
	
	 public void InactiveStatus()
	 {
		 categorypage.SearchCategory();
		categorypage.searchButton();
		categorypage.selectcheckbox();
		categorypage.inactiveActionButton();
		categorypage.okConfirmButton();
		categorypage.verifyInactiveStatusValue();
	 }
	
	 public void delete()
	 {
		 categorypage.selectcheckbox();
		 categorypage.deleteButton();
		 categorypage.okConfirmButton();
	 }
	
}
