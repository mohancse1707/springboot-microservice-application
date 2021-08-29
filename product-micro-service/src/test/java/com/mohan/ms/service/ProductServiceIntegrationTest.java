package com.mohan.ms.service;


import com.mohan.ms.ProductMicroServiceApplication;
import com.mohan.ms.domain.Product;
import com.mohan.ms.repository.ProductRepository;
import com.mohan.ms.service.dto.ProductDTO;

import com.mohan.ms.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProductMicroServiceApplication.class)
@WebAppConfiguration
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application.properties")
public class ProductServiceIntegrationTest {

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ProductReviewServiceProxy productReviewServiceProxy;

    @Autowired
    private ProductService productService;

    @TestConfiguration
    static class ProductReviewServiceImplTestContextConfiguration {
        @Bean
        public ProductService productService() {
            return new ProductServiceImpl();
        }
    }


    @Test
    public void getAllProductTest() {
        when(productRepository.findAll()).thenReturn(getProductList());
        List<ProductDTO> productDTOList = productService.getAllProduct();
        assertTrue(productDTOList.size() > 0);
    }

    @Test
    public void getProductByProductIdTest() {
        when(productRepository.findOneByProductId(anyString())).thenReturn(getProduct());
        ProductDTO product = productService.getProductByProductId("L0001");
        assertTrue(product != null);
    }


    private List<Product> getProductList() {
        List<Product> list = new ArrayList<>();
        Product product = new Product().builder()
                .id(1L)
                .productId("L0001")
                .productTitle("Lenovo Laptop")
                .price(10000L)
                .build();

        Product product1 = new Product().builder()
                .id(2L)
                .productId("L0001")
                .productTitle("Lenovo Laptop")
                .price(10000L)
                .build();
        list.add(product);
        list.add(product1);
        return list;
    }

    private Product getProduct() {
        Product product = new Product().builder()
                .id(1L)
                .productId("L0001")
                .productTitle("Lenovo Laptop")
                .price(10000L)
                .build();
        return product;
    }
}
