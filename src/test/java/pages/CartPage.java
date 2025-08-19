package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    private final By REMOVE_ELEMENT= By.xpath("//*[text()='Remove']");
    private final By BUTTON_CHECKOUT= By.xpath("//*[@id='checkout']");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void setRemoveElement(){
        driver.findElement(REMOVE_ELEMENT).click();
    }

    public void buttonCheckout(){
        driver.findElement(BUTTON_CHECKOUT).click();
    }

    public boolean isProductInCart(String product){
        return driver.findElement(By.xpath(String.format("//*[@class='cart_item']//*[text()='%s']",product))).isDisplayed();
    }

    public String getProductNameFromCart(int index){
        return driver.findElements(By.cssSelector(".inventory_item_name"))
                .get(index)
                .getText();
    }
    public ArrayList<String>getProductsName() {
        List<WebElement>allProductsElements=driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product:allProductsElements){
            names.add(product.getText());
        }
        return names;
    }

}
