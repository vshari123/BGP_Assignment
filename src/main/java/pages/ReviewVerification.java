package pages;

import org.openqa.selenium.By;
import testBase.TestBase;

public class ReviewVerification extends TestBase {

    private final By companyProfileHeader = By.xpath("//h2[text()='Company Profile']");
    private final By eligibilitySuccess = By.id("react-eligibility-sg_registered_check");
    private final By contactSuccess = By.id("react-contact_info-name");
    private final By proposalSuccess = By.id("react-project-title");
    private final By businessImpactSuccess = By.id("react-project_impact-overseas_sales_0");
    private final By costSuccess = By.id("react-project_cost-salaries-0-name");
    private final By declareReviewSuccess = By.id("react-declaration-criminal_liability_check");
    private final By refID = By.xpath("//td[text()='Ref ID:']/following-sibling::td");
    private final By agencyDetails = By.xpath("//td[text()='Agency Details:']/following-sibling::td/span[1]");


    private final By companyUEN = By.xpath("//*[@id='react-company-uen']");
//    private final By registerAddressInCompanyProfile = By.xpath("//*[@id='react-company-registered_address']");
//    private final By localEquityYES = By.xpath("//*[@id='react-eligibility-global_hq_check']");
//    private final By contactNumInContactDetails = By.xpath("//*[@id='react-contact_info-phone']");
//    private final By projectTitleInProposal = By.xpath("<div class='bgp-readonly' id='react-project-title'>sample Project Title</div>");
//    private final By overSalesCurrentFYInBusinessImpact = By.xpath("//*[@id='react-project_impact-overseas_sales_0']");
//    private final By salaryInCost = By.xpath("//*[@id='react-project_cost-salaries-accordion-header']/div/div[2]");
//    private final By civilSuitNoInDeclare = By.xpath("//*[@id='react-declaration-civil_proceeding_check']");
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

    public String getProposalSuccess(){
        return getElementText(proposalSuccess);
    }

    public String getBusinessImpactSuccess(){
        return getElementText(businessImpactSuccess);
    }

    public String getCostSuccess(){
        return getElementText(costSuccess);
    }

    public String getDeclareReviewSuccess(){
        return getElementText(declareReviewSuccess);
    }

    public String getContactSuccess(){
        return getElementText(contactSuccess);
    }

    public String getRefID(){
        return getElementText(refID);
    }

    public String getAgencyDetails(){
        return getElementText(agencyDetails);
    }
}
