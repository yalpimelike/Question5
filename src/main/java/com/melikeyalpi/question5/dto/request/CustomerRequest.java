package com.melikeyalpi.question5.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String name;
    private String address;
    private String phone;
    private String email;
}
