package pages;

import org.openqa.selenium.By;
import testBase.TestBase;

public class DeclareReviewPage extends TestBase {
    private final By sectionTitle = By.xpath("//h2[contains(text(),'Declare & Acknowledge Terms')]");
    private final By declareAndReviewTab = By.xpath("//span[contains(text(),'Declare & Review')]");
    private final By hasTheApplicantCivilSuitNo = By.xpath("//input[@id='react-declaration-civil_proceeding_check-false']/../span[@class='radiobutton']");
    private final By hasTheApplicantJurisdictionNo = By.xpath("//input[@id='react-declaration-criminal_liability_check-false']/../span[@class='radiobutton']");
    private final By applicantBankruptcyNo = By.xpath("//input[@id='react-declaration-insolvency_proceeding_check-false']/../span[@class='radiobutton']");
    private final By financialIncentivesNo = By.xpath("//input[@id='react-declaration-project_incentives_check-false']/../span[@class='radiobutton']");
    private final By otherIncentivesNo = By.xpath("//input[@id='react-declaration-other_incentives_check-false']/../span[@class='radiobutton']");
    private final By signingContractNo = By.xpath("//input[@id='react-declaration-project_commence_check-false']/../span[@class='radiobutton']");
    private final By shareHoldersNo = By.xpath("//input[@id='react-declaration-related_party_check-false']/../span[@class='radiobutton']");
    private final By MOHYes = By.xpath("//input[@id='react-declaration-covid_safe_check-true']/../span[@class='radiobutton']");
    private final By reviewButton = By.xpath("//*[@id='review-btn']");
    private final By acknowledgementCheckBox = By.xpath("//span[contains(text(),'The Applicant hereby acknowledges and consents to')]");
    private final By governmentAndAgenciesYes = By.xpath("//input[@id='react-declaration-covid_safe_ques_check-true']/../span[@class='radiobutton']");




    public void clickTheApplicantJurisdictionNo() {
        clickElement(hasTheApplicantJurisdictionNo);
    }

    public boolean isSectionTitleDisplayed() {
        return isElementDisplayed(sectionTitle);
    }

    public void clickDeclareAndReviewTab() {
        clickElement(declareAndReviewTab);
    }

    public void clickAcknowledgementCheckBox() {
        clickElement(acknowledgementCheckBox);
    }

    public void clickReviewButton() {
        clickElement(reviewButton);
    }


    public void clickApplicantBankruptcyNo() {
        clickElement(applicantBankruptcyNo);
    }

    public void clickTheApplicantCivilSuitNo() {
        clickElement(hasTheApplicantCivilSuitNo);
    }

    public void clickSigningContractNo() {
        clickElement(signingContractNo);
    }

    public void clickGovernmentAndAgenciesYes() {
        clickElement(governmentAndAgenciesYes);
    }

    public void clickShareHoldersNo() {
        clickElement(shareHoldersNo);
    }

    public void clickFinancialIncentivesNo() {
        clickElement(financialIncentivesNo);
    }

    public void clickOtherIncentivesNo() {
        clickElement(otherIncentivesNo);
    }

    public void clickMOHYes() {
        clickElement(MOHYes);
    }

}
