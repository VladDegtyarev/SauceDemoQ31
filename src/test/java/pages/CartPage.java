package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
@Log4j2
public class CartPage extends BasePage{
    private final By REMOVE_ELEMENT= By.xpath("//*[text()='Remove']");
    private final By BUTTON_CHECKOUT= By.xpath("//*[@id='checkout']");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage setRemoveElement(){
        log.info("Click Remove button");
        driver.findElement(REMOVE_ELEMENT).click();
        return this;
    }

    public CheckoutPage buttonCheckout(){
        log.info("Click Checkout button");
        driver.findElement(BUTTON_CHECKOUT).click();
        return new CheckoutPage(driver);
    }

    public boolean isProductInCart(String product){
        return driver.findElement(By.xpath(String.format("//*[@class='cart_item']//*[text()='%s']",product))).isDisplayed();
    }

    public String getProductNameFromCart(int index){
        return driver.findElements(By.cssSelector(".inventory_item_name"))
                .get(index)
                .getText();
    }
    public ArrayList<String> getProductsName() {
        List<WebElement>allProductsElements=driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product:allProductsElements){
            names.add(product.getText());
        }
        return names;
    }

    public CartPage checkRemoveElement(String product){
        log.info("{} remove",product);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.format("//*[text()='%s']",product))));
        return this;
    }

}
