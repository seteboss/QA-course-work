package org.example;

import org.example.pages.AccountPage;
import org.example.pages.CatalogPage;
import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.example.util.ConfProperties;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UITests {

    public static WebDriver webDriver;
    public static LoginPage loginPage;
    public static AccountPage accountPage;
    public static CatalogPage catalogPage;
    public static ProductPage productPage;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        accountPage = new AccountPage(webDriver);
        catalogPage = new CatalogPage(webDriver);
        productPage = new ProductPage(webDriver);
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

    @Test
    public void case2StepInCatalog(){
        webDriver.get(ConfProperties.getProperty("bmwcatalogpage"));
        catalogPage.clickSortMenu();
        catalogPage.clickRatingSort();
        String productName = catalogPage.getProductName();
        Assert.assertEquals(productName, "Кроссовки BMW MMS RS-2K");
    }

    @Test
    public void case3StepInProduct(){
        catalogPage.clickProductBtn();
        String productName = productPage.getProductName();
        Assert.assertEquals(productName, "Кроссовки BMW MMS RS-2K");
    }

    @AfterClass
    public static void tearDown() {
        productPage.clickAccountBtn();
        accountPage.exit();
        webDriver.quit();
    }

}
