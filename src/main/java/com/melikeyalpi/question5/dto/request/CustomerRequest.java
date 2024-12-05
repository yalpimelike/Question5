package com.melikeyalpi.question5.dto.request;

import com.melikeyalpi.question5.dto.enums.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String address;
    private String phone;
    private String email;
    private String city;
    private String country;
}
