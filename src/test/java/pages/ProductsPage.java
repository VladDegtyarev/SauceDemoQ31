package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
@Log4j2
public class ProductsPage extends BasePage {
    private final By TITLE = By.className("title");
    private final By SHOPPING_CART_BUTTON = By.xpath("//*[@class ='shopping_cart_link']");
    private final By PRODUCT_SORT_CONTAINER=By.xpath("//select[@class='product_sort_container']");
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

    public void productElement(String index){
        WebElement pice = driver.findElement(By.xpath(String.format("//*[@class='inventory_item'][%s]" +
                "/descendant::*[@class='inventory_item_price']",index)));
    }

    @Step("Добавления товара с именм'{product}' в корзину")
    public ProductsPage addToCart(String product){
        log.info("Adding product {} to cart",product);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN,product))).click();
        return this;
    }

    @Step("Нажатие на иконку Корзина")
    public CartPage openShoppingCart(){
        log.info("Click button Shopping Cart");
        driver.findElement(SHOPPING_CART_BUTTON).click();
        return new CartPage(driver);
    }

    @Step("Откртие Drop Down")
    public ProductsPage openDropDown(int option){
        log.info("Select Drop Down");
        WebElement dropDown = driver.findElement(PRODUCT_SORT_CONTAINER);
        Select select = new Select(dropDown);
        List<WebElement> options = select.getOptions();
        options.get(option).click();
        return this;
    }

    }
