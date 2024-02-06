package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath =  "//input[@type='text']")
	//@FindBy(name = "user_name")
	private WebElement usernameTextField;

	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	@FindBy(id = "submitButton")
	private WebElement loginButton;

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void loginAction(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
}
