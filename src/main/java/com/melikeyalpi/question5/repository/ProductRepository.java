package com.melikeyalpi.question5.repository;

import com.melikeyalpi.question5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {
}
