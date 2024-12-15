package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CartPage {
    private WebDriver driver;

    private By addToCartButton = By.xpath("//button[@class=\"QqFHMw vslbG+ In9uk2\"]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
}
