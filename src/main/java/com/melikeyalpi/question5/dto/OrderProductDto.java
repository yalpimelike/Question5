package com.melikeyalpi.question5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderProductDto {

    private Long productId;
    private String productName;
    private int count;
    private int totalPrice;
    private int productPrice;
    private int productCurrentPrice;

}
