package com.melikeyalpi.question5.service;

import com.melikeyalpi.question5.entity.Product;
import com.melikeyalpi.question5.dto.request.ProductRequest;
import com.melikeyalpi.question5.exception.BasicException;
import com.melikeyalpi.question5.exception.ExceptionMessages;
import com.melikeyalpi.question5.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public Product createProduct(ProductRequest request) {
        try {
            Product product = new Product();
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            product.setStock(request.getStoke());
            return productRepository.save(product);
        }catch (Exception e){
            log.error(ExceptionMessages.DB_OPERATION);
            throw new BasicException(ExceptionMessages.DB_OPERATION);
        }
    }



    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }



    public Boolean deleteProduct(Long id) {
        try {
            Product product = productRepository.findById(id).orElse(null);
            productRepository.delete(product);
            return true;
        }catch (Exception e){
            log.error(ExceptionMessages.DB_OPERATION);
            throw new BasicException(ExceptionMessages.DB_OPERATION);
        }
    }



    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
