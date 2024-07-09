package selenium.utils;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import framework.utils.Log;

public class TestNgListener implements IResultListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("Start test case : " + result.getMethod().getMethodName());
		String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("Start time : " + time);
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("Passed test case : " + result.getMethod().getMethodName());
		String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("End time : " + time);
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Log.error("++++++++++++++++++++++++++++++++++++++++++++++");
		Log.error("Failed test case : " + result.getMethod().getMethodName());
		String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.error("Failed time : " + time);
		Log.error(result.getThrowable());
		Log.error("++++++++++++++++++++++++++++++++++++++++++++++");		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("Skip test case : " + result.getMethod().getMethodName());
		String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("Skip time : " + time);
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");
	}

	
	
	

}
