package listeners;

import Base.BaseClass;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

public class TestListener implements ITestListener {

	private static Logger log = Logger.getLogger(TestListener.class);

	public void onStart(ITestContext context) {
		log.info("============= Test Suite : " + context.getName() + " started ==========");
	}

	public void onFinish(ITestContext context) {
		log.info(("============ Test Suite : " + context.getName() + " ending =========== "));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		log.info(("=========== Running test method : " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		log.info("======== Executed : " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		log.info("========= Test execution : " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		log.info("=========== Test : " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info("========== Test failed but within percentage % : " + result.getMethod().getMethodName());
	}

}
