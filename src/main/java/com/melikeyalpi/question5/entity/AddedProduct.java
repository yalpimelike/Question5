package com.melikeyalpi.question5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class AddedProduct extends BaseEntity {

    private static final int START_COUNT = 1;


    @ManyToOne
    @JsonIgnore
    private Cart cart;

    private int count;

    private int totalPrice; // Same product's total price


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;



    public AddedProduct(Product product, Cart cart) {
        this.cart = cart;
        this.product = product;
        this.count = START_COUNT;
        this.totalPrice = product.getPrice();
    }


    @Override
    String print() {
        return "";
    }
}
