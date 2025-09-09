package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CartTest extends BaseTest {
    @Test(testName = "Покупа товара",
            description = "Покупка товара",
            priority = 1)
    @Description("Покупка товара")
    @Owner("Degtyarev Vlad")
    public void checkCart() {
        loginPage.open()
                        .login(user, password)
                                .addToCart("Sauce Labs Backpack")
                                        .openShoppingCart();
        assertEquals(cartPage.getProductNameFromCart(0),"Sauce Labs Backpack");

        /*loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        assertEquals(cartPage.getProductNameFromCart(0),"Sauce Labs Backpack");*/
    }

    @Test(testName = "Удаление товара из корзины",
    description = "Удаление товара из корзины и проверка его удаления",
            priority = 2)
    @Description("Удаление товара из корзины и проверка его удаления")
    @Owner("Degtyarev Vlad")
    public void deleteProduct() {
        loginPage.open()
                .login(user, password)
                .addToCart("Sauce Labs Backpack")
                .openShoppingCart()
                .setRemoveElement()
                .checkRemoveElement("Sauce Labs Backpack");

        /*loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        cartPage.setRemoveElement();
        cartPage.checkRemoveElement("Sauce Labs Backpack");*/
    }
}