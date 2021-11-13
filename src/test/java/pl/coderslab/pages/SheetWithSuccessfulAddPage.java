package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SheetWithSuccessfulAddPage {
    private WebDriver driver;


    @FindBy(xpath = "//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedToCheckOut;


    public SheetWithSuccessfulAddPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void goTocheckOut(){
        proceedToCheckOut.click();
    }

}
