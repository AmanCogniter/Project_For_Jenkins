package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.AnnouncementPage;

public class AnnouncementAction {
	WebDriver driver ; 
	AnnouncementPage announcepage;
	
	public AnnouncementAction(WebDriver driver)
	{
		this.driver= driver;
		announcepage= new AnnouncementPage(driver);
	}
	
	public void GoToCompanySetupPage()
	{
		announcepage.clickFullMenuDropDown();
		announcepage.clickCompanySetupLink();
		announcepage.clickCompanySetupPage();		
	}
	
	
	public void validationMessageCheck()
	{
		announcepage.AddButton();
		announcepage.save();
		announcepage.TitleErrorMessageValidation();
		announcepage.MessageFieldErrorMessageValidation();
		announcepage.UserGuide();
	}
	
	
	public void AddAnnouncement()
	{
		announcepage.AddButton();
		announcepage.AnnouncementTitle();
		announcepage.EnableAcknowledgementRequired();
		announcepage.UploadAttachment();
		announcepage.EnterDescription();
		announcepage.save();
		announcepage.HandleSuccessMessage();
		announcepage.SelectSingleCheckBox();
		announcepage.ActiveToInActive();
		announcepage.HandleSuccessMessage();
		announcepage.SelectSingleCheckBox();
		announcepage.InActiveToActive();
		announcepage.HandleSuccessMessage();
		announcepage.SearchAnnouncement();
		announcepage.SelectSingleCheckBox();
		announcepage.DeleteAnnoucement();
		announcepage.HandleSuccessMessage();
		
	}

}
