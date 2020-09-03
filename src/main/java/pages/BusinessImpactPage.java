package pages;

import org.openqa.selenium.By;
import testBase.TestBase;

public class BusinessImpactPage extends TestBase {

    private final By sectionTitle = By.xpath("//h2[contains(text(),'Explain The Business Impact')]");
    private final By businessImpactTab = By.xpath("//span[contains(text(),'Business Impact')]");
    private final By FYEndDate = By.xpath("//*[@id='react-project_impact-fy_end_date_0']");
    private final By overseasSalesCurrentFY = By.xpath("//*[@id='react-project_impact-overseas_sales_0']");
    private final By overseasSalesYear1 = By.xpath("//*[@id='react-project_impact-overseas_sales_1']");
    private final By overseasSalesYear2 = By.xpath("//*[@id='react-project_impact-overseas_sales_2']");
    private final By overseasSalesYear3 = By.xpath("//*[@id='react-project_impact-overseas_sales_3']");
    private final By overseasInvestmentsCurrentFY = By.xpath("//*[@id='react-project_impact-overseas_investments_0']");
    private final By overseasInvestmentsYear1 = By.xpath("//*[@id='react-project_impact-overseas_investments_1']");
    private final By overseasInvestmentYear2 = By.xpath("//*[@id='react-project_impact-overseas_investments_2']");
    private final By overseasInvestmentsYear3 = By.xpath("//*[@id='react-project_impact-overseas_investments_3']");
    private final By projectionsRemarks = By.xpath("//*[@id='react-project_impact-rationale_remarks']");
    private final By nonTangibleBenefitsRemarks = By.xpath("//*[@id='react-project_impact-benefits_remarks']");


    public boolean isSectionTitleDisplayed() {
        return isElementDisplayed(sectionTitle);
    }

    public void clickBusinessImpactTab() {
        clickElement(businessImpactTab);
    }

    public void enterFYEndDate(String varEndDate) {
        enterText(FYEndDate, varEndDate);
    }

    public void enterOverseasSalesCurrentFY(String varCurrentFY) {
        enterText(overseasSalesCurrentFY, varCurrentFY);
    }

    public void enterOverseasSalesYear1(String varYear1) {
        enterText(overseasSalesYear1, varYear1);
    }

    public void enterOverseasSalesYear2(String varYear2) {
        enterText(overseasSalesYear2, varYear2);
    }

    public void enterOverseasSalesYear3(String varYear3) {
        enterText(overseasSalesYear3, varYear3);
    }

    public void enterOverseasInvestmentsCurrentFY(String varCurrentFY) {
        enterText(overseasInvestmentsCurrentFY, varCurrentFY);
    }

    public void enterOverseasInvestmentsYear1(String varYear1) {
        enterText(overseasInvestmentsYear1, varYear1);
    }

    public void enterOverseasInvestmentsYear2(String varYear2) {
        enterText(overseasInvestmentYear2, varYear2);
    }

    public void enterOverseasInvestmentsYear3(String varYear3) {
        enterText(overseasInvestmentsYear3, varYear3);
    }

    public void enterProjectionsRemarks(String VarProjectionsRemarks) {
        enterText(projectionsRemarks, VarProjectionsRemarks);
    }

    public void enterNonTangibleBenefitsRemarks(String VarNonTangibleRemarks) {
        enterText(nonTangibleBenefitsRemarks, VarNonTangibleRemarks);
    }
}