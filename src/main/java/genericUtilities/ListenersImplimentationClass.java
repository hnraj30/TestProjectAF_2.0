package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplimentationClass  implements ITestListener
{
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"-------Test script execution started--------");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"-------Test script passed--------");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub	
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"-------Test script failed--------");
		
		//Exception for failure
		System.out.println(result.getThrowable());
		
		//Screenshot
		String screenShotName = testScriptName+new JavaUtility().getrandomNumber();
		WebDriverUtility wUtil = new WebDriverUtility();
		try {
			wUtil.captureScreenshot(BaseClass.sdriver, screenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"-------Test script skipped--------");
		//Exception for skipped
		System.out.println(result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-------Suite execution started--------");

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-------Suite execution finished--------");

	}
	

}
