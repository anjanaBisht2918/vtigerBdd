package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class PracticeClass {
	WebDriver driver;

	public PracticeClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "potentialname")
	private WebElement opportunitiesNameTextField;
	@FindBy(xpath = "//select[@id=\"related_to_type\"]/../..//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement organizationLookUpButton;
	@FindBy(xpath = " (//img[@src=\"themes/softed/images/select.gif\"])[2]")
	private WebElement campaignSourceLookUpButton;
	@FindBy(name = "closingdate")
	private WebElement closingDateCalenderTextField;
	@FindBy(name = "search_text")
	private WebElement organizationLookUpPageSearchTextField;
	@FindBy(name = "search")
	private WebElement organizationLookUpPageSearchButton;
	@FindBy(xpath = "//input[@type=\"text\"]")
	private WebElement campaignLookUpPageSearchTextField;
	@FindBy(name = "search")
	private WebElement campaignLookUpPageSearchButton;
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement opportunitySaveButton;

	public WebElement getOpportunitiesNameTextField() {
		return opportunitiesNameTextField;
	}

	public WebElement getOrganizationLookUpButton() {
		return organizationLookUpButton;
	}

	public WebElement getCampaignSourceLookUpButton() {
		return campaignSourceLookUpButton;
	}

	public WebElement getClosingDateCalenderTextField() {
		return closingDateCalenderTextField;
	}

	public WebElement getOrganizationLookUpPageSearchTextField() {
		return organizationLookUpPageSearchTextField;
	}

	public WebElement getOrganizationLookUpPageSearchButton() {
		return organizationLookUpPageSearchButton;
	}

	public WebElement getCampaignLookUpPageSearchTextField() {
		return campaignLookUpPageSearchTextField;
	}

	public WebElement getCampaignLookUpPageSearchButton() {
		return campaignLookUpPageSearchButton;
	}

	public WebElement getOpportunitySaveButton() {
		return opportunitySaveButton;
	}

	
	public void enterOpportunityName(String opportnityName) {
		opportunitiesNameTextField.sendKeys(opportnityName);
	}

	public void clickOnOrganizationLookUpButton() {

		organizationLookUpButton.click();
	}

	public void enterOrganizationDetailsInOrganizationLookUpPage(String titleOfPageTOSwitch, String organizationName) {
		String parentWindowTittle = driver.getTitle();
		organizationLookUpButton.click();
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToChildBorwser(driver, parentWindowTittle);
		organizationLookUpPageSearchTextField.sendKeys(organizationName);
		organizationLookUpPageSearchButton.click();
		driver.findElement(By.xpath("")).click();
		wUtils.switchToChildBorwser(driver, parentWindowTittle);
	}

	public void enterCampaignDetailsInCampaignSourceLookUpPage(String tittleofPageToSwitch, String campaignName) {
		String parentWindowTittle = driver.getTitle();
		campaignSourceLookUpButton.click();
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToChildBorwser(driver, tittleofPageToSwitch);
		campaignLookUpPageSearchTextField.sendKeys(campaignName);
		campaignLookUpPageSearchButton.click();
		driver.findElement(By.xpath("//a[text()='" + campaignName + "'")).click();
		wUtils.switchToChildBorwser(driver, parentWindowTittle);
	}

	public void enterClosingDate(String dateInYYYY_MM_DD_format) {
		closingDateCalenderTextField.sendKeys(dateInYYYY_MM_DD_format);

	}

	public void clickOnSaveButton() {
		opportunitySaveButton.click();
	}

}
