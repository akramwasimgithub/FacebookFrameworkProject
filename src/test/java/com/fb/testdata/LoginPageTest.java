package com.fb.testdata;

import com.fb.base.BaseClass;
import com.fb.page.HomePage;
import com.fb.page.LoginPage;
import com.fb.utility.UtilityClass;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginPageTest extends BaseClass {
    LoginPage loginPage;
    HomePage homepage;
    String sheetName ="Sheet1";
    Logger log = Logger.getLogger(LoginPageTest.class);
    public LoginPageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();

    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        loginPage = new LoginPage();
        String loginPageTitle = loginPage.validateLoginPageTitle();
        Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up", loginPageTitle);
        log.info("page title validated");
    }

    @Test(priority = 2)
    public void loginTest() {
        loginPage = new LoginPage();
        homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }
    @DataProvider
    public Object[][] getLoginTestData() {
        Object data [][] = UtilityClass.getTestData(sheetName);
        return data;
    }

    @Test(dataProvider = "getLoginTestData")
    public void multipleLoginTest(String userName,String pass) throws InterruptedException {
        loginPage.loginMultipleAccounts(userName,pass);
        Thread.sleep(3000);
        log.info("login successful with username: " +userName);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
        log.info("browser is closed");
    }

}