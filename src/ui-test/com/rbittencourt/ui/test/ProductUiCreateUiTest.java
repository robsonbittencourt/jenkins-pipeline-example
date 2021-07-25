package com.rbittencourt.ui.test;

import com.rbittencourt.ui.driver.DriverFactory;
import com.rbittencourt.ui.page.ProductListPage;
import com.rbittencourt.ui.page.ViewProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductUiCreateUiTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getInstance();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldCreateProduct() {
        // for is just for demonstration
        for (int i = 0; i < 20; i++) {
            String description = "ball";

            ProductListPage productListPage = new ProductListPage(driver).goTo();

            ViewProductPage viewProductPage = productListPage.create(3, description, 10.50);

            assertEquals(description, viewProductPage.getDescription());
            assertEquals("10.50", viewProductPage.getPrice());
        }
    }

}
