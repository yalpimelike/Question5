package com.melikeyalpi.question5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private Long customerId;
    private String customerEmail;
    private String customerPhone;
    private String orderCode;

    private List<AddedProductDto> productList;

    private int orderPrice;

}
