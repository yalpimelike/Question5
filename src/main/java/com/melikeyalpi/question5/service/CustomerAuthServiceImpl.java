package com.melikeyalpi.question5.service;

import com.melikeyalpi.question5.dto.enums.CustomerStatus;
import com.melikeyalpi.question5.dto.request.CustomerRequest;
import com.melikeyalpi.question5.entity.Customer;
import com.melikeyalpi.question5.exception.BasicException;
import com.melikeyalpi.question5.exception.ExceptionMessages;
import com.melikeyalpi.question5.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class CustomerAuthServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public Customer addCustomer(CustomerRequest request) {

        List<Customer> customers = customerRepository.findAll();

        if (customers.stream().anyMatch(c -> c.getUsername().equals(request.getUsername()))){
            throw new BasicException(ExceptionMessages.CURRENT_USERNAME);
        }
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setUsername(request.getUsername());
        customer.setPassword(request.getPassword());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setCountry(request.getCountry());
        customer.setStatus(CustomerStatus.ACTIVE);

        try {
            return customerRepository.save(customer);
        }catch (Exception e) {
            throw new BasicException(ExceptionMessages.DB_OPERATION);
        }
    }

}
