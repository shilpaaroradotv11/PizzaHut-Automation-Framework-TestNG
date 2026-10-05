## Pizza Hut Automation Framework - TestNG

End-to-end web test automation framework for the Pizza Hut website using Selenium WebDriver, Java, TestNG, Maven, Page Object Model (POM), Excel-based test data, and Extent Reports.

## Technologies Used

- Java 21
- Selenium WebDriver 4.4.0
- TestNG 6.14.3
- Maven
- Page Object Model (POM)
- Apache POI
- Extent Reports
- WebDriverManager
- Git & GitHub

## Framework Features

- Page Object Model design
- TestNG-based test execution
- Parameterized test data using `testng.xml`
- Application URL read from Excel
- Excel-based test data handling using Apache POI
- Explicit waits for reliable element interaction
- Extent HTML reporting
- Maven test execution
- Reusable utility classes

## Project Structure

```text
PizzaHut-Automation-Framework-TestNG
│
├── pom.xml
├── testng.xml
│
└── src/test
    ├── java
    │   ├── pages
    │   │   ├── BasePage.java
    │   │   ├── HomePage.java
    │   │   ├── DealsPage.java
    │   │   ├── SidesPage.java
    │   │   ├── DrinksPage.java
    │   │   └── CheckoutPage.java
    │   │
    │   ├── tests
    │   │   └── PizzaHutTest.java
    │   │
    │   └── utilities
    │       ├── DriverSetup.java
    │       ├── ExcelUtils.java
    │       ├── ExtentManager.java
    │       ├── ExtentTestManager.java
    │       └── WaitUtils.java
    │
    └── resources
        └── testdata
            └── PizzaHutData.xlsx
            
 ```
 

## Test Flow

The automation covers the following end-to-end scenarios:

1. Launch the Pizza Hut application.
2. Set the delivery location.
3. Validate the Deals page URL.
4. Navigate to Sides.
5. Retrieve the price of a side item.
6. Validate that the side item price is below ₹200.
7. Add the side item to the Basket.
8. Validate that the side item is added to the Basket.
9. Validate that the Checkout button does not display the item price.
10. Navigate to Drinks and add two drinks.
11. Validate that the total cart price is greater than ₹200.
12. Click the Checkout button and navigate to the Checkout page.
13. Validate that Online Payment is selected by default.
14. Validate the Cash payment state.
15. Validate that the I Agree checkbox is checked by default.
16. Enter customer name, mobile number, and email address.
17. Enter the delivery address.
18. Click Apply Gift Card and select Coupon.
19. Enter coupon code and submit.
20. Validate the incorrect voucher error message.
21. Close the voucher popup.
22. Validate navigation back to the Basket.

## Test Data

Test data is parameterized through `testng.xml`.

The application URL is read from:

```text
src/test/resources/testdata/PizzaHutData.xlsx
```

## Execution

### Maven

Run the complete test suite using:

```text
mvn clean test
```

### Eclipse

The test suite can also be executed through:

```text
Run As → TestNG Suite
```

### Reporting

Extent Reports are generated at:

```text
test-output/ExtentReport.html
```

The report provides PASS/FAIL status for the executed test steps.

### Author

Shilpa Arora