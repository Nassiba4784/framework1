package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentRep implements ITestListener {

    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    public ExtentTest test;
    String reportName;


    public void onTestStart(ITestResult result){
        String time = new SimpleDateFormat("MM,day,yyyy,hours,Min,second").format(new Date());
String path = System.getProperty("userdir")+ File.separator+"report";
    reportName = "test_report"+time+".html";
    extentSparkReporter = new ExtentSparkReporter(path + reportName);

    extentReports = new ExtentReports();
    extentReports.attachReporter(extentSparkReporter);
   // extentReports.setSystemInfo("HRM application", "orangeHRM.com");
    }
    public void onTestSuccess(ITestResult result){
        test = extentReports.createTest(result.getName());
        test.log(Status.PASS,("Passed"));
    }
    public void ITestFailure(ITestResult result){

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
