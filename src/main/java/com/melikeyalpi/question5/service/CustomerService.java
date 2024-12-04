package com.melikeyalpi.question5.service;

import com.melikeyalpi.question5.entity.Customer;
import com.melikeyalpi.question5.dto.request.CustomerRequest;
import com.melikeyalpi.question5.exception.BasicException;
import com.melikeyalpi.question5.exception.ExceptionMessages;
import com.melikeyalpi.question5.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

   private final CustomerRepository customerRepository;

    public Customer addCustomer(CustomerRequest request) {
        try {
            Customer customer = new Customer();
            customer.setName(request.getName());
            customer.setEmail(request.getEmail());
            customer.setPhone(request.getPhone());
            customer.setAddress(request.getAddress());
            return customerRepository.save(customer);
        }catch (Exception e) {
            log.error(ExceptionMessages.DB_OPERATION);
            throw new BasicException(ExceptionMessages.DB_OPERATION);
        }
    }
}
