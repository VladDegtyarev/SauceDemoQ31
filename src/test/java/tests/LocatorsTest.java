package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsTest extends BaseTest {
    @Test
    public void checkLocators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.className("form_column"));
        driver.findElement(By.tagName("div"));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.linkText("Sauce Labs Bike Light"));
        driver.findElement(By.partialLinkText("Backpack"));
        //xPath
        driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        driver.findElement(By.xpath("//*[contains(text(), 'Jacket')]"));
        driver.findElement(By.xpath("//div[@id='root']/descendant::div[@class='inventory_item_label']"));
        driver.findElement(By.xpath("//div[@class='inventory_item_name ']" +
                "/following::div[@class='inventory_item_name ']"));
        driver.findElement(By.xpath("//*[@class='pricebar']" +
                "/parent::div[@class='inventory_item_description']"));
        driver.findElement(By.xpath("//*[@class='inventory_item'][3]" +
                "/preceding::*[@class='inventory_item'][1]"));
        driver.findElement(By.xpath("//button[text()='Add to cart'and" +
                "@id='add-to-cart-sauce-labs-backpack']"));
        //css
        driver.findElement(By.cssSelector(".inventory_item_price"));
        driver.findElement(By.cssSelector(".inventory_container .inventory_item_img"));
        driver.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory "));
        driver.findElement(By.cssSelector("#root"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("div.header_label"));
        driver.findElement(By.cssSelector("[data-test=inventory-container]"));
        driver.findElement(By.cssSelector("[|data-test|=inventory]"));
        driver.findElement(By.cssSelector("div[class^=inventory_item_price]"));
        driver.findElement(By.cssSelector("[class$=price]"));
        driver.findElement(By.cssSelector("[class*=item]"));
    }
}
