package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// todo extract to separate pages
public class AddNewAddressPage {
    private WebDriver driver;


    @FindBy(id = "addresses-link")
    private WebElement clickToMoveIntoAddresses;

    @FindBy(css = "[data-link-action='add-address']")
    private WebElement buttonCreateNewAddress;

    @FindBy(name = "alias")
    private WebElement enterAlias;

    @FindBy(name = "address1")
    private WebElement enterAddress;

    @FindBy(name = "city")
    private WebElement enterCity;

    @FindBy(name = "postcode")
    private WebElement enterZipCode;

    @FindBy(xpath = "//*[@name='id_country']")
    private WebElement hereChooseCity;
    //but I've got only one country to choose....

    @FindBy(xpath = "//*[@name='phone']")
    private WebElement enterPhoneNumber;

    @FindBy(css = "[class='btn btn-primary float-xs-right']")
    private WebElement clickToSubmitAddress;


    @FindBy(id="history-link")
    private WebElement openHistoryAndDetails;


    public AddNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void chooseAndClickAddresses() {
        clickToMoveIntoAddresses.click();
    }

    public void clickInButtonToCreateNewAddress() {
        buttonCreateNewAddress.click();
    }

    public void transmitAlias(String aliasName) {
        enterAlias.sendKeys(aliasName);
    }

    public void inputAddress(String Address) {
        enterAddress.sendKeys(Address);
    }

    public void inputCity(String city) {
        enterCity.sendKeys(city);
    }

    public void enterZipCode(String zipCode) {
        enterZipCode.sendKeys(String.valueOf(zipCode));
    }

    public void enterPhoneNumber(String telephoneNumber) {
        enterPhoneNumber.sendKeys(String.valueOf(telephoneNumber));
    }

    public void saveImplementedData() {
        clickToSubmitAddress.click();
    }

    public void clickInOrderHistoryTile(){
        openHistoryAndDetails.click();
    }

}
