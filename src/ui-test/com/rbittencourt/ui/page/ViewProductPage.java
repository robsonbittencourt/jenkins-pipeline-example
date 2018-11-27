package com.rbittencourt.ui.page;

import org.openqa.selenium.By;
import com.rbittencourt.ui.element.TextField;

public class ViewProductPage {

    private Menu menu = new Menu();

    public Menu getMenu() {
        return menu;
    }

    public String getId() {
        TextField textField = new TextField(By.id("view-product-id"));
        return textField.getText();
    }

    public String getDescription() {
        TextField textField = new TextField(By.id("view-product-description"));
        return textField.getText();
    }

    public String getPrice() {
        TextField textField = new TextField(By.id("view-product-price"));
        return textField.getText();
    }

}
