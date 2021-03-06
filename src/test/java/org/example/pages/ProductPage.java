package org.example.pages;

import org.example.element.NavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends NavBar {

    public WebDriver webDriver;

    public ProductPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }


    @FindBy(xpath = "//*[@id=\"product-40669\"]/div[2]/h1")
    WebElement productName;

    @FindBy(xpath = "//*[@id=\"product-40669\"]/div[2]/form/table/tbody/tr[2]/td[2]/ul/li[6]/span")
    WebElement productSize;

    @FindBy(xpath = "//*[@id=\"product-40669\"]/div[2]/form/div/div[2]/button")
    WebElement saveProductInBasket;

    public void clickProductSize(){
        productSize.click();
    }

    public void clickSaveProductInBasket(){
        saveProductInBasket.click();
    }

    public String getProductName(){
        return productName.getText();
    }


}
