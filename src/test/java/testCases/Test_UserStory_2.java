package testCases;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import testBase.TestBase;
import testUtil.Datastore;

public class Test_UserStory_2 extends TestBase {

    public static PreloginPage objPreLoginPage = new PreloginPage();
    public static HomePage objHomePage = new HomePage();
    public static GrantSelectionPage objGrantSelectionPage = new GrantSelectionPage();
    public static GrantActionsPage objGrantActionsPage = new GrantActionsPage();
    public static EligibilityPage objEligibilityPage = new EligibilityPage();
    public static ContactDetailsPage objContactDetailsPage = new ContactDetailsPage();
    Datastore objDatastore = new Datastore();

    @BeforeTest
    public void initializeDriver() {
        initialize();
    }

    @AfterTest
    public void closeDriver() {
        teardown();
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
        }
        extent.endTest(logger);
    }

    @Test
    public void ContactTab() {
        Assert.assertTrue(objPreLoginPage.isLoginDisplayed());
        objPreLoginPage.clickLogin();
        Assert.assertTrue(objPreLoginPage.isPageHeaderDisplayed());
        objPreLoginPage.enterTextInNRIC(objDatastore.getTestData("nricInLogin"));
        objPreLoginPage.enterTextInName(objDatastore.getTestData("nameInLogin"));
        objPreLoginPage.enterTextInUIN(objDatastore.getTestData("uinInLogin"));
        objPreLoginPage.selectOptionInRole(objDatastore.getTestData("roleInLogin"));
        objPreLoginPage.clickLoginInStub();
        objHomePage.clickApplicationsTab();
        objHomePage.clickGetNewGrant();
        Assert.assertTrue(objGrantSelectionPage.isSelectSectorTitleDisplayed());
        objGrantSelectionPage.clickITBusiness();
        Assert.assertTrue(objGrantSelectionPage.isSelectGrantTitleDisplayed());
        objGrantSelectionPage.clickBusinessOverseasOption();
        Assert.assertTrue(objGrantSelectionPage.isApplyGrantTitleDisplayed());
        objGrantSelectionPage.clickMarketReadinessOption();
        objGrantSelectionPage.clickApplyButton();
        Assert.assertTrue(objGrantActionsPage.isGrantActionsHeaderDisplayed());
        objGrantActionsPage.clickProceedButton();
        Assert.assertTrue(objEligibilityPage.isEligibilityHeaderDisplayed());
        Assert.assertTrue(objEligibilityPage.isTheApplicantRegisteredDisplayed());
        objEligibilityPage.clickApplicantRegisteredYes();
        Assert.assertTrue(objEligibilityPage.isTheApplicantTurnoverDisplayed());
        objEligibilityPage.clickIsTheApplicantTurnoverNo();
        Assert.assertTrue(objEligibilityPage.isWarningDisplayed());
        objEligibilityPage.clickFAQ();
        switchToNewTab();
        Assert.assertEquals(getWindowURL(), objDatastore.getTestData("correctFAQURL"));
        switchToPreviousTab();
        objEligibilityPage.clickIsTheApplicantTurnoverYes();
        Assert.assertTrue(objEligibilityPage.isDoesTheApplicant30QuestionDisplayed());
        objEligibilityPage.clickDoesTheApplicant30QuestionYes();
        Assert.assertTrue(objEligibilityPage.isLast3YearsQuestionDisplayed());
        objEligibilityPage.clickLast3YearsYesOption();
        Assert.assertTrue(objEligibilityPage.isFollowingStatementTrueDisplayed());
        objEligibilityPage.clickFollowingStatementTrueYes();
        objEligibilityPage.clickSaveButton();
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objContactDetailsPage.isPageHeaderDisplayed());
        objContactDetailsPage.enterName(objDatastore.getTestData("nameInContact"));
        objContactDetailsPage.enterJobTitle(objDatastore.getTestData("jobTitleInContact"));
        objContactDetailsPage.enterContactNo(objDatastore.getTestData("contactNo"));
        objContactDetailsPage.enterEmail(objDatastore.getTestData("emailInContact"));
        objContactDetailsPage.enterAlternateEmail(objDatastore.getTestData("alternateEmail"));
        objContactDetailsPage.enterPostalCodeTextBox(objDatastore.getTestData("postalCode"));
        Assert.assertNotNull(objContactDetailsPage.getBlockNo());
        Assert.assertNotNull(objContactDetailsPage.getStreetAddress());
        objContactDetailsPage.enterLevelTextBox(objDatastore.getTestData("level"));
        objContactDetailsPage.enterUnitTextBox(objDatastore.getTestData("unit"));
        objContactDetailsPage.clickSameAsRegisteredAddressCheckbox();
        Assert.assertNotNull(objContactDetailsPage.getBlockNo());
        Assert.assertNotNull(objContactDetailsPage.getStreetAddress());
        objContactDetailsPage.clickSameAsMainContactPersonCheckbox();
        Assert.assertEquals(objContactDetailsPage.getNameInSameAsmMainContactPerson(), objDatastore.getTestData("nameInContact"));
        Assert.assertEquals(objContactDetailsPage.getJobTitleInSameAsMainContactPerson(), objDatastore.getTestData("jobTitleInContact"));
        Assert.assertEquals(objContactDetailsPage.getEmailInSameAsMainContactPerson(), objDatastore.getTestData("emailInContact"));
        objEligibilityPage.clickSaveButton();
    }
}
