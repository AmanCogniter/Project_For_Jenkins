package Action;

import org.openqa.selenium.WebDriver;


import pageobjects.ReviewTemplatePage;

public class ReviewTemplateAction {
	 WebDriver driver ;
	 ReviewTemplatePage reviewTemplatePage;
	 public ReviewTemplateAction( WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
		 reviewTemplatePage = new  ReviewTemplatePage(driver);
		  
	}
	 
	 
	 public void  goToReviewTemplateTab()
		{
		 reviewTemplatePage.clickFullMenuDropDown();
		 reviewTemplatePage.clickCompanySetupLink();
		 reviewTemplatePage.clickCompanySetupPage();
		 reviewTemplatePage.clickOnReviewTemplate();
		}
	 public void ValidationCheck() {
		 reviewTemplatePage.clickAddReview();
		 reviewTemplatePage.Save();
		 reviewTemplatePage.VerifyMandatoryFieldValidation();
		 reviewTemplatePage.selectCheckBox();

		}
	 
	 public void userGuide()
	 {
		 reviewTemplatePage.openAndCloseUserGuide();
		 reviewTemplatePage.cancelButton();
		 
	 }
	 public void addReviewTemplate()
	 {
		 reviewTemplatePage.clickAddReview();
		 reviewTemplatePage.enterRevieTemplateTitle();
		 reviewTemplatePage.enterDescription();
		 reviewTemplatePage.selectCheckBox();
		 reviewTemplatePage.Save();
	 }
	 public void editReviewTemplate()
	 {
		 reviewTemplatePage.searchreviewtemplate();
		 reviewTemplatePage.searchButton();
		 reviewTemplatePage.editReviewTemplate();
		 reviewTemplatePage.Save();
	 }
	 public void ActiveStatus()
	 {
		 reviewTemplatePage.searchreviewtemplate();
		 reviewTemplatePage.searchButton();
		 reviewTemplatePage.selectAllReviewTemplate();
		 reviewTemplatePage.activeActionButton();
		 reviewTemplatePage.okConfirmButton();
		 reviewTemplatePage.verifyActiveStatusValue();
	 }
	 public void InactiveStatus()
	 {
		 reviewTemplatePage.searchreviewtemplate();
		 reviewTemplatePage.searchButton();
		 reviewTemplatePage.selectAllReviewTemplate();
		 reviewTemplatePage.inactiveActionButton();
		 reviewTemplatePage.okConfirmButton();
		 reviewTemplatePage.verifyInactiveStatusValue();
	 }
	 public void delete()
	 {
		 reviewTemplatePage.selectAllReviewTemplate();
		 reviewTemplatePage.deleteButton();
		 reviewTemplatePage.okConfirmButton();
	 }


}
