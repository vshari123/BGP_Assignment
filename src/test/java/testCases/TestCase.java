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
import testUtil.ExtentReport;

public class TestCase extends TestBase {

    public static PreloginPage objPreLoginPage = new PreloginPage();
    public static HomePage objHomePage = new HomePage();
    public static GrantSelectionPage objGrantSelectionPage = new GrantSelectionPage();
    public static GrantActionsPage objGrantActionsPage = new GrantActionsPage();
    public static EligibilityPage objEligibilityPage = new EligibilityPage();
    public static ContactDetailsPage objContactDetailsPage = new ContactDetailsPage();
    public static ProposalPage objProposalPage = new ProposalPage();
    public static BusinessImpactPage objBusinessImpactPage = new BusinessImpactPage();
    public static CostPage objCostPage = new CostPage();
    public static DeclareReviewPage objDeclareReviewPage = new DeclareReviewPage();
    public static ReviewVerification objReviewVerification = new ReviewVerification();
    protected String refID;
    Datastore objDatastore = new Datastore();
    ExtentReport objExtentReport = new ExtentReport();

    @BeforeTest
    public void initializeDriver() {
        objExtentReport.initializeTest(this.getClass().getName());
        initialize();
    }

    @AfterTest
    public void closeDriver() {
        objExtentReport.endReport();
        teardown();

    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
        }else if(result.getStatus() == ITestResult.SUCCESS){
            logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
        }
        extent.endTest(logger);
    }

    @Test
    public void userLoginToLandingPage(){
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
    }

    @Test
    public void grantSelections(){
        objGrantSelectionPage.clickITBusiness();
        Assert.assertTrue(objGrantSelectionPage.isSelectGrantTitleDisplayed());
        objGrantSelectionPage.clickBusinessOverseasOption();
        Assert.assertTrue(objGrantSelectionPage.isApplyGrantTitleDisplayed());
        objGrantSelectionPage.clickMarketReadinessOption();
        objGrantSelectionPage.clickApplyButton();
        Assert.assertTrue(objGrantActionsPage.isGrantActionsHeaderDisplayed());
        objGrantActionsPage.clickProceedButton();
    }

    @Test
    public void eligibilityPage(){
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
    }

    @Test
    public void contactDetailsPagePartialUpdate(){
        objContactDetailsPage.enterName(objDatastore.getTestData("nameInContact"));
        objContactDetailsPage.enterJobTitle(objDatastore.getTestData("jobTitleInContact"));
        //objContactDetailsPage.enterContactNo("99887766");
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
        objContactDetailsPage.clickPreviousButtonInContactDetails();
        Assert.assertTrue(objEligibilityPage.isEligibilityHeaderDisplayed());
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objContactDetailsPage.isPageHeaderDisplayed());
        objContactDetailsPage.clickTabAtEmail();
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objProposalPage.isSectionHeaderDisplayed());
    }

    @Test
    public void proposalPage(){
        //objProposalPage.enterProjectTitle("Sample project title");
        objProposalPage.enterStartDate(objDatastore.getTestData("startDate"));
        objProposalPage.enterEndDate(objDatastore.getTestData("endDate"));
        //objProposalPage.enterProjectDescription("Test project Description");
        objProposalPage.enterActivity(objDatastore.getTestData("activity"));
        objProposalPage.enterTargetMarket(objDatastore.getTestData("targetMarket"));
        objProposalPage.clickOutsideSingaporeYes();
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objBusinessImpactPage.isSectionTitleDisplayed());
    }


    @Test
    public void businessImpactPage(){
        objBusinessImpactPage.enterFYEndDate(objDatastore.getTestData("fyEndDate"));
        objBusinessImpactPage.enterOverseasSalesCurrentFY(objDatastore.getTestData("ossCurrentFY"));
        objBusinessImpactPage.enterOverseasSalesYear1(objDatastore.getTestData("ossYear1"));
        objBusinessImpactPage.enterOverseasSalesYear2(objDatastore.getTestData("ossYear2"));
        objBusinessImpactPage.enterOverseasSalesYear3(objDatastore.getTestData("ossYear3"));
        objBusinessImpactPage.enterOverseasInvestmentsCurrentFY(objDatastore.getTestData("osiCurrentFY"));
        objBusinessImpactPage.enterOverseasInvestmentsYear1(objDatastore.getTestData("osiYear1"));
        objBusinessImpactPage.enterOverseasInvestmentsYear2(objDatastore.getTestData("osiYear2"));
        objBusinessImpactPage.enterOverseasInvestmentsYear3(objDatastore.getTestData("osiYear3"));
        objBusinessImpactPage.enterProjectionsRemarks(objDatastore.getTestData("projectionRemarks"));
        objBusinessImpactPage.enterNonTangibleBenefitsRemarks(objDatastore.getTestData("nonTangibleRemarks"));
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objCostPage.isSectionTitleDisplayed());
    }

    @Test
    public void costPage(){
        objCostPage.clickSalarySection();
        objCostPage.clickAddNewItemButton();
        objCostPage.enterText(objDatastore.getTestData("nameInCost"));
        objCostPage.enterDesignation(objDatastore.getTestData("designation"));
        objCostPage.enterRole(objDatastore.getTestData("role"));
        objCostPage.enterProjectInvolvement(objDatastore.getTestData("projectInvolvement"));
        objCostPage.enterMonthlySalary(objDatastore.getTestData("monthlySalary"));
        objEligibilityPage.clickSaveButton();
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objDeclareReviewPage.isSectionTitleDisplayed());
    }

    @Test
    public void declareAndReview(){
        objDeclareReviewPage.clickTheApplicantJurisdictionNo();
        objDeclareReviewPage.clickTheApplicantCivilSuitNo();
        objDeclareReviewPage.clickApplicantBankruptcyNo();
        objDeclareReviewPage.clickFinancialIncentivesNo();
        objDeclareReviewPage.clickOtherIncentivesNo();
        objDeclareReviewPage.clickSigningContractNo();
        objDeclareReviewPage.clickShareHoldersNo();
        objDeclareReviewPage.clickMOHYes();
        objDeclareReviewPage.clickGovernmentAndAgenciesYes();
        objDeclareReviewPage.clickAcknowledgementCheckBox();
        objDeclareReviewPage.clickReviewButton();
        driverWait();
        Assert.assertEquals(objContactDetailsPage.getErrors(), objDatastore.getTestData("contactPageErrors"));
    }

    @Test
    public void errorValidationAndCorrection(){
        objContactDetailsPage.enterContactNo(objDatastore.getTestData("contactNo"));
        objProposalPage.clickProposalTab();
        driverWait();
        Assert.assertEquals(objProposalPage.getErrors(), objDatastore.getTestData("proposalPageErrors"));
        objProposalPage.enterProjectTitle(objDatastore.getTestData("projectTitle"));
        objProposalPage.enterProjectDescription(objDatastore.getTestData("projectDescription"));
        objDeclareReviewPage.clickDeclareAndReviewTab();
        objDeclareReviewPage.clickReviewButton();
        Assert.assertTrue(objReviewVerification.isCompanyProfileHeaderDisplayed());
        Assert.assertTrue(objReviewVerification.isCompanyUENDisplayed());
    }

    @Test
    public void reviewAndSubmit(){
        objEligibilityPage.clickEligibilityTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getEligibilitySuccess(), objDatastore.getTestData("eligibilitySuccess"));
        objContactDetailsPage.clickContactDetailsTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getContactSuccess(), objDatastore.getTestData("nameInContact"));
        objProposalPage.clickProposalTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getProposalSuccess(), objDatastore.getTestData("projectTitle"));
        objBusinessImpactPage.clickBusinessImpactTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getBusinessImpactSuccess(), objDatastore.getTestData("ossCurrentFY"));
        objCostPage.clickCostTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getCostSuccess(), objDatastore.getTestData("nameInCost"));
        objDeclareReviewPage.clickDeclareAndReviewTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getDeclareReviewSuccess(), objDatastore.getTestData("declareReviewSuccess"));
        objReviewVerification.clickAcknowledgement();
        objReviewVerification.clickSubmit();
        objReviewVerification.isSubmitSuccessHeaderDisplayed();
    }

    @Test
    public void validateReferenceNumber(){
        Assert.assertEquals(objReviewVerification.getAgencyDetails(), objDatastore.getTestData("agencyDetails"));
        refID = objReviewVerification.getRefID();
        objHomePage.clickMyGrants();
        driverWait();
        objHomePage.clickProcessingTab();
        driverWait();
        Assert.assertTrue(objHomePage.validateRefID(refID));
    }

    @Test
    public void contactDetailsFullUpdatePage(){
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

    @Test
    public void eligibilityPageWrongURL(){
        Assert.assertTrue(objEligibilityPage.isEligibilityHeaderDisplayed());
        Assert.assertTrue(objEligibilityPage.isTheApplicantRegisteredDisplayed());
        objEligibilityPage.clickApplicantRegisteredYes();
        Assert.assertTrue(objEligibilityPage.isTheApplicantTurnoverDisplayed());
        objEligibilityPage.clickIsTheApplicantTurnoverNo();
        Assert.assertTrue(objEligibilityPage.isWarningDisplayed());
        objEligibilityPage.clickFAQ();
        switchToNewTab();
        Assert.assertEquals(getWindowURL(), objDatastore.getTestData("incorrectFAQURL"));
    }

    @Test
    public void fullApplicationFlow() {
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
        //objContactDetailsPage.enterContactNo("99887766");
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
        objContactDetailsPage.clickPreviousButtonInContactDetails();
        Assert.assertTrue(objEligibilityPage.isEligibilityHeaderDisplayed());
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objContactDetailsPage.isPageHeaderDisplayed());
        objContactDetailsPage.clickTabAtEmail();
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objProposalPage.isSectionHeaderDisplayed());
        
        
        //objProposalPage.enterProjectTitle("Sample project title");
        objProposalPage.enterStartDate(objDatastore.getTestData("startDate"));
        objProposalPage.enterEndDate(objDatastore.getTestData("endDate"));
        //objProposalPage.enterProjectDescription("Test project Description");
        objProposalPage.enterActivity(objDatastore.getTestData("activity"));
        objProposalPage.enterTargetMarket(objDatastore.getTestData("targetMarket"));
        objProposalPage.clickOutsideSingaporeYes();
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objBusinessImpactPage.isSectionTitleDisplayed());
        
        
        objBusinessImpactPage.enterFYEndDate(objDatastore.getTestData("fyEndDate"));
        objBusinessImpactPage.enterOverseasSalesCurrentFY(objDatastore.getTestData("ossCurrentFY"));
        objBusinessImpactPage.enterOverseasSalesYear1(objDatastore.getTestData("ossYear1"));
        objBusinessImpactPage.enterOverseasSalesYear2(objDatastore.getTestData("ossYear2"));
        objBusinessImpactPage.enterOverseasSalesYear3(objDatastore.getTestData("ossYear3"));
        objBusinessImpactPage.enterOverseasInvestmentsCurrentFY(objDatastore.getTestData("osiCurrentFY"));
        objBusinessImpactPage.enterOverseasInvestmentsYear1(objDatastore.getTestData("osiYear1"));
        objBusinessImpactPage.enterOverseasInvestmentsYear2(objDatastore.getTestData("osiYear2"));
        objBusinessImpactPage.enterOverseasInvestmentsYear3(objDatastore.getTestData("osiYear3"));
        objBusinessImpactPage.enterProjectionsRemarks(objDatastore.getTestData("projectionRemarks"));
        objBusinessImpactPage.enterNonTangibleBenefitsRemarks(objDatastore.getTestData("nonTangibleRemarks"));
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objCostPage.isSectionTitleDisplayed());
        
        
        objCostPage.clickSalarySection();
        objCostPage.clickAddNewItemButton();
        objCostPage.enterText(objDatastore.getTestData("nameInCost"));
        objCostPage.enterDesignation(objDatastore.getTestData("designation"));
        objCostPage.enterRole(objDatastore.getTestData("role"));
        objCostPage.enterProjectInvolvement(objDatastore.getTestData("projectInvolvement"));
        objCostPage.enterMonthlySalary(objDatastore.getTestData("monthlySalary"));
        objEligibilityPage.clickSaveButton();
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objDeclareReviewPage.isSectionTitleDisplayed());
        
        
        objDeclareReviewPage.clickTheApplicantJurisdictionNo();
        objDeclareReviewPage.clickTheApplicantCivilSuitNo();
        objDeclareReviewPage.clickApplicantBankruptcyNo();
        objDeclareReviewPage.clickFinancialIncentivesNo();
        objDeclareReviewPage.clickOtherIncentivesNo();
        objDeclareReviewPage.clickSigningContractNo();
        objDeclareReviewPage.clickShareHoldersNo();
        objDeclareReviewPage.clickMOHYes();
        objDeclareReviewPage.clickGovernmentAndAgenciesYes();
        objDeclareReviewPage.clickAcknowledgementCheckBox();
        objDeclareReviewPage.clickReviewButton();
        driverWait();
        Assert.assertEquals(objContactDetailsPage.getErrors(), objDatastore.getTestData("contactPageErrors"));
        
        objContactDetailsPage.enterContactNo(objDatastore.getTestData("contactNo"));
        objProposalPage.clickProposalTab();
        driverWait();
        Assert.assertEquals(objProposalPage.getErrors(), objDatastore.getTestData("proposalPageErrors"));
        objProposalPage.enterProjectTitle(objDatastore.getTestData("projectTitle"));
        objProposalPage.enterProjectDescription(objDatastore.getTestData("projectDescription"));
        objDeclareReviewPage.clickDeclareAndReviewTab();
        objDeclareReviewPage.clickReviewButton();
        Assert.assertTrue(objReviewVerification.isCompanyProfileHeaderDisplayed());
        Assert.assertTrue(objReviewVerification.isCompanyUENDisplayed());
        
        
        objEligibilityPage.clickEligibilityTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getEligibilitySuccess(), objDatastore.getTestData("eligibilitySuccess"));
        objContactDetailsPage.clickContactDetailsTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getContactSuccess(), objDatastore.getTestData("nameInContact"));
        objProposalPage.clickProposalTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getProposalSuccess(), objDatastore.getTestData("projectTitle"));
        objBusinessImpactPage.clickBusinessImpactTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getBusinessImpactSuccess(), objDatastore.getTestData("ossCurrentFY"));
        objCostPage.clickCostTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getCostSuccess(), objDatastore.getTestData("nameInCost"));
        objDeclareReviewPage.clickDeclareAndReviewTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getDeclareReviewSuccess(), objDatastore.getTestData("declareReviewSuccess"));
        objReviewVerification.clickAcknowledgement();
        objReviewVerification.clickSubmit();
        objReviewVerification.isSubmitSuccessHeaderDisplayed();
        


        Assert.assertEquals(objReviewVerification.getAgencyDetails(), objDatastore.getTestData("agencyDetails"));
        refID = objReviewVerification.getRefID();
        objHomePage.clickMyGrants();
        driverWait();
        objHomePage.clickProcessingTab();
        driverWait();
        Assert.assertTrue(objHomePage.validateRefID(refID));
    }
}
