package com.melikeyalpi.question5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer extends BaseEntity {

    private String name;
    private String address;
    private String phone;
    private String email;


    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany // Without 'cascade' because we need old prices
    private List<Order> orderList;


    @Override
    String print() {
        return "";
    }
}
