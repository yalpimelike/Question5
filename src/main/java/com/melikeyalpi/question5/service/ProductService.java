package com.melikeyalpi.question5.service;

import com.melikeyalpi.question5.dto.request.ProductRequest;
import com.melikeyalpi.question5.entity.Product;

public interface ProductService {

    Product createProduct(ProductRequest request);
    Product updateProduct(Product product);
    Boolean deleteProduct(Long id);
    Product getProduct(Long id);
}
