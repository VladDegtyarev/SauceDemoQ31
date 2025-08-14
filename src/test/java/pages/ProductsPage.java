package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private final By TITLE = By.className("title");
    private final String ADD_TO_CART_PATTERN="//*[text()='Sauce Labs Backpack']/" +
            "ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }
    public void open(){
        driver.get(BASE_URL+"inventory.html");
    }

    public void addToCart(String product){
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN,product))).click();
    }
}
