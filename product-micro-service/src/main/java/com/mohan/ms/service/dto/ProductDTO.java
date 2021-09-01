package com.mohan.ms.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable{
    private String id;
    private String name;
    @JsonProperty("model_number")
    private String modelNumber;
    @JsonProperty("product_type")
    private String productType;
    @JsonProperty("pricing_information")
    private PricingInformation pricingInformation;
    @JsonProperty("product_description")
    private ProductDescription productDescription;
    private Boolean isRecommendationsEnabled;
    private List<ProductReviewDTO> reviewList;
}
