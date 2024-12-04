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

    private String name;
    private String address;
    private String phone;
    private String email;
}
