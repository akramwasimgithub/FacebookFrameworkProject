package com.fb.page;

import com.fb.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(xpath = "//span[contains(text(),'Raj Chavan')]")
    WebElement userProfile;

    @FindBy(xpath = "//span[contains(text(),'Friends')]")
    WebElement findFriend;

    @FindBy(xpath = "//span[contains(text(),'Saved')]")
    WebElement savedLink;

    @FindBy(xpath = "//span[contains(text(),'Groups')]")
    WebElement groups;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public String verifyHomePagePageTitle() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public ProfilePage clickOnProfile() {
        userProfile.click();
        return new ProfilePage();
    }

    public FindFriendsPage clickOnFriends() {
        findFriend.click();
        return new FindFriendsPage();
    }

    public GroupsPage clickOnGroups() {
        groups.click();
        return new GroupsPage();
    }

}
