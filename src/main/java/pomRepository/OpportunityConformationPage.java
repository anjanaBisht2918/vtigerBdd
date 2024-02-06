package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.support.PageFactory;

public class OpportunityConformationPage {
	WebDriver driver;
  public OpportunityConformationPage(WebDriver driver)
 {
	 PageFactory.initElements(driver,this);
	 this.driver=driver;
 }
  public String opportuntyConfirmation(String opportunityName)
  {
	  return driver.findElement(By.xpath("//span[contains(text(),'"+opportunityName+"')]")).getText();
  }

}
