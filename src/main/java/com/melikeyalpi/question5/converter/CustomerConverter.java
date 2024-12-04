package com.melikeyalpi.question5.converter;

import com.melikeyalpi.question5.dto.CustomerDto;
import com.melikeyalpi.question5.entity.Customer;

public class CustomerConverter {

    public static CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .name(customer.getName())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }
}
