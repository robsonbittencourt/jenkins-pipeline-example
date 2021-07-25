package com.rbittencourt.ui.test;

import com.rbittencourt.ui.driver.DriverFactory;
import com.rbittencourt.ui.page.ProductListPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductUiEditUiTest {

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
    public void shouldNavigateBetweenPagesUsingMenu() {
        // for is just for demonstration
        for (int i = 0; i < 20; i++) {
            ProductListPage productListPage = new ProductListPage(driver).goTo();
            productListPage.getMenu().goToCreatePage();
            productListPage = productListPage.getMenu().goToListPage();

            assertTrue(productListPage.createProductIsVisible());
        }
    }

}
