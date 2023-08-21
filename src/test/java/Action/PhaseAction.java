package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.ChannelPage;
import pageobjects.PhasePage;




public class PhaseAction {
	
	WebDriver  driver ;
	PhasePage phasepage ;
	
	public PhaseAction(WebDriver driver)
	{
		this.driver = driver;
		phasepage = new PhasePage(driver);
	
	}
	
	public void  goToPhaseTab()
	{
		phasepage.clickFullMenuDropDown();
		phasepage.clickCompanySetupLink();
		phasepage.clickCompanySetupPage();
		phasepage.clickOnPhase();
	}
	
	public void validationCheck()
	{
		phasepage.clickOnAdd();
		phasepage.save();
		phasepage.VerifyMandatoryFieldValidation();
		phasepage.UserGuideAndCancel();
	}
	
	public String addPhase()
	{
		phasepage.clickOnAdd();
		String phasename =phasepage.enterPhaseName();
		phasepage.enterDescription();
		phasepage.save();
		//phasepage.closeManagePhase();
		phasepage.verifyAddConfirmationMessage();
		phasepage.HandleSuccessMessage();
		return phasename;
		
	}
	
	
	public void editCreatedPhase()
	{
		phasepage.enterSearchText();
		phasepage.searchButton();
		phasepage.refresh();
		phasepage.enterSearchText();
		phasepage.searchButton();	
		phasepage.clickPhaseName();
		phasepage.save();
		phasepage.verifyUpdateConfirmationMessage();
		
	}
	
	public void ActiveStatus()
	{
		phasepage.enterSearchText();
		phasepage.searchButton();
		phasepage.selectcheckbox();
		phasepage.activeActionButton();
		phasepage.okConfirmButton();
		phasepage.verifyStatusConfirmationMessage();

		phasepage.verifyActiveStatusValue();
	}
	
	public void InactiveStatus()
	{
		phasepage.enterSearchText();
		phasepage.searchButton();
		phasepage.selectcheckbox();
		phasepage.inactiveActionButton();
		phasepage.okConfirmButton();
		phasepage.verifyStatusConfirmationMessage();
		phasepage.verifyInactiveStatusValue();
	}
	
	 public void delete()
	 {
		 phasepage.selectcheckbox();
		 phasepage.deleteButton();
		 phasepage.okConfirmButton();
		 phasepage.verifyDeleteConfirmationMessage();
	 }
	
	
	
	
	

}
