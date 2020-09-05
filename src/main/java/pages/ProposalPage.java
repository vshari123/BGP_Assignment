package pages;

import org.openqa.selenium.By;
import testBase.TestBase;

public class ProposalPage extends TestBase {

    private final By sectionHeader = By.xpath("//h2[contains(text(),'Submit Your Proposal')]");
    private final By proposalTab = By.xpath("//span[contains(text(),'Proposal')]");
    private final By projectTitle = By.id("react-project-title");
    private final By startDate = By.id("react-project-start_date");
    private final By endDate = By.id("react-project-end_date");
    private final By projectDescription = By.id("react-project-description");
    private final By activity = By.xpath("//input[@aria-activedescendant='react-select-project-activity--value']");
    private final By targetMarket = By.xpath("//input[@aria-activedescendant='react-select-project-primary_market--value']");
    private final By outsideSingaporeYes = By.xpath("//input[@id='react-project-is_first_time_expand-true']/../span[@class='radiobutton']");
    private final By errors = By.xpath("//span[text()='Proposal']/following-sibling::div/span");

    public String getErrors(){
        return getElementText(errors);
    }

    public boolean isSectionHeaderDisplayed() {
        waitForElement(sectionHeader);
        return isElementDisplayed(sectionHeader);
    }

    public void clickProposalTab() {
        clickElement(proposalTab);
    }

    public void enterProjectTitle(String varProjectTitle) {
        enterText(projectTitle, varProjectTitle);
        clickTabKey(projectTitle);
    }

    public void enterStartDate(String varStartDate) {
        enterText(startDate, varStartDate);
    }

    public void enterEndDate(String varEndDate) {
        enterText(endDate, varEndDate);
    }

    public void enterProjectDescription(String varProjectDescription) {
        enterText(projectDescription, varProjectDescription);
    }

    public void enterActivity(String varActivity) {
        enterText(activity, varActivity);
        driverWait();
        clickTabAction();
    }

    public void enterTargetMarket(String varTargetMarket) {
        enterText(targetMarket, varTargetMarket);
        driverWait();
        clickTabAction();
    }

    public void clickOutsideSingaporeYes() {
        clickElement(outsideSingaporeYes);
    }

}