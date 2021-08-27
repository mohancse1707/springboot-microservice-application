package com.mohan.ms.service;

import com.mohan.ms.ReviewMicroServiceApplication;
import com.mohan.ms.repository.ProductReviewRepository;
import com.mohan.ms.service.impl.ProductReviewServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ReviewMicroServiceApplication.class)
@WebAppConfiguration
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application.properties")
public class ProductReviewServiceIntegrationTest {

    @MockBean
    private ProductReviewRepository productReviewRepository;


    @TestConfiguration
    static class ProductReviewServiceImplTestContextConfiguration {
        @Bean
        public ProductReviewService productReviewService() {
            return new ProductReviewServiceImpl();
        }
    }
}
