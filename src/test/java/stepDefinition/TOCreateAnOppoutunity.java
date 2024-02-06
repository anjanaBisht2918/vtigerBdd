package stepDefinition;

import java.sql.Connection;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import genericUtility.DataBaseUtility;
import genericUtility.ExcelSheetData;
import genericUtility.IPathConstant;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileData;
import genericUtility.WebDriverUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomRepository.CampaignInformationPage;
import pomRepository.CampaignsListPage;
import pomRepository.CreateNewCampaignPage;
import pomRepository.CreatingNewOrganizationPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.OrganizationInformationPage;
import pomRepository.OrganizationPage;

public class TOCreateAnOppoutunity {

	public WebDriver driver;
	public PropertyFileData propfileUtility = new PropertyFileData();
	public ExcelSheetData execlUtility = new ExcelSheetData();
	public JavaUtility javaUtility = new JavaUtility();
	public WebDriverUtility webDriverutils = new WebDriverUtility();
	public static WebDriver sdriver;

	public Connection connection;
	public DataBaseUtility dutils = new DataBaseUtility();

	@Given("Admin has logged in and on the home page")
	public void admin_has_logged_in_and_on_the_home_page() throws Exception {

		String username = propfileUtility.fetchDataFromPropertyFile("userName");
		String password = propfileUtility.fetchDataFromPropertyFile("password");
		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);

		System.out.println("Login in to Application");
		System.out.println("The User has logged in and is on the Home Page");

	}

	@When("admin creates organization")
	public void admin_creates_organization() throws Exception {

		// Test Data
		String organizationName = execlUtility.fetchStringDataFromExcelSheet(IPathConstant.ORGANIZATION_SHEET_NAME, 1,
				0) + javaUtility.generateRandomNo(10000);
		HomePage home = new HomePage(driver);
		home.clickOnOrganizationsMajorTab();
		OrganizationPage organization = new OrganizationPage(driver);
		CreatingNewOrganizationPage createOrganization = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInfo = new OrganizationInformationPage(driver);
		organization.clickOnOrganizationPlusButton();
		createOrganization.enterOrganizationName(organizationName);
		createOrganization.clickOnSaveButton();
		String actualOrganizationInfo = organizationInfo.verifyOrganizationInformation(organizationName);

		Assert.assertTrue(actualOrganizationInfo.contains(organizationName));
		System.out.println("Pass: the organization has been created");

	}

	@When("admin creates campaign")
	public void admin_creates_campaign() {
		HomePage home = new HomePage(driver);
		CampaignsListPage campaign = new CampaignsListPage(driver);
		CreateNewCampaignPage createCampaign = new CreateNewCampaignPage(driver);
		CampaignInformationPage actualCampaignInfo = new CampaignInformationPage(driver);

		home.clickOnCampaignsMajorTab();
		campaign.clickOnCreateNewCampaignsButton();
		createCampaign.enterCampaignName(campaignName);
		createCampaign.clickOnCampaignSaveButton();
		String actualCampaignInfo = campaignInfo.verifyCreatedCampaignInformation(campaignName);

		Assert.assertTrue(actualCampaignInfo.contains(campaignName));
		System.out.println("Pass: the campaign has been created");

	}

	@When("admin creates opportunity")
	public void admin_creates_opportunity() {
		String opportunityName = execlUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1,
				0);
		HomePage home = new HomePage(driver);
		home.clickOnOpportunitiesMajorTab();
		opportintyName.clickOnaddOppurtunityPlusButton();

		createOpportunity.enterOpportunityName(opportunityName);
		createOpportunity.enterOrganizationDetailsinOrganizationLookUpPage(organizationLookUpPageTitle,
				organizationName);

		createOpportunity.enterCampaignDetailsinCampaignSourceLookUpPage(campaignLookUpPageTitle, campaignName);
		createOpportunity.enterClosingDate(opportunityClosingDate);
		createOpportunity.clickOnSaveButton();

	}

	@Then("Verify the created Opportunity")
	public void verify_the_created_opportunity() {

		String actualOpportunityName = opportunityInfo.verifyOpportuntyInformation(opportunityName);
		Assert.assertTrue(actualOpportunityName.contains(opportunityName));
		System.out.println("Pass: the opportunity has been created");
	}

}
