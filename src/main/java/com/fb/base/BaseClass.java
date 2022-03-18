package com.fb.base;

import com.fb.utility.UtilityClass;
import com.fb.utility.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public  static Properties properties;
    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public BaseClass() {
        properties = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(
                    "C:\\Users\\63not\\IdeaProjects\\SeleniumFrameworkProject\\src\\main\\java\\com\\fb\\config\\config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // for launching the browser
    public void initialization() {
        String browserName = properties.getProperty("browser");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);

        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);
        }
        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(UtilityClass.PAGE_LOAD_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(UtilityClass.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
    }
}