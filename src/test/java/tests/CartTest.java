package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{
    @Test
    public void checkCart(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
        WebElement nameThing= driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
        Assert.assertEquals(nameThing.getText(),"Sauce Labs Backpack");
        WebElement price = driver.findElement(By.xpath("//*[@class='inventory_item_price']"));
        Assert.assertEquals(price.getText(),"$29.99");
    }

}
