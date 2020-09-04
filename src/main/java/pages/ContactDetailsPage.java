package pages;

import org.openqa.selenium.By;
import testBase.TestBase;

public class ContactDetailsPage extends TestBase {
    private final By provideYourDetailsPageHeader = By.xpath("//h2[text()='Provide Your Contact Details']");
    private final By contactDetailsTab = By.xpath("//span[contains(text(),'Contact Details')]");
//    private final By mainContactPersonText = By.xpath("//h3[contains(text(),'Main Contact Person')]");
    private final By name = By.xpath("//*[@id='react-contact_info-name']");
    private final By jobTitle = By.id("react-contact_info-designation");
    private final By contactNo = By.id("react-contact_info-phone");
    private final By email = By.id("react-contact_info-primary_email");
    private final By alternateEmail = By.id("react-contact_info-secondary_email");
    private final By sameAsRegisteredAddressCheckbox = By.xpath("//span[contains(text(),'Same as registered address in Company Profile')]");
    private final By postalCodeTextBox = By.xpath("//input[@placeholder='Enter your Postal Code']");
    private final By blockNoTextBox = By.id("react-contact_info-correspondence_address-block");
    private final By streetTextBox = By.id("react-contact_info-correspondence_address-street");
    private final By levelTextBox = By.id("react-contact_info-correspondence_address-level");
    private final By unitTextBox = By.id("react-contact_info-correspondence_address-unit");
//    private final By buildingNameTextBox = By.id("react-contact_info-correspondence_address-building_name");
//    private final By letterOfferAddresseeText = By.xpath("//h3[contains(text(),'Letter Of Offer Addressee')]");
    private final By sameAsMainContactPersonCheckbox = By.xpath("//span[contains(text(),'Same as main contact person')]");
    private final By nameInSameAsmMainContactPerson = By.id("react-contact_info-offeree_name");
    private final By jobTitleInSameAsMainContactPerson = By.id("react-contact_info-offeree_designation");
    private final By emailInSameAsMainContactPerson = By.id("react-contact_info-offeree_email");
    private final By previousButtonInContactDetails = By.xpath("//button[contains(text(),'Previous')]");
    private final By errorNumbers = By.xpath("//span[text()='Contact Details']/../div/span");

//    private final By blockNo = By.xpath("//input[@id='react-contact_info-correspondence_address-block']");
//    private final By streetAddress = By.xpath("//input[@id='react-contact_info-correspondence_address-street']");

//    private final By saveButton = By.xpath("//button[contains(text(),'Save')]");
//    private final By nextButton = By.xpath("//button[contains(text(),'Next')]");

    public String getBlockNo() {
        return getAttribute(blockNoTextBox, "value");
    }

    public String getErrors(){
        return getElementText(errorNumbers);
    }

    public String getStreetAddress() {
        return getAttribute(streetTextBox, "value");
    }

    public boolean isPageHeaderDisplayed() {
        waitForElement(provideYourDetailsPageHeader);
        return isElementDisplayed(provideYourDetailsPageHeader);
    }

    public void clickContactDetailsTab() {
        clickElement(contactDetailsTab);
    }

    /*public boolean isMainContactPersonText() {
        return isElementDisplayed(mainContactPersonText);
    }*/

    public void enterName(String varName) {
        enterText(name, varName);
    }

    public void enterJobTitle(String varJobTitle) {
        enterText(jobTitle, varJobTitle);
    }

    public void enterContactNo(String varContactNo) {
        enterText(contactNo, varContactNo);
    }

    public void enterEmail(String varEmail) {
        enterText(email, varEmail);
    }

    public void enterAlternateEmail(String varAlternateEmail) {
        enterText(alternateEmail, varAlternateEmail);
    }


    public void clickSameAsRegisteredAddressCheckbox() {
        clickTabKey(alternateEmail);
        clickElement(sameAsRegisteredAddressCheckbox);
    }

    public void enterPostalCodeTextBox(String postalCode) {
        enterText(postalCodeTextBox, postalCode);
        clickTabKey(postalCodeTextBox);
    }

    public void clickTabAtEmail(){
        clickTabKey(emailInSameAsMainContactPerson);
    }

    /*public void enterBlockNoTextBox(String varBlockNo) {
        enterText(blockNoTextBox, varBlockNo);
    }

    public void enterStreetTextBox(String varStreet) {
        enterText(streetTextBox, varStreet);
    }
*/
    public void enterLevelTextBox(String varLevel) {
        enterText(levelTextBox, varLevel);
    }

    public void enterUnitTextBox(String varUnit) {
        enterText(unitTextBox, varUnit);
    }

   /* public void enterBuildingNameTextBox(String varBuildingName) {
        enterText(buildingNameTextBox, varBuildingName);
    }

    public void enterLetterOfferAddresseeText(String name) {
        enterText(letterOfferAddresseeText, name);
    }

    public boolean isLetterOfferAddresseeTextDisplayed() {
        return isElementDisplayed(letterOfferAddresseeText);
    }
*/
    public void clickSameAsMainContactPersonCheckbox() {
        clickElement(sameAsMainContactPersonCheckbox);
    }

    /*public void enterNameInSameAsmMainContactPerson(String name) {
        enterText(nameInSameAsmMainContactPerson, name);
    }*/

    public String getNameInSameAsmMainContactPerson() {
        return getAttribute(nameInSameAsmMainContactPerson, "value");
    }

    public String getJobTitleInSameAsMainContactPerson() {
        return getAttribute(jobTitleInSameAsMainContactPerson, "value");
    }

    /*public void enterJobTitleInSameAsMainContactPerson(String varJobTitle) {
        enterText(jobTitleInSameAsMainContactPerson, varJobTitle);
    }*/

    public String getEmailInSameAsMainContactPerson() {
        return getAttribute(emailInSameAsMainContactPerson, "value");
    }

   /* public void enterEmailInSameAsMainContactPerson(String varEmail) {
        enterText(emailInSameAsMainContactPerson, varEmail);
    }*/

    public void clickPreviousButtonInContactDetails() {
        clickElement(previousButtonInContactDetails);
    }


}