package org.example.pages;

import org.example.element.NavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends NavBar {

    public WebDriver webDriver;

    public BasketPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//*[@id=\"post-7\"]/div/div/form/table/tbody/tr[1]/td[3]/a")
    WebElement fullProductName;

    @FindBy(xpath = "//*[@id=\"post-7\"]/div/div/form/table/tbody/tr[1]/td[1]/a")
    WebElement deleteProductBtn;

    public String getFullProductName(){
        return fullProductName.getText();
    }

    public void clickDeleteProductBtn(){
        deleteProductBtn.click();
    }


}
