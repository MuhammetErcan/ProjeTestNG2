package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.BeforeMethod;

public class Report {
    ExtentReports reports;

    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentlogger;

    @BeforeMethod
    public void setup(){
        reports=new ExtentReports();
        String  projectPath = System.getProperty("user.dir");
        String reportPath = projectPath + "/test-output/report.html";

        extentHtmlReporter=new ExtentHtmlReporter(reportPath);
        reports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("aaaaaa");


    }

}
