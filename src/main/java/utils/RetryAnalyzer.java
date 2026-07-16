package utils;

import org.openqa.selenium.TimeoutException;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	private int retryCount=0;
	private static final int maxRetryCount = Integer.parseInt(ConfigReader.get("retry.Count"));
	
//	public boolean retry(ITestResult result)
//	{
//		if(retryCount < maxRetryCount)
//		{
//			retryCount++;
//			System.out.println("Retrying Test : "+result.getName() + " Attempt : "+retryCount);
//			return true;
//		}
//		return false;
//	}
	
	 @Override
	    public boolean retry(ITestResult result) {

	        Throwable throwable = result.getThrowable();

	        if (throwable instanceof TimeoutException
	                && retryCount < maxRetryCount) {

	            retryCount++;

	            System.out.println(
	                    "Retrying test because of TimeoutException. " +
	                    "Attempt: " + retryCount
	            );

	            return true;
	        }

	        return false;
	    }
	
	
	
}
