package com.melikeyalpi.question5.entity;

import com.melikeyalpi.question5.dto.enums.CustomerStatus;
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
    private String surname;
    private String username;
    private String password;
    private String address;
    private String phone;
    private String email;
    private String city;
    private String country;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany // Without 'cascade' because we need old prices
    private List<Order> orderList;


    @Override
    String print() {
        return "";
    }
}
