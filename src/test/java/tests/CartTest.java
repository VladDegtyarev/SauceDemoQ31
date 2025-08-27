package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class CartTest extends BaseTest {
    @Test(testName = "Покупа товара",
            description = "Покупка товара",
            priority = 1)
    @Description("УПокупка товара")
    @Owner("Degtyarev Vlad")
    public void checkCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        assertEquals(cartPage.getProductNameFromCart(0),"Sauce Labs Backpack");
    }

    @Test(testName = "Удаление товара из корзины",
    description = "Удаление товара из корзины и проверка его удаления",
            priority = 2)
    @Description("Удаление товара из корзины и проверка его удаления")
    @Owner("Degtyarev Vlad")
    public void deleteProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        cartPage.setRemoveElement();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Sauce Labs Backpack']")));
    }
}