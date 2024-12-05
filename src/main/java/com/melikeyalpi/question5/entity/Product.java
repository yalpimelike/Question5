package com.melikeyalpi.question5.entity;

import jakarta.persistence.*;
import lombok.*;


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


    @Override
    String print() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
