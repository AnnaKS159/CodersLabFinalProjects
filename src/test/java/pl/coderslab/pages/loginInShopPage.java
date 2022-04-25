package pl.coderslab.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class loginInShopPage {
    private WebDriver driver;

    @FindBy(css = "[title='Log in to your customer account']")
    private WebElement mainPageSignInButton;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement submitButton;

    @FindBy(id = "_desktop_logo")
    private WebElement comeBackToMainPage;

    @FindBy(className = "ui-autocomplete-input")
    private WebElement nameOfProductInsert;


    public loginInShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goToSignInPage() {
        mainPageSignInButton.click();
    }

    public void insertDataToLogin(String email, String password) {
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void confirmEmailAndPassword() {
        submitButton.click();
    }
    public void clickToGoBackToMAinPage(){
        comeBackToMainPage.click();
    }
    public void findTheProduct(String nameOfProduct){
        nameOfProductInsert.click();
        nameOfProductInsert.clear();
        nameOfProductInsert.click();
        nameOfProductInsert.sendKeys(nameOfProduct);
        nameOfProductInsert.sendKeys(Keys.ENTER);

    }


}
