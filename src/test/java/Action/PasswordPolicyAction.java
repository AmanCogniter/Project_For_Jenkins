package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageobjects.PasswordPolicyPage;
import pageobjects.StatusPage;

public class PasswordPolicyAction {
	
	
	WebDriver driver ;
	PasswordPolicyPage passwordpolicypage;
	
	public  PasswordPolicyAction(WebDriver driver)
	{
		this.driver= driver;
		passwordpolicypage = new PasswordPolicyPage(driver);
	}
	
	// click on full menu
	public void goToPasswordTab()
	{
		passwordpolicypage.clickFullMenuDropDown();
		passwordpolicypage.clickCompanySetupSideMenu();
		passwordpolicypage.clickCompanySetupPage();
		passwordpolicypage.clickOnPasswordPolicy();
	}
	
	public void createUser() {
		passwordpolicypage.clickFullMenuDropDown();
		passwordpolicypage.clickCompanySetupSideMenu();
		passwordpolicypage.clickUserPage();
				
		passwordpolicypage.createUser();
	}
	public void goToUserListing()
	{
		passwordpolicypage.clickFullMenuDropDown();
		passwordpolicypage.clickCompanySetupSideMenu();
		passwordpolicypage.clickUserListingPage();
	}
	
	
	public void passwordLengthValidationCheck()
	{
		passwordpolicypage.clearMaxAndMinPassLength();
		passwordpolicypage.save();
		passwordpolicypage.verifyPasswordLengthValidation();
		passwordpolicypage.closeNotifyMessage();
		passwordpolicypage.enterValueMaxAndMinPassLength();
		passwordpolicypage.save();
		//passwordpolicypage.closeNotifyMessage();
	}
	
	public void resetPasswordLengthValidationCheck(){
		goToUserListing();
		passwordpolicypage.searchLoginUser();
		passwordpolicypage.clickOnUsername();
		passwordpolicypage.clickOnResetPassword();
		passwordpolicypage.enterLessThanLimit();
		passwordpolicypage.resetButton();
		passwordpolicypage.verifyResetPasswordValidation();
		passwordpolicypage.closePopup();
		passwordpolicypage.clickOnResetPassword();
		passwordpolicypage.enterGreaterThanLimit();
		passwordpolicypage.resetButton();
		passwordpolicypage.verifyResetPasswordValidation();
		passwordpolicypage.closePopup();
		
	}
	
	 public void blackListPassword()
	 {
		 passwordpolicypage.clearBlackListPassword();
		 passwordpolicypage.save();
		 passwordpolicypage.verifyBlacklistPassValidation();
		 passwordpolicypage.closeNotifyMessage();
		 passwordpolicypage.enterValueBlacklistfield(); 
		 passwordpolicypage.save();
	 }
	 
	  public void blacklistPasswordValidationCheck()
	  {
		  goToUserListing();
			passwordpolicypage.searchLoginUser();
			passwordpolicypage.clickOnUsername();
			passwordpolicypage.clickOnResetPassword();
			passwordpolicypage.enterBlacklistPassword();
			passwordpolicypage.resetButton();
			passwordpolicypage.verifyResetPasswordValidation();
			passwordpolicypage.closePopup();
			
		  
	  }
	 public void reusePasswordValidation()
	 {
		 passwordpolicypage.clearReusePasswordCount();
		 passwordpolicypage.save();
		 goToUserListing();
		 passwordpolicypage.searchUserByEmailid();
		 passwordpolicypage.clickOnUsername();
		
		passwordpolicypage.clickOnResetPassword();
		passwordpolicypage.enterReUsePassword();
		passwordpolicypage.clickResetButton();
		passwordpolicypage.verifyReusePasswordValidation();
		passwordpolicypage.closePopup();
		 
		 
		 
	//	 passwordpolicypage.verifyreusePasswordValidation();
//		 passwordpolicypage.closeNotifyMessage();
//		 passwordpolicypage.enterPasswordCount();
//		 passwordpolicypage.save();
		 
	 }

}
