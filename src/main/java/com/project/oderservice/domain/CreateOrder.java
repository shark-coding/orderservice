package com.project.oderservice.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class CreateOrder {
    private int customerId;
    private int storeId;

    private Map<Integer, Integer> quantityByProduct; // [상품 키값, 개수]
}
