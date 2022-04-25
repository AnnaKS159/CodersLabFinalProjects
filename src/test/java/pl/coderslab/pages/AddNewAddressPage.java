package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 //todo extract to separate pages
public class AddNewAddressPage {
    private WebDriver driver;


    @FindBy(id="addresses-link")
    private WebElement buttonAddresses;

    @FindBy(css = "[data-link-action='add-address']")
    private WebElement buttonCreateNewAddress;

     @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement zipCodeInput;

    @FindBy(xpath = "//*[@name='id_country']")
    private WebElement placeToCityInput;
    //but I've got only one country to choose....

    @FindBy(xpath = "//*[@name='phone']")
    private WebElement phoneNumberInput;

     @FindBy(css = "[class='btn btn-primary float-xs-right']")
    private WebElement submitAddressButton;


    @FindBy(id="history-link")
    private WebElement buttonHistoryAndDetails;


    public AddNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void chooseAndClickAddresses() {
        buttonAddresses.click();
    }

    public void clickInButtonToCreateNewAddress() {
        buttonCreateNewAddress.click();
    }

    public void transmitAlias(String aliasName) {
        aliasInput.sendKeys(aliasName);
    }

    public void enterAddress(String Address) {
        addressInput.sendKeys(Address);
    }

    public void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    public void enterZipCode(String zipCode) {
        zipCodeInput.sendKeys(String.valueOf(zipCode));
    }

    public void enterPhoneNumber(String telephoneNumber) {
        phoneNumberInput.sendKeys(String.valueOf(telephoneNumber));
    }

    public void saveImplementedData(){
        submitAddressButton.click();
    }

    public void clickInOrderHistoryTile(){
        buttonHistoryAndDetails.click();
    }

}
