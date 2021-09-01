package com.mohan.ms.service.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricingInformation implements Serializable  {

    Double currentPrice;
    @JsonProperty("standard_price")
    Double standardPrice;
    @JsonProperty("standard_price_no_vat")
    Double standardPriceNoVat;
}