package genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class Listenerutility extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		test = extReport.createTest(result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		//to add screenshot in extent report
		
		test.log(Status.FAIL, result.getName()+"is failed");
		TakesScreenshot ts = (TakesScreenshot) sdriver;
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		
		//to add screenshot in screenshot folder
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./screenshots/"+ result.getName()+jLib.getSystemTime()+".png");
		try {
			FileUtils.copyFile(temp, perm);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
