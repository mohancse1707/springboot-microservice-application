package com.mohan.ms.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
@Table(name = "product")
public class Product {
    @Id
    private Long id;
    private String productId;
    private String productTitle;
    private Long price;
}
