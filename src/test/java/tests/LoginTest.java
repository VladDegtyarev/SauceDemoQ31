package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest {

    @Test(testName = "Проверка входа в магазин с позитивными даннами",
            description = "Проверка входа в магазин с позитивными даннами",
            priority = 3)
    @Description("Проверка входа в магазин с позитивными даннами")
    @Owner("Degtyarev Vlad")
    @Link("")
    @Epic("SauceDemo login page")
    @Feature("Login  in")
    @Story("Login in with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("I am")
    @TmsLink("Sd-01")
    @Issue("Sd_1/1")
    public void checkPositiveLogin() {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test(testName = "Проверка входа в магазин с пустым поролем",
            description ="Проверка входа в магазин с пустым поролем" ,
            priority = 2)
    @Description("Проверка входа в магазин с пустым поролем")
    @Owner("Degtyarev Vlad")
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не соответсвует");
    }

    @Test(testName = "Проверка входа в магазин с пустым именем",
            description ="Проверка входа в магазин с пустым именем" ,
            priority = 3)
    @Description("Проверка входа в магазин с пустым именем")
    @Owner("Degtyarev Vlad")
    public void checkLoginWithEmptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не соответствует");
    }

    @Test(testName = "Проверка входа в магазин с негативными даннами",
    description ="Проверка входа в магазин с негативными даннами",
            priority = 4)
    @Description("Проверка входа в магазин с негативными даннами")
    @Owner("Degtyarev Vlad")
    public void checkLoginWithNegativeCred() {
        loginPage.open();
        loginPage.login("test", "test");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не соответствует");
    }
    @DataProvider(name = "Проверка логина с негативными данными")
    public Object[][] loginData() {
        return new Object[][] {
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }
    @Test(dataProvider = "Проверка логина с негативными данными")
    public void paramNegativeTest(String user,String password,String expectedErrorMessage){
        loginPage.open();
        loginPage.login(user,password);
        assertEquals(loginPage.getErrorMessage(),expectedErrorMessage,"Сообщение об ошибки не соответсвует");

    }
}

