package com.rbittencourt.ui.test;

import com.rbittencourt.ui.driver.DriverFactory;
import com.rbittencourt.ui.page.ProductListPage;
import com.rbittencourt.ui.page.ViewProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ProductUiCreateUiTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = DriverFactory.getInstance();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldCreateProduct() {
        // for is just for demonstration
        for (int i = 0; i < 1; i++) {
            String description = "ball";

            ProductListPage productListPage = new ProductListPage(driver).goTo();

            ViewProductPage viewProductPage = productListPage.create(3, description, 10.50);

            assertEquals(description, viewProductPage.getDescription());
            assertEquals("10.50", viewProductPage.getPrice());
        }
    }

}
