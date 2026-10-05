package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtils;

public class SidesPage extends BasePage {

	public SidesPage(WebDriver driver) {
		super(driver);
	}

	By sidesTab = By.cssSelector("a.side-menu__link--sides");

	By classicBreadStix = By.xpath("//div[contains(@class,'list-item__name') and contains(text(),'Classic Bread Stix')]");

	By addButton = By.xpath(
			"//div[contains(@class,'list-item__name') and contains(text(),'Classic Bread Stix')]/ancestor::a//button");

	By sideItemPrice = By.xpath(
		    "//div[contains(@class,'list-item__name') and contains(text(),'Classic Bread Stix')]/ancestor::a//button//span[contains(text(),'₹')]");
	
	By basketItem_side = By
			.xpath("//div[@data-synth='basket-item-type--side' and contains (text(),'Classic Bread Stix')]");

	By checkoutButton = By.cssSelector("div.basket-checkout button");

			
	public void clickSidesTab() {

	    WaitUtils.waitForVisibility(driver, sidesTab);

	    click(sidesTab);
	}	

	public void addSideItem() {

		WaitUtils.waitForClickable(driver, addButton);

		click(addButton);
	}
	
	public String getSideItemPrice() {
	    WaitUtils.waitForVisibility(driver, sideItemPrice);
	    return getText(sideItemPrice);
	}

	public boolean isSideAddedToBasket() {

		WaitUtils.waitForVisibility(driver, basketItem_side);

		return isDisplayed(basketItem_side);
	}

	public boolean isCheckoutButtonDisplayed() {

		WaitUtils.waitForVisibility(driver, checkoutButton);

		return isDisplayed(checkoutButton);
	}

	public String getCheckoutButtonText() {

		WaitUtils.waitForVisibility(driver, checkoutButton);

		return getText(checkoutButton);
	}
}