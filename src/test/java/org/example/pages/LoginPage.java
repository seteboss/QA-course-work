package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//*[contains(@id, 'username')]")
    WebElement loginField;

    @FindBy(xpath = "//*[contains(@id, 'password')]")
    WebElement passwordField;

    @FindBy(xpath = "//*[contains(@id,'rememberme')]")
    WebElement rememberCheckBoxId;

    @FindBy(xpath = "//*[contains(@class, 'woocommerce-button button woocommerce-form-login__submit')]")
    WebElement loginBtn;


    public void inputLogin(String login){
        loginField.sendKeys(login);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickCheckBox(){
        rememberCheckBoxId.click();
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }


}
