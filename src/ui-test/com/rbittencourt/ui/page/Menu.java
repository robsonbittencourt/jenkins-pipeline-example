package com.rbittencourt.ui.page;

import org.openqa.selenium.WebDriver;

public class Menu {

    private WebDriver driver;

    public Menu(WebDriver driver) {
        this.driver = driver;
    }

    public ProductListPage goToListPage() {
        this.driver.get("http://app-uat:8085");
        return new ProductListPage(this.driver);
    }

    public ProductFormPage goToCreatePage() {
        this.driver.get("http://app-uat:8085/product/new");
        return new ProductFormPage(this.driver);
    }

}
