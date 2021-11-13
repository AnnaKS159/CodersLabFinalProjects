package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;


    @FindBy(id = "group_1")
    private WebElement sizeOfProduct;

    @FindBy(name = "qty")
    private WebElement quantityOfProduct;

    @FindBy(css = "[data-button-action='add-to-cart']")
    private WebElement addToCartButton;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseYourSize(String size) {
        sizeOfProduct.click();
        sizeOfProduct.sendKeys(size);
        sizeOfProduct.sendKeys(Keys.ENTER);
    }

    public void choosePreferedQuantity(String numberOfProducts) { /// wrong method? I have still 15 more elements...)

//        quantityOfProduct.clear();
        quantityOfProduct.sendKeys(Keys.BACK_SPACE);
        WebElement enterQuantityagain= driver.findElement(By.name("qty"));
        enterQuantityagain.sendKeys(numberOfProducts);
 //       quantityOfProduct.sendKeys(Keys.ENTER);

    }

    public void buttonAddChosenProductToCart() {
        addToCartButton.click();
    }


}
