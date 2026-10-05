package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utilities.WaitUtils;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {

		super(driver);

	}

	private By locationPopup = By.xpath("//input[contains(@placeholder,'location')]");

	By deliveryAddressText = By.xpath("//*[contains(text(),'Ordering for')]");

	public boolean isLocationPopupDisplayed() {

		WaitUtils.waitForVisibility(driver, locationPopup);

		return isDisplayed(locationPopup);
	}

	public void enterLocation(String location) {

		type(locationPopup, location);

		Actions actions = new Actions(driver);
		
		// Autocomplete suggestions take time to render

		actions.pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
	}

	public boolean isDeliveryAddressDisplayed() {

		WaitUtils.waitForVisibility(driver, deliveryAddressText);

		return isDisplayed(deliveryAddressText);
	}
}
