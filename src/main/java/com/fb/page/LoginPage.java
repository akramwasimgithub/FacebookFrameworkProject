package com.fb.page;

import com.fb.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    // declaration
    @FindBy(id = "email")
    WebElement username;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginButton;

    // initialization
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    public String verifyPageTitle() {
        return driver.getTitle();
    }

    public HomePage login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        return new HomePage();
    }
    public void loginMultipleAccounts(String userName2, String password2) {
        // TODO Auto-generated method stub
        username.sendKeys(userName2);
        password.sendKeys(password2);
        loginButton.click();

    }


    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
}