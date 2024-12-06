package com.melikeyalpi.question5.repository;

import com.melikeyalpi.question5.entity.AddedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddedProductRepository extends JpaRepository<AddedProduct, Integer> {
    List<AddedProduct> findAllByProductId(Long productId);
    void deleteById(Long id);
}
