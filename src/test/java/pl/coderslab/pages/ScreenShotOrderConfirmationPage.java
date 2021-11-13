package pl.coderslab.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScreenShotOrderConfirmationPage {
    private WebDriver driver;

    @FindBy(css = "[class='page-content page-order-confirmation card']")
    private WebElement confirmationOrderItem;

    @FindBy(tagName = "h1 card-title")
    private WebElement yourOrderIsConfirmed;


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

//// Get width and height of the element
//        int eleWidth = confirmationOrderItem.getSize().getWidth();
//        int eleHeight = confirmationOrderItem.getSize().getHeight();
//
//// Crop the entire page screenshot to get only element screenshot
//        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(),
//                eleWidth, eleHeight);
//        ImageIO.write(eleScreenshot, "png", screenshot);

// Copy the element screenshot to disk
        File screenshotLocation = new File(".\\PrintScreen\\_screenshot.png");
        FileUtils.copyFile(screenshot, screenshotLocation);

    }

}


