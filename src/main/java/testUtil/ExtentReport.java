package testUtil;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.File;

public class ExtentReport extends TestBase {



    public ExtentReport() {
        extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);
        extent
                .addSystemInfo("Host Name", "BGP Portal")
                .addSystemInfo("Environment", "QA Automation Environment")
                .addSystemInfo("User Name", "Vaka Sreehari Prasad");
        extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
    }

    public void initializeTest(String testName){
        logger = extent.startTest(testName);
    }

    public void endReport() {
        extent.flush();
    }
}
