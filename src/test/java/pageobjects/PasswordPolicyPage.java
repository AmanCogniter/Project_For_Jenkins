package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class PasswordPolicyPage extends WebBasePage {
	
	
	WebDriver driver;

	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	
	static String useremailid;
	static String globalPass;
	//static String statusproductname;
	
	public PasswordPolicyPage(WebDriver driver) {

		super(driver, "Password Policy Page");
		this.driver = driver;
	}
	
	public void clickFullMenuDropDown() {
		staticWait(2000);
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 40);
		staticWait(2000);
	}
	
	public void clickCompanySetupSideMenu() {
		//clickByJavascript(By.xpath("//li[@data-name='COMPANY']//a//i//following::text()[1]//following::span[1]"),
				//"Company setup side Menu", 10);
		clickByJavascript(By.xpath("//li[@data-name='COMPANY SETUP']"),
				"Company setup side Menu", 10);
	}

//	public void clickCompanySetupLink() {
//		click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"), "Company Setup Link", 30);
//		staticWait(2000);
//	}

	 public void clickUserListingPage()
	 {
		 click(By.xpath("//li[@class='menuitem']/a[@data-original-title='User']"), " User Listing Page ", 30);
			staticWait(2000);
	 }
	public void clickCompanySetupPage() {
		click(By.xpath("//a[contains(text(),'Company Setup')]"), " Company Setup Page", 30);
		staticWait(2000);
	}
	public void clickUserPage() {
		click(By.xpath("//ul[@data-p-name='COMPANY SETUP']//a[@data-original-title='User']"), "User Page", 30);
		staticWait(2000);
	}

	public void clickOnPasswordPolicy() {
		clickByJavascript(By.xpath("//ul[@id='upper']//li/a[text()='Password Policy']"), "Password Policy", 20);
		staticWait(2000);
	}
	
	 public void clearMaxAndMinPassLength()
	 {
		 clear(By.id("MinLengthPwd"),"Password Minimum Length",25);
		 clear(By.id("MaxLengthPwd"),"Password Maximum Length",25);
		 
	 }
	 
	  public void enterValueMaxAndMinPassLength()
	  {
		  enter(By.id("MinLengthPwd"),"6","Password Minimum Length",25);
		  enter(By.id("MaxLengthPwd"),"10" ,"Password Minimum Length", 25);
	  }
	 
	 public void save() {
			clickByJavascript(By.xpath("//a[@id='btnSave']"), "Save Status Name", 20);
			staticWait(3500);
		}
	 
	 public void verifyPasswordLengthValidation()
		{
			String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
			 if(Message.equals("Enter a number between 4-31"))
			 {
				 getTest().log(LogStatus.PASS, "Validation message is displayed as expected " + Message);
	            logger.info("Validation message is displayed as expected " + Message);	
			 }
			 else
			 {
				 getTest().log(LogStatus.FAIL, "Validation message is not displayed as expected "+ Message);
	            logger.info("Validation message is not displayed as expected " + Message);
	            takeScreenshot(new Object() {
	            }.getClass().getEnclosingMethod().getName());
	            //Assert.fail("" + e);
			 }
		}
	 
	 public void verifyBlacklistPassValidation()
		{
			String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
			 if(Message.equals("Black Listed Passwords is required"))
			 {
				 getTest().log(LogStatus.PASS, "Validation message is displayed as expected " + Message);
	            logger.info("Validation message is displayed as expected " + Message);	
			 }
			 else
			 {
				 getTest().log(LogStatus.FAIL, "Validation message is not displayed as expected " + Message );
	            logger.info("Validation message is not displayed as expected " + Message);
	            takeScreenshot(new Object() {
	            }.getClass().getEnclosingMethod().getName());
	            //Assert.fail("" + e);
			 }
		}
	 
	  public void closeNotifyMessage()
	  {
		  click(By.id("closenotifymessage"),"Close Notify Message ", 20);
	  }
	  
	  public void clearBlackListPassword() 
	  {
		  
		 clear(By.xpath("//div[@id='alldivBlackListedPwd']/div/input"),"Clear Black List Password ", 20);
	  }
	  
	  public void enterValueBlacklistfield()
	  {
		  enter(By.xpath("//div[@id='alldivBlackListedPwd']/div/input"),"talygenpassword","enter Black List Password ",25);
	  }
	  
	  public void clearReusePasswordCount()
	  {
		  
		  staticWait(3000);
		  String str = driver.findElement(By.xpath("//input[@id='EnableReusePasswordsPolicy']")).getAttribute("checked");
		  if (str.equalsIgnoreCase("true"))
		  {
		      System.out.println(" Enable Checkbox is already selected");
		  }
		  
		  else
		  {
			  click(By.xpath("//input[@id='EnableReusePasswordsPolicy']")," Enable Reuse Password", 25);
		  }
		  
		  clear(By.id("ReusePwdNumber")," Clear the Reuse Password Count ", 25);
		  enter(By.id("ReusePwdNumber"),"1"," Enter Reuse Password Count", 25);
		  
		  
		  
		  
		  
		  
//	//	isDisplayed(By.xpath("//label[text()='User cannot Reuse Last:']/..//input[@disabled='disabled']"), "Field is disabled ", 25);
//		
//		boolean main = driver.findElement(By.xpath("//label[text()='User cannot Reuse Last:']/..//input[@disabled='disabled']")).isDisplayed();
//		System.out.println(main);
//		
//		//label[text()="User cannot Reuse Last:"]/..//input[@disabled='disabled']
//		  if(main==true)  
//		  {
//			    System.out.println("disabled tag is present");
//			    click(By.id("EnableReusePasswordsPolicy"),"Enabled Password Policy"	, 25);
//		  }
//			else
//			{
//			    System.out.println("disabled tag is not present");
//			   
//			}
//		  clear(By.id("ReusePwdNumber")," Clear the Reuse Password Count ", 25);
	  }
	  
	  public void verifyreusePasswordValidation()
	  {
		  String  Message = driver.findElement(By.xpath("//div[@id='notifymessage']/div/span")).getText(); 
			 if(Message.equals("Enter a number larger than 0"))
			 {
				 getTest().log(LogStatus.PASS, "Validation message is displayed as expected " + Message);
	            logger.info("Validation message is displayed as expected " + Message);	
			 }
			 else
			 {
				 getTest().log(LogStatus.FAIL, "Validation message is not displayed as expected " + Message );
	            logger.info("Validation message is not displayed as expected " + Message);
	            takeScreenshot(new Object() {
	            }.getClass().getEnclosingMethod().getName());
	            //Assert.fail("" + e);
			 } 
	  }
	  
	   public void enterPasswordCount()
	   {
		   enter(By.id("ReusePwdNumber"),"1","Enter Reuse Password Count",25);
	   }
	   
	    public void  searchLoginUser()
	    {
	    	 String loginusername = getText(By.xpath("//a[@id='navbarDropdownMenuLink']/span[2]"), 20);
	    	 click(By.xpath("//div[@id='headingOne1']//span[@id='searchbyname']/following-sibling::i")," click on the  search by name field", 25);
	    	 enter(By.xpath("//input[@id='txtsearchByUserName']"),loginusername," Search By name", 20);
	    	 click(By.xpath("//a[@id='Go']")," Click on search buttton", 25);
	    }
	    
	     public void clickOnUsername()
	     {
	    	 click(By.xpath("//a[@id='ancEdituser']"),"Click on the Username", 25);
	    	// click(By.xpath("//a[@data-original-title='Reset and Send Password']"), "Reset Password Link", 25);
	     }
	     
	      public void clickOnResetPassword()
	      {
	    	  click(By.xpath("//a[@data-original-title='Reset and Send Password']"), "Reset Password Link", 25);
	      }
	
	       public void enterLessThanLimit()
	       {
	    	   enter(By.id("txtNewPass"),"Passw","Entered Less then limit Password", 20);
	    	  
	    	   
	       }
	       public void enterGreaterThanLimit()
	       {
	    	   enter(By.id("txtNewPass"),"Password12345","Entered Greater then limit Password", 20);
	    	   
	    	   
	       }
	       public void verifyResetPasswordValidation()
	 	  {
	 		  String  Message = driver.findElement(By.xpath("//span[@for='txtNewPass']")).getText(); 
	 			 if(Message.equals("Please enter a valid New Password! (e.g. abc123#@_)"))
	 			 {
	 				 getTest().log(LogStatus.PASS, "Validation message is displayed as expected " + Message );
	 	            logger.info("Validation message is displayed as expected " + Message);	
	 			 }
	 			 else
	 			 {
	 				 getTest().log(LogStatus.FAIL, "Validation message is not displayed as expected "+ Message );
	 	            logger.info("Validation message is not displayed as expected " + Message);
	 	            takeScreenshot(new Object() {
	 	            }.getClass().getEnclosingMethod().getName());
	 	            //Assert.fail("" + e);
	 			 } 
	 	  }
	       
	        public void verifyReusePasswordValidation()
	        {
	        	staticWait(3000);
	        	 String  Message = driver.findElement(By.xpath("//div[@id='message']/span")).getText(); 
				 if(Message.equals("Your new password should not match your last 1 passwords."))
				 {
					 getTest().log(LogStatus.PASS, "Validation message is displayed as expected " + Message);
		            logger.info("Validation message is displayed as expected " + Message);	
				 }
				 else
				 {
					 getTest().log(LogStatus.FAIL, "Validation message is not displayed as expected " + Message );
		            logger.info("Validation message is not displayed as expected " + Message);
		            takeScreenshot(new Object() {
		            }.getClass().getEnclosingMethod().getName());
		            //Assert.fail("" + e);
				 } 
	        }
	       public void closePopup()
	       {
	    	   click(By.xpath("//h5[text()='Reset Password']/..//Button[@data-original-title='Close']"),"Close popup", 25);
	       }
	       public void resetButton()
	        {
	        	click(By.xpath("//Button[text()='Reset']")," Reset Button", 25);
	        	
	        }
	        
	       public void enterBlacklistPassword()
	      {
	        	 enter(By.id("txtNewPass"),"talygenpassword","Enter Blacklist Password",25);
	      }
	       
	       public void enterReUsePassword()
		   	 {
	    	   enter(By.id("txtNewPass"),globalPass,"Enter ReUse Password",25);
	    	   enter(By.id("txtConfirmPassword"),globalPass,"Enter ReUse Password",25);   
		   	 }
	       
	       
	       public void createUser() {

	   		clickAddUser();
	   		selectTitle();
	   		selectUserType();
	   		enterFirstName();
	   		enterLastName();
	   		enterEmail();
	   		selectGender();
	   		clickEnableLoginSwitch();
	   		enterPassword();
	   		enterConfirmPassword();
	   		selectTimezone();
	   		selectDOB();
	   		selectDOD();
	   		selectDOJ();
	   		selectDOL();
	   		selectDepartment();
	   		selectDesignation();
	   		selectShift();
	   		enterEmployeeId();
	   		enterAliasName();
	   		clickVirtualUserSwitch();
	   		clickSave();
	   		//clickActionButton();
	   		//clickAssociateLicenses();
	   		//clickPerformanceLicense();
//	   		addLicenseSuccessMessage();
	   		//closeLicensePopup();
//	   		clickActionButton();
//	   		clickConfiguration();
//	   		enableTicketResolve();
//	   		clickSaveSettings();
//	   		verifySuccessMessage(By.cssSelector("#notifymessage div"), "Record(s) has been successfully saved.", 20);
//	   		clickCloseConfiguration();
	   	}
	       
	       
	       public void clickAddUser() {
	   		findElementVisibility(By.xpath("//a[@id='ancCreateDepartment']"), 20);
	   		clickByJavascript(By.xpath("//a[@id='ancCreateDepartment']"), "Add User", 20);
	   	}
	       
	       public void selectTitle() {
	   		selectValueWithText(By.cssSelector("#user_title_id"), "Mr.", "Select Title", 0);
	   	}

	   	// Select User Type
	   	public void selectUserType() {
	   		selectValueWithText(By.cssSelector("#Clientdetail_user_type_id"), "Normal User", "Select User Type", 0);
	   	}

	   	// enter First Name
	   	public void enterFirstName() {
	   		enter(By.cssSelector("#txtFirstName"), prop.getProperty("userFirstName"), "First name", 40);
	   	}

	   	// enter Last Name
	   	public void enterLastName() {
	   		enter(By.cssSelector("#Clientdetail_last_name"), prop.getProperty("enterLastName"), "Last name", 40);
	   	}

	   	// enter Email
	   	public void enterEmail() {
	   		
	   		double randomnumber = Math.random();
	   		
	   		String Emailid ="Testing"+randomnumber+"@yopmail.com"; 
	   		useremailid = Emailid;
	   		enter(By.cssSelector("#txtEmail"), Emailid, "Email", 20);
	   	}

	   	// Select Gender
	   	public void selectGender() {
	   		selectValueWithText(By.cssSelector("#Clientdetail_gender"), "Male", "Select Gender", 20);
	   	}

	   	// Select Enable Login
	   	public void clickEnableLoginSwitch() {
	   		click(By.xpath("//div[@id='divAttForm']/div[7]/div/div/label/span"), "Enable Login switch", 30);

	   		// input[@id='chkHourFormatN']//following::span[@class='slider
	   		// round'][1]//span[@class='slider-no']
	   	}

	   	// enter Password
	   	public void enterPassword() {
	   		
	   		String Pass = prop.getProperty("enterPassword");
	   		globalPass= Pass;
	   		enter(By.cssSelector("#txtPassword"),Pass, "Password", 20);
	   	}

	   	// enter Confirm Password
	   	public void enterConfirmPassword() {
	   		enter(By.cssSelector("#txtConfirmPassword"), prop.getProperty("enterConfirmPassword"), "ConfirmPassword", 20);
	   	}

	   	// Select Timezone
	   	public void selectTimezone() {
	   		selectValueWithText(By.xpath("//select[@id='ddlTimeZone']"),
	   				"(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi Standard Time", "Time zone", 20);
	   	}

	   	// Select Date Format
	   	public void selectDOB() {

	   		click(By.xpath("//div[@data-target='#Clientdetail_date_of_birth']"), "Date picker", 30);
	   		click(By.cssSelector("td.day.active.today"), "Todays Date", 30);
	   	}

	   	// Select DOD
	   	public void selectDOD() {

	   		click(By.xpath("//div[@data-target='#Clientdetail_date_of_death']"), "Date picker", 30);
	   		click(By.cssSelector("td.day.active"), "Date of death", 30);
	   	}

	   	// Select DOJ
	   	public void selectDOJ() {

	   		click(By.xpath("//div[@data-target='#Clientdetail_date_of_join']"), "Date picker", 20);
	   		click(By.cssSelector("td.day.active"), "Date of joining", 30);

	   	}

	   	// Select DOL
	   	public void selectDOL() {

	   		click(By.xpath("//div[@data-target='#Clientdetail_date_of_leave']"), "Date picker", 20);
	   		click(By.cssSelector("td.day.active.today"), "Date of leave", 30);

	   	}

	   	// Select Department
	   	public void selectDepartment() {
	   		selectValueWithText(By.cssSelector("#Clientdetail_department_id"), "Select", "Select", 20);
	   		selectValueWithText(By.cssSelector("#Clientdetail_department_id"), "Human Resource", "Human Resource", 20);
	   	}

	   	// Select Designation
	   	public void selectDesignation() {
	   		selectValueWithText(By.cssSelector("#Clientdetail_designation_id"), "Select", "Select", 20);
	   		selectValueWithText(By.cssSelector("#Clientdetail_designation_id"), "CEO", "CEO", 20);
	   	}

	   	// Select Shift
	   	public void selectShift() {
	   		selectValueWithText(By.cssSelector("#Clientdetail_shift_id"), "Select", "Select", 20);
	   		selectValueWithText(By.cssSelector("#Clientdetail_shift_id"), "Day(Dallas)", "Day(Dallas)", 20);
	   	}

	   	// enter Employee Id:
	   	public void enterEmployeeId() {
//	   			prop.getProperty("employeeId") 
	   		enter(By.cssSelector("#Clientdetail_user_emp_id"), datevalue + prop.getProperty("employeeId"), "Employee Id:",
	   				20);
	   	}

	   	// enter Alias Name
	   	public void enterAliasName() {
	   		enter(By.cssSelector("#Clientdetail_AliasName"), prop.getProperty("aliasName") + datevalue, "Alias Name", 20);
	   	}

	   	// Select Virtual User
	   	public void clickVirtualUserSwitch() {
	   		click(By.xpath("//*[@id='divAttForm']/div[15]/div/div/label/span"), "Virtual User switch", 20);
	   		// input[@id='chkHourFormatN']//following::span[@class='slider
	   		// round'][1]//span[@class='slider-no']
	   	}

	   	public void clickSave() {

	   		click(By.cssSelector("#btnSave"), "Save button", 20);
	   		staticWait(6000);
	   	}
	   	
	   	public void searchUserByEmailid()
	   	{
	   	 click(By.xpath("//span[contains(text(),'Search by Email')]")," click on the  search by email address field", 25);
	   	 enter(By.xpath("//input[@id='txtsearchByEmailId']"),useremailid,"Search By Email id", 20);
	   	 click(By.xpath("//a[@id='Go']")," Click on search buttton", 25);
	   	 
	   	}
	   	
	   	public void clickResetButton()
	   	
	   	{
	   		click(By.xpath("//button[text()='Reset']"), "Click on Reset Button", 25);
	   	}
	   	
	   
	    
}

