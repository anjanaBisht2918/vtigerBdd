package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public abstract class RetryAnalyzerImplimentatiionClass implements IRetryAnalyzer{

	int limit = 2;
	int count= 0;
	@Override
	public boolean retry(ITestResult result) {
		  if ( count <  limit) {
		         count++;
		         return true;
		      }
		  else {
		return false;
	}

	}
}
