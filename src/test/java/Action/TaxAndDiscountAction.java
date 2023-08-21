package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.ShiftPage;
import pageobjects.TaxAndDiscountPage;

public class TaxAndDiscountAction {
	
	 WebDriver driver;
	 TaxAndDiscountPage taxanddiscount ;
	 
	 public TaxAndDiscountAction(WebDriver driver)
	 {
		 this.driver= driver;
		 taxanddiscount = new TaxAndDiscountPage(driver);
	 }
	 
	
	 public void  goToTaxAndDiscount()
		{
		 taxanddiscount.clickFullMenuDropDown();
		 taxanddiscount.clickCompanySetupLink();
		 taxanddiscount.clickCompanySetupPage();
		 taxanddiscount.clickOnTaxAndDiscount();
		}
		
		public void validationCheck()
		{
		
			taxanddiscount.save();
			taxanddiscount.VerifyMandatoryFieldValidation();
			taxanddiscount.cancelButton();
		}
		
		public void addTax()
		{
			taxanddiscount.addTax();
			taxanddiscount.selectTax();
			taxanddiscount.percentage();
			taxanddiscount.selectStatus();
			taxanddiscount.save();
			//taxanddiscount.verifyTaxConfirmationMessage();
			
		}
		
		
		public void addDiscount()
		{
			taxanddiscount.addDiscount();
			taxanddiscount.selectDiscount();
			taxanddiscount.percentage();
			taxanddiscount.selectStatus();
			taxanddiscount.save();
		//	taxanddiscount.verifyDiscountConfirmationMessage();
		}
		
		public void ActiveToInactiveTax()
		{
			taxanddiscount.ChangeTaxStatus();
			taxanddiscount.taxokConfirmButton();
		}
		
		public void ActiveToInactiveDiscount()
		{
			taxanddiscount.ChangeDiscountStatus();
			taxanddiscount.discountOkButton();
		}
		
}
