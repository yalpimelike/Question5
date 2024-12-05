package com.melikeyalpi.question5.repository;

import com.melikeyalpi.question5.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart,Long> {
}
