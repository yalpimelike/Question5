package com.melikeyalpi.question5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@Builder
@Table(name = "products")
@AllArgsConstructor
@RequiredArgsConstructor
public class Product extends BaseEntity {

    private String name;
    private String description;
    private String category;
    private String imageUrl;
    private int price;
    private int stock;



    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AddedProduct> addedProduct;



    @Override
    String print() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
