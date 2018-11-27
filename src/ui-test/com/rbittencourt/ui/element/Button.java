package com.rbittencourt.ui.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.rbittencourt.ui.driver.DriverFactory;

public class Button {

    private By selector;

    public Button(By selector) {
        this.selector = selector;
    }

    public void click() {
        WebElement element = DriverFactory.getInstance().findElement(selector);
        element.click();
    }
}
