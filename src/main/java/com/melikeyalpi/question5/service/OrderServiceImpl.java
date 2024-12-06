package com.melikeyalpi.question5.service;

import com.melikeyalpi.question5.dto.OrderProduct;
import com.melikeyalpi.question5.dto.enums.OrderStatus;
import com.melikeyalpi.question5.entity.*;
import com.melikeyalpi.question5.exception.BasicException;
import com.melikeyalpi.question5.exception.ExceptionMessages;
import com.melikeyalpi.question5.repository.AddedProductRepository;
import com.melikeyalpi.question5.repository.CartRepository;
import com.melikeyalpi.question5.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final AddedProductRepository addedProductRepository;


    public Order createOrder(Long cartId) {

        Cart cart = cartRepository.findById(cartId).orElse(null);
        Order order = new Order();

        if (cart == null || cart.getProductList().isEmpty()) {
            log.error(ExceptionMessages.DATA_NOT_FOUNT);
            throw new BasicException(ExceptionMessages.DATA_NOT_FOUNT);
        }

        order.setCartId(cartId);
        order.setShippingAddress(cart.getCustomer().getAddress());

        order.setCustomer(cart.getCustomer());

        order.setOrderCode(UUID.randomUUID().toString());

        order.setStatus(OrderStatus.CREATED);

        clearProductListToCart(cart);
        order.setProductList(new ArrayList<>());

        cart.getProductList().forEach(product -> {
            order.getProductList().add(new OrderProduct(product));
        });

        order.setOrderPrice(cart.getCartPrice());
        orderRepository.save(order);

        clearProductListToCart(cart);
        cart.setProductList(new ArrayList<>());

        cart.setCartPrice(0);
        cartRepository.save(cart);

        return order;
    }

    public void clearProductListToCart(Cart cart) {
        addedProductRepository.deleteAll(cart.getProductList());
    }



    public Order getOrderForCode(String code) {
        return orderRepository.findByOrderCode(code).orElse(null);
    }



    public List<Order> getAllOrdersForCustomer(Long id) {
        return orderRepository.findByCustomerId(id).orElse(new ArrayList<>());
    }


}
