package com.melikeyalpi.question5.controller;

import com.melikeyalpi.question5.converter.CustomerConverter;
import com.melikeyalpi.question5.dto.CustomerDto;
import com.melikeyalpi.question5.dto.request.CustomerRequest;
import com.melikeyalpi.question5.entity.Customer;
import com.melikeyalpi.question5.repository.CustomerRepository;
import com.melikeyalpi.question5.service.CartService;
import com.melikeyalpi.question5.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CartService cartService;
    private final CustomerRepository customerRepository;


    @PostMapping
    private CustomerDto addCustomer(@RequestBody CustomerRequest customer){
        Customer addedCustomer = customerService.addCustomer(customer);
        cartService.createCart(addedCustomer);
        return CustomerConverter.toDto(addedCustomer);
    }


    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerRepository.findById(id).orElse(null);
    }

}
