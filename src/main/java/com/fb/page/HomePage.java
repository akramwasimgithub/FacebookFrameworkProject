package com.fb.page;

import com.fb.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(xpath = "//span[contains(text(),'Raj Chavan')]")
    WebElement userProfileLink;

    @FindBy(xpath = "//span[contains(text(),'Friends')]")
    WebElement friendsLink;

    @FindBy(xpath = "//span[contains(text(),'Saved')]")
    WebElement savedLink;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public ProfilePage clickOnProfile() {
        userProfileLink.click();
        return new ProfilePage();
    }


}
