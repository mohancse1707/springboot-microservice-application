package com.mohan.ms.rest;

import com.mohan.ms.service.ProductReviewServiceProxy;
import com.mohan.ms.service.ProductService;
import com.mohan.ms.service.dto.ProductDTO;
import com.mohan.ms.service.dto.ProductReviewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

	@GetMapping("/{product_id}")
	public ResponseEntity<ProductDTO> getProductByProductId(@PathVariable(value = "product_id") String productId)  {
		ProductDTO productList = productService.getProductByProductId(productId);
		return new ResponseEntity<ProductDTO>(productList, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<ProductDTO>> getAllProduct()  {
		List<ProductDTO> productList = productService.getAllProduct();
		return new ResponseEntity<List<ProductDTO>>(productList, HttpStatus.OK);
	}
}