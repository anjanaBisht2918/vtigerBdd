package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsListPage {
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	 private WebElement  createNewCampaignsButton;

	public WebElement getCreateNewCampaignsButton() {
		return createNewCampaignsButton;
	}
	
	 public CampaignsListPage(WebDriver driver)
	 {
		 PageFactory.initElements( driver,this); 
	 }
	 
	 public void clickOnCreateNewCampaignsButton()
	 {
		 createNewCampaignsButton.click();
	 }
  
}
