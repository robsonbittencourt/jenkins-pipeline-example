package com.rbittencourt.ui.page;

import com.rbittencourt.ui.driver.DriverFactory;

public class Menu {

    public ProductListPage goToListPage() {
        DriverFactory.getInstance().get("http://localhost:8080");
        return new ProductListPage();
    }

    public ProductFormPage goToCreatePage() {
        DriverFactory.getInstance().get("http://localhost:8080/product/new");
        return new ProductFormPage();
    }

}
