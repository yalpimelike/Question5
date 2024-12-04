package com.melikeyalpi.question5.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class ProductDto {

    private String name;
    private int price;
    private int stock;

}
