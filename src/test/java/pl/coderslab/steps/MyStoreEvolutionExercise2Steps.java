package pl.coderslab.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MyStoreEvolutionExercise2Steps {
    private String orderReference;
    private String valueOfProducts;
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
        loginInShopPage loginInShopPage = new loginInShopPage(driver);
        loginInShopPage.goToSignInPage();
    }

    @When("^I login in my-store-testlab.coderslab.pl with email:(.*) and password: (.*)$")
    public void enterloginDetailTOpenPage(String email, String password) {
        loginInShopPage loginInShopPage = new loginInShopPage(driver);
        loginInShopPage.insertDataToLogin(email, password);
        loginInShopPage.confirmEmailAndPassword();
    }

    @When("I go back to main page")
    public void goBackToMainPage() {
        loginInShopPage loginInShopPage = new loginInShopPage(driver);
        loginInShopPage.clickToGoBackToMAinPage();
    }

    @When("^I search the product: (.*)$")
    public void searchTheProductToBuy(String productName) {
        loginInShopPage loginInShopPage = new loginInShopPage(driver);
        loginInShopPage.findTheProduct(productName);
    }

    @When("I choose my product from results")
    public void chooseAndClickInProductFromSearchResult() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openWebsiteOfProduct();
    }

    @Then("I check that product is discounted about 20%")

    public void checkDiscountIs20() {
        ProductPage productPage = new ProductPage(driver);
        /**
         * wyniki wszystkich 4 metod:
         *
         * productPage.convertedPrimaryPrice();
         * productPage.convertedCurrentPrice();
         *
         * productPage.checkingPercentageOfPrice();
         * productPage.findThePercentageOfDiscount();
         *
         * nie są nigdzie zapisywane ani używane - czy ich wywołania tutaj są potrzebne?
         */
        productPage.convertedPrimaryPrice(); // Szukam ceny regularnej i przetwarzam do doubla
        productPage.convertCurrentPrice(); // szukam ceny obecnej i przetwarzam do doubla

        productPage.calculatingPercentageOfPrice();  //obliczam procent obnizki produktu, dzielac cene obecna przez regularna
        productPage.findThePercentageOfDiscount(); // znajduje ilosc procentow wyswietlona na  stroniei konwertuje do porownania

        Assert.assertEquals(0, productPage.findThePercentageOfDiscount().compareTo(productPage.calculatingPercentageOfPrice()));
    }


    @When("^I choose the size: (.*) and quantity which is equal (.*) of product and I add to cart$")
    public void addingTheProductToCart(String size, String numberOfProducts) {
        ProductPage productPage = new ProductPage(driver);
        productPage.chooseYourSize(size);
        productPage.choosePreferredQuantity(numberOfProducts);
        productPage.buttonAddChosenProductToCart();
    }

    @When("I am proceed to checkout")
    public void pressButtonToCheckOut() {
        SheetWithSuccessfulAddPage sheetWithSuccessfulAddPage = new SheetWithSuccessfulAddPage(driver);
        sheetWithSuccessfulAddPage.goToCheckOut();

    }

    @And("I make doublecheck in my order and click proceed to checkout.")
    public void confirmInAndPressTheProceedButton() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickToButtonProceedToCheckOut();
    }

    @When("I Confirm address")
    public void confirmationAddresses() {
        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.confirmAddress();
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
        orderDetailsPage.orderSubmission();

    }

    @Then("I make screen shot as confirmation of my order")
    public void makeScreenShoot() throws Exception {
        ScreenShotOrderConfirmationPage screenShotOrderConfirmationPage = new ScreenShotOrderConfirmationPage(driver);
        screenShotOrderConfirmationPage.takeSnapShot();

        orderReference = screenShotOrderConfirmationPage.getOrderReferenceNumber();
        valueOfProducts = screenShotOrderConfirmationPage.getPriceOfProduct();
    }

    @And("I go back to main user Page")

    public void goToMainPageOfUser() {
        ScreenShotOrderConfirmationPage screenShotOrderConfirmationPage = new ScreenShotOrderConfirmationPage(driver);
        screenShotOrderConfirmationPage.backToUserMainPage();
    }

    @And("I go to tiles with my details of my order and history of my orders.")
    public void openHistoryAndOrderTiles() {
        AddNewAddressPage addNewAddressPage = new AddNewAddressPage(driver);
        addNewAddressPage.clickInOrderHistoryTile();
    }

    @Then("I check that My order is here")
    public void checkAvailableOrderData() {
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);

        //******I need check reference name***********

        WebElement orderReferenceName = orderHistoryPage.findOrderDetails(orderReference);

        Assert.assertNotNull(orderReferenceName);
        String orderReferenceRowText = orderReferenceName.getText();

        System.out.println("Order reference text: "+ orderReferenceRowText);


        String[] splitOrderReferenceRowText = orderReferenceRowText.split(" ");
        System.out.println("Split reference text: "+ Arrays.toString(splitOrderReferenceRowText));

        Assert.assertEquals(orderReference, splitOrderReferenceRowText[0]);
        System.out.println("The new order reference which I can find in order history is the same as in order details page. ");

        //******I need check value of order *********

        Assert.assertEquals(valueOfProducts, splitOrderReferenceRowText[2]);
        // System.out.println(splitOrderReferenceRowText [2]);
        System.out.println(" The value of order is correct");

    }
}


