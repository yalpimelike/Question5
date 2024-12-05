package com.melikeyalpi.question5.service;

import com.melikeyalpi.question5.dto.request.CustomerRequest;
import com.melikeyalpi.question5.entity.Customer;

public interface CustomerService {

    Customer addCustomer(CustomerRequest customer);

}
