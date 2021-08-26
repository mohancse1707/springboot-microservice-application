package com.mohan.ms.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="review-micro-service" ) //Service Id of ProductReviewService service
public interface ProductReviewServiceProxy {
}
