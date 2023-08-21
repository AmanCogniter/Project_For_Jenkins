package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.AnnouncementPage;
import pageobjects.CannedReplyPage;

public class CannedReplyAction {
	
	WebDriver driver ;
	CannedReplyPage cannedpage;
	
	public CannedReplyAction(WebDriver driver)
	{
		this.driver= driver;
		cannedpage= new CannedReplyPage(driver);
	}
	
	public void GoToCannedReplyTab()
	{
		cannedpage.clickFullMenuDropDown();
		cannedpage.clickCompanySetupLink();
		cannedpage.clickCompanySetupPage();
		cannedpage.clickOnCannedReply();
	}
	
	public void ValidationCheck()
	{
		cannedpage.AddButton();
		cannedpage.SaveButton();
		cannedpage.VerifyMandatoryFieldValidation();
		cannedpage.UserGuideAndCancel();
	}
	
	public void AddPrivateCannedReply()
	{
		cannedpage.AddButton();
		cannedpage.EnterPrivateCannedReplyName();
		cannedpage.EnterDescription();
		cannedpage.SaveButton();	
	}
	
	public void AddPublicCannedReply()
	{
		cannedpage.AddButton();
		cannedpage.EnterPublicCannedReplyName();
		cannedpage.selectStatus();
		cannedpage.PublicCheckBox();
		cannedpage.EnterDescription();
		cannedpage.SaveButton();	
	}
	
	public void SearchCannedReply()
	{
		cannedpage.GetTextCannedReply();
		cannedpage.EnterTextSearchCannedReply();
	}
	public void ActiveInactive()
	{
		cannedpage.SelectSingleCheckBox();
		cannedpage.ActiveToInActive();
		cannedpage.HandleSuccessMessage();
		cannedpage.SelectSingleCheckBox();
		cannedpage.InActiveToActive();
		cannedpage.HandleSuccessMessage();
		
	}
	public void Delete()
	{
		cannedpage.SelectSingleCheckBox();
		cannedpage.Delete();
		cannedpage.HandleSuccessMessage();
		
	}

}
