package com.melikeyalpi.question5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "carts")
@AllArgsConstructor
@RequiredArgsConstructor
public class Cart extends BaseEntity {


    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore // Without customer information than db
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @OneToMany(mappedBy = "cart" )
    private List<AddedProduct> productList;


    private int cartPrice;


    @Override
    String print() {
        return "";
    }
}
