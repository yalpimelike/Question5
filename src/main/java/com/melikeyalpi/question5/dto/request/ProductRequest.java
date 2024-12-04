package com.melikeyalpi.question5.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private int price,stoke;
}
