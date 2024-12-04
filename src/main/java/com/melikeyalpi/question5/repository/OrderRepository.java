package com.melikeyalpi.question5.repository;

import com.melikeyalpi.question5.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    Optional<List<Order>> findByCustomerId(Long customerId);

    Optional<Order> findByOrderCode(String code);
}
