package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitUtils;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Payment Section
    private By upiPaymentRadio = By.id("payment-method--razorpay/upi");
    private By cashPaymentRadio = By.cssSelector("input[id='payment-method--cash']");

    // Agreement Checkbox
    private By agreeCheckbox = By.id("marketingOptIn");

    // Customer Details
    private By nameField = By.cssSelector("input[name='name']");
    private By mobileField = By.cssSelector("input[name='phone']");
    private By emailField = By.cssSelector("input[name='email']");
    
    private By addressField = By.cssSelector("input[name='deliveryAddress.interior']");

    // Gift Card
    private By applyGiftCardLink = By.cssSelector("div.form-section button.w-full");
    private By voucherOption = By.xpath("//h2[contains(.,'Apply a Gift Card')]/following-sibling::div//span[text()='Coupon']");
    private By voucherCodeField = By.cssSelector("input[name='voucherId']");
    private By voucherSubmitButton = By.cssSelector("button[type='submit']");
    private By voucherErrorMessage = By.xpath("//form[@data-testid='voucher-form']//span[contains(.,'Sorry, we don’t currently support')]");
    private By closeVoucherPopup = By.xpath("//button[contains(text(),'Cancel')]");
    private By basketHeading = By.xpath("//span[contains(text(),'Your Basket')]");

    // --------------------------
    // Payment Methods
    // --------------------------

    public boolean isUpiPaymentSelected() {

        WebElement upi =
                WaitUtils.waitForPresence(driver, upiPaymentRadio);

        return upi.isSelected();
    }
    
    public boolean isCashPaymentDisabled() {

        WebElement cash =
                WaitUtils.waitForPresence(driver, cashPaymentRadio);

        return !cash.isEnabled();
    }
    
    // --------------------------
    // Agreement Checkbox
    // --------------------------

    public boolean isAgreeCheckboxSelected() {

        WebElement checkbox =
                WaitUtils.waitForPresence(driver, agreeCheckbox);

        return checkbox.isSelected();
    }
    
    // --------------------------
    // Customer Details
    // --------------------------

    public void enterCustomerDetails(String name, String mobile, String email) {

        WaitUtils.waitForVisibility(driver, nameField);
        type(nameField, name);

        WaitUtils.waitForVisibility(driver, mobileField);
        type(mobileField, mobile);

        WaitUtils.waitForVisibility(driver, emailField);
        type(emailField, email);
    }
    
   
    public void enterAddress(String deliveryAddress) {

        WaitUtils.waitForVisibility(driver, addressField);
        type(addressField, deliveryAddress);
    }


    // --------------------------
    // Gift Card
    // --------------------------

    public void clickApplyGiftCard() {

        WaitUtils.waitForClickable(driver, applyGiftCardLink);

        click(applyGiftCardLink);
    }

    public void clickVoucherOption() {

        WaitUtils.waitForClickable(driver, voucherOption);

        click(voucherOption);
    }

    public void enterVoucherCode(String voucherCode) {

        type(voucherCodeField, voucherCode);
    }

    public void submitVoucher() {

        WaitUtils.waitForClickable(driver, voucherSubmitButton);

        click(voucherSubmitButton);
    }

    public boolean isVoucherErrorDisplayed() {

        WaitUtils.waitForVisibility(driver, voucherErrorMessage);

        return isDisplayed(voucherErrorMessage);
    }

    public String getVoucherErrorText() {

        WaitUtils.waitForVisibility(driver, voucherErrorMessage);

        return getText(voucherErrorMessage);
    }

    public void closeVoucherPopup() {

        WaitUtils.waitForClickable(driver, closeVoucherPopup);

        click(closeVoucherPopup);
    }
    
    public boolean isBasketPageDisplayed() {
        WaitUtils.waitForVisibility(driver, basketHeading);
        return isDisplayed(basketHeading);
    }
    
    
}