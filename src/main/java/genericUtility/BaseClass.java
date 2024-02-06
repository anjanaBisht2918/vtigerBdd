 package genericUtility;

import java.sql.Connection;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import pomRepository.HomePage;
import pomRepository.LoginPage;
//18.1
public class BaseClass {
   public  WebDriver driver ;
   public PropertyFileData propfileUtility = new  PropertyFileData();
   public  ExcelSheetData execlUtility = new  ExcelSheetData();
   public JavaUtility javaUtility = new JavaUtility();
   public WebDriverUtility webDriverutils = new WebDriverUtility();
   public static WebDriver sdriver;
   
   public Connection connection;
   public DataBaseUtility dutils = new DataBaseUtility();
//   @BeforeSuite
//   public void bsConfig() throws SQLException {
//	   Driver dataBasedriver = new Driver();
//	      DriverManager.registerDriver(dataBasedriver);
//	      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger2","root","Anjana@0930");
//	      System.out.println("Data base connection Achieved"); 
//	   
//      System.out.println("Data base connection Achieved");
//   }

   @BeforeClass
   public void bcConfig() throws Exception {
        
   }

   @BeforeMethod
   public void bmConfig() throws Exception {
      String username = propfileUtility.fetchDataFromPropertyFile("userName");
      String password =  propfileUtility .fetchDataFromPropertyFile("password");
      LoginPage login = new LoginPage(driver);
      login.loginAction(username, password);
      System.out.println("Login in to Application");
   }

   @AfterMethod
   public void amConfig() {
      HomePage home = new HomePage(driver);
      home.clickOnSignOutOption();
      
      System.out.println("Sign out from the application");
   }

   @AfterClass
   public void acConfig() {
      driver.quit();
      System.out.println("The Browser is closed");
   }

   @AfterSuite
   public void asConfig() throws SQLException {
	   connection.close();
      System.out.println("Data base connection is Closed");
   }
}
    
//printing statement is imp...jenkins..run...console...headless mode
	  
