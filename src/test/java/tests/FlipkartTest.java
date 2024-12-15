package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseTest;
import pages.LoginPage;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.CartPage;

public class FlipkartTest extends BaseTest {
    @BeforeMethod
    public void setupTest() {
        setup();
    }

    @AfterMethod
    public void teardownTest() {
        teardown();
    }

    @Test
    public void testEndToEndFlow() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.handleLoginPopup();
        homePage.searchProduct("SAMSUNG Galaxy S24 Ultra 5G");
        searchResultsPage.selectFirstProduct();

        // Switch to new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        cartPage.addToCart();
    }
}
