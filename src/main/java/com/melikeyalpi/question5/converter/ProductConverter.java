package com.melikeyalpi.question5.converter;

import com.melikeyalpi.question5.dto.ProductDto;
import com.melikeyalpi.question5.entity.Product;

public class ProductConverter {

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
