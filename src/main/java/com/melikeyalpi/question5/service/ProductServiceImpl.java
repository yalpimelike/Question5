package com.melikeyalpi.question5.service;

import com.melikeyalpi.question5.entity.AddedProduct;
import com.melikeyalpi.question5.entity.Product;
import com.melikeyalpi.question5.dto.request.ProductRequest;
import com.melikeyalpi.question5.exception.BasicException;
import com.melikeyalpi.question5.exception.ExceptionMessages;
import com.melikeyalpi.question5.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final CartService cartService;

    private final OrderService orderService;

    private final ProductRepository productRepository;


    public Product createProduct(ProductRequest request) {
        try {
            Product product = new Product();
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setCategory(request.getCategory());
            product.setImageUrl(request.getImageUrl());
            product.setPrice(request.getPrice());
            product.setStock(request.getStock());
            return productRepository.save(product);
        }catch (Exception e){
            log.error(ExceptionMessages.DB_OPERATION);
            throw new BasicException(ExceptionMessages.DB_OPERATION);
        }
    }



    public Product updateProduct(Product product) {
        try {
            Product savedProduct =  productRepository.save(product);

            cartService.refreshCart(savedProduct);

            return savedProduct;
        }catch (Exception e){
            log.error(ExceptionMessages.DB_OPERATION);
        }
        return product;
    }



    public Boolean deleteProduct(Long id) {
        try {
            Product product = productRepository.findById(id).orElse(null);

            List<AddedProduct> addedProduct = new ArrayList<>(product.getAddedProduct());

            productRepository.delete(product);

            cartService.refreshCart(addedProduct);


            return true;
        }catch (Exception e){
            log.error(ExceptionMessages.DB_OPERATION);
            throw new BasicException(ExceptionMessages.DB_OPERATION);
        }
    }



    public Product getProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new BasicException(ExceptionMessages.DATA_NOT_FOUNT);
        }
        return product;
    }
}
