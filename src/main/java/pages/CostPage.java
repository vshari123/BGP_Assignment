package pages;

import org.openqa.selenium.By;
import testBase.TestBase;

public class CostPage extends TestBase {
    private final By sectionTitle = By.xpath("//h2[contains(text(),'Provide Details of Costs')]");
    private final By costTab = By.xpath("//span[contains(text(),'Cost')]");
    private final By salarySection = By.xpath("//*[@id='react-project_cost-salaries-accordion-header']//div[text()='Salary']");
    private final By addNewItemButton = By.xpath("//button[@id='react-project_cost-salaries-add-item']");
    private final By name = By.xpath("//*[@id='react-project_cost-salaries-0-name']");
    private final By designation = By.xpath("//*[@id='react-project_cost-salaries-0-designation']");
    private final By roleInProject = By.xpath("//*[@id='react-project_cost-salaries-0-project_role']");
    private final By projectInvolvementTextBox = By.xpath("//*[@id='react-project_cost-salaries-0-involvement_months']");
    private final By monthlySalaryTextBox = By.xpath("//*[@id='react-project_cost-salaries-0-salary_in_billing_currency']");

    public boolean isSectionTitleDisplayed() {
        return isElementDisplayed(sectionTitle);
    }

    public void clickCostTab() {
        clickElement(costTab);
    }

    public void clickSalarySection() {
        clickElement(salarySection);
    }

    public void clickAddNewItemButton() {
        clickElement(addNewItemButton);
    }

    public void enterText(String varName) {
        enterText(name, varName);
    }

    public void enterDesignation(String varDesignation) {
        enterText(designation, varDesignation);
    }


    public void enterRole(String varRole) {
        enterText(roleInProject, varRole);
    }

    public void enterProjectInvolvement(String name) {
        enterText(projectInvolvementTextBox, name);
    }

    public void enterMonthlySalary(String name) {
        enterText(monthlySalaryTextBox, name);
    }

}
