package pages;

import org.openqa.selenium.By;
import testBase.TestBase;

public class ReviewVerification extends TestBase {

    private final By companyProfileHeader = By.xpath("//h2[text()='Company Profile']");
    private final By eligibilitySuccess = By.xpath("//*[@id='js-app']/div/div/div[2]/div[1]/div/div/ul/li[1]/a/div/span");
    private final By contactSuccess = By.xpath("//*[@id='js-app']/div/div/div[2]/div[1]/div/div/ul/li[1]/a/div/span");
    private final By proposalSuccess = By.xpath("//*[@id='js-app']/div/div/div[2]/div[1]/div/div/ul/li[3]/a/div/span");
    private final By businessImpactSuccess = By.xpath("//*[@id='js-app']/div/div/div[2]/div[1]/div/div/ul/li[4]/a/div/span");
    private final By costSuccess = By.xpath("//*[@id='js-app']/div/div/div[2]/div[1]/div/div/ul/li[5]/a/div/span");
    private final By declareReviewSuccess = By.xpath("//*[@id='js-app']/div/div/div[2]/div[1]/div/div/ul/li[6]/a/div/span");


    private final By companyUEN = By.xpath("//*[@id='react-company-uen']");
    private final By registerAddressInCompanyProfile = By.xpath("//*[@id='react-company-registered_address']");
    private final By localEquityYES = By.xpath("//*[@id='react-eligibility-global_hq_check']");
    private final By contactNumInContactDetails = By.xpath("//*[@id='react-contact_info-phone']");
    private final By projectTitleInProposal = By.xpath("<div class='bgp-readonly' id='react-project-title'>sample Project Title</div>");
    private final By overSalesCurrentFYInBusinessImpact = By.xpath("//*[@id='react-project_impact-overseas_sales_0']");
    private final By salaryInCost = By.xpath("//*[@id='react-project_cost-salaries-accordion-header']/div/div[2]");
    private final By civilSuitNoInDeclare = By.xpath("//*[@id='react-declaration-civil_proceeding_check']");
    private final By finalCheckbox = By.xpath("//*[@id='react-declaration-info_truthfulness_check']");
    private final By submitButton = By.xpath("//*[@id='submit-btn']");
    private final By submitSuccessHeader = By.xpath("//h3[text()='Your application has been submitted.']");

    public boolean isCompanyProfileHeaderDisplayed(){
        waitForElement(companyProfileHeader);
        return isElementDisplayed(companyProfileHeader);
    }

    public boolean isSubmitSuccessHeaderDisplayed(){
        waitForElement(submitSuccessHeader);
        return isElementDisplayed(submitSuccessHeader);
    }

    public boolean isCompanyUENDisplayed(){
        return isElementDisplayed(companyUEN);
    }

    public void clickAcknowledgement(){
        clickElement(finalCheckbox);
    }

    public void clickSubmit(){
        clickElement(submitButton);
    }

    public String getEligibilitySuccess(){
        return getElementText(eligibilitySuccess);
    }

    public String getContactSuccess(){
        return getElementText(contactSuccess);
    }
}
