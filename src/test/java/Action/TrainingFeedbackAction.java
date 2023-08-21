package Action;

import org.openqa.selenium.WebDriver;


import pageobjects.TrainingFeedbackPage;


public class TrainingFeedbackAction {
	
	
	WebDriver driver;

	TrainingFeedbackPage trainingfeedback;

	public TrainingFeedbackAction(WebDriver driver) {
		this.driver = driver;
		trainingfeedback = new TrainingFeedbackPage(driver);
	}
	
	public void goToTrainingFeedbackTab()
	 {
		trainingfeedback.clickFullMenuDropDown();
		trainingfeedback.clickCompanySetupLink();
		trainingfeedback.clickCompanySetupPage();
		trainingfeedback.clickTrainingFeedbackTab();
	 }
	
	 public void validationCheck() {
		 trainingfeedback.AddButton();
		 trainingfeedback.Save();
		 trainingfeedback.VerifyMandatoryFieldValidation();

		}
	 
	 public void addTrainingFeedback()
	 {
		 trainingfeedback.AddButton();
		 trainingfeedback.enterTitleName();
		 trainingfeedback.enterDescription();
		 trainingfeedback.Save(); 
	 }
	 
	 public void editTrainingFeedback()
	 {
		 
		 

		 trainingfeedback.Search();
		 trainingfeedback.searchButton();
		 trainingfeedback.refresh();
		 trainingfeedback.Search();
		 trainingfeedback.searchButton();
		 trainingfeedback.editFeedback();
		 trainingfeedback.Save(); 
	 }
	 
	 public void ActionButton()
		{
			
		 trainingfeedback.selectAll();	
		}
		
		 public void ActiveStatus()
		 {
			 trainingfeedback.Search();
			 trainingfeedback.searchButton();
			 trainingfeedback.selectcheckbox();
			 trainingfeedback.activeActionButton();
			 trainingfeedback.okConfirmButton();
			 trainingfeedback.verifyActiveStatusValue();	 
		 }
		
		 public void InactiveStatus()
		 {
			 trainingfeedback.Search();
			 trainingfeedback.searchButton();
			 trainingfeedback.selectcheckbox();
			 trainingfeedback.inactiveActionButton();
			 trainingfeedback.okConfirmButton();
			 trainingfeedback.verifyInactiveStatusValue();
		 }
		
		 public void delete()
		 {
			 trainingfeedback.selectcheckbox();
			 trainingfeedback.deleteButton();
			 trainingfeedback.okConfirmButton();
		 }
	 
	
}
