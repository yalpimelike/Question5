package com.melikeyalpi.question5.repository;

import com.melikeyalpi.question5.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
