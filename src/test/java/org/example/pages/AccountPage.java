package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    public WebDriver webDriver;

    public AccountPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/div/p[1]/strong[1]")
    WebElement nameField;

//    @FindBy(xpath = "//*[@id=\"mega-menu-item-51\"]/a")

    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/div/p[1]/a")
    WebElement exitRef;

    public String getName(){
        return nameField.getText();
    }

    public void exit(){
        exitRef.click();
    }

}
