package testcases;

import org.testng.annotations.Test;

import Action.AnnouncementAction;
import Action.LoginAction;
import utils.WebTestBase;
import static reporting.ComplexReportFactory.getTest;
/**
 * 
 * @author aanand
 *
 */
public class Announcement extends WebTestBase 
{

	static String Screenname = "<b>Announcement</b>"; 
	/* First check the validation then add Announcement , because after adding announcement , 
	 * it shows annoucement popup on every screen of Talygen */
	@Test(priority=1)
	public void ValidationCheck()
	{
		test=getTest(Screenname + ": Validation message on Add Annoucement");
		AnnouncementAction annouceaction = new AnnouncementAction(driver);
		new LoginAction(driver).logoutLogin();
		annouceaction.GoToCompanySetupPage();
		annouceaction.validationMessageCheck();
		
	}
	
	

	
}
