package com.melikeyalpi.question5.service;

import com.melikeyalpi.question5.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Long cartId);
    Order getOrderForCode(String code);
    List<Order> getAllOrdersForCustomer(Long id);
}
