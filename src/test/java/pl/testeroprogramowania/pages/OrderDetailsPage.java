package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {

    @FindBy(xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")
    private WebElement orderNotice;

    public WebElement getProductName() {
        return productName;
    }

    @FindBy(xpath = "//td[contains(@class, 'product-name')]")
    private WebElement productName;

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public WebElement getOrderNotice() {
        return orderNotice;
    }
}
