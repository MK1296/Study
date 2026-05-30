package com.example.ecorder.entity;

import lombok.Data;

@Data
public class Product {

    private Integer productId;

    private String productCode;

    private String productName;

    private Integer unitPrice;

    private Boolean isActive;

    private Integer deleteFlg;
}