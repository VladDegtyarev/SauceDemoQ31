package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    private final By SHOPPING_CART_BUTTON = By.xpath("//*[@class ='shopping_cart_link']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openShoppingCart(){
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }
}
