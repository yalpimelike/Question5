package com.melikeyalpi.question5.dto;


import com.melikeyalpi.question5.entity.AddedProduct;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@RequiredArgsConstructor
public class AddedProductDto {

    private String productName;
    private int count;
    private int totalPrice;
    private int productPrice;
    private int productStoke;

    public AddedProductDto(AddedProduct addedProduct) {
      this.productName = addedProduct.getProduct().getName();
      this.count = addedProduct.getCount();
      this.totalPrice = addedProduct.getTotalPrice();
      this.productPrice = addedProduct.getProduct().getPrice();
      this.productStoke = addedProduct.getProduct().getStock();
    }
}
