package com.melikeyalpi.question5.controller;

import com.melikeyalpi.question5.converter.CartConverter;
import com.melikeyalpi.question5.dto.CartDto;
import com.melikeyalpi.question5.dto.request.ToCartRequest;
import com.melikeyalpi.question5.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/{id}")
    private CartDto getCart(@PathVariable Long id){
        return CartConverter.cartDto(cartService.getCart(id));
    }

    @GetMapping
    private CartDto updateCart(@RequestParam Long cartId){
        return CartConverter.cartDto(cartService.updateCart(cartId));
    }

    @PostMapping
    private CartDto addProductToCart(@RequestBody ToCartRequest request){
        return CartConverter.cartDto(cartService.addProductToCart(request));
    }

    @DeleteMapping
    private CartDto removeProductFromCart(@RequestBody ToCartRequest request){
        return CartConverter.cartDto(cartService.removeProductFromCart(request));
    }
}
