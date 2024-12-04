package com.melikeyalpi.question5.converter;

import com.melikeyalpi.question5.dto.CartDto;
import com.melikeyalpi.question5.entity.Cart;

public class CartConverter {

    public static CartDto cartDto(Cart cart) {
        return CartDto.builder()
                .customerId(cart.getCustomer().getId())
                .totalPrice(cart.getCartPrice())
                .productList(cart.getProductList())
                .build();
    }
}
