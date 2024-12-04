package com.melikeyalpi.question5.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ToCartRequest {
    private Long cartId,productId;
}
