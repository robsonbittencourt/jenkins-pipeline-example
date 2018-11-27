package com.rbittencourt.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");

            driver = new ChromeDriver(options);

            driver.manage().window().maximize();
        }

        return driver;
    }

}
