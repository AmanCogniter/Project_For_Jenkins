package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import Action.BreakAction;
import Action.LoginAction;
import utils.WebTestBase;

public class Break extends WebTestBase {

	static String Screenname = " <b> Break </b>";

	@Test(priority = 1)
	public void AddBreakValidationCheck() {
		test = getTest(Screenname + " : Validation message on Add Break Screen");
		BreakAction breakaction = new BreakAction(driver);
		new LoginAction(driver).logoutLogin();
		breakaction.GoToBreakTab();
		breakaction.ValidationMessageCheck();
	}

	
	 

}
