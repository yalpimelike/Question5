package com.melikeyalpi.question5.converter;

import com.melikeyalpi.question5.dto.CartDto;
import com.melikeyalpi.question5.entity.Cart;

public class CartConverter {

    public static CartDto cartDto(Cart cart) {
        return CartDto.builder()
                .id(cart.getId())
                .customerId(cart.getCustomer().getId())
                .customerName(cart.getCustomer().getName())
                .cartPrice(cart.getCartPrice())
                .productList(cart.getProductList())
                .build();
    }
}
