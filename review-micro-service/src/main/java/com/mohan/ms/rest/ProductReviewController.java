package com.mohan.ms.rest;

import com.mohan.ms.rest.response.ProductReviewSuccessResponse;
import com.mohan.ms.service.ProductReviewService;
import com.mohan.ms.service.dto.ProductReviewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductReviewController {

	private final ProductReviewService productReviewService;

	public ProductReviewController(ProductReviewService productReviewService) {
		this.productReviewService = productReviewService;
	}

	@GetMapping("/{product_id}")
	public ResponseEntity<List<ProductReviewDTO>> getProductReviewByProductId(@PathVariable(value = "product_id") String productId)  {
		List<ProductReviewDTO> reviewList = productReviewService.getAllReviewByProductId(productId);
		return new ResponseEntity<List<ProductReviewDTO>>(reviewList, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<ProductReviewDTO>> getAllProductReview()  {
		List<ProductReviewDTO> reviewList = productReviewService.getAllProductReview();
		return new ResponseEntity<List<ProductReviewDTO>>(reviewList, HttpStatus.OK);
	}

	@PostMapping("/addProductReview")
	public ResponseEntity<ProductReviewSuccessResponse> addProductReview(@Valid @RequestBody ProductReviewDTO reviewDTO) {
		productReviewService.addProductReview(reviewDTO);
		ProductReviewSuccessResponse response = new ProductReviewSuccessResponse();
		response.setMessage("Product Review Added Successfully!");
		return new ResponseEntity<ProductReviewSuccessResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/updateProductReview")
	public ResponseEntity<ProductReviewSuccessResponse> updateProductReview(@Valid @RequestBody ProductReviewDTO reviewDTO) {
		productReviewService.updateProductReview(reviewDTO);
		ProductReviewSuccessResponse response = new ProductReviewSuccessResponse();
		response.setMessage("Product Review Updated Successfully!");
		return new ResponseEntity<ProductReviewSuccessResponse>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteProductReview")
	public ResponseEntity<ProductReviewSuccessResponse> deleteProductReview(@RequestParam(value = "id", required = false) Long id) {
		productReviewService.deleteProductReview(id);
		ProductReviewSuccessResponse response = new ProductReviewSuccessResponse();
		response.setMessage("Product Review Deleted Successfully!");
		return new ResponseEntity<ProductReviewSuccessResponse>(response, HttpStatus.OK);
	}
}