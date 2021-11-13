package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressesPage {

    private WebDriver driver;

    @FindBy(css = "[class='address']")
    private List<WebElement> adresses;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement findAddressWithAlias(String alias) {
        for (WebElement addres : adresses) {
            if (doesElementHaveAlias(addres, alias)) {
                return addres;
            }
        }
        return null;
    }
    public void deleteAddressWithAlias (String alias){
       WebElement tableWithAddressData= findAddressWithAlias(alias);
       WebElement deletebutton= tableWithAddressData.findElement(By.cssSelector("[data-link-action=\"delete-address\"]"));
       deletebutton.click();
    }


    public boolean doesElementHaveAlias(WebElement address, String alias) {
        WebElement aliasElement = address.findElement(By.tagName("h4"));
//        System.out.println("*** " + aliasElement.getText());
        return aliasElement.getText().equals(alias);
    }

}




