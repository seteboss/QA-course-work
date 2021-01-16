package org.example.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar {

    @FindBy(xpath = "//*[contains(@class, 'fas fa-user-circle')]")
    WebElement accountBtn;

    @FindBy(xpath = "//*[contains(@class, 'fas fa-shopping-cart')]")
    WebElement basketBtn;

    public void clickAccountBtn(){
        accountBtn.click();
    }

    public void clickBasketBtn(){
        basketBtn.click();
    }

}
