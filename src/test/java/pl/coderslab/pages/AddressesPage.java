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
    private List<WebElement> addresses;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement findAddressWithAlias(String alias) { // w calym kafelku z szukam po aliasie
        for (WebElement address : addresses) {
            if (doesElementHaveAlias(address, alias)) {
                return address;
            }
        }
        return null;
    }

    public void deleteAddressWithAlias (String alias){
       WebElement tableWithAddressData= findAddressWithAlias(alias);


       WebElement deleteButton= tableWithAddressData.findElement(By.cssSelector("[data-link-action=\"delete-address\"]"));
       deleteButton.click();
    }


    private boolean doesElementHaveAlias(WebElement address, String alias) { //Musze po czyms szuakc a alias powinien byc unikalny
        WebElement aliasElement = address.findElement(By.tagName("h4"));
//        System.out.println("*** " + aliasElement.getText());
        return aliasElement.getText().equals(alias);
    }

}




