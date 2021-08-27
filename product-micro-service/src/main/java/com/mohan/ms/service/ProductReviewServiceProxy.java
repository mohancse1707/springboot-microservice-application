package com.mohan.ms.service;

import com.mohan.ms.service.dto.ProductReviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="review-micro-service" ) //Service Id of ProductReviewService service
public interface ProductReviewServiceProxy {
    @RequestMapping("/{product_id}")
    public List<ProductReviewDTO> getAllReviewByProductId(@PathVariable(value="product_id") String productId);

    @RequestMapping("/message")
    public String getMessage();

}
