package testUtil;


import com.relevantcodes.extentreports.ExtentReports;
import testBase.TestBase;

import java.io.File;

public class ExtentReport extends TestBase {



    public ExtentReport() {
        extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
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
