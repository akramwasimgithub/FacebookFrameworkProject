package com.fb.page;

import com.fb.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseClass {

    @FindBy(xpath = "//span[contains(text(), 'About')]")
    WebElement about;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/" +
            "div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]" +
            "/div[1]/a[3]/div[1]/span[1]")
    WebElement friends;

    @FindBy(xpath = "//span[contains(text(), 'Photos')]")
    WebElement photos;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div" +
            "[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]" +
            "/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[5]/div[1]/span[1]")
    WebElement videos;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]" +
            "/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]" +
            "/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[6]/div[1]/span[1]")
    WebElement check;


    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyProfilePageTitle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }


}
