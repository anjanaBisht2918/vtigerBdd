package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;
/**
 * java.anjana
 * this is a object repository to store elements belonging to homePage of Vtiger Application
 */
public class HomePage {
	 public WebDriver driver;
	public HomePage(WebDriver driver ) {
		PageFactory.initElements( driver,this);
		this.driver=driver;
	}
	@FindBy(xpath = "//a[text()='Calendar']/../..//a[text()='Leads']" )
	private WebElement leadsMajorTab;
	@FindBy(linkText = "Organizations")
	private WebElement organizationsMajorTab;
	@FindBy(linkText = "Contacts")
	private WebElement contactsMajorTab;
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesMajorTab;
	@FindBy(linkText = "Products")
	private WebElement productsMajorTab;
	@FindBy(linkText = "More")
	private WebElement moreDropdown;
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsMajorTab;
	@FindBy(linkText = "Vendors")
	private WebElement vendorsMajorTab ;
	@FindBy(xpath = "//img[@ src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon ;
	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	private WebElement signOutOption ;
	
	public WebElement getLeadsMajorTab() {
		return leadsMajorTab;
	}
	public WebElement getOrganizationsMajorTab() {
		return organizationsMajorTab;
	}
	public WebElement getContactsMajorTab() {
		return contactsMajorTab;
	}
	public WebElement getOpportunitiesMajorTab() {
		return opportunitiesMajorTab;
	}
	public WebElement getProductsMajorTab() {
		return productsMajorTab;
	}
	public WebElement getMoreDropdown() {
		return moreDropdown;
	}
	public WebElement getCampaignsMajorTab() {
		return campaignsMajorTab;
	}
	public WebElement getVendorsMajorTab() {
		return vendorsMajorTab;
	}
	public WebElement getAdministratorIcon() {
		return administratorIcon;
	}
	public WebElement getSignOutOption() {
		return signOutOption;
	}
	public void clickOnLeadsMajorTab()
	{
		leadsMajorTab.click();
	}
	public void clickOnOrganizationsMajorTab ()
	{
		organizationsMajorTab.click();
	}
	public void clickOnContactsMajorTab() {
		contactsMajorTab.click();
	}
	public void clickOnOpportunitiesMajorTab () {
		opportunitiesMajorTab.click();
	}
	public void clickOnProductsMajorTab() {
		productsMajorTab.click();
	}
	public void clickOnCampaignsMajorTab() {
		Actions action = new Actions(driver);
		action.moveToElement(moreDropdown);
 		action.click(campaignsMajorTab).perform();
	}
	public void ClickOnVendorsMajorTab() {
		Actions action = new Actions(driver);
		action.moveToElement(moreDropdown);
		action.click(vendorsMajorTab).perform();
	}
	public void clickOnSignOutOption() {
		Actions action = new Actions(driver);
		action.moveToElement(administratorIcon);
 
 		 WebDriverUtility.javaScriptClick(driver, administratorIcon);
 		
		//action.click(signOutOption).perform();
		
	}
	 
 
}
