
package com.lifegrip.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this class is used to retry the execution of the script  
 * @author 91958
 *
 */
public class RetryImplementationClass implements IRetryAnalyzer{
	int count=0;
	int retrylimit=4;
	/**
	 * this method is used to execute the script as per given retryLimit
	 */
	@Override
	public boolean retry(ITestResult result) {
		if(count<retrylimit)
		{
			count++;
			return true;
		}
		return false;
	}

}
