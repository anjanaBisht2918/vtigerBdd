package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsListPage {

	@FindBy(xpath ="//img[@alt=\"Create Lead...\"]")
	private WebElement LeadsPlusButton;

	public LeadsListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddLeadsPlusButton() {
		return LeadsPlusButton;
	}

	public void clickOnLeadsPlusButton() {
		LeadsPlusButton.click();
	}
}
