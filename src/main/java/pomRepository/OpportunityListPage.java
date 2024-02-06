package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityListPage {

	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement addOppurtunityPlusButton;

	public OpportunityListPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	}

	public WebElement getAddOppurtunityPlusButton() {
		return addOppurtunityPlusButton;
	}

	public void clickOnaddOppurtunityPlusButton() {
		addOppurtunityPlusButton.click();
	}
}
