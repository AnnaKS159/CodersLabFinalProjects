package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {
    private WebDriver driver;

    @FindBy(name = "confirm-addresses")
    private WebElement addressConfirmationButton;

    @FindBy(id = "checkout-delivery-step")
    private WebElement goToShippingMethod;

    @FindBy(xpath = "//*[@id='delivery_option_1']")
    private WebElement tickPrestaShopShipping;

    @FindBy(css = "[name='confirmDeliveryOption']")
    private WebElement shippingConfirmationButton;

    @FindBy(css = "[data-module-name='ps_checkpayment']")
    private WebElement paymentMethodByCheck;


    @FindBy(name = "conditions_to_approve[terms-and-conditions]")
    private WebElement acceptanceTermOfService;

    @FindBy(css = "[class='btn btn-primary center-block']")
    private WebElement orderWithAnObligationToPayButton;




    public OrderDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void confirmAddress() {
        addressConfirmationButton.click();
    }

    public void openShippingMethods() {
        goToShippingMethod.click();
    }
    public void choosePrestaShopShipping(){
        tickPrestaShopShipping.click();
    }
    public void confirmChosenShipping(){
        shippingConfirmationButton.click();
    }
    public void choosePreferredPaymentMethod(){
        paymentMethodByCheck.click();
    }
    public void acceptAgreementsOfShopTerms(){
        acceptanceTermOfService.click();
    }


    public void orderSubmission(){
        orderWithAnObligationToPayButton.click();
    }

}
