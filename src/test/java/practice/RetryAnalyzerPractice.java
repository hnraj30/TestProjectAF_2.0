package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	@Test(retryAnalyzer=genericUtilities.RetraAnalyzerImplementationClass.class)
	public void retryAnalyzerPractice()
	{
		Assert.fail();
		System.out.println("Retry analyzer practice");
	}

}
