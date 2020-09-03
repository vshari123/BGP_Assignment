package pages;

import org.openqa.selenium.By;
import testBase.TestBase;

public class GrantActionsPage extends TestBase {

    private final By grantActionsHeader = By.xpath("//h2[contains(text(),'Grant Actions')]");
    private final By proceedButton = By.xpath("//button[contains(text(),'Proceed')]");
    private final By deleteApplicationButton = By.xpath("//a[contains(text(),'Delete Application')]");


    public boolean isGrantActionsHeaderDisplayed() {
        waitForElement(grantActionsHeader);
        return isElementDisplayed(grantActionsHeader);
    }

    public void clickProceedButton() {
        clickElement(proceedButton);
    }

    public void clickDeleteApplicationButton() {
        clickElement(deleteApplicationButton);
    }

}