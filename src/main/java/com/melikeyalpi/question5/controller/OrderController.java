package com.melikeyalpi.question5.controller;

import com.melikeyalpi.question5.converter.OrderConverter;
import com.melikeyalpi.question5.dto.OrderDto;
import com.melikeyalpi.question5.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{cartId}")
    public OrderDto createOrder(@PathVariable Long cartId){
        return OrderConverter.toDto(orderService.createOrder(cartId));
    }


    @GetMapping("/{code}")
    private OrderDto getOrderForCode(@PathVariable String code){
        return OrderConverter.toDto(orderService.getOrderForCode(code));
    }

    @GetMapping
    private List<OrderDto> getAllOrdersForCustomer(@RequestParam Long customerId){
        return orderService.getAllOrdersForCustomer(customerId).stream()
                .map(OrderConverter::toDto).collect(Collectors.toList());
    }
}
