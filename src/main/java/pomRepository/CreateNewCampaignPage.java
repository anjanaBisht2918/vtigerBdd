package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewCampaignPage {

	@FindBy(name = "campaignname")
	private WebElement campaignNameTextField;

	@FindBy(xpath = "//input[@type=\"radio\"]")
	private WebElement campaignAssignToRadioButton;

	@FindBy(name = "assigned_group_id")
	private WebElement campaignAssignTOGroupDropDown;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement campaignSaveButton;

	public WebElement getCampaignnameTextField() {
		return campaignNameTextField;
	}

	public WebElement getCampaignAssignToRadioButton() {
		return campaignAssignToRadioButton;
	}

	public WebElement getCampaignAssignTOGroupDropDown() {
		return campaignAssignTOGroupDropDown;
	}

	public WebElement getCampaignSaveButton() {
		return campaignSaveButton;
	}
	
	public CreateNewCampaignPage(WebDriver driver)
	{
	 PageFactory.initElements( driver ,this);
	}
	public void enterCampaignName(String campaignName)
	{
		campaignNameTextField.sendKeys(campaignName);
	}
    public void clickOnCampaignAssignToRadioButton()
    {
    	campaignAssignToRadioButton.click();
    }
    
    public void clickOnCampaignAssignTOGroupDropDown(String option)
    {
    	Select select = new Select(campaignAssignTOGroupDropDown);
    	select.selectByVisibleText(option);
    }
    public void clickOnCampaignSaveButton()
    {
    	campaignSaveButton.click();
    }
    
    
}
