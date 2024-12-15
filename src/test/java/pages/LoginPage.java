package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private By loginPopup = By.xpath("//a[@class='_1jKL3b' and contains(@href, '/account/login')]"); // Locator for login popup
    private By searchBox = By.name("q");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to handle the login popup
    public void handleLoginPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait for the login popup to appear
            WebElement popupElement = wait.until(ExpectedConditions.presenceOfElementLocated(loginPopup));
            System.out.println("Login popup is visible.");

            // If desired, click on the popup to proceed to the login page
            popupElement.click();
            System.out.println("Clicked on the login popup to navigate to the login page.");
        } catch (TimeoutException e) {
            System.out.println("Login popup did not appear or was already hidden: " + e.getMessage());
        }
    }

    // Method to check if the search box is displayed
    public boolean isSearchBoxDisplayed() {
        try {
            return driver.findElement(searchBox).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Search box is not displayed: " + e.getMessage());
            return false;
        }
    }
}