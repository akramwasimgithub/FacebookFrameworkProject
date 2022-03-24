package com.fb.page;

import com.fb.base.BaseClass;
import com.fb.page.HomePage;
import com.fb.page.LoginPage;
import com.fb.page.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTest extends BaseClass {

    LoginPage loginPage;
    HomePage homepage;
    ProfilePage profilePage;



    public ProfilePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homepage = new HomePage();
        homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        profilePage = homepage.clickOnProfile();
    }

    @Test(priority = 1)
    public void verifyProfilePageTitleTest() {
        String homePageTitle = profilePage.verifyProfilePageTitle();
        Assert.assertEquals(homePageTitle, "Raj | Facebook", "ProfilePage is not matched");
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