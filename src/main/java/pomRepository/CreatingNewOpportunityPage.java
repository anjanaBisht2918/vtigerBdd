package pomRepository;

import genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOpportunityPage {
	WebDriver driver;
	@FindBy(name = "potentialname")
	private WebElement opportunitiesNameTextField;
	@FindBy(xpath = "//select[@id=\"related_to_type\"]/../..//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement organizationLookUpButton;
	@FindBy(xpath = "(//img[@src=\"themes/softed/images/select.gif\"])[2]")
	private WebElement campaignSourceLookUpButton;
	@FindBy(name = "closingdate")
	private WebElement closingDateCalenderTextField;
	@FindBy(name = "search_text")
	private WebElement organizationLookPageSearchTextField;
	@FindBy(name = "search")
	private WebElement organizationLookUpPageSearchButton;
	@FindBy(name = "search_text")
	private WebElement campaignLookPageSearchTextField;
	@FindBy(name = "search")
	private WebElement campaignLookUpPageSearchButton;
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement  opportunitySaveButton;

	public CreatingNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

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

	public void enterOpportunitiesName(String opportunityName) {
		opportunitiesNameTextField.sendKeys(opportunityName);
	}

	public WebElement getOrganizationLookPageSearchTextField() {
		return organizationLookPageSearchTextField;
	}

	public WebElement getOrganizationLookUpPageSearchButton() {
		return organizationLookUpPageSearchButton;
	}

	public WebElement getCampaignLookPageSearchTextField() {
		return campaignLookPageSearchTextField;
	}

	public WebElement getCampaignLookUpPageSearchButton() {
		return campaignLookUpPageSearchButton;
	}

	public WebElement getOrganizationSaveButton() {
		return opportunitySaveButton;
	}

	public void enterOpportunityName(String opportunityName) {
		opportunitiesNameTextField.sendKeys(opportunityName);
	}

	public void enterOrganizationDetailsinOrganizationLookUpPage(String titleOfPageToSwitch, String organizationName) {
		String parentWindowTitle = this.driver.getTitle();
		this.organizationLookUpButton.click();
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToChildBorwser(this.driver, titleOfPageToSwitch);
		 organizationLookPageSearchTextField.sendKeys(organizationName);
		 organizationLookUpPageSearchButton.click();
		 driver.findElement(By.xpath("//a[text()='" + organizationName + "']")).click();
		wUtils.switchToChildBorwser(driver, parentWindowTitle);
	}

	public void enterCampaignDetailsinCampaignSourceLookUpPage(String titleOfPageToSwitch, String campaignName) {
		String parentWindowTitle = this.driver.getTitle();
		campaignSourceLookUpButton.click();
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToChildBorwser(this.driver, titleOfPageToSwitch);
		campaignLookPageSearchTextField.sendKeys(new CharSequence[] { campaignName });
		campaignLookUpPageSearchButton.click();
		driver.findElement(By.xpath("//a[text()='" + campaignName + "']")).click();
		wUtils.switchToChildBorwser(this.driver, parentWindowTitle);
	}

	public void enterClosingDate(String dateInYYYY_MM_DD_Format) {
		 closingDateCalenderTextField.sendKeys(new CharSequence[] { dateInYYYY_MM_DD_Format });
	}

	public void clickOnSaveButton() {
		  opportunitySaveButton.click();
	}
}

//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//
//public class CreatingNewOpportunityPage {
//	public CreatingNewOpportunityPage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
//
//	WebDriver driver;
//	@FindBy(name = "potentialname")
//	private WebElement opportunityName;
//
//	public WebElement getOpportunityName() {
//		return opportunityName;
//	}
//
//	public WebElement getOpportunityRelatedTODropDown() {
//		return opportunityRelatedTODropDown;
//	}
//
//	public WebElement getSelectOrgLookUpPlusButton() {
//		return selectOrgLookUpPlusButton;
//	}
//
//	public WebElement getPopUpOrganizationsearchBar() {
//		return PopUpOrganizationsearchBar;
//	}
//
//	public WebElement getPopUpOrganizationName() {
//		return popUpOrganizationName;
//	}
//
//	public WebElement getCampainSelectLookUpPlusButton() {
//		return campainSelectLookUpPlusButton;
//	}
//
//	public WebElement getCampainsListPopUpSearchBar() {
//		return campainsListPopUpSearchBar;
//	}
//
//	public WebElement getSalesStage() {
//		return salesStage;
//	}
//
//	public WebElement getSaveButton() {
//		return saveButton;
//	}
//
//	@FindBy(xpath = "//select[@id=\"related_to_type\"]")
//	private WebElement opportunityRelatedTODropDown;
//
//	@FindBy(xpath = "//select[@id=\"related_to_type\"]/../..//img[@src=\"themes/softed/images/select.gif\"]")
//	private WebElement selectOrgLookUpPlusButton;
//
//	@FindBy(id = "search_txt")
//	private WebElement PopUpOrganizationsearchBar;
//	@FindBy(xpath = "(//a[contains(text(),'vtiger')])[1]")
//	private WebElement popUpOrganizationName;
//
//	@FindBy(xpath = "(//img[@src=\"themes/softed/images/select.gif\"])[2]")
//	private WebElement campainSelectLookUpPlusButton;
//
//	@FindBy(xpath = " //input[@class=\"txtBox\"]")
//	private WebElement campainsListPopUpSearchBar;
//
//	@FindBy(name = "sales_stage")
//	private WebElement salesStage;
//
//	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
//	private WebElement saveButton;
//
//	public void enterOpportunityName(String name) {
//		opportunityName.sendKeys(name);
//	}
//
//	public void selectOrganizationNamefromDropdown(String option) {
//
//		Select select = new Select(opportunityRelatedTODropDown);
//		select.selectByVisibleText(option);
//
//	}
//
//	public void SwitchToOrganizationChildWindow() {
//		selectOrgLookUpPlusButton.click();
//		Set<String> allid = driver.getWindowHandles();
//		for (String id : allid) {
//			if (driver.getTitle().contains("Accounts")) {
//				driver.switchTo().window(id);
//			}
//		}
//	}
//
//	public void selectOrganisationName(String oganizationName) {
//		PopUpOrganizationsearchBar.sendKeys(oganizationName);
//		driver.findElement(By.xpath("//a[contains(text(),'" + oganizationName + "')])[1]")).click();
//	}
//
//	public void selectOptionFromSalesStage(int index) {
//		Select select = new Select(salesStage);
//		select.selectByIndex(index);
//	}
//
//	public void switchTOCampaignNamePopUpWindow() {
//		campainSelectLookUpPlusButton.click();
//		Set<String> allid = driver.getWindowHandles();
//		for (String id : allid) {
//			if (driver.getTitle().contains(id)) {
//				driver.switchTo().window(id);
//			}
//		}
//	}
//
//	public void selectCampaignName(String campaignName) {
//		campainsListPopUpSearchBar.sendKeys(campaignName);
//		driver.findElement(By.xpath("//a[contains(text(),'" + campaignName + "')]")).click();
//	}
//
//	public void clickOnSaveButton() {
//		saveButton.clear();
//	}
//}
