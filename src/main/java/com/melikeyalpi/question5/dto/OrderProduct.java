package com.melikeyalpi.question5.dto;


import com.melikeyalpi.question5.entity.AddedProduct;
import com.melikeyalpi.question5.entity.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderProduct {

    private String productName;
    private int count;
    private int totalPrice;
    private int productPrice;
    private int productStoke;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    public OrderProduct(AddedProduct addedProduct) {
        this.product = addedProduct.getProduct();
       // this.productId = addedProduct.getProduct().getId();
        this.productName = addedProduct.getProduct().getName();
        this.count = addedProduct.getCount();
        this.totalPrice = addedProduct.getTotalPrice();
        this.productPrice = addedProduct.getProduct().getPrice();
        this.productStoke = addedProduct.getProduct().getStock();
    }
}
