package com.rbittencourt.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver getInstance() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

        try {
            driver = new RemoteWebDriver(new URL("http://chrome:4444"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();

        return driver;
    }

}