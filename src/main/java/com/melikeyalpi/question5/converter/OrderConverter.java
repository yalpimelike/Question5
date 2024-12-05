package com.melikeyalpi.question5.converter;

import com.melikeyalpi.question5.dto.OrderDto;
import com.melikeyalpi.question5.entity.Order;

public class OrderConverter {

    public static OrderDto toDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .cartId(order.getCartId())
                .customerId(order.getCustomerId())
                .customerEmail(order.getCustomerEmail())
                .customerPhone(order.getCustomerPhone())
                .orderCode(order.getOrderCode())
                .productList(order.getProductList())
                .orderPrice(order.getOrderPrice())
                .build();
    }
}
