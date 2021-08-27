package com.mohan.ms.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductReviewController {

	@GetMapping("/message")
	public String test() {
		return "Hello PRODUCT Review";
	}

}