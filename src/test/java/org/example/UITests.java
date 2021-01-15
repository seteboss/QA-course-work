package org.example;

import org.example.pages.AccountPage;
import org.example.pages.LoginPage;
import org.example.util.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UITests {

    public static WebDriver webDriver;
    public static LoginPage loginPage;
    public static AccountPage accountPage;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        accountPage = new AccountPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void case1Login(){

        loginPage.inputLogin(ConfProperties.getProperty("login"));

        loginPage.inputPassword(ConfProperties.getProperty("password"));

        loginPage.clickCheckBox();

        loginPage.clickLoginBtn();

        String name = accountPage.getName();

        Assert.assertEquals(name, "sanek.7144241");


    }

    @AfterClass
    public static void tearDown() {
        accountPage.exit();
        webDriver.quit();
    }

}
