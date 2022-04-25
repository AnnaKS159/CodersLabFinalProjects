package pl.coderslab.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.AddNewAddressPage;
import pl.coderslab.pages.AddressesPage;
import pl.coderslab.pages.loginInShopPage;

import java.util.concurrent.TimeUnit;

public class MyStoreExercise1Steps {
    private WebDriver driver;
    private AddNewAddressPage addNewAddressEx1Page;

    @Given("I am login in my-store-testlab.coderslab.pl")
    public void loginUser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl.");
        addNewAddressEx1Page = new AddNewAddressPage(driver);

    }

    @When("I click in SignIn Button")
    public void clickInSignInButtonOnMainPage() {
        loginInShopPage loginInShopPage = new loginInShopPage(driver);
        loginInShopPage.goToSignInPage();
    }

    @When("^I am login in my-store-testlab.coderslab.pl with email:(.*) and password: (.*)$")

    public void enterLoginDetailTOpenPage(String email, String password) {
        loginInShopPage loginInShopPage = new loginInShopPage(driver);
        loginInShopPage.insertDataToLogin(email, password);
        loginInShopPage.confirmEmailAndPassword();
    }

    @When("I click in Addresses button.")
    public void clickAddressesTile() {
        addNewAddressEx1Page.chooseAndClickAddresses();

    }

    @When("I choose the option to create new address.")
    public void clickInButtonCreateNewAddress() {
        addNewAddressEx1Page.clickInButtonToCreateNewAddress();

    }

    @When("^I create new address with alias:(.*), address:(.*), city:(.*), zip code:(.*), phone number:(.*)$")
    public void fillAddressForm(String alias, String address, String city, String zipCode, String phoneNumber) {
        addNewAddressEx1Page.transmitAlias(alias);
        addNewAddressEx1Page.enterAddress(address);
        addNewAddressEx1Page.enterCity(city);
        addNewAddressEx1Page.enterZipCode(zipCode);
        addNewAddressEx1Page.enterPhoneNumber(phoneNumber);
    }

    @When("I save the data")
    public void saveEnteredData() {
        addNewAddressEx1Page.saveImplementedData();

    }


    @Then("^I see the address with alias:(.*), address:(.*), city:(.*), zip code:(.*), phone number:(.*)$")
    public void checkCorrectness(String alias, String address, String city, String zipCode, String phoneNumber) {
        AddressesPage addressesPage = new AddressesPage(driver);

        WebElement addressWithAlias = addressesPage.findAddressWithAlias(alias);

        Assert.assertNotNull(addressWithAlias);
        String addressText = addressWithAlias.getText();
        String[] splittedAddresses = addressText.split("\\n");
//        System.out.println(Arrays.toString(splittedAddresses));
        Assert.assertEquals(alias, splittedAddresses[0]);
        Assert.assertEquals(address, splittedAddresses[2]);
        Assert.assertEquals(city, splittedAddresses[3]);
        Assert.assertEquals(zipCode, splittedAddresses[4]);
        Assert.assertEquals(phoneNumber, splittedAddresses[6]);

    }

    @And("^I delete my inserted data with alias (.*)$")
    public void deletedMyData(String alias) throws InterruptedException {
        Thread.sleep(2000);
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.deleteAddressWithAlias(alias);
        Assert.assertNull(addressesPage.findAddressWithAlias(alias));
    }


}
