package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.ChannelPage;



public class ChannelAction {
	
	WebDriver  driver ;
	ChannelPage channelPage ;
	
	public ChannelAction(WebDriver driver)
	{
		this.driver = driver;
		channelPage = new ChannelPage(driver);
		
	}
	
	public void  goToChannelTab()
	{
		channelPage.clickFullMenuDropDown();
		channelPage.clickCompanySetupLink();
		channelPage.clickCompanySetupPage();
		channelPage.clickOnChannel();
	}
	
	public void  validationCheck()
	{
		channelPage.clickOnAdd();
		channelPage.save();
		channelPage.VerifyMandatoryFieldValidation();
		channelPage.UserGuideAndCancel();
		
	}
	
	public void addChannel()
	{
		channelPage.clickOnAdd();
		channelPage.enterChannelName();
		channelPage.selectStatus();
		channelPage.save();
		
	}
	
	public void editCreatedChannel()
	{
		channelPage.enterSearchText();
		channelPage.searchButton();
		channelPage.refresh();
		channelPage.enterSearchText();
		channelPage.searchButton();	
		channelPage.clickChannelName();
		channelPage.save();
		
	}
	
	public void ActiveStatus()
	{
		channelPage.enterSearchText();
		channelPage.searchButton();
		channelPage.selectcheckbox();
		channelPage.activeActionButton();
		channelPage.okConfirmButton();
		channelPage.verifyActiveStatusValue();
	}
	
	public void InactiveStatus()
	{
		channelPage.enterSearchText();
		channelPage.searchButton();
		channelPage.selectcheckbox();
		channelPage.inactiveActionButton();
		channelPage.okConfirmButton();
		channelPage.verifyInactiveStatusValue();
	}
	
	 public void delete()
	 {
		 channelPage.selectcheckbox();
		 channelPage.deleteButton();
		 channelPage.okConfirmButton();
	 }
	
	
	
	

}
