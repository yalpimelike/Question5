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

    private Long id;
    private Long customerId;
    private String customerName;

    private int cartPrice;

    private List<AddedProduct> productList;

}
