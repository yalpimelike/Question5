package com.melikeyalpi.question5.dto;

import com.melikeyalpi.question5.entity.AddedProduct;
import com.melikeyalpi.question5.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class CartDto {

    private List<AddedProduct> productList;

    private int totalPrice;

    private Long customerId;
}
