package com.melikeyalpi.question5.controller;

import com.melikeyalpi.question5.converter.CustomerConverter;
import com.melikeyalpi.question5.dto.CustomerDto;
import com.melikeyalpi.question5.dto.request.CustomerRequest;
import com.melikeyalpi.question5.entity.Customer;
import com.melikeyalpi.question5.service.CartService;
import com.melikeyalpi.question5.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@AllArgsConstructor

public class CustomerController {

    private CustomerService customerService;

    private CartService cartService;


    @PostMapping
    private CustomerDto addCustomer(@RequestBody CustomerRequest customer){
        Customer addedCustomer = customerService.addCustomer(customer);
        cartService.createCart(addedCustomer);
        return CustomerConverter.toDto(addedCustomer);
    }


    @PostMapping("/save-list")
    private void addCustomer(@RequestBody List<CustomerRequest> customerList){
        customerList.forEach(this::addCustomer);
    }

}