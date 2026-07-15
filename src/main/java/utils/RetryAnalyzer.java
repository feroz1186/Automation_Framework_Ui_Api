package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	private int retryCount=0;
	private static final int maxRetryCount = Integer.parseInt(ConfigReader.get("retry.Count"));
	
	public boolean retry(ITestResult result)
	{
		if(retryCount < maxRetryCount)
		{
			retryCount++;
			System.out.println("Retrying Test : "+result.getName() + " Attempt : "+retryCount);
			return true;
		}
		return false;
	}
	
	
	
}
