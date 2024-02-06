package stepDefinition;

import java.sql.Connection;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.DataBaseUtility;
import genericUtility.ExcelSheetData;
import genericUtility.IPathConstant;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileData;
import genericUtility.WebDriverUtility;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomRepository.CreatingNewLeadPage;
import pomRepository.HomePage;
import pomRepository.LeadinformationPage;
import pomRepository.LeadsListPage;
import pomRepository.LoginPage;
import runner.TestRunner;

public class ToCreateALeadSteps {
	
	 WebDriver driver;
	 public ToCreateALeadSteps ()
	 {
		 
		 this .driver=TestRunner.driver;
		 
	 }
	
	

	

//	@Before
//	public void setup() throws Exception {
//		String browser = propfileUtility.fetchDataFromPropertyFile("browser");
//		String url = propfileUtility.fetchDataFromPropertyFile("url");
//
//		if (browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (browser.equals("edge")) {
//			driver = new EdgeDriver();
//		}
//
//		if (browser.equals("firefox")) {
//			driver = new FirefoxDriver();
//		}
//
//		System.out.println("The browser is launched");
//
//		driver.get(url);
//		webDriverutils.maximizeTheWindow(driver);
//		webDriverutils.waitForElementsToLoaded(driver);
//		System.out.println("The URL is navigated");
//	}
	
	
	
//      
//  	@After
//	public void tearDown() {
//		driver.quit();
//		System.out.println("The Browser is closed");
//	}

	@Given("user should be logged in and navigate to the Home page")
	public void user_should_be_logged_in_and_navigate_to_the_home_page() throws Exception {
		String username = PropertyFileData.fetchDataFromPropertyFile("username");
		String password = PropertyFileData.fetchDataFromPropertyFile("password");

		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("Login in to Application");
		Assert.fail();

		System.out.println("The User has logged in and is on the Home Page");

	}

	@When("user creates a lead")
	public void user_creates_a_lead() throws Exception {
		// Test Data
		String leadSalutation = ExcelSheetData.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 0);
		String leadFirstName = ExcelSheetData.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 1);
		String leadLastName = ExcelSheetData.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 2);
		String leadCompanyName = ExcelSheetData.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 3);
		String leadAssignedToSalutationGroupOption = ExcelSheetData
				.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 4);

		HomePage home = new HomePage(driver);
		LeadsListPage lead = new LeadsListPage(driver);
		CreatingNewLeadPage createLead = new CreatingNewLeadPage(driver);
		LeadinformationPage leadinfo = new LeadinformationPage(driver);

		home.clickOnLeadsMajorTab();
		lead.clickOnLeadsPlusButton();
		createLead.selectLeadSalutation(leadSalutation);
		createLead.enterLeadsFirstName(leadFirstName);
		createLead.enterLeadsLastName(leadLastName);
		createLead.enterLeadsCompanyName(leadCompanyName);
		createLead.clickOnAssignedToGroupsRadioButton();
		createLead.selectFromAssignToGroupDropDown(leadAssignedToSalutationGroupOption);
		createLead.clickOnSaveButton();
		System.out.println("the user has created a lead");

	}

	@Then("user verify the lead informaion")
	public void user_verify_the_lead_informaion() throws Exception {

		String leadFirstName = ExcelSheetData.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 1);
		String leadLastName = ExcelSheetData.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 2);
		LeadinformationPage leadInfo = new LeadinformationPage(driver);
		String actualLeadInfo = leadInfo.verifyLeadInformation(leadFirstName, leadLastName);
		Assert.assertTrue(actualLeadInfo.contains(leadLastName));
		System.out.println("Pass: the Lead has been created");
		System.out.println("The Lead is verified");

		HomePage home = new HomePage(driver);
		home.clickOnSignOutOption();
		System.out.println("The user has logged out");

	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
		System.out.println("the browser is closed");
	}

}
