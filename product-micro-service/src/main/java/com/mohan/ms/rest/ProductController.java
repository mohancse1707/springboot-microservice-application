package com.mohan.ms.rest;

import com.mohan.ms.service.ProductReviewServiceProxy;
import com.mohan.ms.service.ProductService;
import com.mohan.ms.service.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

	private final RestTemplate restTemplate;
	private final ProductReviewServiceProxy productReviewServiceProxy;
	private final ProductService productService;
	public ProductController(RestTemplate restTemplate, ProductReviewServiceProxy productReviewServiceProxy, ProductService productService) {
		this.restTemplate = restTemplate;
		this.productReviewServiceProxy = productReviewServiceProxy;
		this.productService = productService;
	}

	@GetMapping("/message")
	public String test() {
		String reviewMessage = productReviewServiceProxy.getMessage();
		return "Hello PRODUCT AND " + reviewMessage;
	}

	@GetMapping("/{product_id}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable(value = "product_id") String productId)  {
		ProductDTO reviewMessage = productService.getProductByProductId(productId);
		return new ResponseEntity<ProductDTO>(reviewMessage, HttpStatus.OK);
	}

}