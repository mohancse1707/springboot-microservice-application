package com.mohan.ms.rest;

import com.mohan.ms.service.ProductReviewServiceProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

	private final RestTemplate restTemplate;
	private final ProductReviewServiceProxy productReviewServiceProxy;

	public ProductController(RestTemplate restTemplate, ProductReviewServiceProxy productReviewServiceProxy) {
		this.restTemplate = restTemplate;
		this.productReviewServiceProxy = productReviewServiceProxy;
	}

	@GetMapping("/message")
	public String test() {
		String reviewMessage = productReviewServiceProxy.getMessage();
		return "Hello PRODUCT AND " + reviewMessage;
	}


}