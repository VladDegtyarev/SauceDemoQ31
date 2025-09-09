package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class CheckoutPage extends BasePage {
    private final By FIRST_NAME= By.xpath("//*[@id='first-name']");
    private final By LAST_NAME= By.xpath("//*[@id='last-name']");
    private final By ZIP_CODE= By.xpath("//*[@id='postal-code']");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By ERROR_MESSAGE_CHECKOUT = By.xpath("//*[@class='error-message-container error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Вход в заказа товара  с именем :" +
            "'{firstName}' и фамилией : '{lastName}' и почтовым индексом:'{zipCod}'")
    public CheckoutPage YourInformation(String firstName,String lastName,String zipCode){
        log.info("Login to order product with name : {} and last name: {} and Zip code:{}",
                firstName,lastName,zipCode);
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    public String getErrorMessageCheckout() {
        return driver.findElement(ERROR_MESSAGE_CHECKOUT).getText();
    }
}
