package Action;

import org.openqa.selenium.WebDriver;


import pageobjects.EmailTemplatePage;

public class EmailTemplateAction {

	
	WebDriver  driver ;
	EmailTemplatePage emailtemplatepage;
	
	 public EmailTemplateAction( WebDriver driver) {
		 
		 this.driver= driver;
		 
		 emailtemplatepage = new EmailTemplatePage(driver);		 
	 }
	 
	 
	 public void  moveToEmailTemplateTab()
	 {
	 
		 emailtemplatepage.clickFullMenuDropDown();
		 emailtemplatepage.clickCompanySetupLink();
		 emailtemplatepage.clickCompanySetupPage();
		 emailtemplatepage.clickOnEmailemplate();
	 }
	 
	 public void validationCheck()
	 {
		 emailtemplatepage.addTemplate();
		 emailtemplatepage.save();
		 emailtemplatepage.VerifyMandatoryFieldValidation();
		 emailtemplatepage.userGuideAndCancel(); 
	 }
	 
	 public void AddEmailTemplate()
	 { 
		 emailtemplatepage.addTemplate();
		 emailtemplatepage.templateName();
		 emailtemplatepage.subjectName();
		 emailtemplatepage.selectCategory();
		 emailtemplatepage.subCategory();
		 emailtemplatepage.templateContent();
		 emailtemplatepage.save(); 
	 }
	 
	 public void AddEmailMappingTemplate()
	 { 
		 emailtemplatepage.addTemplate();
		 emailtemplatepage.templateName();
		 emailtemplatepage.subjectName();
		 emailtemplatepage.selectCategoryTicketing();
		 //emailtemplatepage.subCategory();
		 emailtemplatepage.templateContent();
		 emailtemplatepage.save(); 
	 }
	 
	 
	 public void AddEmailTemplateReview()
	 { 
		 emailtemplatepage.addTemplate();
		 emailtemplatepage.templateName();
		 emailtemplatepage.subjectName();
		 emailtemplatepage.selectCategoryTicketing();
		 emailtemplatepage.templateContent();
		 emailtemplatepage.save(); 
	 }
	 public void AddEmailTemplateGreeting()
	 { 
			/*
			 * emailtemplatepage.addTemplate(); emailtemplatepage.greetingTemplateName();
			 * emailtemplatepage.subjectName();//modified
			 * emailtemplatepage.selectGreetingCategory();
			 * //emailtemplatepage.subCategory(); //
			 * emailtemplatepage.templateContent();//modified emailtemplatepage.save();
			 */
		 emailtemplatepage.addTemplate();
		 emailtemplatepage.templateName();
		 emailtemplatepage.subjectName();
		 emailtemplatepage.selectGreetingCategory();
		 //emailtemplatepage.subCategory();
		 emailtemplatepage.templateContent();
		 emailtemplatepage.save(); 
	 }
	 
	 
	 public void editTemplate()
	 {
		 emailtemplatepage.enterSearchText();
		 emailtemplatepage.searchButton();
		 emailtemplatepage.refresh();
		 emailtemplatepage.enterSearchText();
		 emailtemplatepage.searchButton();
		 emailtemplatepage.clickTemplateName();
		 emailtemplatepage.save();
		 
	 }
	 
	 public void ActiveStatus()
		{
		 emailtemplatepage.enterSearchText();
		 emailtemplatepage.searchButton();
		 emailtemplatepage.selectcheckbox();
		 emailtemplatepage.activeActionButton();
		 emailtemplatepage.okConfirmButton();
		 emailtemplatepage.verifyActiveStatusValue();
		}
		
		public void InactiveStatus()
		{
			emailtemplatepage.enterSearchText();
			emailtemplatepage.searchButton();
			emailtemplatepage.selectcheckbox();
			emailtemplatepage.inactiveActionButton();
			emailtemplatepage.okConfirmButton();
			emailtemplatepage.verifyInactiveStatusValue();
		}
		
		 public void delete()
		 {
			 emailtemplatepage.selectcheckbox();
			 emailtemplatepage.deleteButton();
			 emailtemplatepage.okConfirmButton();
		 }
		 
		 public void customTemplate()
		 {
			 emailtemplatepage.advancedEmailTemplateButton();
		//	 emailtemplatepage.headingSetup();
		 }
		 
		 public void addDetailAdvancedTemplate() {
			 
			 emailtemplatepage.templateName();
			 emailtemplatepage.subjectName();
			 emailtemplatepage.selectCategory();
			 emailtemplatepage.subCategory();
			 
			 emailtemplatepage.templateContent();
			 emailtemplatepage.save();
		 }
	 
}
