package Action;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import pageobjects.TemplateMappingPage;
import pageobjects.TrainingFeedbackPage;
import utils.PropertiesLoader;
import utils.WebBasePage;

public class TemplateMappingAction  {
	
	
	WebDriver driver;

	TemplateMappingPage templatemapping;

	public TemplateMappingAction(WebDriver driver) {
		this.driver = driver;
		templatemapping = new TemplateMappingPage(driver);
	}
	
	public void goToTemplateMappingTab()
	 {
		templatemapping.clickFullMenuDropDown();
		templatemapping.clickCompanySetupLink();
		templatemapping.clickCompanySetupPage();
		templatemapping.clickTemplateMappingTab();
	 }
	
	 public void validationCheck() {
		 templatemapping.AddButton();
		 templatemapping.Save();
		 templatemapping.VerifyMandatoryFieldValidation();	
	 }
	 
	 public void addTemplateMapping()
	 {
		 templatemapping.AddButton();
		 templatemapping.selectEventType();
		 templatemapping.selectTemplateName();
		 templatemapping.Save(); 	 
	 }
	 
	 
	 public void ActionButton()
		{
			
		 templatemapping.selectAll();	
		}
		
		 public void ActiveStatus()
		 {
			 templatemapping.Search();
			 templatemapping.searchButton();
			 templatemapping.selectcheckbox();
			 templatemapping.activeActionButton();
			 templatemapping.okConfirmButton();
			 templatemapping.verifyActiveStatusValue();	 
		 }
		
		 public void InactiveStatus()
		 {
			 templatemapping.Search();
			 templatemapping.searchButton();
			 templatemapping.selectcheckbox();
			 templatemapping.inactiveActionButton();
			 templatemapping.okConfirmButton();
			 templatemapping.verifyInactiveStatusValue();
		 }
		
		 public void delete()
		 {
			 templatemapping.selectcheckbox();
			 templatemapping.deleteButton();
			 templatemapping.okConfirmButton();
		 }
	 
	 
}