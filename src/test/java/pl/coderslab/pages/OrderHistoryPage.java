package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class OrderHistoryPage {
    private WebDriver driver;


    @FindBy(xpath = "//*[@id='content']/table/tbody/tr[1]")
    private List<WebElement> orderDetails;


    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement findOrderDetails(String orderReference){
        for (WebElement orderReferenceNumber : orderDetails){
            if(doesRowHaveOrderReference(orderReferenceNumber,orderReference)){
                return orderReferenceNumber;
            }
        }
        return null;
    }

    public boolean doesRowHaveOrderReference(WebElement orderDetails, String orderReferenceUniqueName){
        WebElement orderReferenceElement=orderDetails.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]"));
        System.out.println("----->"+orderReferenceElement.getText());
        String [] splittedOrderReferenceElement = orderReferenceElement.getText().split(" ");
        String orderReference = splittedOrderReferenceElement [0];
       // System.out.println(orderReference);
        //System.out.println(orderReferenceUniqueName);

        return orderReference.equals(orderReferenceUniqueName);
    }





}
