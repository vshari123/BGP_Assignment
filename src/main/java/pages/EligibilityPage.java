package pages;

import org.openqa.selenium.By;
import testBase.TestBase;

public class EligibilityPage extends TestBase {

    private final By eligibilityTab = By.xpath("//span[contains(text(),'Eligibility')]");
    private final By eligibilityHeader = By.xpath("//h2[contains(text(),'Check Your Eligibility')]");
    private final By isTheApplicantRegistered = By.xpath("//label[contains(text(),'Is the applicant registered in Singapore?')]");
    private final By isTheApplicantRegisteredYes = By.xpath("//input[@id='react-eligibility-sg_registered_check-true']/../span[@class='radiobutton']");
    private final By doesTheApplicant30Question = By.xpath("//*[text()='Does the applicant have at least 30% ']");
    private final By doesTheApplicant30QuestionYes = By.xpath("//input[@id='react-eligibility-global_hq_check-true']/../span[@class='radiobutton']");
    private final By isTheApplicantTurnover = By.xpath("//label[contains(text(),'group sales turnover')]");
    private final By isTheApplicantTurnoverYes = By.xpath("//input[@id='react-eligibility-turnover_check-true']/../span[@class='radiobutton']");
    private final By isTheApplicantTurnoverNo = By.xpath("//input[@id='react-eligibility-turnover_check-false']/../span[@class='radiobutton']");
    private final By followingStatementTrue = By.xpath("//*[text()=' the following statements true for this project?']");
    private final By followingStatementTrueYes = By.xpath("//input[@id='react-eligibility-started_project_check-true']/../span[@class='radiobutton']");
    private final By saveButton = By.xpath("//*[@id='save-btn']");
    private final By nextButton = By.xpath("//*[@id='next-btn']");
    private final By applicantTurnoverNoWarning = By.xpath("//div[@class='eligibility-advice']/span");
    private final By faq = By.xpath("//div[@class='eligibility-advice']//a[text()='FAQ']");
    private final By last3YearsQuestion = By.xpath("//a[text()='target market']/..");
    private final By last3YearsYesOption = By.xpath("//input[@id='react-eligibility-new_target_market_check-true']/../span[@class='radiobutton']");

    public boolean isLast3YearsQuestionDisplayed() {
        return isElementDisplayed(last3YearsQuestion);
    }

    public void clickLast3YearsYesOption() {
        clickElement(last3YearsYesOption);
    }

    public void clickFAQ() {
        clickElement(faq);
    }

    public void clickSaveButton() {
        clickElement(saveButton);
    }

    public void clickNextButton() {
        driverWait();
        clickElement(nextButton);
    }

    public void clickEligibilityTab() {
        clickElement(eligibilityTab);
    }



    public boolean isTheApplicantRegisteredDisplayed() {
        return isElementDisplayed(isTheApplicantRegistered);
    }

    public boolean isWarningDisplayed() {
        return isElementDisplayed(applicantTurnoverNoWarning);
    }

    public boolean isEligibilityHeaderDisplayed() {
        waitForElement(eligibilityHeader);
        return isElementDisplayed(eligibilityHeader);
    }

    public void clickApplicantRegisteredYes() {
        clickElement(isTheApplicantRegisteredYes);
    }



    public boolean isDoesTheApplicant30QuestionDisplayed() {
        return isElementDisplayed(doesTheApplicant30Question);
    }

    public void clickDoesTheApplicant30QuestionYes() {
        clickElement(doesTheApplicant30QuestionYes);
    }



    public boolean isTheApplicantTurnoverDisplayed() {
        return isElementDisplayed(isTheApplicantTurnover);
    }

    public void clickIsTheApplicantTurnoverYes() {
        clickElement(isTheApplicantTurnoverYes);
    }

    public void clickIsTheApplicantTurnoverNo() {
        clickElement(isTheApplicantTurnoverNo);
    }

    public boolean isFollowingStatementTrueDisplayed() {
        return isElementDisplayed(followingStatementTrue);
    }

    public void clickFollowingStatementTrueYes() {
        clickElement(followingStatementTrueYes);
    }


}
