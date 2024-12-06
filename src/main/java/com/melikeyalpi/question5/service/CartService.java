package com.melikeyalpi.question5.service;

import com.melikeyalpi.question5.dto.request.ToCartRequest;
import com.melikeyalpi.question5.entity.AddedProduct;
import com.melikeyalpi.question5.entity.Cart;
import com.melikeyalpi.question5.entity.Customer;
import com.melikeyalpi.question5.entity.Product;

import java.util.List;

public interface CartService {

    void createCart(Customer customer);
    Cart getCart(Long id);
    Cart updateCart(Long cartId);
    Cart addProductToCart(ToCartRequest request);
    Cart removeProductFromCart(ToCartRequest request);
    void refreshCart(Product product);
    void refreshCart(List<AddedProduct> addedProductList);
}
