package com.fb.page;

import com.fb.base.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    FindFriendsPage findFriendsPage;
    GroupsPage groupsPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        homePage.verifyHomePageTitle();
    }

    @Test(priority = 2)
    public void verifyClickOnProfileTest() throws InterruptedException {
        homePage.clickOnProfile();
        Thread.sleep(50000);
    }

    @Test(priority = 3)
    public void verifyFriendsPageTest() {
        findFriendsPage= homePage.clickOnFriends();
    }

    @Test(priority = 4)
    public void verifySavedPageTest() {
        homePage.clickOnGroups();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}