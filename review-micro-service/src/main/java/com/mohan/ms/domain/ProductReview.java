package com.mohan.ms.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_review")
public class ProductReview implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String productId;
    private Long averageReviewScore;
    private Long numberOfReview;
}
