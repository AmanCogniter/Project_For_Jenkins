package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.EmailTemplatePage;
import pageobjects.GreetingPage;

public class GreetingAction {


	WebDriver driver;
	GreetingPage greetingpage;
	//EmailTemplatePage emailtemplatepage;
	EmailTemplateAction emailtemplateaction;
	
	public GreetingAction(WebDriver driver)
	{
		
		this.driver = driver;
		greetingpage= new GreetingPage(driver);
	//	emailtemplatepage = new EmailTemplatePage(driver);	
		 emailtemplateaction = new EmailTemplateAction (driver);
		
		
	}
	
	 public void moveToGreetingTab()
	 {
		 greetingpage.clickFullMenuDropDown();
		 greetingpage.clickCompanySetupLink();
		 greetingpage.clickCompanySetupPage();
		 greetingpage.clickOnGreeting();
	 }
	 
	  public void validationMesssageCheck()
	  
	  {
		  
		
		
		  greetingpage.deSelectTemplate();
		  greetingpage.save();
		  greetingpage.validationMessage();
		    
	  }
	  
	  public void addGreetingAndGreetingTemplate()
	  {
			/*
			 * greetingpage.EmailTemplateURL();
			 * 
			 * 
			 * emailtemplateaction.AddEmailTemplateGreeting(); moveToGreetingTab();
			 * 
			 * greetingpage.selectTemplatedropdown(); greetingpage.save();
			 * greetingpage.successMessage();
			 */
		  greetingpage.selectTemplatedropdown();
		  greetingpage.save();
		  greetingpage.successMessage();
		
		
		
		
	  }
	 
	 

}
