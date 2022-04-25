package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductPage {
    private WebDriver driver;


    @FindBy(id = "group_1")
    private WebElement sizeOfProduct;

    @FindBy(name = "qty")
    private WebElement quantityOfProduct;

    @FindBy(css = "[data-button-action='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(className = "regular-price")
    private WebElement regularPrice;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[1]")
    private WebElement currentPrice;

    @FindBy (className = "discount-percentage")
    private WebElement discountPrecentage;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseYourSize(String size) {
        sizeOfProduct.click();
        sizeOfProduct.sendKeys(size);
        sizeOfProduct.sendKeys(Keys.ENTER);
    }

     public void choosePreferredQuantity(String numberOfProducts) {

//        quantityOfProduct.clear();
        quantityOfProduct.sendKeys(Keys.BACK_SPACE);
        WebElement enterQuantityAgain = driver.findElement(By.name("qty"));
        enterQuantityAgain.sendKeys(numberOfProducts);
        //       quantityOfProduct.sendKeys(Keys.ENTER);

    }

    public void buttonAddChosenProductToCart() {
        addToCartButton.click();
    }


    public double convertedPrimaryPrice() {  // Pobieram pierwotna cene i usuwam znak euro
        String primaryPrice = regularPrice.getText().replace("€","");
        // prezksztalcam na double zebym miala liczbe z dwoma miejscami po przecinku
        double regularPriceInConvert = Double.parseDouble(primaryPrice);
        return regularPriceInConvert;

    }



    public double convertCurrentPrice() {   //wyciagam i konwertuje obecna cene
        String priceAfterDiscount = currentPrice.getText().replace("€","");
       // System.out.println(priceAfterDiscount);
        double convertedCurrentPrice = Double.parseDouble(priceAfterDiscount);
         return  convertedCurrentPrice;
    }



    public BigDecimal calculatingPercentageOfPrice(){ // obliczam procent obnizki produktu, dzielac cene obecna przez regularna
        Double percentOfDiscount = convertCurrentPrice()/convertedPrimaryPrice();
        Double finalPercent = (1- percentOfDiscount);
        //System.out.println(finalPercent);

        BigDecimal prc = new BigDecimal( finalPercent).setScale(2,RoundingMode.HALF_UP);
        return prc;

    }
    public BigDecimal findThePercentageOfDiscount(){ // znajduje ilosc procentow wyswietlona na  stroniei konwertuje do porownania
        String percentOfDiscount = discountPrecentage.getText().replaceAll("[^0-9]","");
        BigDecimal convertedPercentOfDiscount =  new BigDecimal(percentOfDiscount);
        BigDecimal findThePercentage = convertedPercentOfDiscount.divide(new BigDecimal( 100));
        return (findThePercentage);
    }


}
