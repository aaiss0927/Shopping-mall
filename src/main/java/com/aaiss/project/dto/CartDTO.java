package com.aaiss.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartDTO {
    private Long id;
    private String productName;
    private int productSku;
    private int productPrice;
    private String memberId;
    private int quantity;
}