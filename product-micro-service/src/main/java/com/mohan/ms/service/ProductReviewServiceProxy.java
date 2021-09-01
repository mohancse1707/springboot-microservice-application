package com.mohan.ms.service;

import com.mohan.ms.client.ProductReviewFeignClientFallback;
import com.mohan.ms.service.dto.ProductReviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="review-micro-service", url = "http://localhost:8083", fallback = ProductReviewFeignClientFallback.class) //Service Id of ProductReviewService service
public interface ProductReviewServiceProxy {
    @RequestMapping("/api/{product_id}")
    public List<ProductReviewDTO> getAllReviewByProductId(@PathVariable(value="product_id") String productId);

}
