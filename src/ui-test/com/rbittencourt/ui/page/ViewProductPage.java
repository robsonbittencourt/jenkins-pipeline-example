package com.rbittencourt.ui.page;

import org.openqa.selenium.By;
import com.rbittencourt.ui.element.TextField;
import org.openqa.selenium.WebDriver;

public class ViewProductPage {

    private WebDriver driver;
    private Menu menu;

    public ViewProductPage(WebDriver driver) {
        this.driver = driver;
        this.menu = new Menu(driver);
    }

    public Menu getMenu() {
        return menu;
    }

    public String getId() {
        TextField textField = new TextField(this.driver, By.id("view-product-id"));
        return textField.getText();
    }

    public String getDescription() {
        TextField textField = new TextField(this.driver, By.id("view-product-description"));
        return textField.getText();
    }

    public String getPrice() {
        TextField textField = new TextField(this.driver, By.id("view-product-price"));
        return textField.getText();
    }

}
