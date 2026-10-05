package pages;


import org.openqa.selenium.WebDriver;


import utilities.WaitUtils;

public class DealsPage extends BasePage {

	public DealsPage(WebDriver driver) {
		super(driver);
	}

	public boolean isDealsPageDisplayed() {

		WaitUtils.waitForUrlContains(driver, "deals");
		return getCurrentUrl().contains("deals");
	}

}