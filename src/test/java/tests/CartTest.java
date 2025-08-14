package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{
    @Test
    public void checkCart(){
        driver.get("https://www.saucedemo.com/");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");;
        //driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();//
        productsPage.addToCart("Sauce Labs Backpack");

        WebElement nameThing= driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
        Assert.assertEquals(nameThing.getText(),"Sauce Labs Backpack");
        WebElement price = driver.findElement(By.xpath("//*[@class='inventory_item_price']"));
        Assert.assertEquals(price.getText(),"$29.99");

    }

}
