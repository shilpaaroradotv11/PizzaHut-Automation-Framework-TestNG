package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtils;

public class DrinksPage extends BasePage {

	public DrinksPage(WebDriver driver) {
		super(driver);
	}

	private By drinksTab = By.cssSelector("a.side-menu__link--drinks");

	private By firstDrinkAddButton = By.cssSelector("button[data-synth*='pepsi-600ml']");

	private By secondDrinkAddButton = By.cssSelector("a[data-synth*='lemon-mint-mojito'] button");

	private By checkoutButton = By.xpath("//a[contains(@class,'button--primary') and .//span[contains(text(),'Checkout')]]");
	
	private By cartTotal = By.cssSelector("a[data-synth='link--checkout'] span.ml-auto span[data-synth='basket-value']");

	public void clickDrinksTab() {

		WaitUtils.waitForVisibility(driver, drinksTab);

		click(drinksTab);
	}

	public void addFirstDrink() {

		WaitUtils.waitForClickable(driver, firstDrinkAddButton);

		click(firstDrinkAddButton);
	}

	public void addSecondDrink() {

		WaitUtils.waitForClickable(driver, secondDrinkAddButton);

		click(secondDrinkAddButton);
	}

	public boolean isCheckoutButtonDisplayed() {

		WaitUtils.waitForVisibility(driver, checkoutButton);

		return isDisplayed(checkoutButton);
	}

	public String getCheckoutButtonText() {

		WaitUtils.waitForVisibility(driver, checkoutButton);

		return getText(checkoutButton);
	}

	public String getCartTotal() {

		WaitUtils.waitForVisibility(driver, cartTotal);

		return getText(cartTotal);
	}

	public void clickCheckout() {

		WaitUtils.waitForClickable(driver, checkoutButton);

		click(checkoutButton);
	}
}