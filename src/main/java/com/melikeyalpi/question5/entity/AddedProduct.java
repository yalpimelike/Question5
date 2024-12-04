package com.melikeyalpi.question5.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Embeddable
@AllArgsConstructor
@RequiredArgsConstructor
public class AddedProduct {

    private static final int START_COUNT = 1;

    private Long id;

    private Long cartId;

    private int count;

    private int totalPrice; // Same product's total price

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;


    public AddedProduct(Product product, Long cartId) {
        this.id = product.getId();
        this.cartId = cartId;
        this.product = product;
        this.count = START_COUNT;
        this.totalPrice = product.getPrice();
    }

}
