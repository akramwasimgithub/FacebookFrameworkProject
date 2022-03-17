package com.fb.testdata;

import com.fb.base.BaseClass;
import com.fb.page.HomePage;
import com.fb.page.RegisterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseClass {

   RegisterPage registerPage;
   HomePage homePage;

    public RegisterPageTest(){
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialization();

    }
   /* @Test(priority = 1)
    public void RegisterPageTitleTest {
        registerPage = new RegisterPage();
        String RegisterPageTitle = registerPage.validateRegisterPageTitle();
        Assert.assertEquals(RegisterPageTitle, "Facebook – log in or sign up", RegisterPageTitle);
    }*/
    @Test
    public void RegisterTest() {
        registerPage=new RegisterPage();
       registerPage.Register(properties.getProperty("firstname"), properties.getProperty("lastname"),
                 properties.getProperty("birthday_day"));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
