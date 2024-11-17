package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentRep implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest extentTest;
    public ExtentTest test;

    String reportName;

    public void onTestStart(ITestResult result){
        String time = new SimpleDateFormat("MM,day,yyyy,hours,Min,second").format(new Date());
    reportName = "test_report"+time+".html";

    sparkReporter= new ExtentSparkReporter(".\\reports\\" + reportName);

    sparkReporter.config().setDocumentTitle("orangeHRM Automation Report");
    sparkReporter.config().setReportName("functional testing");
    sparkReporter.config().setTheme(Theme.DARK);

    extent = new ExtentReports();
    extent.attachReporter(sparkReporter);
    extent.setSystemInfo("application", "orangehrm.com");
    extent.setSystemInfo("Opersting System", System.getProperty("os.name"));

    }

    public void onTestSuccess(ITestResult result){
        test = extent.createTest(result.getName());
        test.log(Status.PASS,"passed");
    }

    public void ITestFailure(ITestResult result){
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
        try {
            String screenshotPath = System.getProperty("user dir")+File.separator+"screenshot"+File.separator+result.getName()+".png";
            test.addScreenCaptureFromPath(screenshotPath);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result){

    }
    public void onTestFaileButWithinSuccessPercentage(ITestResult result){

    }
    public void onTestFaileWithTimeout(ITestResult result){

    }
    public void onStart(ITestResult result){

    }
    public void onFinish(ITestResult result){

    }
}
