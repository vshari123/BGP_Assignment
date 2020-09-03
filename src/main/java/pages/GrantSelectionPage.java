package pages;

import org.openqa.selenium.By;
import testBase.TestBase;

public class GrantSelectionPage extends TestBase {
    private final By ITBusiness = By.xpath("//div[contains(text(),'IT')]");
    private final By selectGrantTitle = By.xpath("//h3[contains(text(),'I need this grant to')]");
    private final By businessOverseasOption = By.xpath("//div[contains(text(),'Bring my business overseas or establish a stronger')]");
    private final By selectSectorTitle = By.xpath("//h3[contains(text(),'Which sector best describes your business?')]");
    private final By marketReadinessOption = By.xpath("//span[contains(text(),'Set up an overseas market, identify overseas busin')]");
    //private final By nextButton = By.xpath("//button[contains(text(),'Next')]");
    private final By applyButton = By.xpath("//button[contains(text(),'Apply')]");
    private final By previousButton = By.xpath("//button[contains(text(),'Previous')]");
    private final By applyGrantTitle = By.xpath("//*[@id=\"grant-wizard\"]//h3[contains(text(), 'plan to do overseas with')]");


    public void clickITBusiness() {
        clickElement(ITBusiness);
    }

    public void clickBusinessOverseasOption() {
        clickElement(businessOverseasOption);
    }

    public void clickMarketReadinessOption() {
        clickElement(marketReadinessOption);
    }

    /*public void clickNextButton() {
        clickElement(nextButton);
    }*/

    public void clickApplyButton() {
        clickElement(applyButton);
    }

    public void clickPreviousButton() {
        clickElement(previousButton);
    }

    public boolean isSelectSectorTitleDisplayed(){
        waitForElement(selectSectorTitle);
        return isElementDisplayed(selectSectorTitle);
    }

    public boolean isSelectGrantTitleDisplayed(){
        return isElementDisplayed(selectGrantTitle);
    }

    public boolean isApplyGrantTitleDisplayed(){ return isElementDisplayed(applyGrantTitle);}
}

