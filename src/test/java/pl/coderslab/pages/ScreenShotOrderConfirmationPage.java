package pl.coderslab.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ScreenShotOrderConfirmationPage {
    private WebDriver driver;

    @FindBy(css = "[title='View my customer account']")
    private WebElement goToUserAccountPage;

    @FindBy(xpath = "//*[@id='order-details']/ul/li[1]")
    private WebElement orderReference;

    @FindBy(xpath = "//*[@id=\"order-items\"]/div/table/tbody/tr[3]/td[2]")
    private WebElement priceOfProducts;


    public ScreenShotOrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void takeSnapShot() throws Exception {

// Get entire page screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

// Copy the element screenshot to disk
        File screenshotLocation = new File(".\\PrintScreen\\_screenshot.png");
        FileUtils.copyFile(screenshot, screenshotLocation);

    }

    public void backToUserMainPage() {
        goToUserAccountPage.click();
    }

    public String getOrderReferenceNumber() {
        return orderReference.getText().replace("Order reference: ", "");
    }


    public String getPriceOfProduct() {
        return priceOfProducts.getText();
    }


}


