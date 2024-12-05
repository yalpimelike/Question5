package com.melikeyalpi.question5.repository;

import com.melikeyalpi.question5.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order,Long> {
    Optional<List<Order>> findByCustomerId(Long customerId);

    Optional<Order> findByOrderCode(String code);
}
