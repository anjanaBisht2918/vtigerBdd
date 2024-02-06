   package genericUtility;

import java.io.IOException;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//22.1
public class ListenersImplementationClass implements ITestListener {
   public JavaUtility jUtils = new JavaUtility();

   public void onTestStart(ITestResult result) {
   }

   public void onTestSuccess(ITestResult result) {
   }

   public void onTestFailure(ITestResult result) {
      String testCaseName = result.getMethod().getMethodName();

      
         try {
        	 	WebDriverUtility.takeAScreenShot(BaseClass.sdriver, "./src/test/resources/screenshots/demoapp.png");

			//WebDriverUtility.takeAScreenShot(BaseClass.sdriver, "./src/test/resources/screenshots/" + testCaseName + jUtils.generateSystemDateTime() + ".png");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
      }
 
   public void onTestSkipped(ITestResult result) {
   }

   public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
   }

   public void onStart(ITestContext context) {
   }

   public void onFinish(ITestContext context) {
   }
}