package pages;

import org.openqa.selenium.By;
import testBase.TestBase;

public class HomePage extends TestBase {

    private final By logoutButton = By.xpath("//span[contains(text(),'LOG OUT')]");
    private final By userName = By.className("username");
    private final By applicationsTab = By.xpath("//a[contains(text(),'Applications')]");
    private final By applicationTabParent = By.xpath("//a[contains(text(),'Applications')]/..");
    private final By getNewGrant = By.xpath("//h4[contains(text(),'Get new grant')]");
    private final By processingTab = By.xpath("//a[contains(text(),'Processing')]");
    private final By myGrants = By.xpath("//a[text()='My Grants']");

    public void clickLogout() {
        clickElement(logoutButton);
    }

    public String getUserNameText() {
        return getElementText(userName);
    }

    public boolean checkApplicationsTabSelected() {
        try {
            return !getAttribute(applicationTabParent, "class").equalsIgnoreCase("active");
        } catch (NullPointerException e) {
            return true;
        }

    }

    public void clickApplicationsTab() {
        waitForElement(applicationsTab);
        if (checkApplicationsTabSelected()) {
            clickElement(applicationsTab);
        }
    }

    public void clickGetNewGrant() {
        clickElement(getNewGrant);
    }

    public void clickProcessingTab() {
        clickElement(processingTab);
    }



    public void clickMyGrants(){
        clickElement(myGrants);
    }
}






