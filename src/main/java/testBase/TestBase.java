package testBase;


import java.io.FileInputStream;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testUtil.TimeOuts;

public class TestBase {
    public static WebDriver driver;
    public static Properties objProperties;
    public static WebDriverWait wait;
    public static String currentTab;
    public static ExtentReports extent;
    public static ExtentTest logger;

    /**
     * Base class to initialize properties file
     */
    public TestBase() {
        try {
            objProperties = new Properties();
            FileInputStream objFileInputStream = new FileInputStream(
                    System.getProperty("user.dir") + "\\src\\main\\resources\\config\\config.properties");
            objProperties.load(objFileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializing the browser based on the values set in Config.properties file.
     */
    public static void initialize() {
        String browserName = objProperties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + objProperties.getProperty("driverPath_Chrome"));
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    System.getProperty("user.dir") + objProperties.getProperty("driverPath_Firefox"));
            driver = new FirefoxDriver();
        }

        wait = new WebDriverWait(driver, TimeOuts.PAGE_LOAD_TIMEOUT);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TimeOuts.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TimeOuts.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.get(objProperties.getProperty("url"));
        currentTab = driver.getWindowHandle();

    }

    /**
     * Close the browser
     */
    public static void teardown() {
        driver.quit();
    }

    public boolean isElementDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void enterText(By by, String inputValue) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(inputValue);
    }

    public void selectOption(By by, String selectValue) {
        Select varSelect = new Select(driver.findElement(by));
        varSelect.selectByVisibleText(selectValue);
    }

    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    public String getElementText(By by) {
        return driver.findElement(by).getText();
    }

    public void waitForElement(By by) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    public String getAttribute(By by, String attributeName) {
        return driver.findElement(by).getAttribute(attributeName);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void switchToNewTab() {
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
    }

    public void driverWait() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void switchToPreviousTab() {
        driver.switchTo().window(currentTab);
    }

    public void clickTabKey(By by) {
        driver.findElement(by).sendKeys(Keys.TAB);
    }

    public void clickTabAction() {
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.TAB).build().perform();
    }

    public String getWindowURL() {
        return driver.getCurrentUrl();
    }



}
