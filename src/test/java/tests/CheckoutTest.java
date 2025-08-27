package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {
    @Test(testName = "Авторизация в Your Information позитивными данными",
            description = "Авторизация в Your Information позитивными данными",
            priority = 1)
    @Description("Авторизация в Your Information позитивными данными")
    @Owner("Degtyarev Vlad")
    public void checkCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        cartPage.buttonCheckout();
        checkoutPage.YourInformation("test", "test", "511611");
        WebElement element = driver.findElement(By.xpath("//*[@class='summary_total_label']"));
        assertEquals(element.getText(), "Total: $32.39",
                "Авторизация не выполнена");
    }

    @Test(testName = "Авторизация в Your Information с пустыи именем",
            description = "Авторизация в Your Information с пустыи именем",
            priority = 2)
    @Description("Авторизация в Your Information с пустыи именем")
    @Owner("Degtyarev Vlad")
    public void checkCheckoutWithEmptyFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        cartPage.buttonCheckout();
        checkoutPage.YourInformation("", "test", "511611");
        assertEquals(checkoutPage.getErrorMessageCheckout(), "Error: First Name is required",
                "Сообщение об ошибке не соответствует");
    }

    @Test(testName = "Авторизация в Your Information с пустыи порлем",
            description = "Авторизация в Your Information с пустыи порлем",
            priority = 3)
    @Description("Авторизация в Your Information с пустыи порлем")
    @Owner("Degtyarev Vlad")
    public void checkCheckoutWithEmptyLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        cartPage.buttonCheckout();
        checkoutPage.YourInformation("test", "", "511611");
        assertEquals(checkoutPage.getErrorMessageCheckout(), "Error: Last Name is required",
                "Сообщение об ошибке не соответствует");
    }

    @Test(testName = "Авторизация в Your Information с пустыи почтовым индексом",
            description = "Авторизация в Your Information с пустыи почтовым индексом",
            priority = 4)
    @Description("Авторизация в Your Information с пустыи почтовым индексом")
    @Owner("Degtyarev Vlad")
    public void checkCheckoutWithEmptyZipCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        cartPage.buttonCheckout();
        checkoutPage.YourInformation("test", "test", "");
        assertEquals(checkoutPage.getErrorMessageCheckout(), "Error: Postal Code is required",
                "Сообщение об ошибке не соответствует");
    }
}
