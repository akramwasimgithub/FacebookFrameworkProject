package com.fb.page;

import com.fb.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupsPageTest extends BaseClass {

    LoginPage loginPage;
    HomePage homepage;
    GroupsPage groupsPage;
    DiscoverPage discoverPage;

    public GroupsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homepage = new HomePage();
        homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        groupsPage = homepage.clickOnGroups();
        discoverPage = groupsPage.clickOnDiscover();
    }

    @Test(priority = 1)
    public void verifyDiscoverPageTitleTest() {
        String groupsPageTitle = groupsPage.verifyGroupsPageTitle();
        Assert.assertEquals(groupsPageTitle, "Groups | Facebook", "GroupsPage is not matched");
    }

    @Test(priority = 2)
    public void verifyClickOnWorkAndEduction() {
        discoverPage = groupsPage.clickOnDiscover();

    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
