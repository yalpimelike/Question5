package com.melikeyalpi.question5.converter;

import com.melikeyalpi.question5.dto.ProductDto;
import com.melikeyalpi.question5.entity.Product;

public class ProductConverter {

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
