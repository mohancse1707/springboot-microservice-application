package com.mohan.ms.rest;

import com.mohan.ms.service.ProductService;
import com.mohan.ms.service.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/{product_id}")
	public ResponseEntity<ProductDTO> getProductByProductId(@PathVariable(value = "product_id") String productId)  {
		ProductDTO productList = productService.getProductByProductId(productId);
		return new ResponseEntity<ProductDTO>(productList, HttpStatus.OK);
	}
}