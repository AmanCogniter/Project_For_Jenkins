package Action;

import java.util.spi.CurrencyNameProvider;

import org.openqa.selenium.WebDriver;

import pageobjects.CurrencyManagementPage;


public class CurrencyManagementAction {

	
	WebDriver  driver ;
	CurrencyManagementPage  currencymanagementpage;
	
	 public CurrencyManagementAction(WebDriver driver) {
		 
		 this.driver= driver;
		 
		 currencymanagementpage = new  CurrencyManagementPage(driver);
		 
	 }
	 
	 public void  goToCurrencyTab()
		{
		 currencymanagementpage.clickFullMenuDropDown();
		 currencymanagementpage.clickCompanySetupLink();
		 currencymanagementpage.clickCompanySetupPage();
		 currencymanagementpage.clickOnCurrencyManagement();
		}
	 
	 public void saveButtonCheck()
	 {
		 
		currencymanagementpage.SaveButtonIsDisable();
		currencymanagementpage.CompanyBaseCurrency();
		currencymanagementpage.okConfirmButton();
		currencymanagementpage.SaveButtonIsEnable();
		currencymanagementpage.cancelButton();
	 }
	 
	 public void validationMessages()
	 
	 {
		 currencymanagementpage.CompanyBaseCurrency();
		 currencymanagementpage.okConfirmButton();
		 currencymanagementpage.Addicon();
		 currencymanagementpage.saveButton();
		 currencymanagementpage.mandatoryFieldMessage();
		 
		  currencymanagementpage.saveButton(); 
	 }
	 
	 public void alreadySelectedSourceValidation()
	 {
		 currencymanagementpage.CompanyBaseCurrency();
		 currencymanagementpage.okConfirmButton();
		 currencymanagementpage.Addicon();
		 currencymanagementpage.alreadySelectedCurrencyValidation();
		  currencymanagementpage.saveButton(); 
	 }
	 
	 public void alreadySelectedBaseValidation()
	 {
		
		 currencymanagementpage.Addicon();
		 currencymanagementpage.alreadySelectedBaseValidation();
		 
	 }
	 
	  public void addCurrencyAndDelete()
	  {
		  currencymanagementpage.Addicon();
		  currencymanagementpage.enterSourceAndRate();
		  currencymanagementpage.delete();
		  currencymanagementpage.okConfirmButton();
		  currencymanagementpage.HandleSuccessMessage();
		  
	  }
	 
	
	 
	 
}