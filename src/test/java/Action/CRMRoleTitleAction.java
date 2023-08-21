package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.CRMRoleTitlePage;
import pageobjects.ReviewTemplatePage;

public class CRMRoleTitleAction {
	WebDriver driver ;
	CRMRoleTitlePage crmRoleTitlePage;
	 public CRMRoleTitleAction( WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
		 crmRoleTitlePage = new  CRMRoleTitlePage(driver);
		  
	}
	 
	 
	 public void  goToCRMRoleTitleTab()
		{
		 crmRoleTitlePage.clickFullMenuDropDown();
		 crmRoleTitlePage.clickCompanySetupLink();
		 crmRoleTitlePage.clickCompanySetupPage();
		 crmRoleTitlePage.clickOnCRMRoleTitle();
		}
	 public void ValidationCheck() {
		 crmRoleTitlePage.clickAddCRMRoleTitle();
		 crmRoleTitlePage.Save();
		 crmRoleTitlePage.VerifyMandatoryFieldValidation();
		 //crmRoleTitlePage.selectCheckBox();
		 crmRoleTitlePage.cancelButton();

		}
	 
		/*
		 * public void userGuide() { //crmRoleTitlePage.openAndCloseUserGuide();
		 * crmRoleTitlePage.cancelButton();
		 * 
		 * }
		 */
	 public void addCRMRoleTitlePage()
	 {
		 crmRoleTitlePage.clickAddCRMRoleTitle();
		 crmRoleTitlePage.enterCRMRoleTitle();
		 crmRoleTitlePage.enterCRMRoleTitleDescription();
		 //crmRoleTitlePage.selectCheckBox();
		 crmRoleTitlePage.Save();
	 }
	 public void editCRMRoleTitlePage()
	 {
		 crmRoleTitlePage.searchCRMRoleTitle();
		 crmRoleTitlePage.searchButton();
		 crmRoleTitlePage.editCRMRoleTitle();
		 crmRoleTitlePage.Save();
	 }
	 public void ActiveStatus()
	 {
		 crmRoleTitlePage.searchCRMRoleTitle();
		 crmRoleTitlePage.searchButton();
		 crmRoleTitlePage.selectAllCRMRoleTitle();
		 crmRoleTitlePage.activeActionButton();
		 crmRoleTitlePage.okConfirmButton();
		 crmRoleTitlePage.verifyActiveStatusValue();
	 }
	 public void InactiveStatus()
	 {
		 crmRoleTitlePage.searchCRMRoleTitle();
		 crmRoleTitlePage.searchButton();
		 crmRoleTitlePage.selectAllCRMRoleTitle();
		 crmRoleTitlePage.inactiveActionButton();
		 crmRoleTitlePage.okConfirmButton();
		 crmRoleTitlePage.verifyInactiveStatusValue();
	 }
	 public void delete()
	 {
		 crmRoleTitlePage.selectAllCRMRoleTitle();
		 crmRoleTitlePage.deleteButton();
		 crmRoleTitlePage.okConfirmButton();
	 }


}


