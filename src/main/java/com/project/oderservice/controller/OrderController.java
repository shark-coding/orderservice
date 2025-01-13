package com.project.oderservice.controller;

import com.project.oderservice.domain.CreateOrder;
import com.project.oderservice.service.OrderService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 하드코딩
//    @PostMapping("/api/v1/orders")
//    public Response<Void> newOrder() {
//
//        HashMap<Integer, Integer> orderMap = new HashMap<>();
//        orderMap.put(1, 5);
//        orderMap.put(2, 10);
//
//        orderService.newOrder(CreateOrder.builder()
//                .customerId(1)
//                .quantityByProduct(orderMap)
//                .build());
//        return Response.success(null);
//    }

    @PostMapping("/api/v1/orders")
    public Response<Void> newOrder(
            @RequestBody NewOrderRequest request
    ) {

        orderService.newOrder(CreateOrder.builder()
                .customerId(request.getCustomerId())
                .storeId(request.getStoreId())
                .quantityByProduct(request.getProducts())
                .build());
        return Response.success(null);
    }
}
