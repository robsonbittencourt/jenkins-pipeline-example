package com.rbittencourt.services;

import com.rbittencourt.domain.Product;
import com.rbittencourt.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void shouldListAllProducts() {
        service.listAllProducts();

        verify(productRepository).findAll();
    }

    @Test
    public void shouldGetProductById() {
        Integer id = 10;
        Product product = new Product();
        product.setId(id);
        Optional<Product> result = Optional.of(product);

        when(productRepository.findById(id)).thenReturn(result);

        Product productResult = service.getProductById(id);

        assertEquals(10, productResult.getId().intValue());
    }

    @Test
    public void shouldReturnNullWhenNotFoundProduct() {
        Integer id = 10;
        Product product = new Product();
        product.setId(id);
        Optional<Product> result = Optional.empty();

        when(productRepository.findById(id)).thenReturn(result);

        Product productResult = service.getProductById(id);

        assertNull(productResult);
    }

    @Test
    public void shouldSaveProduct() {
        Integer id = 10;
        Product product = new Product();
        product.setId(id);

        service.saveProduct(product);

        verify(productRepository).save(product);
    }

}