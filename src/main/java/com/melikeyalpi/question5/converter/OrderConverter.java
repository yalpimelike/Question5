package com.melikeyalpi.question5.converter;

import com.melikeyalpi.question5.dto.OrderDto;
import com.melikeyalpi.question5.dto.OrderProduct;
import com.melikeyalpi.question5.dto.OrderProductDto;
import com.melikeyalpi.question5.entity.Order;

import java.util.stream.Collectors;

public class OrderConverter {

    public static OrderDto toDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .cartId(order.getCartId())
                .customerId(order.getCustomer().getId())
                .customerEmail(order.getCustomer().getEmail())
                .customerPhone(order.getCustomer().getPhone())
                .orderCode(order.getOrderCode())
                .productList(order.getProductList().stream()
                        .map(OrderConverter::toDto).collect(Collectors.toList()))
                .orderPrice(order.getOrderPrice())
                .build();
    }

    public static OrderProductDto toDto(OrderProduct orderProduct) {
        return OrderProductDto.builder()
                .productId(orderProduct.getProduct().getId())
                .productName(orderProduct.getProductName())
                .productPrice(orderProduct.getProductPrice())
                .count(orderProduct.getCount())
                .totalPrice(orderProduct.getTotalPrice())
                .productCurrentPrice(orderProduct.getProduct().getPrice())
                .build();
    }
}
