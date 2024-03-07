package com.aaiss.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private String productName;
    private String productCategory;
    private int productSku;
    private int productPrice;
    private int productStock;
    private String productSrc;
}