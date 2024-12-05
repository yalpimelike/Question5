package com.melikeyalpi.question5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CustomerDto {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String address;
    private String phone;
    private String email;
}
