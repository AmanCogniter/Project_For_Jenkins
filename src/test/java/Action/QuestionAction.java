package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.PriorityPage;
import pageobjects.QuestionPage;

public class QuestionAction {
	
	WebDriver driver;
	
	QuestionPage  questionpage ;
	
	public  QuestionAction(WebDriver driver)
	{
		this.driver= driver;
		questionpage = new QuestionPage(driver);
	}
	
	
	public void  goToQuestionTab()
	{
		questionpage.clickFullMenuDropDown();
		questionpage.clickCompanySetupLink();
		questionpage.clickCompanySetupPage();
		questionpage.clickOnQuestion();
	}
	
	
	public void  validationCheck()
	{
		questionpage.clickOnAdd();
		questionpage.save();
		questionpage.VerifyMandatoryFieldValidation();
		questionpage.UserGuideAndCancel();
		
	}
	
	public void addQuestion()
	{
		questionpage.clickOnAdd();
		questionpage.enterQuestionName();
		questionpage.enterDescription();
		questionpage.save();
		questionpage.verifyAddConfirmationMessage();
		
	}
	public void editCreatedQuestion()
	 {
		 
		questionpage.enterSearchText();
		questionpage.searchButton();
		questionpage.refresh();
		questionpage.enterSearchText();
		questionpage.searchButton();	
		questionpage.clickQuestionName();
		questionpage.save();
		questionpage.verifyUpdateConfirmationMessage();
		 
	 }
	
	 public void ActiveStatus()
		{
		 questionpage.enterSearchText();
		 questionpage.searchButton();
		 questionpage.selectcheckbox();
		 questionpage.activeActionButton();
		 questionpage.okConfirmButton();
		 questionpage.verifyStatusConfirmationMessage();
		 questionpage.verifyActiveStatusValue();
		}
		
		public void InactiveStatus()
		{
			questionpage.enterSearchText();
			questionpage.searchButton();
			questionpage.selectcheckbox();
			questionpage.inactiveActionButton();
			questionpage.okConfirmButton();
			questionpage.verifyStatusConfirmationMessage();
			questionpage.verifyInactiveStatusValue();
		}
		
		 public void delete()
		 {
			 questionpage.selectcheckbox();
			 questionpage.deleteButton();
			 questionpage.okConfirmButton();
			 questionpage.verifyDeleteConfirmationMessage();
		 }
		

}
