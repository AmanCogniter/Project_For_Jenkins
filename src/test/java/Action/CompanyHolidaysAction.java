package Action;

import org.openqa.selenium.WebDriver;

import pageobjects.CompanyHolidaysPage;

public class CompanyHolidaysAction {

	WebDriver driver;
	CompanyHolidaysPage holidayPage;

	public CompanyHolidaysAction(WebDriver driver) {
		this.driver = driver;
		holidayPage = new CompanyHolidaysPage(driver);

	}

	public void goToCompanyHolidayTab() {
		holidayPage.clickFullMenuDropDown();
		holidayPage.clickCompanySetupLink();
		holidayPage.clickCompanySetupPage();
		holidayPage.clickOnCompanyHolidays();
	}

	public void validationCheck() {
		holidayPage.clickOnAdd();
		holidayPage.save();
		holidayPage.VerifyMandatoryFieldValidation();
		holidayPage.UserGuideAndCancel();

	}

	public void addHolidayFullDay() {
		holidayPage.getHolidayDates();
		holidayPage.clickOnAdd();
		holidayPage.EnterHolidayName();
		holidayPage.SelectLocation();
		holidayPage.Description();
		holidayPage.SelectDate();
		holidayPage.clickOnAddHoliDayInCheckBOx();

		holidayPage.save();
		//holidayPage.HandleSuccessMessage();
	}

	public void SearchHoliday() {
		holidayPage.GetTextCompanyHoliday();
		holidayPage.EntertextIntoNameSearchHoliday();
		holidayPage.VerifySearch();
		holidayPage.Resetbutton();
		holidayPage.SelectInactive();
		holidayPage.okConfirmButton();
		//holidayPage.HandleSuccessMessage();
		holidayPage.SelectActive();
		holidayPage.okConfirmButton();
		//holidayPage.HandleSuccessMessage();
	}

}
