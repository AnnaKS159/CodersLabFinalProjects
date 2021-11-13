package pl.coderslab.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.*;

import java.util.concurrent.TimeUnit;

public class MyStoreEvolutionExercise2Steps {
    private WebDriver driver;
    private AddNewAddressPage addNewAddressEx1Page;

    @Given("I login in my-store-testlab.coderslab.pl")
    public void loginUser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl.");
        addNewAddressEx1Page = new AddNewAddressPage(driver);

    }

    @When("I click in SignIn Button to login")
    public void clickInSignInButtonOnMainPage() {
        LoginInShopPage loginInShopPage = new LoginInShopPage(driver);
        loginInShopPage.goToSignInPage();
    }

    @When("^I login in my-store-testlab.coderslab.pl with email:(.*) and password: (.*)$")
    public void enterloginDetailTOpenPage(String email, String password) {
        LoginInShopPage loginInShopPage = new LoginInShopPage(driver);
        loginInShopPage.insertDataToLogin(email, password);
        loginInShopPage.confirmEmailAndPassword();
    }

    @When("I go back to main page")
    public void goBackToMainPage() {
        LoginInShopPage loginInShopPage = new LoginInShopPage(driver);
        loginInShopPage.clickToGoBackToMAinPage();
    }

    @When("^I search the product: (.*)$")
    public void searchTheProductToBuy(String productName) {
        LoginInShopPage loginInShopPage = new LoginInShopPage(driver);
        loginInShopPage.findTheProduct(productName);
    }

    @When("I choose my product from results")
    public void chooseAndClickInProductFromSearchResult() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openWebsiteOfProduct();
    }

    @When("^I choose the size: (.*) and quantity which is equal (.*) of product and I add to cart$")
    public void addingTheProductToCart(String size, String numberOfProducts) {
        ProductPage productPage = new ProductPage(driver);
        productPage.chooseYourSize(size);
        productPage.choosePreferedQuantity(numberOfProducts);
        productPage.buttonAddChosenProductToCart();
    }

    @When("I am proceed to checkout")
    public void pressButtonToCheckOut() {
        SheetWithSuccessfulAddPage sheetWithSuccessfulAddPage = new SheetWithSuccessfulAddPage(driver);
        sheetWithSuccessfulAddPage.goTocheckOut();

    }

    @And("I make doublecheck in my order and click proceed to checkout.")
    public void confirminAndPressTheProceedButton() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickToButtonProceedToCheckOut();
    }

    @When("I Confirm address")
    public void confirmationAdresses() {
        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.confirmationAddress();
    }

    @When("I choose pick up method as PrestaShop \"pick up in store\"")
    public void openShippingMethodPage() {
        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.openShippingMethods();
        orderDetailsPage.choosePrestaShopShipping();
        orderDetailsPage.confirmChosenShipping();
    }

    @When("I choose payment method: Pay by Check")
    public void choosingPaymentMethod() {
        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.choosePreferredPaymentMethod();
        orderDetailsPage.acceptAgreementsOfShopTerms();
        orderDetailsPage.confirmPaymentMethod();

    }
    @Then("I make screen shot as confirmation of my order")
    public void makeScreenShoot() throws Exception {
        ScreenShotOrderConfirmationPage screenShotOrderConfirmationPage =new ScreenShotOrderConfirmationPage(driver);
        screenShotOrderConfirmationPage.takeSnapShot();

    }
}

