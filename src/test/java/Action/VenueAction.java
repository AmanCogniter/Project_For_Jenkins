package Action;

import org.openqa.selenium.WebDriver;
import pageobjects.VenuePage;

public class VenueAction {
	
	WebDriver driver;
	
	
	VenuePage venuepage;
	
	public VenueAction(WebDriver driver) {
		this.driver = driver;
		venuepage = new VenuePage(driver);
	}
	
	public void goToVenueTab()
	 {
		venuepage.clickFullMenuDropDown();
		venuepage.clickCompanySetupLink();
		venuepage.clickCompanySetupPage();
		venuepage.clickVenueTab();
	 }
	
	
	public void validationCheck() {
		
		venuepage.Save();
		venuepage.VerifyMandatoryFieldValidation();

		}
	 
	 public void userGuide() {
		 venuepage.openAndCloseUserGuide();
		 venuepage.cancelButton();
		}
	 
	 public void addVenue()
	 {
		 venuepage.enterVenueName();
		 venuepage.enterCapacity();
		 venuepage.selectCompanyLocation();
		 venuepage.enterInformation();
		 venuepage.Save();
		 
	 }
	 
	 public void editVenue()

		{

		 venuepage.SearchVenue();
		 venuepage.searchButton();
		 venuepage.refresh();
		 venuepage.SearchVenue();
		 venuepage.searchButton();
		 venuepage.editVenue();
		 venuepage.Save();
		}
	 
	  public void addLayout()
	  {
		  venuepage.SearchVenue();
		  venuepage.searchButton();
		  venuepage.clickAddLayout();
		  venuepage.addLayoutButton();
		  
	  }
	   public void rectangleLayout()
	   {
		   
		  venuepage.clickRectanglePlanLayout();
		  venuepage.addRectangleLayout();
		  venuepage.clickOnApply();
		  
	   }
	   public void circleLayout()
	   {
		  venuepage.clickCircleLayout();
		  venuepage.addCircleLayout();
		  venuepage.clickOnApply();
	  }
	   
	   public void halllayout()
	   {
		   venuepage.clickHallLayout();
			  venuepage.addHallLayout();
			  venuepage.clickOnApply();
			  venuepage.saveButtonAndLayoutName();
			  venuepage.SaveFinal();
			 // venuepage.verifyConfirmationMessage();
	   }
	   
	   public void deleteVenue()
	   {
		   venuepage.SearchVenue();
			 venuepage.searchButton();
			 venuepage.deletevenue();
			 venuepage.okConfirmButton();
			 
			 
	   }


}
