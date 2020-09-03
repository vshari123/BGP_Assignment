package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import testBase.TestBase;

public class TestApplicationSubmission extends TestBase {

    public static PreloginPage objPreLoginPage = new PreloginPage();
    public static HomePage objHomePage = new HomePage();
    public static GrantSelectionPage objGrantSelectionPage = new GrantSelectionPage();
    public static GrantActionsPage objGrantActionsPage = new GrantActionsPage();
    public static EligibilityPage objEligibilityPage = new EligibilityPage();
    public static ContactDetailsPage objContactDetailsPage = new ContactDetailsPage();
    public static ProposalPage objProposalPage =  new ProposalPage();
    public static BusinessImpactPage objBusinessImpactPage = new BusinessImpactPage();
    public static CostPage objCostPage = new CostPage();
    public static DeclareReviewPage objDeclareReviewPage = new DeclareReviewPage();
    public static ReviewVerification objReviewVerification = new ReviewVerification();

    @BeforeTest
    public void initializeDriver() {
        initialize();
    }

    @AfterTest
    public void closeDriver() {
        //teardown();
    }

    @Test
    public void firstFlow() {

        Assert.assertTrue(objPreLoginPage.isLoginDisplayed());
        objPreLoginPage.clickLogin();
        Assert.assertTrue(objPreLoginPage.isPageHeaderDisplayed());
        objPreLoginPage.enterTextInNRIC();
        objPreLoginPage.enterTextInName("VAKA SREEHARI PRASAD");
        objPreLoginPage.enterTextInUIN();
        objPreLoginPage.selectOptionInRole();
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
        Assert.assertEquals(getWindowURL(), "https://www.ifaq.gov.sg/BGP/apps/fcd_faqmain.aspx#FAQ_1111145");
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
        objContactDetailsPage.enterName("John Smith");
        objContactDetailsPage.enterJobTitle("Manager");
        objContactDetailsPage.enterContactNo("99887766");
        objContactDetailsPage.enterEmail("testmail@mymail.com");
        objContactDetailsPage.enterAlternateEmail("alternatemail@mymail.com");
        objContactDetailsPage.enterPostalCodeTextBox("530166");
        Assert.assertNotNull(objContactDetailsPage.getBlockNo());
        Assert.assertNotNull(objContactDetailsPage.getStreetAddress());
        objContactDetailsPage.enterLevelTextBox("05");
        objContactDetailsPage.enterUnitTextBox("12");
        objContactDetailsPage.clickSameAsRegisteredAddressCheckbox();
        Assert.assertNotNull(objContactDetailsPage.getBlockNo());
        Assert.assertNotNull(objContactDetailsPage.getStreetAddress());
        objContactDetailsPage.clickSameAsMainContactPersonCheckbox();
        Assert.assertEquals(objContactDetailsPage.getNameInSameAsmMainContactPerson(), "John Smith");
        Assert.assertEquals(objContactDetailsPage.getJobTitleInSameAsMainContactPerson(), "Manager");
        Assert.assertEquals(objContactDetailsPage.getEmailInSameAsMainContactPerson(), "testmail@mymail.com");
        objEligibilityPage.clickSaveButton();
        objContactDetailsPage.clickPreviousButtonInContactDetails();
        Assert.assertTrue(objEligibilityPage.isEligibilityHeaderDisplayed());
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objContactDetailsPage.isPageHeaderDisplayed());
        objContactDetailsPage.clickTabAtEmail();
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objProposalPage.isSectionHeaderDisplayed());
        objProposalPage.enterProjectTitle("Sample project title");
        objProposalPage.enterStartDate("12 Sep 2020");
        objProposalPage.enterEndDate("30 Oct 2020");
        objProposalPage.enterProjectDescription("Test project Description");
        objProposalPage.enterActivity("Overseas Marketing Presence");
        objProposalPage.enterTargetMarket("Singapore");
        objProposalPage.clickOutsideSingaporeYes();
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objBusinessImpactPage.isSectionTitleDisplayed());
        objBusinessImpactPage.enterFYEndDate("30 Oct 2020");
        objBusinessImpactPage.enterOverseasInvestmentsCurrentFY("10000");
        objBusinessImpactPage.enterOverseasInvestmentsYear1("12000");
        objBusinessImpactPage.enterOverseasInvestmentsYear2("14000");
        objBusinessImpactPage.enterOverseasInvestmentsYear3("16000");
        objBusinessImpactPage.enterOverseasSalesCurrentFY("15000");
        objBusinessImpactPage.enterOverseasSalesYear1("17000");
        objBusinessImpactPage.enterOverseasSalesYear2("19000");
        objBusinessImpactPage.enterOverseasSalesYear3("21000");
        objBusinessImpactPage.enterProjectionsRemarks("Nice Projections");
        objBusinessImpactPage.enterNonTangibleBenefitsRemarks("nothing");
        objEligibilityPage.clickNextButton();
        Assert.assertTrue(objCostPage.isSectionTitleDisplayed());
        objCostPage.clickSalarySection();
        objCostPage.clickAddNewItemButton();
        objCostPage.enterText("Edward Norton");
        objCostPage.enterDesignation("Test Analyst");
        objCostPage.enterRole("Automation QA");
        objCostPage.enterProjectInvolvement("2");
        objCostPage.enterMonthlySalary("9000");
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
        Assert.assertTrue(objReviewVerification.isCompanyProfileHeaderDisplayed());
        Assert.assertTrue(objReviewVerification.isCompanyUENDisplayed());
        objEligibilityPage.clickEligibilityTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getEligibilitySuccess(), "Yes");
        objContactDetailsPage.clickContactDetailsTab();
        driverWait();
        Assert.assertEquals(objReviewVerification.getContactSuccess(), "John Smith");
        objProposalPage.clickProposalTab();
        driverWait();
        objBusinessImpactPage.clickBusinessImpactTab();
        driverWait();
        objCostPage.clickCostTab();
        driverWait();
        objDeclareReviewPage.clickDeclareAndReviewTab();
        driverWait();
        objReviewVerification.clickAcknowledgement();
        objReviewVerification.clickSubmit();
        objReviewVerification.isSubmitSuccessHeaderDisplayed();
        objHomePage.clickMyGrants();
        driverWait();
        objHomePage.clickProcessingTab();


    }
}
