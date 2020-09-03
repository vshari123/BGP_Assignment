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
    private final By reviewTab = By.xpath("//button[contains(text(),'Review')]");
    private final By finalAcknowledgementCheckBox = By.xpath("//span[contains(text(),'We, the Applicant, declare that the facts stated i')]");
    private final By reviewButton = By.xpath("//*[@id='review-btn']");
    private final By submitButton = By.xpath("//button[contains(text(),'Submit')]");
    private final By acknowledgementCheckBox = By.xpath("//span[contains(text(),'The Applicant hereby acknowledges and consents to')]");
    private final By governmentAndAgenciesYes = By.xpath("//input[@id='react-declaration-covid_safe_ques_check-true']/../span[@class='radiobutton']");
    //private final By hasTheApplicantCivilSuit = By.xpath("//label[contains(text(),'Has the applicant ");
    //private final By hasTheApplicantJurisdictionYes = By.xpath("//li[1]//div[1]//div[2]//label[2]//span[1]");
    //private final By hasTheApplicantJurisdiction = By.xpath("//*[@id='js-app']/div/div/div[2]/div[2]/div/div/div[1]/ol/li[1]/div/div[1]/span/div/label");
    //private final By hasTheApplicantCivilSuitYes = By.xpath("//li[4]//div[1]//div[2]//label[2]//span[1]");
    //private final By applicantBankruptcy = By.xpath("//label[contains(text(),'Is the applicant cu");
    //private final By applicantBankruptcyYes = By.xpath("//li[3]//div[1]//div[2]//label[2]//span[1]");
    //private final By financialIncentives = By.xpath("//label[contains(text(),'Has the applicant applied for or obtained any othe')]");
    //private final By financialIncentivesYes = By.xpath("//li[4]//div[1]//div[2]//label[2]//span[1]");
    //private final By signingContract = By.xpath("//label[contains(text(),'Has the applicant c");
    //private final By shareHolders = By.xpath("//label[contains(text(),'Do any of the suppliers and service providers enga')]");
    //private final By signingContractYes = By.xpath("//li[5]//div[1]//div[2]//label[2]//span[1]");
    //private final By MOH = By.xpath("//label[contains(text(),'The Applicant has complied with all applicable saf')]");
    //private final By shareHoldersYes = By.xpath("//li[6]//div[1]//div[2]//label[2]//span[1]");
    //private final By MOHNo = By.xpath("//input[@id='react-declaration-covid_safe_check-false']/../span[@class='radiobutton']");
    //private final By SDMNo = By.xpath("//li[9]//div[1]//div[2]//label[1]//span[1]");
    //private final By SDM = By.xpath("//label[contains(text(),'The Applicant agrees to comply with all applicable')]");
    //private final By governmentAndAgencies = By.xpath("//label[contains(text(),'The Applicant agre");
    //private final By governmentAndAgenciesNo = By.xpath("//input[@id='react-declaration-covid_safe_ques_check-false']/../span[@class='radiobutton']");
    //private final By SDMYes = By.xpath("//li[9]//div[1]//div[2]//label[2]//span[1]");


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
    public void clickReviewTab() {
        clickElement(reviewTab);
    }

    public void clickFinalAcknowledgementCheckBox() {
        clickElement(finalAcknowledgementCheckBox);
    }

    public void clickReviewButton() {
        clickElement(reviewButton);
    }

    public void clickSubmitButton() {
        clickElement(submitButton);
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

    /*public void financialIncentivesYes() {
        clickElement(financialIncentivesYes, "yes");
    }

    public boolean signingContractDisplayed() {
        return isElementDisplayed(signingContract);
    }

    public void signingContractYes() {
        clickElement(signingContractYes, "yes");
    }

    public boolean shareHoldersDisplayed() {
        return isElementDisplayed(shareHolders);
    }

    public void shareHoldersYes() {
        clickElement(shareHoldersYes, "yes");
    }

    public boolean MOHDisplayed() {
        return isElementDisplayed(MOH);
    }

    public void MOHNo() {
        clickElement(MOHNo, "No");
    }

    public boolean governmentAndAgenciesDisplayed() {
        return isElementDisplayed(governmentAndAgencies);
    }

    public void governmentAndAgenciesNo() {
        clickElement(governmentAndAgenciesNo, "No");
    }
    public boolean SDMDisplayed() {
        return isElementDisplayed(SDM);
    }

    public void SDMNo() {
        clickElement(SDMNo, "No");
    }

    public void SDMYes() {
        clickElement(SDMYes, "yes");
    }


    public void hasTheApplicantCivilSuitYes() {
        clickElement(hasTheApplicantCivilSuitYes, "yes");
    }

    public boolean hasTheApplicantJurisdictionDisplayed() {
        return isElementDisplayed(hasTheApplicantJurisdiction);
    }
    public void hasTheApplicantJurisdictionYes() {
        clickElement(hasTheApplicantJurisdictionYes, "yes");
    }

    public boolean hasTheApplicantCivilSuitDisplayed() {
        return isElementDisplayed(hasTheApplicantCivilSuit);
    }

    public boolean applicantBankruptcyDisplayed() {
        return isElementDisplayed(applicantBankruptcy);
    }

    public void applicantBankruptcyYes() {
        clickElement(applicantBankruptcyYes, "yes");
    }

    public boolean financialIncentivesDisplayed() {
        return isElementDisplayed(financialIncentives);
    }
*/
}
