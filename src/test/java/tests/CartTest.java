package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {
    @Test(testName = "Покупа товара",
            description = "Покупка товара",
            priority = 1)
    public void checkCart() {
        driver.get("https://www.saucedemo.com/");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        WebElement nameThing = driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
        assertEquals(nameThing.getText(), "Sauce Labs Backpack");
        WebElement price = driver.findElement(By.xpath("//*[@class='inventory_item_price']"));
        assertEquals(price.getText(), "$29.99");
    }

    @Test(testName = "Удаление товара из корзины",
    description = "Удаление товара из корзины и проверка его удаления",
            priority = 2)
    public void deleteProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        cartPage.setRemoveElement();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Sauce Labs Backpack']")));
    }
}