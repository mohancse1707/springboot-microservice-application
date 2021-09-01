package com.mohan.ms.service;


import com.mohan.ms.ProductMicroServiceApplication;
import com.mohan.ms.client.ProductFeignClient;
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


import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = ProductMicroServiceApplication.class)
//@WebAppConfiguration
//@AutoConfigureTestDatabase
//@TestPropertySource(locations = "classpath:application.properties")
public class ProductServiceIntegrationTest {

//    @MockBean
//    private ProductReviewServiceProxy productReviewServiceProxy;
//
//    @MockBean
//    private ProductFeignClient productFeignClient;
//
//    @Autowired
//    private ProductService productService;
//
//    @TestConfiguration
//    static class ProductReviewServiceImplTestContextConfiguration {
//        @Bean
//        public ProductService productService() {
//            return new ProductServiceImpl();
//        }
//    }
//
//
//    @Test
//    public void getProductByProductIdTest() {
//        when(productFeignClient.getProductById(anyString())).thenReturn(getProduct());
//        ProductDTO product = productService.getProductByProductId("L0001");
//        assertTrue(product != null);
//    }
//
//    private ProductDTO getProduct() {
//        ProductDTO product = new ProductDTO().builder()
//                .id(1L)
//                .productId("L0001")
//                .productTitle("Lenovo Laptop")
//                .price(10000L)
//                .build();
//        return product;
//    }
}
