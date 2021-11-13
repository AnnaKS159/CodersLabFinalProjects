package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class ShoppingCartPage {
    private WebDriver driver;

    @FindBy(css = "[class='checkout cart-detailed-actions card-block']")
    private WebElement proceedToCheckOutButton;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickToButtonProceedToCheckOut (){
        proceedToCheckOutButton.click();
    }

}
