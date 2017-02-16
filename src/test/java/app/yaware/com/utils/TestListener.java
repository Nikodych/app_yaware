package app.yaware.com.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener extends TestListenerAdapter {

    //  logging of failure test result with creating screenshot
    @Override
    public final void onTestFailure(final ITestResult result) {

        final Object currentClass = result
                .getInstance();

        final WebDriver driver = ((TestRunner) currentClass)
                .getDriver();

        final Date currentDate = new Date();
        final Format formatter = new SimpleDateFormat("dd.MM.yyyy_HH-mm - ");

        final File screenShotFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        Logger.logFail("In test: " + result.getName());

        try {

            FileUtils.copyFile(screenShotFile, new File("test-output//screenshots//"
                    + formatter.format(currentDate) + result.getName() + ".png"));
            Logger.logFail("<a target='_top' href='" + "../../" + "/screenshots/"
                    + formatter.format(currentDate) + result.getName()
                    + ".png'><b><font size='2' color='orange'> Screenshot</font></b></a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  logging of successful test result
    @Override
    public final void onTestSuccess(final ITestResult result) {
        Logger.logPass(result.getName());
    }
}