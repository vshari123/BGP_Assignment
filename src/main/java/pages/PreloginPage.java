package pages;

import org.openqa.selenium.By;
import testBase.TestBase;

public class PreloginPage extends TestBase {

    private final By loginButton = By.xpath("//div[@id='login-button']");
    private final By pageHeader = By.xpath("//h1[contains(text(),'Stub CorpPass')]");
    private final By NRICTextBox = By.xpath("//input[@placeholder='NRIC']");
    private final By nameTextBox = By.name("CPUID_FullName");
    private final By UENTextBox = By.xpath("//input[@placeholder='UEN']");
    private final By roleDropdown = By.xpath("//select[@name='CPRole']");
    private final By loginButtonInStub = By.xpath("//form[2]//button[1]");

    public void clickLoginInStub() {
        clickElement(loginButtonInStub);
    }

    public void selectOptionInRole() {
        selectOption(roleDropdown, "Acceptor");
    }

    public void enterTextInUIN() {
        enterText(UENTextBox, "123456");
    }

    public void enterTextInName(String name) {
        enterText(nameTextBox, name);
    }

    public void enterTextInNRIC() {
        enterText(NRICTextBox, "G3065824N");
    }

    public boolean isPageHeaderDisplayed() {
        return isElementDisplayed(pageHeader);
    }

    public boolean isLoginDisplayed() {
        return isElementDisplayed(loginButton);
    }

    public void clickLogin() {
        clickElement(loginButton);
    }


}
