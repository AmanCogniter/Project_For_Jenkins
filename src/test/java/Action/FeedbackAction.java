package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.FeedbackPage;

public class FeedbackAction {

	
	 WebDriver driver ;
	 
	 FeedbackPage feedbackpage ;
	  public  FeedbackAction(WebDriver driver)
	  {
		  
		  this.driver = driver;
		  
		    feedbackpage = new FeedbackPage(driver);
		  
	  }
	  
	  public void GoToFeedbackTab()
		{
		  feedbackpage.clickFullMenuDropDown();
		  feedbackpage.clickCompanySetupLink();
		  feedbackpage.clickCompanySetupPage();
		  feedbackpage.clickOnFeedBack();
		}
	  
	  
	   public void validationCheck()
	   {
		   feedbackpage.addFeedBack();
		   feedbackpage.save();
		  feedbackpage.VerifyMandatoryFieldValidation();
		  feedbackpage.UserGuide();
		   
	   }
	   
	    public void addFeedback()
	    {
	    	feedbackpage.addFeedBack();
	    	feedbackpage.feedbackAddByType();  	
	   }
	    
	    public void editFeedback()
	    {
	    	feedbackpage.searchFeedback();
	    	feedbackpage.searchButton();
	    	feedbackpage.refresh();
	    
	    	feedbackpage.searchFeedback();
	    	feedbackpage.searchButton();
	    	feedbackpage.editfeedback();
	    	feedbackpage.save();
	    	
	    }
	    
	    public void ActiveStatus()
	    {
	    	feedbackpage.searchFeedback();
	    	feedbackpage.searchButton();
	    	feedbackpage.selectcheckbox();
	    	feedbackpage.activeActionButton();
	    	feedbackpage.okConfirmButton();
	    	feedbackpage.verifyActiveStatusValue();	 
	    }
	    
	    public void InactiveStatus()
	    {
	    	feedbackpage.searchFeedback();
	    	feedbackpage.searchButton();
	    	feedbackpage.selectcheckbox();
	    	feedbackpage.inactiveActionButton();
	    	feedbackpage.okConfirmButton();
	    	feedbackpage.verifyInactiveStatusValue();
	    }
	     
	   
	    public void delete()
	    {
	    	feedbackpage.selectAll();	
	    	feedbackpage.deleteButton();
	    	feedbackpage.okConfirmButton();
	    }
}
	    
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    
	   
	  
	 
	