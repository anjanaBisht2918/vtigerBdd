package runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.PropertyFileData;
import genericUtility.WebDriverUtility;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features =  "src/test/resources/features/lead.feature"  , glue = "stepDefinition", 
            plugin = {"pretty","html:target/htmlReport/cucumber-HTML-Report.html","json:target/jsonReport/cucumber-json-report.json"}
		)
public class TestRunner {
	public static WebDriver driver;

	@BeforeClass
	public  static void setup() throws Exception {
		String browser = PropertyFileData.fetchDataFromPropertyFile("browser");
		String url = PropertyFileData.fetchDataFromPropertyFile("url");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge"))  {
			driver = new EdgeDriver();
		}

		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		System.out.println("The browser is launched");

		driver.get(url);                                
		WebDriverUtility.maximizeTheWindow(driver);
		WebDriverUtility.waitForElementsToLoaded(driver);
		System.out.println("The URL is navigated");
	}
}
