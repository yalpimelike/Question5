package com.melikeyalpi.question5.controller;

import com.melikeyalpi.question5.converter.ProductConverter;
import com.melikeyalpi.question5.dto.ProductDto;
import com.melikeyalpi.question5.entity.Product;
import com.melikeyalpi.question5.dto.request.ProductRequest;
import com.melikeyalpi.question5.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    private ProductDto getProduct(@PathVariable Long id){
        return ProductConverter.toDto(productService.getProduct(id));
    }


    @PostMapping
    private ProductDto createProduct(@RequestBody ProductRequest request){
        return ProductConverter.toDto(productService.createProduct(request));
    }


    @PutMapping
    private ProductDto updateProduct(@RequestBody Product product){
        return ProductConverter.toDto(productService.updateProduct(product));
    }


    @DeleteMapping
    private Boolean deleteProduct(@RequestParam Long id){
        return productService.deleteProduct(id);
    }

}
