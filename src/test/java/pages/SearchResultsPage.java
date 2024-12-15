package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SearchResultsPage {
    private WebDriver driver;

    private By firstProduct = By.xpath("//div[contains(@class, 'KzDlHZ') and contains(text(), 'SAMSUNG Galaxy S24 Ultra 5G')]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstProduct() {
        driver.findElement(firstProduct).click();
    }
}
