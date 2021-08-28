package com.mohan.ms.service;

import com.mohan.ms.ReviewMicroServiceApplication;
import com.mohan.ms.domain.ProductReview;
import com.mohan.ms.repository.ProductReviewRepository;
import com.mohan.ms.service.dto.ProductReviewDTO;
import com.mohan.ms.service.impl.ProductReviewServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ReviewMicroServiceApplication.class)
@WebAppConfiguration
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application.properties")
public class ProductReviewServiceIntegrationTest {

    @MockBean
    private ProductReviewRepository productReviewRepository;

    @Autowired
    private ProductReviewService productReviewService;

    @TestConfiguration
    static class ProductReviewServiceImplTestContextConfiguration {
        @Bean
        public ProductReviewService productReviewService() {
            return new ProductReviewServiceImpl();
        }
    }


    @Test
    public void getAllProductReviewTest() {
        when(productReviewRepository.findAll()).thenReturn(getProductReviewList());
        List<ProductReviewDTO> review = productReviewService.getAllProductReview();
        assertTrue(review.size() > 0);
    }

    @Test
    public void addProductReviewTest() {
        when(productReviewRepository.save(any(ProductReview.class))).thenReturn(getProductReview());
        productReviewService.addProductReview(getProductReviewDTO());
        Mockito.verify(productReviewRepository).save(any(ProductReview.class));
    }

    private List<ProductReview> getProductReviewList() {
        List<ProductReview> list = new ArrayList<>();
        ProductReview productReview = new ProductReview().builder()
                .id(1L)
                .productId("L0001")
                .averageReviewScore(3L)
                .numberOfReview(10l)
                .build();

        ProductReview productReview1 = new ProductReview().builder()
                .id(1L)
                .productId("L0001")
                .averageReviewScore(3L)
                .numberOfReview(10l)
                .build();
        list.add(productReview);
        list.add(productReview1);
        return list;
    }

    private ProductReview getProductReview() {
        ProductReview productReview  = new ProductReview().builder()
                .id(1L)
                .productId("L0001")
                .averageReviewScore(3L)
                .numberOfReview(10l)
                .build();
        return productReview;
    }

    private ProductReviewDTO getProductReviewDTO() {
        ProductReviewDTO ProductReviewDTO  = new ProductReviewDTO().builder()
                .id(1L)
                .productId("L0001")
                .averageReviewScore(3L)
                .numberOfReview(10l)
                .build();
        return ProductReviewDTO;
    }

    private ProductReviewDTO modifyReviewDTO() {
        ProductReviewDTO ProductReviewDTO  = new ProductReviewDTO().builder()
                .id(1L)
                .productId("L0001")
                .averageReviewScore(3L)
                .numberOfReview(25L)
                .build();
        return ProductReviewDTO;
    }
}
