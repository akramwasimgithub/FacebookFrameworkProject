package com.fb.page;

import com.fb.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AboutPageTest extends BaseClass {
    LoginPage loginPage;
    HomePage homepage;
    ProfilePage profilePage;
    AboutPage aboutPage;
    WorkAndEducation workAndEducation;
    //PlacesLived placesLived;
    ContactAndInfo contactAndInfo;
    FamilyAndRelationship familyAndRelationship;
    //DetailsAboutYou detailsAboutYou;
    //LifeEvents lifeEvents;

    public AboutPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homepage = new HomePage();
        homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        profilePage = homepage.clickOnProfile();
        //aboutPage = profilePage.clickOnAbout();
    }

    @Test(priority = 1)
    public void verifyAboutPageTitleTest() {
        String aboutPageTitle = aboutPage.verifyAboutPageTitle();
        Assert.assertEquals(aboutPageTitle, "Raj  | Facebook", "AboutPage is not matched");
    }

   /* @Test(priority = 2)
    public void verifyClickOnWorkAndEduction() {
        workAndEduacation = aboutPage.clickOnWorkAndEducation();

    }*/

   /* @Test(priority = 3)
    public void verifyClickOnPlacesLived() {
        placesLived = aboutPage.clickOnPlacesLived();

    }
*/
    @Test(priority = 4)
    public void verifyClickOnContactAndInfo() {
        contactAndInfo = aboutPage.clickOnContacts();

    }

    @Test(priority = 5)
    public void verifyClickOnFamilyAndRelationship() {
        familyAndRelationship = aboutPage.clickOnFamilyAndRelationship();

    }

   /* @Test(priority = 6)
    public void verifyClickOnDetails() {
        detailsAboutYou = aboutPage.clickOnDetails();

    }*/
/*

    @Test(priority = 7)
    public void verifyClickOnLifeEvents() {
        lifeEvents = aboutPage.clickOnLifeEvents();

    }
*/

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
