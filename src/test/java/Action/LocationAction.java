package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.LocationPage;

public class LocationAction {
	
	WebDriver driver ;
	
	LocationPage locationpage;
	
	public LocationAction(WebDriver driver)
	{
			this.driver= driver;
			 locationpage= new LocationPage(driver);
	}
	
	public void goToLocationTab()
	{
		locationpage.clickFullMenuDropDown();
		locationpage.clickCompanySetupLink();
		locationpage.clickCompanySetupPage();
		locationpage.clickLocationTab();
		
	}
	
	
	public void parentLocationValidationCheck()
	{
		locationpage.addLocationButton();
		locationpage.Save();
		locationpage.VerifyMandatoryFieldValidation();	
	}
	
	public void userGuide()
	{
		locationpage.openAndCloseUserGuide();
		locationpage.cancelButton();
	}
	 public void addLocation()
	 {
			locationpage.addLocationButton();
		 locationpage.enterLocationName();
		 locationpage.enterAddress1();
		 locationpage.enterCity();
		 locationpage.selectCountry();
		 locationpage.selectState();
		 locationpage.enterPostalCode();
		 locationpage.enterEmail();
		 locationpage.enterPhone1();
		 locationpage.enterPhone2();
		 locationpage.locationCode();
		 locationpage.Save();
	 }
	 
	 public void addChildLocation()
	 {
		 searchParentLocation();
		 locationpage.addChildLocationButton();
		 locationpage.enterChildLocationName();
		 locationpage.enterAddress1();
		 locationpage.enterCity();
		 locationpage.selectCountry();
		 locationpage.selectState();
		 locationpage.enterPostalCode();
		 locationpage.enterEmail();
		 locationpage.enterPhone1();
		 locationpage.enterPhone2();
		 locationpage.locationCode();
		 locationpage.Save();
	 }
	 
	 public void searchParentLocation()
	 {
		 locationpage.searchParentLocation();
		 locationpage.searchButton();
		 locationpage.verifyParentSearch();
		 
	 }
	 
	  public void searchChildLocation()
	  
	  {
		  locationpage.searchChildLocation();
		  locationpage.searchButton();
	  }
	 
	  public void editParentLocation()
	  {
		  searchParentLocation();
		  locationpage.clickParentLocationName();
		  locationpage.clearLocationNameText();
		  locationpage.updatedParentLocation();
			 locationpage.Save();	    
	  }
	  
	   public void editChildLocation()
	   {
		   searchChildLocation();
		   locationpage.clickOnChildLocationName();
		   locationpage.clearLocationNameText();
		   locationpage.updatedChildLocation();
			 locationpage.Save();	    
	   }
	   
	   public void inactiveChildLocation()
	   {
		   locationpage.searchUpdatedChildLocation();
		   locationpage.clickChildInactiveStatus();
		   locationpage.okConfirmButton();
		  
	   }
	   
	   public void inactiveParentLocation()
	   {
		   locationpage.searchUpdatedParentLocation();
		   locationpage.clickParentInactiveStatus();
		   locationpage.okConfirmButton(); 
	   }
	   
	   public void deleteLocation()
	   {
		   locationpage.deleteChildLocation();
		   locationpage.okConfirmButton(); 
		   locationpage.deleteParentLocation();
		   locationpage.okConfirmButton(); 
	   }

}
