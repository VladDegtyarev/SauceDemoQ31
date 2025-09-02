package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test(testName = "Проверка сортировкаи low to high",
    description = "Проверка сортировки по стоимости low to high",
            priority = 1)
    @Description("Проверка сортировки по стоимости low to high")
    @Owner("Degtyarev Vlad")
    public void checkDropDownPriceLow() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openDropDown(2);
        WebElement item = driver.findElement(By.xpath("//*[@class='inventory_item'][1]" +
                "/descendant::*[@class='inventory_item_price']"));
        assertEquals(item.getText(), "$7.99",
                "Цена не соответствует");
    }

    @Test(testName = "Проверка сортировкаи high to low",
            description = "Проверка сортировки по стоимости  high to low",
            priority = 2)
    @Description("Проверка сортировки по стоимости  high to low")
    @Owner("Degtyarev Vlad")
    public void checkDropDownPriceHigh() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openDropDown(3);
        WebElement item = driver.findElement(By.xpath("//*[@class='inventory_item'][1]" +
                "/descendant::*[@class='inventory_item_price']"));
        assertEquals(item.getText(), "$49.99",
                "Цена не соответствует");
    }

    @Test(testName = "Проверка сортировкаи ZtoA",
            description = "Проверка сортировки по имени  ZtoA",
            priority = 4)
    @Description("Проверка сортировки по имени  ZtoA")
    @Owner("Degtyarev Vlad")
    public void checkDropDownNameZtoA() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openDropDown(1);
        WebElement item = driver.findElement(By.xpath("//*[@class='inventory_item'][1]" +
                "/descendant::*[@class='inventory_item_name ']"));
        assertEquals(item.getText(), "Test.allTheThings() T-Shirt (Red)",
                "Название не соответствует");
    }

    @Test(testName = "Проверка сортировкаи AtoZ",
            description = "Проверка сортировки по имени  AtoZ",
            priority = 3)
    @Description("Проверка сортировки по имени  AtoZ")
    @Owner("Degtyarev Vlad")
    public void checkDropDownNameAtoZ() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openDropDown(0);
        WebElement item = driver.findElement(By.xpath("//*[@class='inventory_item'][1]" +
                "/descendant::*[@class='inventory_item_name ']"));
        assertEquals(item.getText(), "Sauce Labs Backpack",
                "Название не соответствует");
    }
}