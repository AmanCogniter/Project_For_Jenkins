package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.PaymentGatewayPage;

public class PaymentGatewayAction {
	
	WebDriver driver;
	
	PaymentGatewayPage paymentgatewaypage;
	
	public PaymentGatewayAction(WebDriver driver)
	{
		this.driver= driver;
		paymentgatewaypage = new PaymentGatewayPage(driver);
	}
	
	public void goToPaymentGatewayTab()
	{
		paymentgatewaypage.clickFullMenuDropDown();
		paymentgatewaypage.clickCompanySetupLink();
		paymentgatewaypage.clickCompanySetupPage();
		paymentgatewaypage.clickPaymentGatewayTab();
		
	}

	
	public void ValidationCheck() {
		paymentgatewaypage.clickOnAddPaymentGateway();
		paymentgatewaypage.Save();
		paymentgatewaypage.VerifyMandatoryFieldValidation();

		}
	 
	 public void userGuide()
	 {
		 paymentgatewaypage.openAndCloseUserGuide();
		 paymentgatewaypage.cancelButton(); 
	 }
	 
	 public void addPaymentGateway()
	 {
		 //paymentgatewaypage.clickOnAddPaymentGateway();
		 paymentgatewaypage.deleteMultipleRecord();
		 paymentgatewaypage.selectPaymentGatewayType();
	 }
	 
	 public void editPaymentGateway()
	 {
		// paymentgatewaypage.clickOnAddPaymentGateway();
		 paymentgatewaypage.editPaymentGatwayType();
		 
	 }
	 
//	 public void ActionButton()
//		{
//			
//		 paymentgatewaypage.selectAll();	
//		}
		
		 public void ListingActions()
		 {
//			 paymentgatewaypage.SearchActiveInactiveDelete();
//			// paymentgatewaypage.searchIndustryType();
//			 //paymentgatewaypage.searchButton();
////			 paymentgatewaypage.selectcheckbox();
////			 paymentgatewaypage.activeActionButton();
////			 paymentgatewaypage.okConfirmButton();
////			 paymentgatewaypage.verifyActiveStatusValue();	 
		 }
		
//		 public void InactiveStatus()
//		 {
//			// paymentgatewaypage.searchIndustryType();
//			// paymentgatewaypage.searchButton();
//			 paymentgatewaypage.selectcheckbox();
//			 paymentgatewaypage.inactiveActionButton();
//			 paymentgatewaypage.okConfirmButton();
//			 paymentgatewaypage.verifyInactiveStatusValue();
//		 }
//		
//		 public void delete()
//		 {
//			 paymentgatewaypage.selectcheckbox();
//			 paymentgatewaypage.deleteButton();
//			 paymentgatewaypage.okConfirmButton();
//		 }
	
	 
	
	
	
	

}
