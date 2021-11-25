package pl.coderslab.pages;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class ScreenShotOrderConfirmationPage {
    private WebDriver driver;

    @FindBy(css = "[class='page-content page-order-confirmation card']")
    private WebElement confirmationOrderItem;

    @FindBy(tagName = "h1 card-title")
    private WebElement yourOrderIsConfirmed;

    @FindBy(css = "[title='View my customer account']")
    private WebElement goToUserAccountPage;

    @FindBy(xpath = "//*[@id='order-details']/ul/li[1]")
    private WebElement orderReference;

    @FindBy(xpath = "//*[@id=\"order-items\"]/div/table/tbody/tr[1]/td[2]")
    private WebElement subtotal;

    @FindBy(xpath = "//*[@id=\"order-items\"]/div/table/tbody/tr[3]/td[2]")
    private WebElement priceOfProducts;


    public ScreenShotOrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void takeSnapShot() throws Exception {

// Get entire page screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
// Get the location of element on the page
        Point point = confirmationOrderItem.getLocation();
// Copy the element screenshot to disk
        File screenshotLocation = new File(".\\PrintScreen\\_screenshot.png");
        FileUtils.copyFile(screenshot, screenshotLocation);

    }

    public void backToUserMainPage() {
        goToUserAccountPage.click();
    }

    public String getOrderReferenceNumber(){
        return orderReference.getText().replace("Order reference: ", "");
    }

    public boolean checkDoesItDisplay(){
        return priceOfProducts.isDisplayed();
    }
    public String getPriceOfProduct(){
        return priceOfProducts.getText();
    }



}


