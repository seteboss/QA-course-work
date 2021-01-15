package org.example.pages;

import org.example.element.NavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage extends NavBar {

    public WebDriver webDriver;

    public CatalogPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }


    @FindBy(xpath = "//*[contains(@class, 'orderby')]")
    WebElement selectSortMenu;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/form/select/option[3]")
    WebElement ratingSort;

    @FindBy(xpath = "//*[@id=\"main\"]/ul/li[1]/a[1]/h2")
    WebElement productName;

    @FindBy(xpath = "//*[@id=\"main\"]/ul/li[1]/a[2]")
    WebElement productBtn;


    public void clickSortMenu(){
        selectSortMenu.click();
    }

    public void clickRatingSort(){
        ratingSort.click();
    }

    public void clickProductBtn(){
        productBtn.click();
    }

    public String getProductName(){
        return productName.getText();
    }

}
