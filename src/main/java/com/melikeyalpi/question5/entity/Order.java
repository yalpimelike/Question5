package com.melikeyalpi.question5.entity;

import com.melikeyalpi.question5.dto.AddedProductDto;
import com.melikeyalpi.question5.dto.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@Table(name = "orders")
@AllArgsConstructor
@RequiredArgsConstructor
public class Order extends BaseEntity {

    private Long customerId;
    private String customerEmail;
    private String customerPhone;
    private String orderCode;
    private String shippingAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ElementCollection
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_products_id"))
    private List<AddedProductDto> productList;

    private int orderPrice;


    @Override
    String print() {
        return "";
    }

}
