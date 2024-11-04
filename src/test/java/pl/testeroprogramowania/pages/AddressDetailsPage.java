package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.testeroprogramowania.models.Customer;

public class AddressDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement nameInput;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "billing_address_1")
    private WebElement addressInput;

    @FindBy(id = "billing_company")
    private WebElement companyNameInput;

    @FindBy(id = "billing_country")
    private WebElement countrySelect;

    @FindBy(id = "billing_postcode")
    private WebElement postcodeInput;

    @FindBy(id = "billing_city")
    private WebElement cityInut;

    @FindBy(id = "billing_email")
    private WebElement emailInput;

    @FindBy(id = "billing_phone")
    private WebElement phoneInput;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    @FindBy(id = "order_comments")
    private WebElement orderCommentsInput;

    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage fillAddressDetails(Customer customer, String comments) {
        nameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyNameInput.sendKeys(customer.getCompanyName());
        Select countryList = new Select(countrySelect);
        countryList.selectByVisibleText(customer.getCountryName());
        addressInput.sendKeys(String.format("%s %s", customer.getStreetAddress(), customer.getHouseNumber()));
        postcodeInput.sendKeys(customer.getPostcode());
        cityInut.sendKeys(customer.getCity());
        emailInput.sendKeys(customer.getEmail());
        phoneInput.sendKeys(customer.getPhoneNumber());
        orderCommentsInput.sendKeys(comments);
        placeOrderButton.click();
        return new OrderDetailsPage(driver);
    }
}
