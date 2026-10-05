package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.DealsPage;
import pages.DrinksPage;
import pages.HomePage;
import pages.SidesPage;
import utilities.DriverSetup;
import utilities.ExcelUtils;
import utilities.ExtentManager;
import utilities.ExtentTestManager;

public class PizzaHutTest {

	@BeforeSuite
	public void setup() {

		ExtentManager.getReport();

		String url = ExcelUtils.getCellData(1, 1);

		DriverSetup.launchBrowser(url);
	}

	@Parameters({ 
		"location",
        "name",
        "mobile",
        "email",
        "voucher",
        "deliveryAddress"
		}) 
	@Test
	public void test(String location, String name, String mobile, String email, String voucher, String deliveryAddress){
		
		
		ExtentTestManager.test = ExtentManager.extent.createTest("Pizza Hut Test - pizzahut001");
		
		HomePage homePage = new HomePage(DriverSetup.getDriver());
		
		homePage.enterLocation(location);
		ExtentTestManager.test.pass("Delivery location entered successfully");

		DealsPage dealsPage = new DealsPage(DriverSetup.getDriver());

		Assert.assertTrue(dealsPage.isDealsPageDisplayed());
		ExtentTestManager.test.pass("Deals page validated successfully");

		SidesPage sidesPage = new SidesPage(DriverSetup.getDriver());

		sidesPage.clickSidesTab();
		ExtentTestManager.test.pass("Navigated to Sides page");
		
		String sidePrice = sidesPage.getSideItemPrice();
		System.out.println("Side item price = " + sidePrice);
		double price = Double.parseDouble(sidePrice.replace("₹", "").trim());

		Assert.assertTrue(price < 200, "Side item should be below ₹200");
		ExtentTestManager.test.pass("Side item price validated: below ₹200");


		sidesPage.addSideItem();
		ExtentTestManager.test.pass("Side item added to Basket");

		Assert.assertTrue(sidesPage.isSideAddedToBasket());
		ExtentTestManager.test.pass("Side item validated in Basket");


		Assert.assertTrue(sidesPage.isCheckoutButtonDisplayed());
		ExtentTestManager.test.pass("Checkout button displayed");


		String checkoutText = sidesPage.getCheckoutButtonText();
		System.out.println("Sides Checkout Text = " + checkoutText);

		Assert.assertFalse(checkoutText.contains("₹"));
		ExtentTestManager.test.pass("Checkout button price is not displayed after adding side");

		DrinksPage drinksPage = new DrinksPage(DriverSetup.getDriver());

		drinksPage.clickDrinksTab();
		ExtentTestManager.test.pass("Navigated to Drinks page");

		drinksPage.addFirstDrink();
		ExtentTestManager.test.pass("First drink added to Basket");

		drinksPage.addSecondDrink();
		ExtentTestManager.test.pass("Second drink added to Basket");

		
		String cartPrice = drinksPage.getCartTotal();
		System.out.println("Cart total = " + cartPrice);
		double total = Double.parseDouble(cartPrice.replace("₹", "").trim());

		Assert.assertTrue(total > 200, "Cart total should be greater than ₹200");
		ExtentTestManager.test.pass("Cart total validated: greater than ₹200");

		drinksPage.clickCheckout();
		ExtentTestManager.test.pass("Checkout button clicked");

		CheckoutPage checkoutPage = new CheckoutPage(DriverSetup.getDriver());
		
		Assert.assertTrue(checkoutPage.isUpiPaymentSelected(),"UPI payment should be selected by default");
		ExtentTestManager.test.pass("UPI payment selected by default");

		Assert.assertTrue(checkoutPage.isCashPaymentDisabled(),"Cash payment should be disabled");
		ExtentTestManager.test.pass("Cash payment state validated");
		
		Assert.assertTrue(checkoutPage.isAgreeCheckboxSelected(),"I Agree checkbox should be checked by default");
		ExtentTestManager.test.pass("I Agree checkbox checked by default");

		checkoutPage.enterCustomerDetails(name, mobile, email);
		ExtentTestManager.test.pass("Customer name, mobile and email entered");

		checkoutPage.enterAddress(deliveryAddress);
		ExtentTestManager.test.pass("Delivery address entered");

		checkoutPage.clickApplyGiftCard();
		ExtentTestManager.test.pass("Apply Gift Card clicked");

		checkoutPage.clickVoucherOption();
		ExtentTestManager.test.pass("Voucher option selected");

		checkoutPage.enterVoucherCode(voucher);
		ExtentTestManager.test.pass("Voucher code entered");

		checkoutPage.submitVoucher();
		ExtentTestManager.test.pass("Voucher submitted");

		Assert.assertTrue(checkoutPage.isVoucherErrorDisplayed());
		ExtentTestManager.test.pass("Incorrect voucher error validated");

		System.out.println(checkoutPage.getVoucherErrorText());

		checkoutPage.closeVoucherPopup();
		ExtentTestManager.test.pass("Voucher popup closed");
		
		Assert.assertTrue(checkoutPage.isBasketPageDisplayed(),"User should be navigated back to Basket page");
		ExtentTestManager.test.pass("Basket page displayed successfully");

	}
	
	@AfterMethod
	public void testResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.test.fail(result.getThrowable());
		}
	}

	@AfterSuite
	public void teardown() {

		DriverSetup.closeBrowser();

		if (ExtentManager.extent != null) {
			ExtentManager.extent.flush();
		}
	}

}
