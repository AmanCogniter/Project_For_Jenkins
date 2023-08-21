package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.ShiftPage;
import pageobjects.SkillPage;

public class SkillAction {
	
	WebDriver driver ;
	SkillPage skillpage;
	
	public  SkillAction(WebDriver driver)
	{
		this.driver= driver;
		skillpage = new SkillPage(driver);
	}
	
	
	public void  goToSkillTab()
	{
		skillpage.clickFullMenuDropDown();
		skillpage.clickCompanySetupLink();
		skillpage.clickCompanySetupPage();
		skillpage.clickOnSkill();
	}
	
	
	public void validationCheck()
	{
		skillpage.clickOnAdd();
		skillpage.save();
		skillpage.VerifyMandatoryFieldValidation();
		skillpage.UserGuideAndCancel();
	}
	
	
	public void addNewSkill()
	{
		skillpage.clickOnAdd();
		skillpage.enterTitleName();
		skillpage.Description();
		skillpage.save();	
	}
	
	 public void EditSkill()
	 {
		 skillpage.enterSearchText();
		 skillpage.searchButton();
		 skillpage.refresh();
		 skillpage.enterSearchText();
		 skillpage.searchButton();	
		 skillpage.clickSkillName();
		 skillpage.save();
		 skillpage.verifyUpdateConfirmationMessage();
	 }
	 
	 
	 public void ActiveStatus()
		{
		 skillpage.enterSearchText();
		 skillpage.searchButton();
		 skillpage.selectcheckbox();
		 skillpage.activeActionButton();
		 skillpage.okConfirmButton();
		 skillpage.verifyStatusConfirmationMessage();
		 skillpage.verifyActiveStatusValue();
		}
		
		public void InactiveStatus()
		{
			skillpage.enterSearchText();
			skillpage.searchButton();
			skillpage.selectcheckbox();
			skillpage.inactiveActionButton();
			skillpage.okConfirmButton();
			skillpage.verifyStatusConfirmationMessage();
			skillpage.verifyInactiveStatusValue();
		}
		
		 public void delete()
		 {
			 skillpage.selectcheckbox();
			 skillpage.deleteButton();
			 skillpage.okConfirmButton();
			 skillpage.verifyDeleteConfirmationMessage();
		 }

}
