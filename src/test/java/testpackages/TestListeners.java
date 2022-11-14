package testpackages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ParentClass;

import java.io.File;
import java.io.IOException;


public class TestListeners extends ParentClass implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        String fileName = result.getName();
        TakesScreenshot srcShot = (TakesScreenshot) driver;

        File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./screenShots/" + fileName + ".png");

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
